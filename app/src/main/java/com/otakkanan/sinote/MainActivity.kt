package com.otakkanan.sinote

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.otakkanan.sinote.ui.components.inspirasi.inspirasiDataDummy
import com.otakkanan.sinote.ui.navigations.Screen
import com.otakkanan.sinote.ui.screens.forgotpasswordscreens.createNewPassword.CreateNewPasswordScreen
import com.otakkanan.sinote.ui.screens.forgotpasswordscreens.emailVerification.EmailVerificationScreen
import com.otakkanan.sinote.ui.screens.forgotpasswordscreens.forgotPassword.ForgotPasswordScreen
import com.otakkanan.sinote.ui.screens.inspirasiScreens.CreateInspirasiScreen
import com.otakkanan.sinote.ui.screens.inspirasiScreens.InspirasiScreen
import com.otakkanan.sinote.ui.screens.authScreens.login.LoginScreen
import com.otakkanan.sinote.ui.screens.authScreens.onboard.OnBoardScreen
import com.otakkanan.sinote.ui.screens.authScreens.register.RegisterScreen
import com.otakkanan.sinote.ui.screens.catatanScreens.CatatanListScreen
import com.otakkanan.sinote.ui.screens.profilScreens.ChangePasswordScreen
import com.otakkanan.sinote.ui.screens.profilScreens.EditProfilScreen
import com.otakkanan.sinote.ui.screens.profilScreens.FaqScreen
import com.otakkanan.sinote.ui.screens.profilScreens.ProfilScreen
import com.otakkanan.sinote.ui.screens.profilScreens.tema.TemaCustomScreen
import com.otakkanan.sinote.ui.screens.profilScreens.tema.TemaScreen
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
                NavHost(navController = navController, startDestination = "auth_route") {
                    navigation(
                        startDestination = Screen.OnBoarding.route,
                        route = "auth_route"
                    ) {
                        composable(Screen.OnBoarding.route) {
                            OnBoardScreen(navController = navController)
                        }
                        composable(Screen.Login.route) {
                            LoginScreen(navController = navController)
                        }
                        composable(Screen.Register.route) {
                            RegisterScreen(navController = navController)
                        }
                        navigation(
                            route = "forgot_password_route",
                            startDestination = Screen.ForgotPassword.route,
                        ) {
                            composable(Screen.ForgotPassword.route) {
                                ForgotPasswordScreen(navController = navController)
                            }
                            composable(Screen.EmailVerification.route) {
                                EmailVerificationScreen(navController = navController)
                            }
                            composable(Screen.CreateNewPassword.route) {
                                CreateNewPasswordScreen(navController = navController)
                            }
                        }
                    }
                    navigation(
                        route = "catatan_route",
                        startDestination = Screen.CatatanList.route
                    ) {
                        composable(Screen.CatatanList.route) {
                            CatatanListScreen(navController = navController)
                        }
//                        composable(Screen.CreateCatatan.route) {
//                            CreateCatatanScreen(navController = navController)
//                        }
//                        composable(Screen.CatatanSearchScreen.route) {
//                            CatatanSearchScreen(navController = navController)
//                        }
                    }
                    navigation(
                        startDestination = Screen.TugasList.route,
                        route = "tugas_route"
                    ) {
                        composable(Screen.TugasList.route) {
                            val isNotEmpty = it.arguments?.getString("isNotEmpty") ?: "false"
                            TugasListScreen(navController = navController, isNotEmpty = isNotEmpty.toBoolean())
                        }
                        composable(Screen.CreateTugas.route) {
                            CreateTugasScreen(navController = navController)
                        }
                        composable(Screen.AddMembers.route) {
                            AddMembersScreen(navController = navController)
                        }
                    }
                    navigation(
                        startDestination = Screen.InspirasiList.route,
                        route = "inspirasi_route"
                    ) {
                        composable(Screen.InspirasiList.route) {
                            InspirasiScreen(navController = navController)
                        }
                        composable(Screen.CreateInspirasi.route) {
                            CreateInspirasiScreen(navController = navController, inspirasiDataClass = inspirasiDataDummy)
                        }
                    }
                    navigation(
                        route = "profil_route",
                        startDestination = Screen.Profil.route
                    ) {
                        composable(Screen.Profil.route) {
                            ProfilScreen(navController = navController)
                        }
                        composable(Screen.EditProfil.route) {
                            EditProfilScreen(navController = navController)
                        }
                        composable(Screen.Tema.route) {
                            TemaScreen(navController = navController)
                        }
                        composable(Screen.TemaCustom.route) {
                            TemaCustomScreen(navController = navController)
                        }
                        composable(Screen.Faq.route) {
                            FaqScreen(navController = navController)
                        }
                        composable(Screen.ProfilChangePassword.route) {
                            ChangePasswordScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}