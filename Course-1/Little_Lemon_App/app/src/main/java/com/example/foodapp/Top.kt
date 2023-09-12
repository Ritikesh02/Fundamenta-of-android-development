package com.example.foodapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Top() {
    Row(
        Modifier
            .fillMaxWidth().background(Color(0xff91a4fc)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /*TODO*/ },

        ) {
            Image(painter = painterResource(id = R.drawable.menu),
                contentDescription ="menu" ,
                modifier = Modifier.size(24.dp))

        }
        Image(painter = painterResource(id = R.drawable.littlelemonimgtxt),
            contentDescription ="logo" ,
            modifier = Modifier.fillMaxWidth(0.5f).padding(horizontal = 20.dp))
        IconButton(onClick = { /*TODO*/ },

            ) {
            Image(painter = painterResource(id = R.drawable.ic_cart),
                contentDescription ="menu" ,
                modifier = Modifier.width(200.dp))

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Toppreview() {
    Top()
}