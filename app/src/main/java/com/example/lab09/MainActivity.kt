package com.example.lab09

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.lab09.ui.theme.ScreenUserDetail
import com.example.lab09.ui.theme.ScreenUsers
import com.example.lab09.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AppUsuarios() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppUsuarios() {
    val navController = rememberNavController()
    val vm: UserViewModel = viewModel()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Directorio de Usuarios",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF1E1E2E)
                )
            )
        }
    ) { pv ->
        NavHost(
            navController = navController,
            startDestination = "users",
            modifier = Modifier.padding(pv)
        ) {
            composable("users") {
                ScreenUsers(navController, vm)
            }
            composable(
                "userDetail/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) {
                ScreenUserDetail(navController, vm)
            }
        }
    }
}