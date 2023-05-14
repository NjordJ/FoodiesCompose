package com.iruda.foodiescompose.presentation.catalogue.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.iruda.foodiescompose.R
import com.iruda.foodiescompose.presentation.cart.screens.CartScreen

class CatalogueScreen : Screen {

    @Composable
    override fun Content() {
        CatalogueView()
    }

    @Preview
    @Composable
    private fun CatalogueView() {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 16.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                FilterButton()
                LogoImage()
                SearchButton()
            }
            FoodCategories()
            CartButton()
            ListOfFood()
            CartButton()
        }
    }

    @Composable
    private fun FilterButton() {
        Box {
            Image(painter = painterResource(id = R.drawable.filter),
                contentDescription = null,
                modifier = Modifier
                    .clickable { println("Filter Clicked!") })
        }
    }

    @Composable
    private fun LogoImage() {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .width(111.dp)
                .height(44.dp)
        )
    }

    @Composable
    private fun SearchButton() {
        Box {
            Image(painter = painterResource(id = R.drawable.search),
                contentDescription = null,
                modifier = Modifier
                    .clickable { println("Search Clicked!") })
        }
    }

    private val filters =
        listOf("Filter 1", "Filter 2", "Filter 3", "Filter 4", "Filter 5", "Filter 6")

    @Composable
    private fun FoodCategories() {
        LazyRow(
            content = {
                items(filters.size) { index ->
                    val filter = filters[index]
                    Button(
                        onClick = { /* filter */ },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(filter)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
        )
    }

    private val foodList = listOf(
        Food(name = "Food1", weight = 500.0, price = 25.0),
        Food(name = "Food2", weight = 500.0, price = 25.0),
        Food(name = "Food3", weight = 500.0, price = 25.0),
        Food(name = "Food4", weight = 500.0, price = 25.0),
        Food(name = "Food5", weight = 500.0, price = 25.0),
        Food(name = "Food6", weight = 500.0, price = 25.0),
        Food(name = "Food7", weight = 500.0, price = 25.0),
        Food(name = "Food8", weight = 500.0, price = 25.0),
        Food(name = "Food9", weight = 500.0, price = 25.0),
        Food(name = "Food10", weight = 500.0, price = 25.0),
        Food(name = "Food11", weight = 500.0, price = 25.0),
        Food(name = "Food12", weight = 500.0, price = 25.0),
        Food(name = "Food13", weight = 500.0, price = 25.0),
        Food(name = "Food14", weight = 500.0, price = 25.0),
        Food(name = "Food15", weight = 500.0, price = 25.0),
    )

    @Composable
    private fun ListOfFood() {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
        ) {
            items(foodList.size) { index ->
                Card(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(horizontal = 4.dp, vertical = 8.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.food),
                            contentDescription = foodList[index].name,
                            modifier = Modifier.size(100.dp)
                        )
                        Text(text = foodList[index].name, fontWeight = FontWeight.Bold)
                        Text(text = "Price: ${foodList[index].price}")
                    }
                }
            }
        }

    }

    @Composable
    private fun CartButton() {
        val navigator = LocalNavigator.currentOrThrow
        Button(
            onClick = { navigator.push(CartScreen()) }
        ) {
            Text(text = "Cart")
        }
    }
}

data class Food(
    val name: String,
    val weight: Double,
    val price: Double,
)

