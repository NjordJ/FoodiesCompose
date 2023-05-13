package com.iruda.foodiescompose.presentation.catalogue.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.iruda.foodiescompose.R

class CatalogueScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
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
        }
    }

    @Composable
    private fun FilterButton() {
        Box() {
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
        Box() {
            Image(painter = painterResource(id = R.drawable.search),
                contentDescription = null,
                modifier = Modifier
                    .clickable { println("Search Clicked!") })
        }
    }

    val filters = listOf("Filter 1", "Filter 2", "Filter 3", "Filter 4", "Filter 5", "Filter 6")

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
}

