package com.example.foodmenu


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

val categories = listOf("All", "Drinks", "Black tea", "Food", "Dessert")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, produectlist: List<ProductItem>) {
    var selectedCategory by remember { mutableStateOf(categories[0]) }
    Column {
        var showMenu by remember { mutableStateOf(false) }
        val context = LocalContext.current

        TopAppBar(
            title = { Text("Food Menu") },
            actions = {

                IconButton(onClick = { Toast.makeText(context, "Favorite", Toast.LENGTH_SHORT).show() }) {
                    Icon(Icons.Default.Favorite, "")
                }

                IconButton(onClick = { showMenu = !showMenu }) {
                    Icon(Icons.Default.MoreVert, "")
                }

                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false }
                ) {
                    categories.forEach {category ->
                        if (category == "All"){

                        }else{
                            DropdownMenuItem(text= { Text(text = category) },onClick = {
                                selectedCategory = category
                            }
                            )
                        }
                    }

                }


            }
        )
        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth(),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(20.dp),
            userScrollEnabled = true
        ) {
            itemsIndexed(produectlist.filter {it.category ==selectedCategory || selectedCategory == "All" }) { _, d ->
                Card(
                    onClick = {
                        Log.d("AAA", "Click ${d.id}")
                        navController?.navigate(Dishdetails.route + "/${d.id}")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .height(height = 150.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(size = 4.dp)
                        )
                        .shadow(
                            spotColor = Color.DarkGray,
                            elevation = 20.dp,
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(
                        Modifier.fillMaxSize(),
                    ) {
                        Image(
                            painter = painterResource(id = d.image), contentDescription = "",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .padding(top=5.dp)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Text(
                                text = d.title,
                                modifier = Modifier
                                    .align(Alignment.CenterStart)
                                    .padding(start = 12.dp),
                                style = TextStyle(
                                    fontSize = TextUnit.Unspecified
                                )
                            )
                            Text(
                                text = "${d.price}",
                                modifier = Modifier
                                    .align(Alignment.CenterEnd)
                                    .padding(end = 12.dp),
                                style = TextStyle(
                                    fontSize = TextUnit.Unspecified,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }
                Divider(
                    thickness = 3.dp,
                    color = Color.Yellow
                )
            }
        }
    }
}