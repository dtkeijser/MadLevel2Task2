package com.example.madlevel2task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task2.databinding.ItemQuestionBinding


class QuestionAdapter (private val question: List<Question>):  RecyclerView.Adapter<QuestionAdapter.ViewHolder>(){

    inner class ViewHolder(questionView: View) : RecyclerView.ViewHolder(questionView) {
        val binding = ItemQuestionBinding.bind(questionView)

        fun databind(question: Question) {
            binding.textView2.text = question.question
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_question,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return question.size
    }

    override fun onBindViewHolder(holder: QuestionAdapter.ViewHolder, position: Int) {
        holder.databind(question[position])
    }

}