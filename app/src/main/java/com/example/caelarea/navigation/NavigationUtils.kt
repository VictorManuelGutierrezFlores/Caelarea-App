package com.example.caelarea.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun CurrentRoute( navController: NavHostController ): String? =
    navController.currentBackStackEntryAsState().value?.destination?.route