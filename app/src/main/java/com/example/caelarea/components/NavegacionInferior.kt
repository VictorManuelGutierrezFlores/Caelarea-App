package com.example.caelarea.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.caelarea.models.ItemsBottomNav.Item_bottom_navbar
import com.example.caelarea.models.ItemsBottomNav.Item_bottom_navbar2
import com.example.caelarea.models.ItemsBottomNav.Item_bottom_navbar3
import com.example.caelarea.models.ItemsBottomNav.Item_bottom_navbar4
import com.example.caelarea.navigation.CurrentRoute

@Composable
fun NavegacionInferior(
    navController:NavHostController){
    // LOAD MODELS AN LIST
    val menuItems = listOf(
        Item_bottom_navbar,
        Item_bottom_navbar2,
        Item_bottom_navbar3,
        Item_bottom_navbar4
    )

    BottomAppBar {
        NavigationBar {
            menuItems.forEach { item->
                val selected = CurrentRoute(navController) == item.route
                NavigationBarItem(selected = selected,
                    onClick = { navController.navigate(item.route) },
                    icon = {
                        Icon(imageVector = item.icon,
                        contentDescription = item.title)
                    },
                        label = {
                            Text(text = item.title)
                        }
                    )
            }
        }
    }
}