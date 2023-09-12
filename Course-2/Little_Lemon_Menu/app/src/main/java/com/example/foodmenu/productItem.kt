package com.example.foodmenu

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable

object DishRepository{

    var productsList: List<ProductItem> = listOf(
        ProductItem(1,"Black tea", 3.00, "Drinks", R.drawable.black_tea),
        ProductItem(2,"Green tea", 3.00, "Drinks", R.drawable.green_tea),
        ProductItem(3,"Espresso", 5.00, "Drinks", R.drawable.espresso),
        ProductItem(4,"Cappuccino", 8.00, "Drinks", R.drawable.cappuccino),
        ProductItem(5,"Latte", 8.00, "Drinks", R.drawable.latte),
        ProductItem(6,"Mocha", 10.00, "Drinks", R.drawable.mocha),
        ProductItem(7,"Bouillabaisse", 20.00, "Food", R.drawable.bouillabaisse),
        ProductItem(8,"Lasagna", 15.00, "Food", R.drawable.lasagna),
        ProductItem(9,"Onion soup", 12.00, "Food", R.drawable.onion_soup),
        ProductItem(10,"Salmon en papillote", 25.00, "Food", R.drawable.salmon_en_papillote),
        ProductItem(11,"Quiche Lorraine", 17.00, "Dessert", R.drawable.quiche_lorraine),
        ProductItem(12, "Custard tart", 14.00, "Dessert", R.drawable.custard_tart),
    )
    fun getDish(id: Int) = productsList.firstOrNull { it.id == id }
}
data class ProductItem(
    var id :Int,
    val title: String,
    val price: Double,
    var category: String,
    @DrawableRes val image: Int
)
data class Products(val items: List<ProductItem>)

@Composable
fun filter():List<ProductItem> {
    return DishRepository.productsList
}