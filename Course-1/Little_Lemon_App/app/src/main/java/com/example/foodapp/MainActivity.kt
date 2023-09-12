package com.example.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.foodapp.ui.theme.FoodAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Home.route) {
                    composable(Home.route) {
                        Home(navController)
                    }
                    composable(
                        Dishdetails.route + "/{${Dishdetails.argDishId}}",
                        arguments = listOf(navArgument(Dishdetails.argDishId) { type = NavType.IntType })
                    ) {
                        val id =
                            requireNotNull(it.arguments?.getInt(Dishdetails.argDishId)) { "Dish id is null" }
                           Dishdetails(id)
                    }
                }
            }
        }
    }
}
//C:\Users\Ranjan Alok\Downloads\9v5j08WUQ2SNup61a4lQng_d7584d7ae33c4c89aaac904ea22022e1_C5M5L1-Item-05-Starter-Code (1).zip\C5M5L1 Item 05 Starter Code\app\src\main\java\com\example\littlelemon