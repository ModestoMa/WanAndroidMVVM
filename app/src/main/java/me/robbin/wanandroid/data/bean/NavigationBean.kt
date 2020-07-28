package me.robbin.wanandroid.data.bean

/**
 * 导航
 * Created by Robbin on 2020-07-21
 */
data class NavigationBean(
    var cid: Int,
    var name: String,
    var articles: List<ArticleBean>
)