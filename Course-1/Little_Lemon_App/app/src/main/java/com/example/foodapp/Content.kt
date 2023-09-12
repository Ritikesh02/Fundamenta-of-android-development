package com.example.foodapp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Content(navController: NavController, dishes: List<Dish>) {
    Column (){
        val scroll = rememberScrollState()
        WeeklySpecialCard()
        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth(),
            columns = GridCells.Fixed(1),
            contentPadding = PaddingValues(10.dp),
            userScrollEnabled = true
        ) {
             itemsIndexed(dishes) { _, dish ->
                MenuDish(navController, dish)
            }
        }
    }
}



@Composable
fun WeeklySpecialCard() {
    Text(text = "Weekly Special",
        Modifier.padding(8.dp),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuDish(navController: NavController, dish: Dish) {
    val cardShape = RoundedCornerShape(16.dp)
    Card(
        onClick = {
            Log.d("AAA", "Click ${dish.id}")
            navController?.navigate(Dishdetails.route + "/${dish.id}")
        },
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .shadow(
                shape = cardShape,
                spotColor = Color.DarkGray,
                elevation = 20.dp,
            )
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        )
        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column (
                Modifier.fillMaxWidth(0.7f)
            ){
                Text(text = dish.name,
                    Modifier.padding(start = 10.dp , end = 5.dp),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                    )
                Text(text = dish.description,
                    Modifier.padding(start = 10.dp , end = 5.dp),
                    fontSize = 12.sp
                    )
                Text(text = "₹${dish.price}",
                    Modifier.padding(top = 5.dp , start = 10.dp , end = 5.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                    )
            }
            Image(painter = painterResource(id = dish.imageResource),
                contentDescription = "",
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape) // clip to the circle shape
                    .border(1.dp, Color.Gray, CircleShape) // add a border (optional)
                )
        }
    }
    Divider(
        thickness = 3.dp,
        color = Color.Yellow
    )
}

