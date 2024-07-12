package com.otakkanan.sinote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.otakkanan.sinote.ui.components.inspirasi.inspirasiDataDummy
import com.otakkanan.sinote.ui.screens.forgotpasswordscreens.createNewPassword.CreateNewPasswordScreen
import com.otakkanan.sinote.ui.screens.forgotpasswordscreens.emailVerification.EmailVerificationScreen
import com.otakkanan.sinote.ui.screens.forgotpasswordscreens.forgotPassword.ForgotPasswordScreen
import com.otakkanan.sinote.ui.screens.inspirasiScreens.CreateInspirasiScreen
import com.otakkanan.sinote.ui.screens.inspirasiScreens.InspirasiScreen
import com.otakkanan.sinote.ui.screens.loginscreens.login.LoginScreen
import com.otakkanan.sinote.ui.screens.registerscreens.onboard.OnBoardScreen
import com.otakkanan.sinote.ui.screens.registerscreens.register.RegisterScreen
import com.otakkanan.sinote.ui.screens.tugasScreens.AddMembersScreen
import com.otakkanan.sinote.ui.screens.tugasScreens.CreateTugasScreen
import com.otakkanan.sinote.ui.screens.tugasScreens.TugasListScreen
import com.otakkanan.sinote.ui.theme.SiNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SiNoteTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    navigation(
                        startDestination = "onboarding",
                        route = "auth"
                    ) {
                        composable("onboarding") {
                            OnBoardScreen(navController = navController)
                        }
                        composable("login") {
                            LoginScreen(navController = navController)
                        }
                        composable("register") {
                            RegisterScreen(navController = navController)
                        }
                        navigation("forgot_password", route = "forgot_password_route") {
                            composable("forgot_password") {
                                ForgotPasswordScreen(navController = navController)
                            }
                            composable("email_verification") {
                                EmailVerificationScreen(navController = navController)
                            }
                            composable("create_new_password") {
                                CreateNewPasswordScreen(navController = navController)
                            }
                        }

                    }
                    navigation(
                        startDestination = "tugas_list",
                        route = "tugas"
                    ) {
                        composable("tugas_list") {
                            TugasListScreen(navController = navController)
                        }
                        composable("create_tugas") {
                            CreateTugasScreen(navController = navController)
                        }
                        composable("add_members") {
                            AddMembersScreen(navController = navController)
                        }
                    }
                    navigation(
                        startDestination = "inspirasi_list",
                        route = "inspirasi"
                    ) {
                        composable("inspirasi_list") {
                            InspirasiScreen(navController = navController)
                        }
                        composable("create_inspirasi") {
                            CreateInspirasiScreen(navController = navController, inspirasiDataClass = inspirasiDataDummy)
                        }
                    }
                }
            }
        }
    }
}