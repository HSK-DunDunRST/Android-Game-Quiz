package kr.co.ipdisk.quiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kr.co.ipdisk.quiz.data.UserData
import kr.co.ipdisk.quiz.databinding.MainActivityBinding
import kr.co.ipdisk.quiz.databinding.QuestionActivityBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainBinding : MainActivityBinding
    private lateinit var questionBinding: QuestionActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = MainActivityBinding.inflate(layoutInflater)
        questionBinding = QuestionActivityBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.btnStart.setOnClickListener {
            if (mainBinding.userName.text.toString().isEmpty()) {
                /* text라인에서 이름을 입력받지 못했다면 짧게 토스트메세지 */
                Toast.makeText(this,"닉네임을 입력하십시요", Toast.LENGTH_SHORT).show()
            } else { /* Activity 간의 데이터 전송 및 호출 & 전환 코드 수정 해야됨.*/
                /* Activity 전환시 전송할 userName 데이터 변수 */
                val userName = mainBinding.userName.text
                /* Activity 전환시 전송할 UserData 객체 */
                val intentData = UserData(userName.toString(),0,0)
                /*데이터를 전송할 Activity */
                val intent = Intent(this, QuestionActivity::class.java)
//                Log.v("userName", userName.toString())
                intent.putExtra("Main_userData", intentData) //이름전송
//                Log.v("putExtra",QuestionData.USER_NAME)
                /* activity 전환, 이동 액션 수행 */
                startActivity(intent)
                //종료, 스택방지
                finish()
            }
        }
    } // onCreate

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}