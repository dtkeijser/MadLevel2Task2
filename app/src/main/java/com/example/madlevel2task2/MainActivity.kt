package com.example.madlevel2task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val questions = arrayListOf<Question>()
    private val questionAdapter = QuestionAdapter(questions)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews(){
        binding.rvQuestion.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL,false)
        binding.rvQuestion.adapter = questionAdapter

        for (key in Question.questions.keys){
            questions.add(Question(key, Question.questions.getValue(key) ))
        }

        createItemTouchHelper().attachToRecyclerView(binding.rvQuestion)

    }

    private fun createItemTouchHelper(): ItemTouchHelper{
        val callback = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition

                if (direction == 4) { //left swipe
                    if (!questions.get(position).answer) {
                        questions.removeAt(position)
                    }
                    else {
                        Snackbar.make(binding.rvQuestion, "Wrong! The Question will not be removed.", Snackbar.LENGTH_SHORT).show()
                    }
                }
                if (direction == 8) { //right swipe
                    if (questions.get(position).answer) {
                        questions.removeAt(position)
                    }
                    else {
                        Snackbar.make(binding.rvQuestion, "Wrong! The Question will not be removed.", Snackbar.LENGTH_SHORT).show()
                    }
                }
                questionAdapter.notifyDataSetChanged()
            }
        }
        return ItemTouchHelper(callback)
    }
}