package com.example.zelswa_180112_triviaapp.data

data class Question (
    val question: String,
    val categoryId: Int,
    val answers: List<String>,
    val correctAnswer: String
)