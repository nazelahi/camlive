# Remote Score Display - Setup Guide

## 🎯 Overview

The Remote Score Display system allows you to show live snooker scores on a separate device or as a browser source in OBS/streaming software. Scores update in real-time as you control them from your CamLiveBilliard app or manually through the web interface.

## 📁 Files Created

```
website/
├── score.html              # Main score display page
├── css/
│   ├── score.css          # Score display styling
│   └── legal.css          # Legal pages styling (fixed)
├── js/
│   └── score.js           # Score display logic
└── REMOTE_SCORE_GUIDE.md  # This file
```

## 🚀 Quick Start

### Option 1: Manual Control (Testing)

1. Open `score.html` in your browser
2. Use the control panel on the right to update scores manually
3. Perfect for testing and demonstrations

**URL:** `https://yourdomain.com/score.html`

### Option 2: OBS Browser Source

1. Open OBS Studio
2. Add a new "Browser" source
3. Set URL to: `https://yourdomain.com/score.html?obs=true`
4. Set Width: 1920, Height: 1080
5. Check "Shutdown source when not visible"
6. Check "Refresh browser when scene becomes active"

### Option 3: App Integration (Future)

When you integrate with your Android app:
1. App sends score updates via HTTP POST or WebSocket
2. Score display updates automatically
3. No manual intervention needed

## 🎨 Layout Options

Add `?layout=` parameter to URL:

- **Default:** `score.html` or `score.html?layout=default`
  - Bottom center position
  - Full information display
  
- **Top:** `score.html?layout=top`
  - Top center position
  - Same as default but at top

- **Compact:** `score.html?layout=compact`
  - Smaller size
  - Less padding
  
- **Minimal:** `score.html?layout=minimal`
  - Smallest size
  - Hides frame count
  - Only shows current points

## 🔧 URL Parameters

Customize the display with URL parameters:

```
score.html?obs=true&layout=compact&controls=false&demo=true
```

### Available Parameters:

| Parameter | Values | Description |
|-----------|--------|-------------|
| `obs` | `true`/`false` | Hides control panel for OBS |
| `layout` | `default`/`top`/`compact`/`minimal` | Changes layout style |
| `controls` | `true`/`false` | Show/hide control panel |
| `demo` | `true` | Loads demo data automatically |

### Examples:

**For OBS (clean overlay):**
```
score.html?obs=true&layout=default
```

**For testing with demo data:**
```
score.html?demo=true
```

**Minimal overlay without controls:**
```
score.html?layout=minimal&controls=false
```

## 💻 JavaScript API

Control scores programmatically via browser console or external scripts:

```javascript
// Update individual scores
ScoreAPI.setPlayer1Points(50);
ScoreAPI.setPlayer2Points(35);

// Update frames
ScoreAPI.setPlayer1Frames(3);
ScoreAPI.setPlayer2Frames(2);

// Update player names
ScoreAPI.setPlayerNames("John Smith", "Mike Johnson");

// Show current break
ScoreAPI.setBreak(25);

// Update everything at once
ScoreAPI.updateScore({
    player1Name: "John",
    player2Name: "Mike",
    player1Points: 45,
    player2Points: 32,
    player1Frames: 3,
    player2Frames: 2,
    currentBreak: 15
});

// Reset all scores
ScoreAPI.reset();
```

## 🔌 Android App Integration

### Method 1: HTTP POST (Recommended)

Create an endpoint in your app that the web page can poll:

```kotlin
// In your Android app
class ScoreServer {
    fun startServer() {
        // Use NanoHTTPD or similar
        // Serve JSON with current scores
    }
    
    fun getScoresJSON(): String {
        return """
        {
            "player1Name": "$player1Name",
            "player2Name": "$player2Name",
            "player1Points": $player1Points,
            "player2Points": $player2Points,
            "player1Frames": $player1Frames,
            "player2Frames": $player2Frames,
            "currentBreak": $currentBreak
        }
        """
    }
}
```

Then modify `score.js` to poll this endpoint:

```javascript
// Add to ScoreDisplay class
pollScores() {
    setInterval(async () => {
        try {
            const response = await fetch('http://localhost:8080/scores');
            const data = await response.json();
            this.updateScores(data);
        } catch (error) {
            console.error('Failed to fetch scores:', error);
        }
    }, 1000); // Poll every second
}
```

### Method 2: WebSocket (Real-time)

For instant updates without polling:

```kotlin
// In your Android app
class ScoreWebSocket {
    fun broadcastScore(score: Score) {
        val json = Gson().toJson(score)
        webSocketServer.broadcast(json)
    }
}
```

Modify `score.js`:

```javascript
initializeWebSocket() {
    this.ws = new WebSocket('ws://localhost:8080/scores');
    
    this.ws.onmessage = (event) => {
        const data = JSON.parse(event.data);
        this.updateScores(data);
    };
    
    this.ws.onopen = () => {
        this.updateConnectionStatus('Connected', true);
    };
    
    this.ws.onerror = () => {
        this.updateConnectionStatus('Connection failed', false);
    };
}
```

### Method 3: Local File (Simple)

App writes scores to a JSON file, web page reads it:

```kotlin
// In your Android app
fun saveScoresToFile() {
    val file = File(getExternalFilesDir(null), "scores.json")
    file.writeText(getScoresJSON())
}
```

