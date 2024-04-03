package com.example.caelarea.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CallToAction
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material.icons.outlined.ChangeHistory
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.caelarea.navigation.NavScreen

// BOTTON MODELS
sealed class ItemsBottomNav(
    val icon: ImageVector,
    val title: String,
    val route: String ) {

    // CIRCLE BOTTON
    object Item_bottom_navbar: ItemsBottomNav(
        Icons.Outlined.Circle,
        title = "Circulo",
        NavScreen.CircleScreen.name
    )

    object Item_bottom_navbar2: ItemsBottomNav(
        Icons.Outlined.ChangeHistory,
        title = "Triangulo",
        NavScreen.TriangleScreen.name
    )

    object Item_bottom_navbar3: ItemsBottomNav(
        Icons.Filled.Directions,
        title = "Rombo",
        NavScreen.RhombusScreen.name
    )

    object Item_bottom_navbar4: ItemsBottomNav(
        Icons.Filled.CheckBoxOutlineBlank,
        title = "Trapecio",
        NavScreen.TrapezeScreen.name
    )

    object  Item_bottom_navbar5: ItemsBottomNav(
        Icons.Filled.CallToAction,
        title = "Rectangulo",
        NavScreen.RectangleScreen.name
    )
}
