package com.example.zelswa_180112_triviaapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zelswa_180112_triviaapp.data.Question

class GameViewModel : ViewModel(){

    private val _question = MutableLiveData<Question>()
    private val _currentQuestion = MutableLiveData<Int>()
    private val _score = MutableLiveData<Int>()
    private val _amountOfQuestions = MutableLiveData<Int>()
    private val _categoryQuestions = MutableLiveData<List<Question>>()

    fun setupGame(categoryId: Int){
        val newQuestion = questions.filter { question -> question.categoryId == categoryId  }
        _categoryQuestions.postValue(newQuestion)
        _question.value = newQuestion[0]
        _currentQuestion.value = 0
        _score.value = 0
        _amountOfQuestions.value = 3
    }

    val question: LiveData<Question> = _question
    val currentQuestion: LiveData<Int> = _currentQuestion
    val score: LiveData<Int> = _score
    val amountOfQuestions : LiveData<Int> = _amountOfQuestions

    fun updateQuestion(index: Int){
        _question.value = _categoryQuestions.value?.get(index.plus(1))
        _currentQuestion.value = index.plus(1)
    }
    fun checkQuestion(answer: Int){
        val validAnswer: String? = question.value?.correctAnswer
        val submittedAnswer: String? = question.value?.answers?.get(answer)
        if(submittedAnswer == validAnswer){
            _score.value = score.value?.plus(1)
        }
    }
    private val questions = listOf(
        Question("Who is Batmans' sidekick?",1, listOf("Robin","Raven","Rocco"),"Robin"),
        Question("Are superheroes humans?",2, listOf("Yes","No","Maybe"),"Yes"),
        Question("Can all superheroes fly?",2, listOf("Yes","No","Just Some"),"Just Some"),
        Question("First Question",3, listOf("answerOne","answerTwo","answerThree"),"answerOne"),
        Question("Is Batman really a superhero?",1, listOf("No, just rich!","Yes","No"),"No, just rich!"),
        Question("Are all superheroes men?",2, listOf("Yes","Obviously","NO"),"NO"),
        Question("Fourth Question",2, listOf("answerOne","answerTwo","answerThree"),"answerOne"),
        Question("Second Question",3, listOf("answerOne","answerTwo","answerThree"),"answerOne"),
        Question("What is Supermans' real name?",1, listOf("Clark","Kent","Jack"),"Clark"),
        Question("Fifth Question",2, listOf("answerOne","answerTwo","answerThree"),"answerOne"),
        Question("Sixth Question",2, listOf("answerOne","answerTwo","answerThree"),"answerOne"),
        Question("Third Question",3, listOf("answerOne","answerTwo","answerThree"),"answerOne")
    )
}




