package com.example.cosmodeep.activities

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.cosmodeep.R
import com.example.cosmodeep.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val window: Window = getWindow()

// clear FLAG_TRANSLUCENT_STATUS flag:

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

// finally change the color

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, com.example.cosmodeep.R.color.black))

        navController = Navigation.findNavController(this,R.id.activity_main_nav_host_fragment)

        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)

        playMusic()

        val handler: Handler = Handler()
        handler.postDelayed(Runnable {         playMusic()
        },121800)

    }

    private fun playMusic() {
        var mediaPlayer: MediaPlayer? = MediaPlayer()
        mediaPlayer = MediaPlayer.create(this, R.raw.snowfall)
        mediaPlayer!!.isLooping = true
        mediaPlayer.start()
    }

}