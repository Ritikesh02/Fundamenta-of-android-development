package com.example.foodapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Upper() {
    Column (
        Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF4CAF50))
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
    ){
        Text(text = "Little Lemon", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFFF4CE14))
        Text(text = "Chicago", fontSize = 16.sp , color = Color(0xFFFFFFFF))
        Row (
            Modifier.padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "We are a family owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFFFFFFFF),
                modifier = Modifier
                    .padding(bottom = 28.dp, end = 20.dp)
                    .fillMaxWidth(0.6f)
                )
            Image(painter = painterResource(id = R.drawable.upperpanelimage), contentDescription ="body",
                modifier = Modifier.clip(RoundedCornerShape(10.dp)))
        }
        Button(onClick = { /*TODO*/ } ,
            shape = RoundedCornerShape(20),
            colors = ButtonDefaults.buttonColors(Color.Yellow),
            elevation =  ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            )
            ) {
            Text(text = "Order Take Away", color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UpperPreview() {
    Upper()
}