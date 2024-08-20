package kr.co.ipdisk.quiz.data

data class Question(
    /* 문제 번호 */
    var id:Int,
    /* 문제 점수 */
    var questionScore : Int,
    /* 문제 질문 */
    var question: String,
    /* 답 선택 옵션 1 */
    var optionOne: String,
    /* 답 선택 옵션 2 */
    var optionTwo: String,
    /* 답 선택 옵션 3 */
    var optionThree: String,
    /* 답 선택 옵션 4 */
    var optionFour: String,
    /* 문제 정답 */
    var correctAnswer: Int,
    /* 이미지 URL */
    var imagePath : String
)
