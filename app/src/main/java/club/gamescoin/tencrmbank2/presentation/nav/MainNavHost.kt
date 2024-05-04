package club.gamescoin.tencrmbank2.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import club.gamescoin.tencrmbank2.presentation.direct_buy.ActiveGameScreen
import club.gamescoin.tencrmbank2.presentation.direct_buy.DirectBuyPaymentMethodScreen
import club.gamescoin.tencrmbank2.presentation.direct_buy.DirectBuyScreen
import club.gamescoin.tencrmbank2.presentation.forgotpass.ForgotPasswordOtpScreen
import club.gamescoin.tencrmbank2.presentation.forgotpass.ForgotPasswordScreen
import club.gamescoin.tencrmbank2.presentation.forgotpass.ResetPasswordScreen
import club.gamescoin.tencrmbank2.presentation.getstart.GetStartScreen
import club.gamescoin.tencrmbank2.presentation.help.HelpScreen
import club.gamescoin.tencrmbank2.presentation.home.HomeScreen
import club.gamescoin.tencrmbank2.presentation.login.LoginOtpScreen
import club.gamescoin.tencrmbank2.presentation.login.LoginScreen
import club.gamescoin.tencrmbank2.presentation.registration.RegistrationOtpScreen
import club.gamescoin.tencrmbank2.presentation.registration.RegistrationScreen

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screens.GetStart.route) {
        composable(Screens.GetStart.route) {
            GetStartScreen(navController)
        }
        composable(Screens.Login.route) {
            LoginScreen(navController)
        }
        composable(Screens.LoginOTP.route) {
            LoginOtpScreen(navController)
        }
        composable(Screens.ForgotPassword.route) {
            ForgotPasswordScreen(navController)
        }
        composable(Screens.ForgotPasswordOtp.route) {
            ForgotPasswordOtpScreen(navController)
        }
        composable(Screens.ResetPassword.route) {
            ResetPasswordScreen(navController)
        }
        composable(Screens.Help.route) {
            HelpScreen(navController)
        }
        composable(Screens.Registration.route) {
            RegistrationScreen(navController)
        }
        composable(Screens.RegistrationOtp.route) {
            RegistrationOtpScreen(navController)
        }
        composable(Screens.ActiveGames.route) {
            ActiveGameScreen(navController)
        }
        composable("${Screens.DirectBuy.route}/{gameName}") { backStackEntry ->
            val gameName = backStackEntry.arguments?.getString("gameName")
            DirectBuyScreen(navController, gameName)
        }
        composable("${Screens.DirectBuyPaymentMethod.route}/{page}/{token}") { backStackEntry ->
            val page = backStackEntry.arguments?.getString("page")
            val token = backStackEntry.arguments?.getString("token")
            DirectBuyPaymentMethodScreen(navController, page, token)
        }
        composable(Screens.Home.route) {
            HomeScreen(navController)
        }
    }
}