Host the file with a simple HTTP server and poll it from the web page.

## 🎬 OBS Setup Guide

### Step-by-Step:

1. **Add Browser Source**
   - Sources → Add → Browser
   - Name it "Snooker Score Overlay"

2. **Configure Source**
   - URL: `https://yourdomain.com/score.html?obs=true`
   - Width: 1920
   - Height: 1080
   - FPS: 30
   - ✅ Shutdown source when not visible
   - ✅ Refresh browser when scene becomes active

3. **Position Overlay**
   - The overlay is already positioned at bottom center
   - You can move it in OBS if needed
   - Or use different layout parameter

4. **Test It**
   - Open the score page in a regular browser
   - Update scores manually
   - Watch them appear in OBS

### OBS Tips:

- **Transparent Background:** The page has a transparent background by default
- **Performance:** Use hardware acceleration in OBS settings
- **Refresh:** Right-click source → Refresh to reload
- **Interaction:** Right-click source → Interact to access controls

## 🎨 Customization

### Change Colors

Edit `css/score.css`:

```css
:root {
    --primary-color: #4F46E5;      /* Main accent color */
    --secondary-color: #10B981;    /* Break display color */
    --text-primary: #FFFFFF;       /* Main text */
    --text-secondary: #14F195;     /* Player names */
    --bg-overlay: rgba(0, 0, 0, 0.85); /* Background */
}
```

### Change Font

Edit `score.html` and `score.css`:

```html
<!-- In score.html -->
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;600;700;800&display=swap" rel="stylesheet">
```

```css
/* In score.css */
body {
    font-family: 'Roboto', sans-serif;
}
```

### Change Position

Edit `css/score.css`:

```css
.score-overlay {
    /* Change from bottom to top */
    top: 20px;
    bottom: auto;
    
    /* Or change horizontal position */
    left: 20px;  /* Left side */
    right: auto;
    transform: none;
}
```

### Add Team Logos

Modify `score.html`:

```html
<div class="player-section player-1">
    <img src="team1-logo.png" class="team-logo" alt="Team 1">
    <div class="player-name" id="player1Name">Player 1</div>
    <!-- rest of code -->
</div>
```

Add CSS:

```css
.team-logo {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    margin-bottom: 0.5rem;
}
```

## 🐛 Troubleshooting

### Scores Not Updating

1. Check browser console for errors (F12)
2. Verify the URL is correct
3. Check if control panel is visible (press 'H' key)
4. Try manual update to test display

### Overlay Not Showing in OBS

1. Check URL is correct with `?obs=true`
2. Verify width/height are set (1920x1080)
3. Try refreshing the browser source
4. Check if overlay is behind other sources

### Connection Issues

1. Ensure app and browser are on same network
2. Check firewall settings
3. Verify server is running in app
4. Test with manual controls first

### Performance Issues

1. Lower OBS browser source FPS to 30
2. Use hardware acceleration
3. Close unnecessary browser tabs
4. Use minimal layout for better performance

## 📱 Mobile Access

The score display is fully responsive and works on mobile devices:

1. Open `score.html` on your phone/tablet
2. Use as a secondary display for scorekeeping
3. Control panel adapts to smaller screens
4. Touch-friendly interface

## 🔒 Security Notes

### For Production:

1. **HTTPS Required:** Use HTTPS for security
2. **CORS:** Configure CORS headers if app and web are on different domains
3. **Authentication:** Add authentication for score updates
4. **Rate Limiting:** Prevent abuse with rate limiting

### Example CORS Headers:

```
Access-Control-Allow-Origin: *
Access-Control-Allow-Methods: GET, POST
Access-Control-Allow-Headers: Content-Type
```

## 📊 Features

### Current Features:
- ✅ Real-time score display
- ✅ Player names
- ✅ Current points (animated)
- ✅ Frames won
- ✅ Current break display
- ✅ Multiple layout options
- ✅ Manual control panel
- ✅ OBS-ready
- ✅ Responsive design
- ✅ Keyboard shortcuts
- ✅ JavaScript API

### Future Enhancements:
- 🔄 WebSocket integration
- 🔄 Connection ID pairing
- 🔄 Historical score tracking
- 🔄 Match statistics
- 🔄 Custom themes
- 🔄 Sound effects
- 🔄 Animations/transitions
- 🔄 Multi-language support

## 🎯 Use Cases

### 1. Tournament Streaming
- Display scores on main stream
- Use multiple layouts for different scenes
- Professional appearance

### 2. Club Matches
- Show scores on TV/monitor
- Easy manual control
- No app required

### 3. Practice Sessions
- Track scores during practice
- Review performance
- Simple setup

### 4. Content Creation
- Professional overlays
- Customizable branding
- Easy integration

## 📞 Support

For issues or questions:
- **Email:** support@camlivebilliard.com
- **Documentation:** See website/README.md
- **Updates:** Check GitHub for latest version

## 🎉 Quick Test

Try it now:

1. Open `score.html` in your browser
2. Click "Update Scores" with default values
3. See the scores animate
4. Try different layouts from dropdown
5. Press 'H' to hide/show controls
6. Copy the connection ID for future app integration

---

**Version:** 1.0  
**Last Updated:** November 29, 2024  
**Created for:** CamLiveBilliard Android App
