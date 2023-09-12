package com.example.foodmenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home"){
                composable("home"){
                    HomeScreen(navController,DishRepository.productsList)
                }
                composable(
                    Dishdetails.route + "/{${Dishdetails.argDishId}}",
                    arguments = listOf(navArgument(Dishdetails.argDishId) { type = NavType.IntType })
                ) {
                    val id =
                        requireNotNull(it.arguments?.getInt(Dishdetails.argDishId)) { "Dish id is null" }
                    ProductDetails(id)
                }
            }
        }
    }
}


