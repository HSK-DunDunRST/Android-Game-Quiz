package kr.co.ipdisk.quiz

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kr.co.ipdisk.quiz.data.Question
import kr.co.ipdisk.quiz.data.UserData
import kr.co.ipdisk.quiz.data.QuestionData
import kr.co.ipdisk.quiz.databinding.NewRecordActivityBinding

class NewRecordActivity : AppCompatActivity() {

    private lateinit var newRecordActivityBinding: NewRecordActivityBinding
    private lateinit var questionList: ArrayList<Question>
    private lateinit var userData : UserData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newRecordActivityBinding = NewRecordActivityBinding.inflate(layoutInflater)
        setContentView(newRecordActivityBinding.root)

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
            newRecordActivityBinding.nicknameText.text = getString(R.string.correct_view,userData.userName,userData.score.toString())
            newRecordActivityBinding.showResult.text = "모두 맞추셨습니다!"
        }

        newRecordActivityBinding.btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

//    private fun refreshHistory(){
//        var historyList = "도전 기록!\n"
//
//        CoroutineScope(Dispatchers.Main).launch {
//            val historys = CoroutineScope(Dispatchers.IO).async {
//                resultDatabase.resultDao().getQuizResults()
//            }.await()
//
//            for(history in historys){
//                historyList += "닉네임: ${history.userName}, "
//            }
//        }
//    }
}