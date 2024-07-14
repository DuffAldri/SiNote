package com.otakkanan.sinote.ui.navigations

sealed class Screen(val route: String) {
    data object OnBoarding : Screen("auth_onboarding")
    data object Login : Screen("auth_login")
    data object Register : Screen("auth_register")
    data object ForgotPassword : Screen("auth_forgot_password")
    data object EmailVerification : Screen("auth_email_verification")
    data object CreateNewPassword : Screen("auth_create_new_password")
    data object TugasList : Screen("tugas_list/{isNotEmpty}") {
        fun createRoute(isNotEmpty: Boolean) = "tugas_list/$isNotEmpty"
    }
    data object CreateTugas : Screen("tugas_create")
    data object AddMembers : Screen("tugas_add_members")
    data object InspirasiList : Screen("inspirasi_list")
    data object CreateInspirasi : Screen("inspirasi_create")
    data object CatatanList : Screen("catatan_list")
    data object CreateCatatan : Screen("catatan_create")
    data object CatatanSearch : Screen("catatan_search")
    data object Profil: Screen("profil")
    data object EditProfil: Screen("profil_edit")
    data object Tema: Screen("profil_tema")
    data object TemaCustom: Screen("profil_tema_custom")
    data object Faq: Screen("profil_faq")
    data object ProfilChangePassword: Screen("profil_change_password")
}