// Score Display JavaScript

class ScoreDisplay {
    constructor() {
        this.connectionId = this.generateConnectionId();
        this.isConnected = false;
        this.ws = null;
        this.pollInterval = null;
        
        this.initializeElements();
        this.initializeControls();
        this.initializeWebSocket();
        this.checkURLParams();
        
        // Cleanup on page unload
        window.addEventListener('beforeunload', () => {
            this.cleanup();
        });
    }

    cleanup() {
        if (this.pollInterval) {
            clearInterval(this.pollInterval);
        }
        if (this.ws) {
            this.ws.close();
        }
    }

    generateConnectionId() {
        return Math.random().toString(36).substring(2, 8).toUpperCase();
    }

    initializeElements() {
        // Score elements
        this.player1Name = document.getElementById('player1Name');
        this.player1Points = document.getElementById('player1Points');
        this.player1Frames = document.getElementById('player1Frames');
        this.player2Name = document.getElementById('player2Name');
        this.player2Points = document.getElementById('player2Points');
        this.player2Frames = document.getElementById('player2Frames');
        this.breakDisplay = document.getElementById('breakDisplay');
        this.breakValue = document.getElementById('breakValue');
        this.scoreOverlay = document.getElementById('scoreOverlay');

        // Control elements
        this.controlPanel = document.getElementById('controlPanel');
        this.connectionStatus = document.getElementById('connectionStatus');
        this.statusIndicator = document.getElementById('statusIndicator');
        this.connectionIdDisplay = document.getElementById('connectionId');
        
        // Set connection ID
        this.connectionIdDisplay.textContent = this.connectionId;
    }

    initializeControls() {
        // Toggle controls button
        document.getElementById('toggleControls').addEventListener('click', () => {
            this.controlPanel.classList.toggle('hidden');
            const btn = document.getElementById('toggleControls');
            btn.textContent = this.controlPanel.classList.contains('hidden') ? 'Show Controls' : 'Hide Controls';
        });

        // Copy ID button
        document.getElementById('copyIdBtn').addEventListener('click', () => {
            navigator.clipboard.writeText(this.connectionId).then(() => {
                const btn = document.getElementById('copyIdBtn');
                const originalText = btn.textContent;
                btn.textContent = 'Copied!';
                setTimeout(() => {
                    btn.textContent = originalText;
                }, 2000);
            });
        });

        // Manual update button
        document.getElementById('updateScoresBtn').addEventListener('click', () => {
            this.updateScoresManually();
        });

        // Layout selector
        document.getElementById('layoutSelect').addEventListener('change', (e) => {
            this.changeLayout(e.target.value);
        });

        // Keyboard shortcuts
        document.addEventListener('keydown', (e) => {
            if (e.key === 'h' || e.key === 'H') {
                this.controlPanel.classList.toggle('hidden');
            }
        });
    }

    initializeWebSocket() {
        // Check if server URL is provided in URL params
        const params = new URLSearchParams(window.location.search);
        const serverUrl = params.get('server');
        
        if (serverUrl) {
            this.startPolling(serverUrl);
        } else {
            // For demo purposes, simulate connection
            this.simulateConnection();
        }
    }

    simulateConnection() {
        // Simulate connection after 2 seconds
        setTimeout(() => {
            this.isConnected = true;
            this.updateConnectionStatus('Connected - Ready to receive scores', true);
        }, 2000);

        // Listen for messages from parent window (for iframe integration)
        window.addEventListener('message', (event) => {
            if (event.data.type === 'scoreUpdate') {
                this.updateScores(event.data);
            }
        });
    }

    startPolling(serverUrl) {
        this.updateConnectionStatus('Connecting to server...', false);
        
        // Poll server every second
        this.pollInterval = setInterval(async () => {
            try {
                const response = await fetch(`${serverUrl}/scores`);
                if (response.ok) {
                    const data = await response.json();
                    this.updateScores(data);
                    
                    if (!this.isConnected) {
                        this.isConnected = true;
                        this.updateConnectionStatus(`Connected to ${serverUrl}`, true);
                    }
                } else {
                    throw new Error('Server returned error');
                }
            } catch (error) {
                if (this.isConnected) {
                    this.isConnected = false;
                    this.updateConnectionStatus('Connection lost - Retrying...', false);
                }
            }
        }, 1000);
    }

    updateConnectionStatus(message, connected = false) {
        this.connectionStatus.textContent = message;
        if (connected) {
            this.statusIndicator.classList.add('connected');
        } else {
            this.statusIndicator.classList.remove('connected');
        }
    }

