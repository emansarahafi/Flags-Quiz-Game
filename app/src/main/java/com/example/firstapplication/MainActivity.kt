// Student Name: Eman Sarah Afi

package com.example.firstapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Declare variables for UI elements
    private var tvQuestion: TextView? = null
    private var ivCountry: ImageView? = null
    private var pbQuizProgress: ProgressBar? = null
    private var tvQuizProgress: TextView? = null
    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnSubmit: Button? = null
    private var mQuestionsList: ArrayList<Question>? = null
    private var mCurrentPosition: Int = 1
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private val options = ArrayList<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        // Find views by id
        tvQuestion = findViewById(R.id.tv_question)
        ivCountry = findViewById(R.id.iv_country)
        pbQuizProgress = findViewById(R.id.pb_quiz_progress)
        tvQuizProgress = findViewById(R.id.tv_quiz_progress)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
        mQuestionsList = Constants.getQuestions()

        // Call setQuestion to display the first question
        setQuestion()

    }

    private fun setQuestion() {
        // TODO: call defaultOptionsTextView
        defaultOptionsTextView()

        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        ivCountry?.setImageResource(question.image)
        pbQuizProgress?.progress = mCurrentPosition
        tvQuizProgress?.text = getString(R.string.quiz_progress_text, mCurrentPosition, pbQuizProgress?.max)
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        // TODO: Handle the text on the submit button based on the current question's position.
        // If the question reaches the end, then display 'Finish' in button; else, display 'Submit'.
        if (mCurrentPosition == mQuestionsList!!.size) {
            btnSubmit?.setText(R.string.finish)
        } else {
            btnSubmit?.setText(R.string.submit_text)
        }
    }
    private fun defaultOptionsTextView() {
        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT

            option.background = ContextCompat.getDrawable(
                this@MainActivity, R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum: Int){
        defaultOptionsTextView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)

        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tv_option_one -> { tvOptionOne?.let{
                selectedOptionView(it,1) }
            }
            R.id.tv_option_two -> { tvOptionTwo?.let{
                selectedOptionView(it,2) }
            }
            R.id.tv_option_three -> { tvOptionThree?.let{
                selectedOptionView(it,3) }
            }
            R.id.tv_option_four -> { tvOptionFour?.let{
                selectedOptionView(it,4) }
            }
            R.id.btn_submit ->{
                if(mSelectedOptionPosition == 0) {
                    // Code for when no option is selected
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else ->{
                            val intent = Intent(this,ResultActivity::class.java)

                            intent.putExtra(Constants.CORRECT_ANS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)

                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    // Code for when an option is selected
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btnSubmit?.setText(R.string.finish)
                    } else {
                        btnSubmit?.setText(R.string.next_question)
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer : Int, drawableView : Int){
        when(answer) {
            1 ->{
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 ->{
                tvOptionTwo?.background = ContextCompat.getDrawable( this@MainActivity,
                    drawableView
                )
            }
            3 ->{
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this@MainActivity,
                    drawableView
                )
            }
            4 ->{
                tvOptionFour?.background = ContextCompat.getDrawable( this@MainActivity,
                    drawableView
                )
            }
        }
    }
}
