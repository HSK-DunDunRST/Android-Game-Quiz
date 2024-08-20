package kr.co.ipdisk.quiz.data

import java.lang.Math.random
import java.lang.reflect.Array.set

object QuestionData {
    fun getQuestion() : ArrayList<Question>{
        val queList: ArrayList<Question> = arrayListOf()

        val question1 = Question(
            1,
            20,
            "그림에 보이는 국기는 어느 나리일까요?",
            "대한민국",
            "중국",
            "몽골",
            "일본",
            1,
            "res/anim/"
        )

        val question2 = Question(
            2,
            40,
            "문제 2번의 질문을 넣으십시요",
            "옵션1",
            "옵션2",
            "옵션3",
            "옵션4",
            2,
            "./"

        )

        val question3 = Question(
            3,
            15,
            "문제 3번의 질문을 넣으십시요",
            "옵션1",
            "옵션2",
            "옵션3",
            "옵션4",
            3,
            "./"

        )

        queList.add(question1)
        queList.add(question2)
        queList.add(question3)

        return getRandomQuestions(queList,queList.size)
    }

    private fun getRandomQuestions(questions: ArrayList<Question>, count: Int): ArrayList<Question> {
        val questionsList: ArrayList<Question> = arrayListOf()
        val tempList = questions.toList()
        while (questionsList.size < count && questionsList.size < tempList.size) {
            val randomQuestion = tempList.random()
            if (!questionsList.contains(randomQuestion)) {
                questionsList.add(randomQuestion)
            }
        }
        return questionsList
    }
}
