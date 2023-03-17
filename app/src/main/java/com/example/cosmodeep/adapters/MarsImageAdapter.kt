package com.example.cosmodeep.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cosmodeep.R
import com.example.cosmodeep.activities.FeedDetailsActivity
import com.example.cosmodeep.databinding.CustomFeedsLayoutBinding
import com.example.cosmodeep.databinding.CustomMarsImageLayoutBinding
import com.example.cosmodeep.models.FeedModelItem
import com.example.cosmodeep.models.MarsModel
import com.example.cosmodeep.models.Photo

class MarsImageAdapter(private val list: List<Photo>, private val context: Context)
    : RecyclerView.Adapter<MarsImageAdapter.HoursViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoursViewHolder {
        val binding = CustomMarsImageLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HoursViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: HoursViewHolder, position: Int) {
        with(holder){
            with(list[position]) {
                binding.nameText.setText("Rover: "+rover.name)
                binding.cameraNameText.setText("Rover Cam: "+camera.fullName)
                binding.earthDate.setText("Earth Date: "+earthDate)
                binding.status.setText("Status: "+rover.status)
                Glide.with(holder.itemView.context)
                    .load(imgSrc)
                    .into(binding.imageView)

                binding.cardView.animation =
                    AnimationUtils.loadAnimation(holder.itemView.context, R.anim.anim)
            }
        }
    }

    inner class HoursViewHolder(val binding: CustomMarsImageLayoutBinding)
        :RecyclerView.ViewHolder(binding.root)

}