// Android Integration Example for Remote Score Display
// Add this to your CamLiveBilliard Android app

package com.camlivebilliard.stream.score

import android.content.Context
import com.google.gson.Gson
import fi.iki.elonen.NanoHTTPD
import kotlinx.coroutines.*
import java.io.IOException

/**
 * Simple HTTP server to serve score data to the remote score display webpage
 * 
 * Usage:
 * val scoreServer = ScoreServer(8080)
 * scoreServer.start()
 * scoreServer.updateScore(player1Points = 50, player2Points = 35)
 * 
 * Then access from browser: http://YOUR_PHONE_IP:8080/scores
 */
class ScoreServer(port: Int = 8080) : NanoHTTPD(port) {
    
    private var currentScore = ScoreData()
    private val gson = Gson()
    
    data class ScoreData(
        var player1Name: String = "Player 1",
        var player2Name: String = "Player 2",
        var player1Points: Int = 0,
        var player2Points: Int = 0,
        var player1Frames: Int = 0,
        var player2Frames: Int = 0,
        var currentBreak: Int = 0
    )
    
    override fun serve(session: IHTTPSession): Response {
        // Enable CORS for web access
        val response = when (session.uri) {
            "/scores" -> {
                // Return current scores as JSON
                val json = gson.toJson(currentScore)
                newFixedLengthResponse(Response.Status.OK, "application/json", json)
            }
            "/health" -> {
                // Health check endpoint
                newFixedLengthResponse(Response.Status.OK, "text/plain", "OK")
            }
            else -> {
                newFixedLengthResponse(Response.Status.NOT_FOUND, "text/plain", "Not Found")
            }
        }
        
        // Add CORS headers
        response.addHeader("Access-Control-Allow-Origin", "*")
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
        response.addHeader("Access-Control-Allow-Headers", "Content-Type")
        
        return response
    }
    
    /**
     * Update score data
     */
    fun updateScore(
        player1Name: String? = null,
        player2Name: String? = null,
        player1Points: Int? = null,
        player2Points: Int? = null,
        player1Frames: Int? = null,
        player2Frames: Int? = null,
        currentBreak: Int? = null
    ) {
        player1Name?.let { currentScore.player1Name = it }
        player2Name?.let { currentScore.player2Name = it }
        player1Points?.let { currentScore.player1Points = it }
        player2Points?.let { currentScore.player2Points = it }
        player1Frames?.let { currentScore.player1Frames = it }
        player2Frames?.let { currentScore.player2Frames = it }
        currentBreak?.let { currentScore.currentBreak = it }
    }
    
    /**
     * Get current IP address to display to user
     */
    fun getServerUrl(context: Context): String {
        val ip = getLocalIpAddress(context)
        return "http://$ip:${listeningPort}/scores"
    }
    
    private fun getLocalIpAddress(context: Context): String {
        try {
            val wifiManager = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as android.net.wifi.WifiManager
            val wifiInfo = wifiManager.connectionInfo
            val ipInt = wifiInfo.ipAddress
            return String.format(
                "%d.%d.%d.%d",
                ipInt and 0xff,
                ipInt shr 8 and 0xff,
                ipInt shr 16 and 0xff,
                ipInt shr 24 and 0xff
            )
        } catch (e: Exception) {
            return "localhost"
        }
    }
}

/**
 * Integration with your existing ScoreOverlayActivity
 * 
 * Add this to your ScoreOverlayActivity.kt
 */
class ScoreOverlayActivityIntegration {
    
    private var scoreServer: ScoreServer? = null
    
    fun setupScoreServer(context: Context) {
        try {
            scoreServer = ScoreServer(8080)
            scoreServer?.start()
            
            // Show URL to user
            val url = scoreServer?.getServerUrl(context)
            showToast("Remote Score URL: $url")
            
            // Or show in a dialog with QR code
            showRemoteScoreDialog(url ?: "")
            
        } catch (e: IOException) {
            showToast("Failed to start score server: ${e.message}")
        }
    }
    
    fun updateRemoteScore() {
        scoreServer?.updateScore(
            player1Name = player1Name,
            player2Name = player2Name,
            player1Points = player1CurrentPoints,
            player2Points = player2CurrentPoints,
            player1Frames = player1FramesWon,
            player2Frames = player2FramesWon,
            currentBreak = currentBreakScore
        )
    }
    
