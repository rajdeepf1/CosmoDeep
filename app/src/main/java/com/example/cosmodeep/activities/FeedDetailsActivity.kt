package com.example.cosmodeep.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.cosmodeep.R
import com.example.cosmodeep.databinding.ActivityFeedDetailsBinding
import com.example.cosmodeep.databinding.ActivityMainBinding

class FeedDetailsActivity : AppCompatActivity() {

    private val TAG: String = FeedDetailsActivity::class.java.name
    private lateinit var binding: ActivityFeedDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);


        val intent: Intent = getIntent()
        val feed_title = intent.getStringExtra("feed_title")
        val feed_date = intent.getStringExtra("feed_date")
        val feed_explanation = intent.getStringExtra("feed_explanation")
        val feed_hdUrl = intent.getStringExtra("feed_hdUrl")

        Glide.with(this)
            .load(feed_hdUrl)
            .into(binding.imageView)

        binding.titleText.text = feed_title
        binding.titleDate.text = feed_date
        binding.explanationText.text = feed_explanation


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}