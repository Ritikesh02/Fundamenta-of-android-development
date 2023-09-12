package com.example.foodmenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun ProductDetails(id: Int?) {
    val productItem = requireNotNull(id?.let { DishRepository.getDish(it) })
    Column (
        modifier = Modifier.padding(top = 10.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = productItem.image), contentDescription = productItem.title,
            modifier = Modifier
                .shadow(
                    elevation = 20.dp,
                    spotColor = Color.DarkGray
                )
                .clip(RoundedCornerShape(20.dp))
                .width(200.dp)
                .height(200.dp).align(Alignment.CenterHorizontally)
        )
        Text(text = productItem.title ,
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(text = "Price: $${productItem.price}")
        Text(text = "Category: ${productItem.category}")
    }
}