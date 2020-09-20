package com.example.madlevel2task2

data class Question( var question: String,
                     var answer: Boolean) {


    companion object{
        val questions = mapOf<String, Boolean> (
            "10*10=100" to true,
            "A dog has four legs" to true,
            "swimming is not tiresome" to false,
            "muscle strain is pleasant" to false
        )
    }

}