    fun stopScoreServer() {
        scoreServer?.stop()
        scoreServer = null
    }
    
    // Call this whenever scores change
    fun onScoreChanged() {
        updateRemoteScore()
    }
    
    private fun showToast(message: String) {
        // Your toast implementation
    }
    
    private fun showRemoteScoreDialog(url: String) {
        // Show dialog with URL and instructions
        // Optionally include QR code for easy scanning
    }
}

/**
 * Add to your build.gradle (Module: app)
 */
/*
dependencies {
    // For NanoHTTPD (lightweight HTTP server)
    implementation 'org.nanohttpd:nanohttpd:2.3.1'
    
    // For JSON serialization
    implementation 'com.google.code.gson:gson:2.10.1'
    
    // Optional: For QR code generation
    implementation 'com.google.zxing:core:3.5.1'
}
*/

/**
 * Add to AndroidManifest.xml
 */
/*
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
*/

/**
 * Usage Example in your Activity:
 */
/*
class ScoreOverlayActivity : AppCompatActivity() {
    
    private val scoreIntegration = ScoreOverlayActivityIntegration()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Start score server
        scoreIntegration.setupScoreServer(this)
    }
    
    private fun updateScore() {
        // Your existing score update logic
        player1CurrentPoints += points
        
        // Update remote display
        scoreIntegration.onScoreChanged()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        scoreIntegration.stopScoreServer()
    }
}
*/

/**
 * Alternative: WebSocket Implementation (More Advanced)
 * 
 * For real-time bidirectional communication
 */
class ScoreWebSocketServer(port: Int = 8080) {
    
    // Use library like Java-WebSocket
    // implementation 'org.java-websocket:Java-WebSocket:1.5.3'
    
    /*
    private val server = object : WebSocketServer(InetSocketAddress(port)) {
        override fun onOpen(conn: WebSocket, handshake: ClientHandshake) {
            // Client connected
            sendCurrentScore(conn)
        }
        
        override fun onMessage(conn: WebSocket, message: String) {
            // Handle incoming messages (if needed)
        }
        
        override fun onClose(conn: WebSocket, code: Int, reason: String, remote: Boolean) {
            // Client disconnected
        }
        
        override fun onError(conn: WebSocket?, ex: Exception) {
            // Handle error
        }
        
        override fun onStart() {
            // Server started
        }
    }
    
    fun broadcastScore(scoreData: ScoreData) {
        val json = Gson().toJson(scoreData)
        server.broadcast(json)
    }
    */
}

/**
 * UI Component: Remote Score Settings
 * 
 * Add this to your settings or overlay screen
 */
/*
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="16dp">
    
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Remote Score Display"
        android:textSize="18sp"
        android:textStyle="bold" />
    
    <TextView
        android:id="@+id/remoteScoreUrl"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:text="URL: Not started"
        android:textSize="14sp" />
    
    <Button
        android:id="@+id/btnStartRemoteScore"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:text="Start Remote Score Server" />
    
    <Button
        android:id="@+id/btnCopyUrl"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="4dp"
        android:text="Copy URL" />
    
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:text="Instructions:\n1. Start the server\n2. Copy the URL\n3. Open in browser or OBS\n4. Scores update automatically"
        android:textSize="12sp" />
</LinearLayout>
*/

/**
 * Helper: QR Code Generator (Optional)
 */
class QRCodeHelper {
    /*
    fun generateQRCode(text: String, width: Int = 512, height: Int = 512): Bitmap {
        val bitMatrix = MultiFormatWriter().encode(
            text,
            BarcodeFormat.QR_CODE,
            width,
            height
        )
        
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
            }
        }
        return bitmap
    }
    */
}

/**
 * Testing:
 * 
 * 1. Run your app on device/emulator
 * 2. Start the score server
 * 3. Note the IP address (e.g., 192.168.1.100:8080)
 * 4. Open browser on same network
 * 5. Navigate to: http://192.168.1.100:8080/scores
 * 6. Or use the score display page with polling:
 *    score.html?server=http://192.168.1.100:8080
 * 7. Update scores in app
 * 8. Watch them update in browser
 */
