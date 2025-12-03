package com.bytedance.tiktok.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bytedance.tiktok.adapter.VideoAdapter.VideoViewHolder
import com.bytedance.tiktok.base.BaseAdapter
import com.bytedance.tiktok.bean.VideoBean
import com.bytedance.tiktok.databinding.ItemVideoBinding
import com.bytedance.tiktok.player.VideoPlayer
import com.bytedance.tiktok.view.LikeView.OnLikeListener
import com.google.android.exoplayer2.MediaItem


/**
 * create by Random
 * create on 2025-12-3
 * description
 */
class VideoAdapter(val context: Context, val recyclerView: RecyclerView): BaseAdapter<VideoViewHolder, VideoBean>(VideoDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        mList[position]?.let {
            holder.binding.controller.setVideoData(it)
            Glide.with(context)
                .asBitmap()
                .load(it.videoRes)
                .apply(RequestOptions.frameOf(0))  // 从第一帧开始
                .into(holder.binding.ivCover)
            holder?.binding?.likeview?.setOnLikeListener(object : OnLikeListener {
                override fun onLikeListener() {
                    if (!it.isLiked) {  //未点赞，会有点赞效果，否则无
                        holder?.binding?.controller!!.like()
                    }
                }
            })
            holder.binding.ivPlay.alpha = 0.4f
        }
    }

    /**
     * 通过position获取当前item.rootview
     */
    fun getRootViewAt(position: Int): View? {
        val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)
        return if (viewHolder != null && viewHolder is VideoViewHolder) {
            viewHolder.itemView
        } else {
            null
        }
    }

    inner class VideoViewHolder(val binding: ItemVideoBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}

class VideoDiff: DiffUtil.ItemCallback<VideoBean>() {
    override fun areItemsTheSame(oldItem: VideoBean, newItem: VideoBean): Boolean {
        return (oldItem.userBean!!.uid == newItem.userBean!!.uid)
    }

    override fun areContentsTheSame(oldItem: VideoBean, newItem: VideoBean): Boolean {
        return (oldItem.videoRes == newItem.videoRes && oldItem.userBean!!.uid == newItem.userBean!!.uid)
    }

}