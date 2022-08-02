package com.example.servicesstudyapp

import android.app.IntentService
import android.content.Intent
import android.media.MediaPlayer
import android.provider.Settings
import android.widget.Toast

class MyIntentService:IntentService("MyIntentService") {
    private lateinit var player: MediaPlayer

    override fun onHandleIntent(p0: Intent?) {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        player.isLooping = true
        player.start()

        try {
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
            // Restore interrupt status.
            Thread.currentThread().interrupt()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
        Toast.makeText(this, "Player stoped", Toast.LENGTH_LONG).show()
    }

}