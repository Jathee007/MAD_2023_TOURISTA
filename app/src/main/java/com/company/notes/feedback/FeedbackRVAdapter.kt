package com.company.notes.feedback

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.company.notes.R

class FeedbackRVAdapter(private val feedbackRVModalArrayList: ArrayList<FeedbackModel>, val context: Context, val feedbackClickInterface: FeedbackClickInterface) : RecyclerView.Adapter<FeedbackRVAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_card_item, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvpaymentTitle.text = feedbackRVModalArrayList[position].review
        holder.tvrating.rating = feedbackRVModalArrayList[position].rating.toString().toFloat()
        holder.itemView.setOnClickListener {
            feedbackClickInterface.onFeedbackClick(position)
        }
    }

    override fun getItemCount(): Int {
        return feedbackRVModalArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvpaymentTitle: TextView
        lateinit var tvrating : RatingBar
        init {
            tvpaymentTitle = itemView.findViewById(R.id.tvcardnumber)
            tvrating=itemView.findViewById(R.id.ratingBar)
        }
    }
    interface FeedbackClickInterface {
        fun onFeedbackClick(position: Int)
    }
}