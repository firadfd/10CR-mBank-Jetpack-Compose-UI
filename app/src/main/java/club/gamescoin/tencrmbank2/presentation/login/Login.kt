package club.gamescoin.tencrmbank2.presentation.login

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import club.gamescoin.tencrmbank2.presentation.common.PasswordTextInputField
import club.gamescoin.tencrmbank2.presentation.nav.Screens
import club.gamescoin.tencrmbank2.presentation.ui.theme.green
import club.gamescoin.tencrmbank2.presentation.ui.theme.labelTextColor
import club.gamescoin.tencrmbank2.presentation.ui.theme.superNova

@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopBar(text = "Login", showIcon = false) {

        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Phone\\Email",
            textAlign = TextAlign.Start,
            style = TextStyle(color = labelTextColor),
            modifier = Modifier.fillMaxWidth(.9f)
        )
        Spacer(modifier = Modifier.height(5.dp))
        CustomTextInputField(
            value = email,
            onValueChange = {
                email = it
            },
            modifier = Modifier.fillMaxWidth(.9f),
            keyboardType = KeyboardType.Text,
            placeholder = "Enter your email"
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Password",
            textAlign = TextAlign.Start,
            style = TextStyle(color = labelTextColor),
            modifier = Modifier.fillMaxWidth(.9f)
        )
        Spacer(modifier = Modifier.height(5.dp))
        PasswordTextInputField(
            value = pass, onValueChange = {
                pass = it
            }, modifier = Modifier.fillMaxWidth(.9f), hintText = "Password"
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(.9f)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Forgot Password?",
                textAlign = TextAlign.End,
                style = TextStyle(color = superNova),
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screens.ForgotPassword.route)
                    }
                    .wrapContentWidth()
                    .padding(5.dp))
        }

        Spacer(modifier = Modifier.height(25.dp))
        CustomButton(text = "Log In", modifier = Modifier.fillMaxWidth(.9f)) {
            navController.navigate(Screens.LoginOTP.route)
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
                        navController.navigate(Screens.Registration.route)
                    }
                    .wrapContentWidth())

        }
        Spacer(modifier = Modifier.weight(1f))
        CustomButton(
            text = "Direct Buy",
            color = green,
            textColor = Color.White,
            showIcon = true,
            icon = Icons.Filled.ArrowForward,
            modifier = Modifier.fillMaxWidth(.9f)
        ) {
            navController.navigate(Screens.ActiveGames.route)
        }
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedButton(modifier = Modifier
            .fillMaxWidth(.9f)
            .clip(shape = RoundedCornerShape(20.dp))
            .padding(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            border = BorderStroke(1.dp, green),
            onClick = {
                navController.navigate(Screens.Help.route)
            }) {
            Text(
                text = "Need help?",
                style = TextStyle(color = green),
                modifier = Modifier.padding(10.dp)
            )
        }

    }
}

@Preview(showSystemUi = true)
//@PreviewScreenSizes
//@PreviewLightDark
@Composable
fun PreviewLogin() {
    val navHostController = rememberNavController()
    LoginScreen(navHostController)
}