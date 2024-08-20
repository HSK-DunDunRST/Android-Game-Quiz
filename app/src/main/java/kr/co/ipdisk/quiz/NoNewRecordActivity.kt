package kr.co.ipdisk.quiz

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kr.co.ipdisk.quiz.data.Question
import kr.co.ipdisk.quiz.data.UserData
import kr.co.ipdisk.quiz.data.QuestionData
import kr.co.ipdisk.quiz.databinding.NonewRecordActivityBinding

class NoNewRecordActivity : AppCompatActivity() {

    private lateinit var nonewRecordActivityBinding: NonewRecordActivityBinding
    private lateinit var questionList: ArrayList<Question>
    private lateinit var userData : UserData

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nonewRecordActivityBinding = NonewRecordActivityBinding.inflate(layoutInflater)
        setContentView(nonewRecordActivityBinding.root)

        questionList = QuestionData.getQuestion()

        // SDK 버전에 따라 getParcelableExtra 메서드 사용
        val userData: UserData? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("question_userData", UserData::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("question_userData")
        }
        // 전달된 Data 객체 받기
        if (userData != null) {
            nonewRecordActivityBinding.nicknameText.text = getString(R.string.correct_view,userData.userName,userData.score.toString())
            nonewRecordActivityBinding.showResult.text = getString(R.string.showScore,questionList.size.toString(),userData.correctAnswer.toString())
        }

        nonewRecordActivityBinding.btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}