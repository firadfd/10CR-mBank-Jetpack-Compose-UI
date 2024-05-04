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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import club.gamescoin.tencrmbank2.presentation.common.CustomButton
import club.gamescoin.tencrmbank2.presentation.common.CustomTopBar
import club.gamescoin.tencrmbank2.presentation.common.PasswordTextInputField
import club.gamescoin.tencrmbank2.presentation.nav.Screens
import club.gamescoin.tencrmbank2.presentation.ui.theme.labelTextColor

@Composable
fun ResetPasswordScreen(navController: NavHostController) {
    val newPassValue = remember { mutableStateOf("") }
    val conNewPassValue = remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopBar(
            text = "Reset Password", showIcon = true, icon = Icons.Default.ArrowBackIosNew
        ) {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "New Password",
            textAlign = TextAlign.Start,
            style = TextStyle(color = labelTextColor),
            modifier = Modifier.fillMaxWidth(.9f)
        )
        Spacer(modifier = Modifier.height(5.dp))
        PasswordTextInputField(
            value = newPassValue.value, onValueChange = {
                newPassValue.value = it
            }, modifier = Modifier.fillMaxWidth(.9f), hintText = "New Password"
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Confirm Password",
            textAlign = TextAlign.Start,
            style = TextStyle(color = labelTextColor),
            modifier = Modifier.fillMaxWidth(.9f)
        )
        Spacer(modifier = Modifier.height(5.dp))
        PasswordTextInputField(
            value = conNewPassValue.value, onValueChange = {
                conNewPassValue.value = it
            }, modifier = Modifier.fillMaxWidth(.9f), hintText = "Confirm Password"
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomButton(text = "Save & Login", modifier = Modifier.fillMaxWidth(.9f)) {
            navController.navigate(Screens.Login.route)
        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewResetPass() {
    ResetPasswordScreen(navController = rememberNavController())

}