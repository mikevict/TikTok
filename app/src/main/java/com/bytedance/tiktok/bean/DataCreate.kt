package com.bytedance.tiktok.bean

import com.bytedance.tiktok.R
import com.bytedance.tiktok.bean.VideoBean.UserBean
import java.util.*

/**
 * create by Random
 * create on 2025-12-3
 * description 本地数据创建，代替接口获取数据
 */
class DataCreate {

    init {
        val videoBeanOne = VideoBean()
        videoBeanOne.content = "#圣诞树 #美国 感恩节"
//        videoBeanOne.videoRes = "https://wave.video/embed/6581e9eedd95d26a606f6c87/6581e9eedd95d26a606f6c85.mp4"
        videoBeanOne.videoRes = "http://43.143.240.89:8080/1.mp4"
        videoBeanOne.distance = 7.9f
        videoBeanOne.isFocused = false
        videoBeanOne.isLiked = true
        videoBeanOne.likeCount = 226823
        videoBeanOne.commentCount = 3480
        videoBeanOne.shareCount = 4252

        val userBeanOne = UserBean()
        userBeanOne.uid = 1
        userBeanOne.head = R.mipmap.head1
        userBeanOne.nickName = "采访喵"
        userBeanOne.sign = "你喜欢的话题，就是我采访的内容"
        userBeanOne.subCount = 119323
        userBeanOne.focusCount = 482
        userBeanOne.fansCount = 32823
        userBeanOne.workCount = 42
        userBeanOne.dynamicCount = 42
        userBeanOne.likeCount = 821
        userList.add(userBeanOne)
        videoBeanOne.userBean = userBeanOne

        val videoBeanTwo = VideoBean()
        videoBeanTwo.content = "时装周，走秀！"
        videoBeanTwo.videoRes = "http://43.143.240.89:8080/2.mp4"
        videoBeanTwo.distance = 19.7f
        videoBeanTwo.isFocused = true
        videoBeanTwo.isLiked = false
        videoBeanTwo.likeCount = 1938230
        videoBeanTwo.commentCount = 8923
        videoBeanTwo.shareCount = 5892

        val userBeanTwo = UserBean()
        userBeanTwo.uid = 2
        userBeanTwo.head = R.mipmap.head2
        userBeanTwo.nickName = "时装周狗仔队"

        userBeanTwo.sign = "时尚是私人的事，也是街头的事"
        userBeanTwo.subCount = 20323234
        userBeanTwo.focusCount = 244
        userBeanTwo.fansCount = 1938232
        userBeanTwo.workCount = 123
        userBeanTwo.dynamicCount = 123
        userBeanTwo.likeCount = 344
        userList.add(userBeanTwo)
        videoBeanTwo.userBean = userBeanTwo

        val videoBeanThree = VideoBean()
        videoBeanThree.content = "旅行者 世界破破烂烂，NPC缝缝补补 @采访喵 "
        videoBeanThree.videoRes = "http://43.143.240.89:8080/3.mp4"
        videoBeanThree.distance = 15.9f
        videoBeanThree.isFocused = false
        videoBeanThree.isLiked = false
        videoBeanThree.likeCount = 592032
        videoBeanThree.commentCount = 9221
        videoBeanThree.shareCount = 982

        val userBeanThree = UserBean()
        userBeanThree.uid = 3
        userBeanThree.head = R.mipmap.head3
        userBeanThree.nickName = "旅行者"
        userBeanThree.sign = "在陌生街头写诗，用脚印给世界标注释"
        userBeanThree.subCount = 1039232
        userBeanThree.focusCount = 159
        userBeanThree.fansCount = 29232323
        userBeanThree.workCount = 171
        userBeanThree.dynamicCount = 173
        userBeanThree.likeCount = 1724
        userList.add(userBeanThree)
        videoBeanThree.userBean = userBeanThree

        val videoBeanFour = VideoBean()
        videoBeanFour.content = "黑龙江大雪 #大雪 "
        videoBeanFour.videoRes = "http://43.143.240.89:8080/4.mp4"
        videoBeanFour.distance = 25.2f
        videoBeanFour.isFocused = false
        videoBeanFour.isLiked = false
        videoBeanFour.likeCount = 887232
        videoBeanFour.commentCount = 2731
        videoBeanFour.shareCount = 8924

        val userBeanFour = UserBean()
        userBeanFour.uid = 4
        userBeanFour.head = R.mipmap.head4
        userBeanFour.nickName = "爱修图的剪辑师"
        userBeanFour.sign = "接剪辑，活动拍摄，修图单\n 合作私信"
        userBeanFour.subCount = 2689424
        userBeanFour.focusCount = 399
        userBeanFour.fansCount = 360829
        userBeanFour.workCount = 562
        userBeanFour.dynamicCount = 570
        userBeanFour.likeCount = 4310
        userList.add(userBeanFour)
        videoBeanFour.userBean = userBeanFour

        val videoBeanFive = VideoBean()
        videoBeanFive.content = "联想裁员200人 #互联网  #裁员 "
        videoBeanFive.videoRes = "http://43.143.240.89:8080/5.mp4"
        videoBeanFive.distance = 9.2f
        videoBeanFive.isFocused = false
        videoBeanFive.isLiked = false
        videoBeanFive.likeCount = 8293241
        videoBeanFive.commentCount = 982
        videoBeanFive.shareCount = 8923

        val userBeanFive = UserBean()
        userBeanFive.uid = 5
        userBeanFive.head = R.mipmap.head5
        userBeanFive.nickName = "程序员"
        userBeanFive.sign = "键盘造梦师  在0与1的缝隙里种玫瑰"
        userBeanFive.subCount = 1002342
        userBeanFive.focusCount = 87
        userBeanFive.fansCount = 520232
        userBeanFive.workCount = 89
        userBeanFive.dynamicCount = 122
        userBeanFive.likeCount = 9
        userList.add(userBeanFive)
        videoBeanFive.userBean = userBeanFive

        val videoBeanSix = VideoBean()
        videoBeanSix.content = "音乐  #乐器 "
        videoBeanSix.videoRes = "http://43.143.240.89:8080/6.mp4"
        videoBeanSix.distance = 16.4f
        videoBeanSix.isFocused = true
        videoBeanSix.isLiked = true
        videoBeanSix.likeCount = 2109823
        videoBeanSix.commentCount = 9723
        videoBeanFive.shareCount = 424

        val userBeanSix = UserBean()
        userBeanSix.uid = 6
        userBeanSix.head = R.mipmap.head6
        userBeanSix.nickName = "音乐人"
        userBeanSix.sign = "一个行走在音符之间的人\n 有什么不懂的可以来直播间问我"
        userBeanSix.subCount = 29342320
        userBeanSix.focusCount = 67
        userBeanSix.fansCount = 7028323
        userBeanSix.workCount = 5133
        userBeanSix.dynamicCount = 5159
        userBeanSix.likeCount = 0
        userList.add(userBeanSix)
        videoBeanSix.userBean = userBeanSix

        val videoBeanSeven = VideoBean()
        videoBeanSeven.content = "电影解说 倒霉的海盗 #海盗"
        videoBeanSeven.videoRes = "http://43.143.240.89:8080/7.mp4"
        videoBeanSeven.distance = 16.4f
        videoBeanSeven.isFocused = false
        videoBeanSeven.isLiked = false
        videoBeanSeven.likeCount = 185782
        videoBeanSeven.commentCount = 2452
        videoBeanSeven.shareCount = 3812

        val userBeanSeven = UserBean()
        userBeanSeven.uid = 7
        userBeanSeven.head = R.mipmap.head7
        userBeanSeven.nickName = "Sean"
        userBeanSeven.sign = "云深不知处"
        userBeanSeven.subCount = 471932
        userBeanSeven.focusCount = 482
        userBeanSeven.fansCount = 371423
        userBeanSeven.workCount = 242
        userBeanSeven.dynamicCount = 245
        userBeanSeven.likeCount = 839
        userList.add(userBeanSeven)
        videoBeanSeven.userBean = userBeanSeven

        val videoBeanEight = VideoBean()
        videoBeanEight.content = "甲流来袭"
        videoBeanEight.videoRes = "http://43.143.240.89:8080/8.mp4"
        videoBeanEight.distance = 8.4f
        videoBeanEight.isFocused = false
        videoBeanEight.isLiked = false
        videoBeanEight.likeCount = 1708324
        videoBeanEight.commentCount = 8372
        videoBeanEight.shareCount = 982

        val userBeanEight = UserBean()
        userBeanEight.uid = 8
        userBeanEight.head = R.mipmap.head8
        userBeanEight.nickName = "曹小"
        userBeanEight.sign = "一个晒娃狂魔班主任，平日里没啥爱好！喜欢拿着手机记录孩子成长片段！"
        userBeanEight.subCount = 1832342
        userBeanEight.focusCount = 397
        userBeanEight.fansCount = 1394232
        userBeanEight.workCount = 164
        userBeanEight.dynamicCount = 167
        userBeanEight.likeCount = 0
        userList.add(userBeanEight)
        videoBeanEight.userBean = userBeanEight

        datas.add(videoBeanOne)
        datas.add(videoBeanTwo)
        datas.add(videoBeanThree)
        datas.add(videoBeanFour)
        datas.add(videoBeanFive)
        datas.add(videoBeanSix)
        datas.add(videoBeanSeven)
        datas.add(videoBeanEight)
        datas.add(videoBeanOne)
        datas.add(videoBeanTwo)
        datas.add(videoBeanThree)
        datas.add(videoBeanFour)
        datas.add(videoBeanFive)
        datas.add(videoBeanSix)
        datas.add(videoBeanSeven)
        datas.add(videoBeanEight)
    }

    companion object {
        @JvmField
        var datas = ArrayList<VideoBean>()
        @JvmField
        var userList = ArrayList<UserBean>()
    }
}