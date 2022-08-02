package com.example.servicesstudyapp

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

/**
 * Podemos extender da classe Service ou IntentService, sendo que a classe Service é a melhor opção
 * para que o serviço lide com várias solicitações simultaneamente.
 * Ao usar o IntentService, basta sobrescrever o método onHandleIntent apenas.
 * Acesse: https://developer.android.com/guide/components/services?hl=pt-br
 */
class MyService: Service() {
    private lateinit var player:MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        player.isLooping = true
        player.start()

        //como o sistema retornará o método em questão
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }
}