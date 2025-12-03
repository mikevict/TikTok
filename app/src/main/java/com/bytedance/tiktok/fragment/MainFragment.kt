package com.bytedance.tiktok.fragment

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.bytedance.tiktok.R
import com.bytedance.tiktok.base.BaseBindingFragment
import com.bytedance.tiktok.base.CommPagerAdapter
import com.bytedance.tiktok.bean.PauseVideoEvent
import com.bytedance.tiktok.databinding.FragmentMainBinding
import com.bytedance.tiktok.utils.RxBus
import java.util.*

/**
 * create by Random
 * create on 2025-12-3
 * description 主页fragment
 */
class MainFragment : BaseBindingFragment<FragmentMainBinding>({FragmentMainBinding.inflate(it)}) {
    private var currentLocationFragment: CurrentLocationFragment? = null
    private var recommendFragment: RecommendFragment? = null

    private val fragments = ArrayList<Fragment>()
    private var pagerAdapter: CommPagerAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragments()
        setMainMenu()
    }

    private fun setFragments() {
        currentLocationFragment = CurrentLocationFragment()
        recommendFragment = RecommendFragment()
        fragments.add(currentLocationFragment!!)
        fragments.add(recommendFragment!!)
        binding.tabTitle!!.addTab(binding.tabTitle!!.newTab().setText("海淀"))
        binding.tabTitle!!.addTab(binding.tabTitle!!.newTab().setText("推荐"))
        pagerAdapter = CommPagerAdapter(childFragmentManager, fragments, arrayOf("海淀", "推荐"))
        binding.viewPager!!.adapter = pagerAdapter
        binding.tabTitle!!.setupWithViewPager(binding.viewPager)
        binding.tabTitle!!.getTabAt(1)!!.select()
        binding.viewPager!!.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                curPage = position
                if (position == 1) {
                    //继续播放
                    RxBus.getDefault().post(PauseVideoEvent(true))
                } else {
                    //切换到其他页面，需要暂停视频
                    RxBus.getDefault().post(PauseVideoEvent(false))
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun setMainMenu() {
        with(binding.tabMainMenu) {
            addTab(newTab().setText("首页"))
            addTab(newTab().setText("好友"))
            addTab(newTab().setText(""))
            addTab(newTab().setText("消息"))
            addTab(newTab().setText("我"))
        }
    }

    companion object {
        /** 默认显示第一页推荐页  */
        var curPage = 1
    }
    
    /**
     * 设置导航栏和搜索图标的显示状态
     */
    fun setNavigationVisibility(visible: Boolean) {
        // 隐藏/显示顶部直播文字
        binding.getRoot().findViewById<TextView>(R.id.tvLive).visibility = if (visible) View.VISIBLE else View.GONE
        // 隐藏/显示顶部标签栏
        binding.tabTitle.visibility = if (visible) View.VISIBLE else View.GONE
        // 隐藏/显示搜索图标
        binding.getRoot().findViewById<ImageView>(R.id.ivSearch).visibility = if (visible) View.VISIBLE else View.GONE
        // 隐藏/显示底部导航栏
        binding.tabMainMenu.visibility = if (visible) View.VISIBLE else View.GONE
        // 隐藏/显示底部中央录制按钮
        binding.getRoot().findViewById<ImageView>(R.id.ivMainMenu).visibility = if (visible) View.VISIBLE else View.GONE
        
        // 调整ViewPager的底部margin，横屏时设为0，竖屏时恢复为48dp
        val params = binding.viewPager.layoutParams as RelativeLayout.LayoutParams
        params.bottomMargin = if (visible) 48 else 0
        binding.viewPager.layoutParams = params
    }
}