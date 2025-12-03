package com.bytedance.tiktok.bean

import com.bytedance.tiktok.bean.VideoBean.UserBean

/**
 * create by Random
 * create on 2025-12-3
 * description
 */
class CommentBean {
    var content: String? = null
        get() = if (field == null) "" else field
    var userBean: UserBean? = null
    var likeCount = 0
    var isLiked = false
}