/*
To create ViewModel, right click on 'java' 'com.example.surveyapp' with "New" Kotlin Class/File,
Class.
 */

package com.example.surveyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    private lateinit var resetButton: Button
    private lateinit var surveyQuestion: TextView
    private lateinit var yesCountView: TextView
    private lateinit var noCountView: TextView

//    private var yesCount = 0
//    private var noCount= 0

    // Create Global variable
    private val votesViewModel by lazy {
        ViewModelProvider(this).get(VotesViewModel::class.java)
    }

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
// Updates the votes (especially when rotated/destroyed)
        updateCounts()
    }

    private fun addToYesCount() {
    // Original design
//        yesCount++
        // Creates a ViewModel to store the data when destroyed
        votesViewModel.yesCounts++
        updateCounts()
    }

    private fun addToNoCount() {
        // Original design
//        noCount++
        // Creates a ViewModel to store the data when destroyed
        votesViewModel.noCounts++
        updateCounts()

    }

    private fun updateCounts() {
        // yesCountView.text = getString(R.string.yes_vote_message, yesCounts)
        //  noCountView.text = getString(R.string.no_vote_message, noCounts)

        yesCountView.text = getString(R.string.yes_vote_message, votesViewModel.yesCounts)
        noCountView.text = getString(R.string.no_vote_message, votesViewModel.noCounts)
    }

    private fun resetCount() {
        yesCountView.text = " "
        noCountView.text = " "
//        yesCount = 0
//        noCount = 0
        votesViewModel.yesCounts = 0
        votesViewModel.noCounts = 0
    }
}