    updateScores(data) {
        // Update player names
        if (data.player1Name) {
            this.player1Name.textContent = data.player1Name;
        }
        if (data.player2Name) {
            this.player2Name.textContent = data.player2Name;
        }

        // Update points with animation
        if (data.player1Points !== undefined) {
            this.animateValue(this.player1Points, parseInt(this.player1Points.textContent), data.player1Points);
        }
        if (data.player2Points !== undefined) {
            this.animateValue(this.player2Points, parseInt(this.player2Points.textContent), data.player2Points);
        }

        // Update frames
        if (data.player1Frames !== undefined) {
            this.player1Frames.textContent = data.player1Frames;
        }
        if (data.player2Frames !== undefined) {
            this.player2Frames.textContent = data.player2Frames;
        }

        // Update break display
        if (data.currentBreak !== undefined && data.currentBreak > 0) {
            this.breakValue.textContent = data.currentBreak;
            this.breakDisplay.style.display = 'block';
        } else {
            this.breakDisplay.style.display = 'none';
        }
    }

    animateValue(element, start, end, duration = 500) {
        const range = end - start;
        const increment = range / (duration / 16);
        let current = start;

        const timer = setInterval(() => {
            current += increment;
            if ((increment > 0 && current >= end) || (increment < 0 && current <= end)) {
                element.textContent = end;
                clearInterval(timer);
            } else {
                element.textContent = Math.round(current);
            }
        }, 16);
    }

    updateScoresManually() {
        const data = {
            player1Name: document.getElementById('manualPlayer1Name').value || 'Player 1',
            player2Name: document.getElementById('manualPlayer2Name').value || 'Player 2',
            player1Points: parseInt(document.getElementById('manualPlayer1Points').value) || 0,
            player2Points: parseInt(document.getElementById('manualPlayer2Points').value) || 0,
            player1Frames: parseInt(document.getElementById('manualPlayer1Frames').value) || 0,
            player2Frames: parseInt(document.getElementById('manualPlayer2Frames').value) || 0
        };

        this.updateScores(data);
    }

    changeLayout(layout) {
        this.scoreOverlay.className = 'score-overlay';
        if (layout !== 'default') {
            this.scoreOverlay.classList.add(`layout-${layout}`);
        }
    }

    checkURLParams() {
        const params = new URLSearchParams(window.location.search);
        
        // Check for OBS mode
        if (params.get('obs') === 'true') {
            document.body.classList.add('obs-mode');
        }

        // Check for layout
        const layout = params.get('layout');
        if (layout) {
            this.changeLayout(layout);
            document.getElementById('layoutSelect').value = layout;
        }

        // Check for hide controls
        if (params.get('controls') === 'false') {
            this.controlPanel.classList.add('hidden');
        }

        // Load demo data if requested
        if (params.get('demo') === 'true') {
            setTimeout(() => {
                this.loadDemoData();
            }, 1000);
        }
    }

    loadDemoData() {
        this.updateScores({
            player1Name: 'John Smith',
            player2Name: 'Mike Johnson',
            player1Points: 45,
            player2Points: 32,
            player1Frames: 3,
            player2Frames: 2,
            currentBreak: 0
        });
    }
}

// API for external control
window.ScoreAPI = {
    updateScore: function(data) {
        if (window.scoreDisplay) {
            window.scoreDisplay.updateScores(data);
        }
    },
    
    setPlayer1Points: function(points) {
        this.updateScore({ player1Points: points });
    },
    
    setPlayer2Points: function(points) {
        this.updateScore({ player2Points: points });
    },
    
    setPlayer1Frames: function(frames) {
        this.updateScore({ player1Frames: frames });
    },
    
    setPlayer2Frames: function(frames) {
        this.updateScore({ player2Frames: frames });
    },
    
    setPlayerNames: function(player1, player2) {
        this.updateScore({ player1Name: player1, player2Name: player2 });
    },
    
    setBreak: function(breakValue) {
        this.updateScore({ currentBreak: breakValue });
    },
    
    reset: function() {
        this.updateScore({
            player1Points: 0,
            player2Points: 0,
            player1Frames: 0,
            player2Frames: 0,
            currentBreak: 0
        });
    }
};

// Initialize when DOM is ready
document.addEventListener('DOMContentLoaded', () => {
    window.scoreDisplay = new ScoreDisplay();
});

// Example usage in console:
// ScoreAPI.setPlayer1Points(50);
// ScoreAPI.setPlayer2Points(35);
// ScoreAPI.setPlayerNames("John", "Mike");
// ScoreAPI.setBreak(25);
