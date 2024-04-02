package com.example.caelarea.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.caelarea.screens.Circle
import com.example.caelarea.screens.HomeScreen
import com.example.caelarea.screens.Rhombus
import com.example.caelarea.screens.Trapeze
import com.example.caelarea.screens.Triangle

@Composable
fun CaelareaNavigation(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = NavScreen.HomeScreen.name) {
        composable(NavScreen.HomeScreen.name){
            HomeScreen()
        }
        composable(NavScreen.TriangleScreen.name){
            Triangle()
        }
        composable(NavScreen.CircleScreen.name){
            Circle()
        }
        composable(NavScreen.RhombusScreen.name){
            Rhombus()
        }
        composable(NavScreen.TrapezeScreen.name){
            Trapeze()
        }
    }
}