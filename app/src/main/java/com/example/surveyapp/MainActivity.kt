package com.example.surveyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    private lateinit var resetButton: Button
    private lateinit var surveyQuestion: TextView
    private lateinit var yesCountView: TextView
    private lateinit var noCountView: TextView

    private var yesCount = 0
    private var noCount= 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        surveyQuestion = findViewById(R.id.survey_question)
        yesButton = findViewById(R.id.yes_button)
        noButton = findViewById(R.id.no_button)
        yesCountView = findViewById(R.id.yesCountText)
        noCountView = findViewById(R.id.noCountText)
        resetButton = findViewById(R.id.reset_button)


        yesButton.setOnClickListener {
            addToYesCount()
        }

        noButton.setOnClickListener {
            addToNoCount()

        }

        resetButton.setOnClickListener {
            resetCount()

        }
    }

    private fun addToYesCount() {

        yesCount++
        updateCounts()
    }

    private fun addToNoCount() {

        noCount++
        updateCounts()

    }

    private fun updateCounts() {
        yesCountView.text = getString(R.string.yes_vote_message, yesCount)
        noCountView.text = getString(R.string.no_vote_message, noCount)
    }

    private fun resetCount() {
        yesCountView.text = " "
        noCountView.text = " "
        yesCount = 0
        noCount = 0
    }
}