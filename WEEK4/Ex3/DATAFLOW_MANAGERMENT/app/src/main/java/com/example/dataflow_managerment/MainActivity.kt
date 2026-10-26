package com.example.dataflow_managerment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dataflow_managerment.ui.screens.ConfirmScreen
import com.example.dataflow_managerment.ui.screens.FGPScreen
import com.example.dataflow_managerment.ui.screens.NewPassWordScreen
import com.example.dataflow_managerment.ui.screens.VerifyScreen
import com.example.dataflow_managerment.ui.theme.DATAFLOW_MANAGERMENTTheme
import com.example.dataflow_managerment.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DATAFLOW_MANAGERMENTTheme {
                val navController = rememberNavController()
                val authViewModel: AuthViewModel = viewModel()
                var showSuccessDialog by remember { mutableStateOf(false) }

                NavHost(navController = navController, startDestination = "forget_password") {
                    composable("forget_password") {
                        FGPScreen(
                            viewModel = authViewModel,
                            showDialog = showSuccessDialog,
                            onDismissDialog = { showSuccessDialog = false },
                            onNextClick = {
                                navController.navigate("verify")
                            }
                        )
                    }
                    composable("verify") {
                        VerifyScreen(
                            viewModel = authViewModel,
                            onBackClick = {
                                navController.popBackStack()
                            },
                            onNextClick = {
                                navController.navigate("new_password")
                            }
                        )
                    }
                    composable("new_password") {
                        NewPassWordScreen(
                            viewModel = authViewModel,
                            onBackClick = {
                                navController.popBackStack()
                            },
                            onNextClick = {
                                navController.navigate("confirm")
                            }
                        )
                    }
                    composable("confirm") {
                        ConfirmScreen(
                            viewModel = authViewModel,
                            onBackClick = {
                                navController.popBackStack()
                            },
                            onConfirmClick = {
                                showSuccessDialog = true
                                navController.popBackStack("forget_password", inclusive = false)
                            }
                        )
                    }
                }
            }
        }
    }
}
