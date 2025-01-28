package com.example.uas.ui.navigation


import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.uas.ui.view.DestinasiHome
import com.example.uas.ui.view.HomeMenuView
import com.example.uas.ui.view.JenisTerapis.DestinasiDetailJenisTerapis
import com.example.uas.ui.view.JenisTerapis.DestinasiEditJenisTerapis
import com.example.uas.ui.view.JenisTerapis.DestinasiEntryJenisTerapis
import com.example.uas.ui.view.JenisTerapis.DestinasiHomeJenisTerapis
import com.example.uas.ui.view.JenisTerapis.DetailJenisTerapisView
import com.example.uas.ui.view.JenisTerapis.EditJenisTerapisView
import com.example.uas.ui.view.JenisTerapis.EntryJnsScreen
import com.example.uas.ui.view.JenisTerapis.HomeJenisTerapisScreen


@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(
            route = DestinasiHome.route
        ) {
            HomeMenuView(
                onJenisClick = {
                    navController.navigate(DestinasiHomeJenisTerapis.route)
                }
            )
        }

        composable(
            route = DestinasiHomeJenisTerapis.route
        ) {
            HomeJenisTerapisScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntryJenisTerapis.route) },
                onDetailClick = { id_jenis_terapis ->
                    navController.navigate("${DestinasiDetailJenisTerapis.route}/$id_jenis_terapis")
                    println(id_jenis_terapis)
                }
            )
        }

        composable(
            route = DestinasiEntryJenisTerapis.route
        ) {
            EntryJnsScreen(
                navigateBack = {
                    navController.navigate(DestinasiHomeJenisTerapis.route) {
                        popUpTo(DestinasiHomeJenisTerapis.route) { inclusive = true }
                    }
                }
            )
        }
        composable(
            route = DestinasiDetailJenisTerapis.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetailJenisTerapis.id_jenis_terapis) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val id_jenis_terapis =
                backStackEntry.arguments?.getString(DestinasiDetailJenisTerapis.id_jenis_terapis)
            id_jenis_terapis?.let {
                DetailJenisTerapisView(
                    navigateBack = {
                        navController.navigateUp()
                    },
                    onEditClick = { id_jenis_terapis ->
                        navController.navigate("${DestinasiEditJenisTerapis.route}/$id_jenis_terapis")
                        println(id_jenis_terapis)
                    }
                )
            }
        }
        composable(
            route = DestinasiEditJenisTerapis.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEditJenisTerapis.id_jenis_terapis) {
                type = NavType.StringType
            })
        ) {
            EditJenisTerapisView(
                navigateBack = {
                    navController.popBackStack()
                },
                onNavigateUp = {
                    navController.navigate(
                        DestinasiEditJenisTerapis.route
                    ) {
                        popUpTo(DestinasiHomeJenisTerapis.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}