package me.robbin.wanandroid.app.bindingadapter

import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import me.robbin.mvvmscaffold.utils.StatusBarUtils
import me.robbin.wanandroid.app.watcher.SimpleWatcher
import me.robbin.wanandroid.ext.addTopPadding

/**
 * 通用 BindingAdapter
 * Create by Robbin at 2020/7/17
 */

/**
 * 给 View 添加顶部 Padding，大部分情况下用于 Toolbar
 * @param flag 是否添加顶部 Padding
 * Create by Robbin at 2020/7/17
 */
@BindingAdapter("addStatusPadding")
fun addStatusPadding(view: View, flag: Boolean) {
    if (flag) view.addTopPadding(StatusBarUtils.getStatusBarHeight())
}

/**
 * EditText 绑定自定义 Watcher
 * @param watcher 自定义 Watcher
 * Create by Robbin at 2020/7/17
 */
@BindingAdapter("onTextChanged")
fun textChanged(view: EditText, watcher: SimpleWatcher) {
    view.addTextChangedListener(watcher)
}

/**
 * 设置当前组件是否可见
 * @param isVisible 控制标识
 * Create by Robbin at 2020/7/17
 */
@BindingAdapter("isVisible")
fun isVisible(view: View, isVisible: Boolean) {
    view.isVisible = isVisible
}

/**
 * 设置 Toolbar NavigationIcon 点击事件
 * @param action 点击事件
 * Create by Robbin at 2020/7/17
 */
@BindingAdapter("tbNavIconClick")
fun tbNavIconClick(view: Toolbar, action: () -> Unit) {
    view.setNavigationOnClickListener { action() }
}