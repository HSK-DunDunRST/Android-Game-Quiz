```markdown
# 퀴즈 예제 (Quiz Example)

이 프로젝트는 안드로이드 플랫폼에서 동작하는 퀴즈 애플리케이션입니다. Kotlin을 기반으로 개발되었으며, 사용자는 다양한 질문에 답하면서 자신의 지식을 테스트하고, 맟춘 문제수를 확인할 수 있습니다.

## 주요 기능

### 1. 퀴즈 진행
- 사용자는 제공된 여러 가지 질문에 답할 수 있습니다.
- 각 질문에 대해 여러 선택지가 제공되며, 사용자는 올바른 답을 선택해야 합니다.

### 2. 점수 기록 및 관리
- 퀴즈를 완료하면 사용자의 점수가 계산됩니다.

### 3. 간단하고 직관적인 사용자 인터페이스
- 사용자가 쉽게 접근하고 사용할 수 있는 직관적인 UI를 제공합니다.
- 결과 페이지에서 사용자의 점수를 확인할 수 있습니다.

## 프로젝트 구조

```
Quiz_Example/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/kr/co/ipdisk/quiz/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── QuestionActivity.kt
│   │   │   │   ├── ResultActivity.kt
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── activity_question.xml
│   │   │   │   │   ├── activity_result.xml
│   │   │   │   ├── drawable/
│   │   │   │   ├── values/
│   │   │   │   ├── mipmap/
│   ├── build.gradle
│   ├── settings.gradle
│
├── gradle/
│   ├── wrapper/
│   │   ├── gradle-wrapper.jar
│   │   ├── gradle-wrapper.properties
├── build.gradle
├── gradlew
├── gradlew.bat
├── .gitignore
├── README.md
```

### 주요 파일 및 디렉터리 설명

- **`app/src/main/java/kr/co/ipdisk/quiz/`**: 애플리케이션의 핵심 로직이 포함된 Kotlin 파일들이 위치합니다.
  - **`MainActivity.kt`**: 앱의 메인 액티비티로, 퀴즈의 시작 화면을 담당합니다.
  - **`QuestionActivity.kt`**: 각 퀴즈 질문을 표시하고 사용자의 응답을 처리하는 액티비티입니다.
  - **`ResultActivity.kt`**: 퀴즈 완료 후 결과를 표시하는 액티비티입니다.

- **`app/src/main/res/`**: 애플리케이션의 리소스 파일들이 포함된 디렉터리입니다.
  - **`layout/`**: 각 화면의 레이아웃을 정의한 XML 파일들이 위치합니다.
  - **`drawable/`**: 이미지 리소스가 포함된 디렉터리입니다.
  - **`values/`**: 색상, 문자열, 테마 등의 값을 정의한 리소스 파일들이 위치합니다.

- **`gradle/`**: Gradle 빌드 시스템 관련 파일들이 포함된 디렉터리입니다.

## 설치 및 실행 방법

### 1. 클론하기

GitHub에서 이 프로젝트를 로컬로 클론합니다.

```bash
git clone https://github.com/yourusername/quiz-example.git
cd quiz-example
```

### 2. Android Studio로 열기

Android Studio에서 `quiz-example` 디렉터리를 열어 프로젝트를 불러옵니다.

### 3. 프로젝트 빌드 및 실행

1. Android Studio에서 프로젝트를 빌드합니다 (`Build > Make Project`).
2. 실제 디바이스나 에뮬레이터를 통해 앱을 실행합니다 (`Run > Run 'app'`).
