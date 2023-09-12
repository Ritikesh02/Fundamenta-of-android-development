package com.example.foodmenu

interface Destination{
    val route : String
}

object Home : Destination{
    override val route = "Home"
}

object Dishdetails : Destination{
    override val route = "Menu"
    const val argDishId = "dishID"
}