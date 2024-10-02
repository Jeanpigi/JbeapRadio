package com.example.jbeapradio


import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

import android.util.Log

class RadioService : Service() {

    private var player: ExoPlayer? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val url = "http://45.63.108.83:3006/stream"

        player = ExoPlayer.Builder(this).build().apply {
            val mediaItem = MediaItem.fromUri(url)
            setMediaItem(mediaItem)
            prepare()
            play() // Inicia la reproducción

            // Log para verificar que ExoPlayer esté funcionando
            Log.d("RadioService", "Reproducción iniciada")
        }

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release() // Libera los recursos del reproductor cuando el servicio se detiene
        Log.d("RadioService", "Reproducción detenida")
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}

