package com.bytedance.tiktok.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.bytedance.tiktok.R
import com.bytedance.tiktok.bean.VideoBean
import com.bytedance.tiktok.databinding.ViewControllerBinding
import com.bytedance.tiktok.utils.AutoLinkHerfManager
import com.bytedance.tiktok.utils.NumUtils
import com.bytedance.tiktok.utils.OnVideoControllerListener

/**
 * create by Randon
 * create on 2025-12-3
 * description
 */
class ControllerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : RelativeLayout(context, attrs), View.OnClickListener {
    private var listener: OnVideoControllerListener? = null
    private var videoData: VideoBean? = null
    private var binding: ViewControllerBinding = ViewControllerBinding.inflate(LayoutInflater.from(context), this, true)
    private var isLandscapeMode = false

    init {
        init()
    }

    private fun init() {
        binding.ivHead!!.setOnClickListener(this)
        binding.ivComment!!.setOnClickListener(this)
        binding.ivShare!!.setOnClickListener(this)
        binding.rlLike!!.setOnClickListener(this)
        binding.ivFocus!!.setOnClickListener(this)
        binding.ivRotate!!.setOnClickListener(this)
        setRotateAnim()
    }

    fun setVideoData(videoData: VideoBean) {
        this.videoData = videoData
        binding.ivHead!!.setImageResource(videoData.userBean!!.head)
        binding.tvNickname!!.text = "@" + videoData.userBean!!.nickName
        AutoLinkHerfManager.setContent(videoData.content, binding.autoLinkTextView)
        // 设置底部滚动文本："创作的原声"
        binding.marqueeTextView!!.text = "@" + videoData.userBean!!.nickName + " 创作的原声 - " + videoData.userBean!!.nickName
        binding.ivHeadAnim!!.setImageResource(videoData.userBean!!.head)
        binding.tvLikecount!!.text = NumUtils.numberFilter(videoData.likeCount)
        binding.tvCommentcount!!.text = NumUtils.numberFilter(videoData.commentCount)
        binding.tvSharecount!!.text = NumUtils.numberFilter(videoData.shareCount)
        binding.animationView!!.setAnimation("like.json")

        //点赞状态
        if (videoData.isLiked) {
            binding.ivLike!!.setTextColor(resources.getColor(R.color.color_FF0041))
        } else {
            binding.ivLike!!.setTextColor(resources.getColor(R.color.white))
        }

        //关注状态
        if (videoData.isFocused) {
            binding.ivFocus!!.visibility = GONE
        } else {
            binding.ivFocus!!.visibility = VISIBLE
        }
    }

    fun setListener(listener: OnVideoControllerListener?) {
        this.listener = listener
    }

    override fun onClick(v: View) {
        if (listener == null) {
            return
        }
        when (v.id) {
            R.id.ivHead -> listener!!.onHeadClick()
            R.id.rlLike -> {
                listener!!.onLikeClick()
                like()
            }
            R.id.ivComment -> listener!!.onCommentClick()
            R.id.ivShare -> listener!!.onShareClick()
            R.id.ivRotate -> listener!!.onScreenRotateClick()
            R.id.ivFocus -> {
                // 切换关注状态
                videoData!!.isFocused = !videoData!!.isFocused
                // 更新加号显示
                if (videoData!!.isFocused) {
                    binding.ivFocus!!.visibility = GONE
                } else {
                    binding.ivFocus!!.visibility = VISIBLE
                }
                // 调用关注状态变更回调
                listener?.onFocusChange(videoData!!.isFocused, videoData!!.userBean!!)
            }
        }
    }

    /**
     * 点赞动作
     */
    fun like() {
        if (!videoData!!.isLiked) {
            //点赞
            binding.animationView!!.visibility = VISIBLE
            binding.animationView!!.playAnimation()
            binding.ivLike!!.setTextColor(resources.getColor(R.color.color_FF0041))
        } else {
            //取消点赞
            binding.animationView!!.visibility = INVISIBLE
            binding.ivLike!!.setTextColor(resources.getColor(R.color.white))
        }
        videoData!!.isLiked = !videoData!!.isLiked
    }

    /**
     * 循环旋转动画
     */
    private fun setRotateAnim() {
        val rotateAnimation = RotateAnimation(0f, 359f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        rotateAnimation.repeatCount = Animation.INFINITE
        rotateAnimation.duration = 8000
        rotateAnimation.interpolator = LinearInterpolator()
        binding.rlRecord!!.startAnimation(rotateAnimation)
    }
    
    /**
     * 设置横屏模式
     */
    fun setLandscapeMode(landscape: Boolean) {
        isLandscapeMode = landscape
        
        if (landscape) {
            // 横屏模式：只显示全屏图标，隐藏所有其他内容
            // 隐藏整个左侧文字区域
            binding.tvNickname.visibility = GONE
            binding.autoLinkTextView.visibility = GONE
            binding.marqueeTextView.visibility = GONE
            
            // 隐藏右侧所有图标，只保留全屏按钮
            binding.ivHead.visibility = GONE
            binding.ivFocus.visibility = GONE
            binding.rlLike.visibility = GONE
            binding.ivComment.visibility = GONE
            binding.ivShare.visibility = GONE
            binding.rlRecord.visibility = GONE
            binding.tvLikecount.visibility = GONE
            binding.tvCommentcount.visibility = GONE
            binding.tvSharecount.visibility = GONE
            binding.ivHeadAnim.visibility = GONE
            binding.animationView.visibility = GONE
            binding.ivRecord.visibility = GONE
            
            // 确保全屏按钮可见
            binding.ivRotate.visibility = VISIBLE
        } else {
            // 竖屏模式：显示所有图标，恢复默认布局
            // 显示左侧文字区域
            binding.tvNickname.visibility = VISIBLE
            binding.autoLinkTextView.visibility = VISIBLE
            binding.marqueeTextView.visibility = VISIBLE
            
            // 显示右侧所有图标
            binding.ivHead.visibility = VISIBLE
            if (!videoData!!.isFocused) {
                binding.ivFocus.visibility = VISIBLE
            }
            binding.rlLike.visibility = VISIBLE
            binding.ivComment.visibility = VISIBLE
            binding.ivShare.visibility = VISIBLE
            binding.rlRecord.visibility = VISIBLE
            binding.tvLikecount.visibility = VISIBLE
            binding.tvCommentcount.visibility = VISIBLE
            binding.tvSharecount.visibility = VISIBLE
            binding.ivHeadAnim.visibility = VISIBLE
            binding.animationView.visibility = VISIBLE
            binding.ivRecord.visibility = VISIBLE
            
            // 确保全屏按钮可见
            binding.ivRotate.visibility = VISIBLE
        }
    }
}