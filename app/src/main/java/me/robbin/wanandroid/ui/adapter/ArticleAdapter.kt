package me.robbin.wanandroid.ui.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import me.robbin.mvvmscaffold.utils.toToast
import me.robbin.wanandroid.R
import me.robbin.wanandroid.data.bean.ArticleBean
import me.robbin.wanandroid.databinding.RvItemArticleBinding

/**
 *
 * Create by Robbin at 2020/7/11
 */
class ArticleAdapter(private val context: Context) :
    PagingDataAdapter<ArticleBean, ArticleViewHolder>(POST_COMPARATOR) {

    companion object {
        val POST_COMPARATOR = object : DiffUtil.ItemCallback<ArticleBean>() {
            override fun areItemsTheSame(oldItem: ArticleBean, newItem: ArticleBean): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ArticleBean, newItem: ArticleBean): Boolean =
                oldItem == newItem
        }
    }

    interface OnArticleItemClickListener {
        fun setNavController(): NavController
    }

    private var listener: OnArticleItemClickListener? = null

    fun setOnArticleItemClickListener(listener: OnArticleItemClickListener) {
        this.listener = listener
    }

    private var view: View? = null

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val binding = DataBindingUtil.getBinding<RvItemArticleBinding>(holder.itemView)
        binding?.route = this.RouteClick()
        binding?.bean = getItem(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding: RvItemArticleBinding =
            DataBindingUtil.inflate(inflater, R.layout.rv_item_article, parent, false)
        view = binding.root
        return ArticleViewHolder(binding)
    }

    inner class RouteClick {
        fun goWeb(bean: ArticleBean) {
            val bundle = Bundle()
            bundle.putParcelable("article", bean)
            view?.let {
                listener?.setNavController()
                    ?.navigate(R.id.action_global_to_webFragment, bundle)
            }
        }

        fun goAuthorProfile() {
            "Hello Author".toToast()
        }

        fun goChapter() {
            "Hello Chapter".toToast()
        }

    }

}

class ArticleViewHolder(binding: RvItemArticleBinding) : RecyclerView.ViewHolder(binding.root)
