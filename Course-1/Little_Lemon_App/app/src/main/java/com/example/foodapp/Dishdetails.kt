package com.example.foodapp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.waterfallPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Dishdetails(Id :Int) {
    var totalCost : Double
    val dish = requireNotNull(DishRepository.getDish(Id))
    fun Double.roundDecimal(digit: Int) = "%.${digit}f".format(this)
    val contest = LocalContext.current
    Column (
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .fillMaxSize()
            .padding(0.dp)
            .background(Color.White)
    ){
        Top()
        Column (
            Modifier
                .fillMaxWidth()
                .padding(0.dp)
        ){
            Image(painter = painterResource(id = dish.imageResource), contentDescription ="greeksald" ,
                Modifier.fillMaxWidth()
            )
            Text(text = dish.name,
                Modifier.padding(top=10.dp , start=10.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = dish.description,
                Modifier.padding(top=20.dp , start=10.dp , end = 10.dp),
                fontSize = 16.sp
            )
            var count : Int= Counter()
            totalCost = count * dish. price
            Button(onClick = {
                             if(count <1){
                                 Toast.makeText(contest,"Please select item !",Toast.LENGTH_SHORT).show()
                             }else if(count >=1){
                                 Toast.makeText(contest,"Order Placed",Toast.LENGTH_SHORT).show()
                             }
            },
                Modifier
                    .padding(top = 20.dp, start = 10.dp, end = 10.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Yellow),
                elevation =  ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 15.dp,
                    disabledElevation = 0.dp
                )

                ) {
                Text(text = "Add for ₹${totalCost.roundDecimal(2)}", color = Color.Black)
            }
        }
    }
}

@Composable
fun Counter(): Int {
    var count by rememberSaveable {              // rember saveable use to save the data
        mutableStateOf(0)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
    ) {


        TextButton(
            onClick = {
                count--
            },
            elevation =  ButtonDefaults.buttonElevation(
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            )
        ) {
            Text(
                text = "-",
                style = MaterialTheme.typography.headlineMedium
            )
        }
        Text(
            text = "$count",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        TextButton(
            onClick = {
                count++
            },
            elevation =  ButtonDefaults.buttonElevation(
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            )
        ) {
            Text(
                text = "+",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
    return count
}
@Preview
@Composable
fun DishdetailsPreview() {
    Dishdetails(Id = 1)
}