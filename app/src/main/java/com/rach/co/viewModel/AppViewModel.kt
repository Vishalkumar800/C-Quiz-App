package com.rach.co.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rach.co.dataClass.DummyQuestionData
import com.rach.co.dataClass.QuestionDataClass
import com.rach.co.navigation.Screens
import com.rach.co.roomDatabase.CheckingRepository
import com.rach.co.roomDatabase.Graph
import com.rach.co.roomDatabase.ProfileEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


data class ProfileFields(
    val label: String,
    val title: String = "",
    val showError: Boolean = false
)

class AppViewModel(private val repository: CheckingRepository = Graph.checkingRepository) :
    ViewModel() {
    private val _currentScreen: MutableState<Screens> = mutableStateOf(Screens.DrawerScreen.Home)

    val currentScreens: MutableState<Screens> get() = _currentScreen

    // currentQuiz
    private val _currentQuiz = MutableStateFlow<QuestionDataClass?>(null)
    val currentQuiz: StateFlow<QuestionDataClass?> get() = _currentQuiz

    private val _answerStatus = MutableStateFlow<MutableList<Boolean>>(mutableListOf())


    // currentQuestionIndex

    private val _currentQuestionIndex = MutableStateFlow(0)
    val currentQuestionIndex: StateFlow<Int> get() = _currentQuestionIndex

    private val _score = MutableStateFlow(0)
    val score: StateFlow<Int> = _score

    init {
        updateCurrentQuiz(DummyQuestionData.itemList.first())
    }

    fun updateCurrentQuiz(quiz: QuestionDataClass) {
        _currentQuiz.value = quiz
        _currentQuestionIndex.value = 0
        _score.value = 0
       _answerStatus.value = MutableList(quiz.questionList.size){false}
    }

    fun handleAnswer(selectedAns: String) {
        val currentQuestion =
            _currentQuiz.value?.questionList?.getOrNull(_currentQuestionIndex.value)

        if (currentQuestion != null) {
            val correctAns = currentQuestion.correct == selectedAns
            val currentIndex = _currentQuestionIndex.value

            if (_answerStatus.value[currentIndex] != correctAns){
                if (correctAns) _score.value ++ else _score.value--
                _answerStatus.value[currentIndex] = correctAns
            }


        }
    }

    fun goToNextQuestion() {
        val quiz = _currentQuiz.value
        if (quiz != null && _currentQuestionIndex.value < quiz.questionList.size - 1) {
            _currentQuestionIndex.value++

        }

    }

    fun goToPreviousQuestion() {
        val currentIndex = _currentQuestionIndex.value

        if (currentIndex > 0 && _answerStatus.value[currentIndex - 1]) {
            _score.value--
            _answerStatus.value[currentIndex - 1] = false
        }

        if (currentIndex > 0) {
            _currentQuestionIndex.value--
        }
    }

    /// Profile ViewModel

    private val _fields = MutableStateFlow(
        listOf(
            ProfileFields("Name"),
            ProfileFields("Email"),
            ProfileFields("Hobby" ),
            ProfileFields("favouriteCodingLanguage")
        )
    )

    val fields: StateFlow<List<ProfileFields>> = _fields

    private val _editFields = MutableStateFlow(
        listOf(
            ProfileFields("Name"),
            ProfileFields("Email"),
            ProfileFields("Hobby"),
            ProfileFields("favouriteCodingLanguage")
        )
    )

    val editFields: StateFlow<List<ProfileFields>> = _editFields

    fun updateFields(index: Int, newValue: String) {
        _editFields.value = _editFields.value.toMutableList().apply {
            this[index] = this[index].copy(
                title = newValue,
                showError = newValue.isEmpty()
            )
        }
    }

    fun validateFields(): Boolean {
        var isValid = true
        _editFields.value = _editFields.value.map { field ->
            if (field.title.isEmpty()) {
                isValid = false
                field.copy(showError = true)
            } else {
                field
            }

        }

        return isValid
    }
    // Room Database

    private val _isLoading = MutableStateFlow(false)
    val isLoading:StateFlow<Boolean> = _isLoading

    init {
        loadProfileData()
    }

    fun profileSave(){
        viewModelScope.launch {
            _isLoading.value= true
            val profileSave = _editFields.value
            repository.insertDao(
                profileEntity = ProfileEntity(
                    id = 1,
                    name = profileSave[0].title,
                    email = profileSave[1].title,
                    hobby =profileSave[2].title ,
                    favouriteCodingLanguage =profileSave[3].title
                )
            )
            delay(2000)
            _isLoading.value = false
        }
    }

    private fun loadProfileData(){
        viewModelScope.launch {
            val profile = repository.getAlLData()
            if (profile == null){
                _fields.value = listOf(
                    ProfileFields("Name", "None"),
                    ProfileFields("Email", "None"),
                    ProfileFields("Hobby", "None"),
                    ProfileFields("favouriteCodingLanguage", "C++")
                )
            }else{
                _fields.value = listOf(
                    ProfileFields("Name", profile.name!!),
                    ProfileFields("Email", profile.email!!),
                    ProfileFields("Hobby", profile.hobby!!),
                    ProfileFields("favouriteCodingLanguage", profile.favouriteCodingLanguage!!)
                )
            }
        }
    }


}