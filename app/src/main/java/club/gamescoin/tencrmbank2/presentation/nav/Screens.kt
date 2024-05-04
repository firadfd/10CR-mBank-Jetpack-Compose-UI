package club.gamescoin.tencrmbank2.presentation.nav

sealed class Screens(val route: String) {
    object GetStart : Screens("get_start")
    object Login : Screens("login")
    object LoginOTP : Screens("login_otp")
    object ForgotPassword : Screens("forgot_password")
    object ForgotPasswordOtp : Screens("forgot_password_otp")
    object ResetPassword : Screens("reset_password")
    object Help : Screens("help")
    object Registration : Screens("registration")
    object RegistrationOtp : Screens("registration_otp")
    object ActiveGames : Screens("active_games")
    object DirectBuy : Screens("direct_buy")
    object DirectBuyPaymentMethod : Screens("direct_buy_payment_method")
    object Home : Screens("home")
}
