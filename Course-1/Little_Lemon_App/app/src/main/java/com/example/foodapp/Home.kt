package com.example.foodapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController) {
    Column (
        Modifier.fillMaxWidth().wrapContentHeight()
    ){
        Top()
        Upper()
        Content(navController,DishRepository.dishes)
    }
}