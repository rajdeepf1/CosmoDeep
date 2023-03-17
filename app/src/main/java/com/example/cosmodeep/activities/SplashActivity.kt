package com.example.cosmodeep.activities

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.cosmodeep.R
import com.example.cosmodeep.databinding.ActivitySplashBinding
import com.example.cosmodeep.utils.Constant


class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    lateinit var mediaPlayer: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        playMusic()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, Constant.setTimeOutDuration)

    }

    private fun playMusic() {
        var mediaPlayer: MediaPlayer? = MediaPlayer()
        mediaPlayer = MediaPlayer.create(this, R.raw.snowfall)
        mediaPlayer!!.isLooping = true
        mediaPlayer.start()
    }

}