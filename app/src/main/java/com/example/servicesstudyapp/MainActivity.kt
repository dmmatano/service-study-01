package com.example.servicesstudyapp

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.servicesstudyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var intentServiceTurnedOn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            startMusicBtn.setOnClickListener {
                if(intentServiceTurnedOn){
                    startService(Intent(this@MainActivity,MyIntentService::class.java))
                }else{
                    // isso chama onStartCommand da classe MyService
                    startService(Intent(this@MainActivity,MyService::class.java))
                }
            }
            stopMusicBtn.setOnClickListener {
                if(intentServiceTurnedOn){
                    // obrigatóriamente deve-se usar stopService() quqando usa-se onStartCommand
                    stopService(Intent(this@MainActivity,MyIntentService::class.java))
                }else{
                    // obrigatóriamente deve-se usar stopService() quqando usa-se onStartCommand
                    stopService(Intent(this@MainActivity,MyService::class.java))
                }
            }
            enableIntentServiceBtn.setOnClickListener {
                intentServiceTurnedOn = !intentServiceTurnedOn
                if(intentServiceTurnedOn){
                    intentServiceState.text = "On"
                    stopMusicBtn.visibility = View.GONE
                    foregroundServiceBtn.visibility = View.GONE
                }else{
                    intentServiceState.text = "Off"
                    stopMusicBtn.visibility = View.VISIBLE
                    foregroundServiceBtn.visibility = View.VISIBLE
                }
            }
        }

    }
}