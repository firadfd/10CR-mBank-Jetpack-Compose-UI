package club.gamescoin.tencrmbank2.presentation.forgotpass

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import club.gamescoin.tencrmbank2.presentation.common.CustomButton
import club.gamescoin.tencrmbank2.presentation.common.CustomTextInputField
import club.gamescoin.tencrmbank2.presentation.common.CustomTopBar
import club.gamescoin.tencrmbank2.presentation.nav.Screens
import club.gamescoin.tencrmbank2.presentation.ui.theme.labelTextColor

@Composable
fun ForgotPasswordOtpScreen(navController: NavHostController) {
    var otp by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopBar(
            text = "OTP",
            showIcon = true,
            icon = Icons.Default.ArrowBackIosNew
        ) {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Enter the OTP code",
            textAlign = TextAlign.Start,
            style = TextStyle(color = labelTextColor),
            modifier = Modifier.fillMaxWidth(.9f)
        )
        Spacer(modifier = Modifier.height(5.dp))
        CustomTextInputField(
            value = otp,
            onValueChange = {
                otp = it
            },
            modifier = Modifier.fillMaxWidth(.9f),
            keyboardType = KeyboardType.Text,
            placeholder = "Enter the OTP code"
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomButton(text = "Confirm", modifier = Modifier.fillMaxWidth(.9f)) {
            navController.navigate(Screens.ResetPassword.route)
        }

    }
}
