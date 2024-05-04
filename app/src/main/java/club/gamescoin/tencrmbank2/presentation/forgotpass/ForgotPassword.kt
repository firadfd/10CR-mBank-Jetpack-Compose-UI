package club.gamescoin.tencrmbank2.presentation.forgotpass

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun ForgotPasswordScreen(navController: NavHostController) {
    val emailValue = remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopBar(
            text = "Forgot Password",
            showIcon = true,
            icon = Icons.Default.ArrowBackIosNew
        ) {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Enter your Email Or Phone",
            textAlign = TextAlign.Start,
            style = TextStyle(color = labelTextColor),
            modifier = Modifier.fillMaxWidth(.9f)
        )
        Spacer(modifier = Modifier.height(5.dp))
        CustomTextInputField(
            value = emailValue.value,
            onValueChange = {
                emailValue.value = it
            },
            modifier = Modifier.fillMaxWidth(.9f),
            keyboardType = KeyboardType.Text,
            placeholder = "Enter your email or phone"
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomButton(text = "Continue", modifier = Modifier.fillMaxWidth(.9f)) {
            navController.navigate(Screens.ForgotPasswordOtp.route)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = "Don’t have account?",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(color = Color.Black),
                modifier = Modifier.wrapContentWidth()
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "Register",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(color = superNova),
                modifier = Modifier
                    .clickable {

                    }
                    .wrapContentWidth())

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewForgotPass() {
    val navHostController = rememberNavController()
    ForgotPasswordScreen(navHostController)
}