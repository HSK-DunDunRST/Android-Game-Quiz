package kr.co.ipdisk.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kr.co.ipdisk.quiz.data.UserData
import kr.co.ipdisk.quiz.data.Question
import kr.co.ipdisk.quiz.data.QuestionData
import kr.co.ipdisk.quiz.databinding.QuestionActivityBinding

class QuestionActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var questionBinding: QuestionActivityBinding
    private lateinit var questionList: ArrayList<Question>
    private lateinit var userData: UserData

    private var currentPosition: Int = 1
    private var selectOption: Int = 0
    private var correctAnswer: Int = 0
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        questionBinding = QuestionActivityBinding.inflate(layoutInflater)
        setContentView(questionBinding.root)
        /* MainActivty에서 받은 userData */
        userData = intent.getParcelableExtra("Main_userData")!!

        questionList = QuestionData.getQuestion()
        getQuestionData()

        questionBinding.option1Text.setOnClickListener(this)
        questionBinding.option2Text.setOnClickListener(this)
        questionBinding.option3Text.setOnClickListener(this)
        questionBinding.option4Text.setOnClickListener(this)

        questionBinding.submitBtn.setOnClickListener {
            if (selectOption != 0) {
                val question = questionList[currentPosition - 1]

                if (selectOption != question.correctAnswer) {
                    setColor(selectOption, R.drawable.option_error_background)
                    callDialog("오답", "${question.correctAnswer}")
                } else {
                    score += question.questionScore
                    correctAnswer++

                }
                setColor(question.correctAnswer, R.drawable.option_correct_background)
                setOptionsEnabled(false)

                if (currentPosition == questionList.size) {
                    setSubmitBtn("결과보기")
                } else {
                    setSubmitBtn("다음")
                }
            } else {
                currentPosition++
                if (currentPosition <= questionList.size) {
                    getQuestionData()
                    setOptionStyle()
                    setSubmitBtnEnabled(false)
                    setOptionsEnabled(true)
                } else { //문제가 끝까지 도달했을 때의 액션
                    userData.score = score
                    userData.correctAnswer = correctAnswer
                    if(score == questionList.size){
                        moveToNoNewRecordActivity()
                    }else{
                        moveToNoNewRecordActivity()
                    }

                }
            }
            selectOption = 0
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.option1_text -> selectedOptionEvent(questionBinding.option1Text, 1)
            R.id.option2_text -> selectedOptionEvent(questionBinding.option2Text, 2)
            R.id.option3_text -> selectedOptionEvent(questionBinding.option3Text, 3)
            R.id.option4_text -> selectedOptionEvent(questionBinding.option4Text, 4)
        }
    }

    private fun setColor(opt: Int, color: Int) {
        when (opt) {
            1 -> questionBinding.option1Text.background = ContextCompat.getDrawable(this, color)
            2 -> questionBinding.option2Text.background = ContextCompat.getDrawable(this, color)
            3 -> questionBinding.option3Text.background = ContextCompat.getDrawable(this, color)
            4 -> questionBinding.option4Text.background = ContextCompat.getDrawable(this, color)
        }
    }

    private fun callDialog(alertTitle: String, correctAnswer: String) {
        AlertDialog.Builder(this)
            .setTitle(alertTitle)
            .setMessage("정답: $correctAnswer")
            .setPositiveButton("확인") { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            .setCancelable(false)
            .show()
    }

    private fun getQuestionData() {
        val question = questionList[currentPosition - 1]
        questionBinding.nicknameText.text = getString(R.string.user_name,userData.userName)
        questionBinding.progressBar.progress = currentPosition
        questionBinding.progressBar.max = questionList.size
        questionBinding.progressText.text = getString(R.string.count_label, currentPosition, questionList.size)
        questionBinding.scoreText.text = getString(R.string.user_score, score)
        questionBinding.questionText.text = question.question
        questionBinding.option1Text.text = question.optionOne
        questionBinding.option2Text.text = question.optionTwo
        questionBinding.option3Text.text = question.optionThree
        questionBinding.option4Text.text = question.optionFour

        setSubmitBtn("제출")
        setSubmitBtnEnabled(false)
    }

    private fun setSubmitBtn(text: String) {
        questionBinding.submitBtn.text = getString(R.string.submit, text)
    }

    private fun setOptionStyle() {
        val optionList: ArrayList<TextView> = arrayListOf(
            questionBinding.option1Text,
            questionBinding.option2Text,
            questionBinding.option3Text,
            questionBinding.option4Text
        )

        for (op in optionList) {
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.option_background)
            op.typeface = Typeface.DEFAULT
        }
    }

    private fun selectedOptionEvent(view: TextView, opt: Int) {
        setOptionStyle()
        selectOption = opt

        view.setTextColor((Color.parseColor("#5F00FF")))
        view.background = ContextCompat.getDrawable(this, R.drawable.option_select_background)
        view.typeface = Typeface.DEFAULT

        setSubmitBtnEnabled(true)
    }

    private fun setSubmitBtnEnabled(enabled: Boolean) {
        questionBinding.submitBtn.isEnabled = enabled
        questionBinding.submitBtn.alpha = if (enabled) 1.0f else 0.5f
    }

    private fun moveToNewRecordActivity() {
        val intent = Intent(this, NewRecordActivity::class.java)
        intent.putExtra("question_userData", userData) //이름전송
        /* activity 전환, 이동 액션 수행 */
        startActivity(intent)
        //종료, 스택방지
        finish()
    }

    private fun moveToNoNewRecordActivity() {
        val intent = Intent(this, NoNewRecordActivity::class.java)
        intent.putExtra("question_userData", userData) //이름전송
        /* activity 전환, 이동 액션 수행 */
        startActivity(intent)
        //종료, 스택방지
        finish()
    }

    private fun setOptionsEnabled(enabled: Boolean) {
        questionBinding.option1Text.isClickable = enabled
        questionBinding.option2Text.isClickable = enabled
        questionBinding.option3Text.isClickable = enabled
        questionBinding.option4Text.isClickable = enabled
    }

    private fun restartQuiz() {
        currentPosition = 1
        userData.score = 0
        questionList = QuestionData.getQuestion()
        getQuestionData()
    }
}
