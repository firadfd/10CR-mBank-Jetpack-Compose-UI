package club.gamescoin.tencrmbank2.presentation.registration

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import club.gamescoin.tencrmbank2.presentation.common.CustomButton
import club.gamescoin.tencrmbank2.presentation.common.CustomTextInputField
import club.gamescoin.tencrmbank2.presentation.common.CustomTopBar
import club.gamescoin.tencrmbank2.presentation.nav.Screens
import club.gamescoin.tencrmbank2.presentation.ui.theme.labelTextColor
import club.gamescoin.tencrmbank2.presentation.ui.theme.superNova

@Composable
fun RegistrationOtpScreen(navController: NavHostController) {
    var otp by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopBar(
            text = "Registration",
            showIcon = true,
            icon = Icons.Default.ArrowBackIosNew
        ) {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Verify your Phone",
            textAlign = TextAlign.Center,
            style = TextStyle(color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.fillMaxWidth(.5f)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Please enter the 4 digit code sent to 01798*****65",
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = labelTextColor, fontSize = 16.sp
            ),
            modifier = Modifier.fillMaxWidth(.5f)
        )
        Spacer(modifier = Modifier.height(10.dp))
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
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(.9f)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Resend Code",
                textAlign = TextAlign.End,
                style = TextStyle(color = superNova),
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screens.ForgotPassword.route)
                    }
                    .wrapContentWidth()
                    .padding(5.dp))
        }
        Spacer(modifier = Modifier.height(10.dp))
        CustomButton(text = "Confirm", modifier = Modifier.fillMaxWidth(.9f)) {

        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewOtp() {
    val navHostController = rememberNavController()
    RegistrationOtpScreen(navController = navHostController)

}