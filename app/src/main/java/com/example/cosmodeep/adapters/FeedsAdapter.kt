package com.example.cosmodeep.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cosmodeep.activities.FeedDetailsActivity
import com.example.cosmodeep.databinding.CustomFeedsLayoutBinding
import com.example.cosmodeep.models.FeedModelItem

class FeedsAdapter(private val list: List<FeedModelItem>, private val context: Context)
    : RecyclerView.Adapter<FeedsAdapter.HoursViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoursViewHolder {
        val binding = CustomFeedsLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HoursViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: HoursViewHolder, position: Int) {
        with(holder){
            with(list[position]) {
                binding.titleText.setText(title)
                binding.titleDate.setText(date)
                binding.explanationText.setText(explanation)
                Glide.with(holder.itemView.context)
                    .load(hdurl)
                    .into(binding.imageView)


                binding.onCardClick.setOnClickListener(View.OnClickListener {
                    context.startActivity(Intent(context,FeedDetailsActivity::class.java)
                        .putExtra("feed_title",title)
                        .putExtra("feed_date",date)
                        .putExtra("feed_explanation",explanation)
                        .putExtra("feed_hdUrl",hdurl)
                    )
                })

            }
        }
    }

    inner class HoursViewHolder(val binding: CustomFeedsLayoutBinding)
        :RecyclerView.ViewHolder(binding.root)

}