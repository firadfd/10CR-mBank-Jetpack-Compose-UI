package club.gamescoin.tencrmbank2.presentation.registration

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
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
import club.gamescoin.tencrmbank2.presentation.ui.theme.labelTextColor
import club.gamescoin.tencrmbank2.presentation.ui.theme.superNova

@Composable
fun RegistrationScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var conPass by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(
            scrollState
        )
    ) {
        CustomTopBar(text = "Registration") {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Full name",
            textAlign = TextAlign.Start,
            style = TextStyle(color = labelTextColor),
            modifier = Modifier.fillMaxWidth(.9f)
        )
        Spacer(modifier = Modifier.height(5.dp))
        CustomTextInputField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier.fillMaxWidth(.9f),
            keyboardType = KeyboardType.Text,
            placeholder = "Enter your name"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Phone",
            textAlign = TextAlign.Start,
            style = TextStyle(color = labelTextColor),
            modifier = Modifier.fillMaxWidth(.9f)
        )
        Spacer(modifier = Modifier.height(5.dp))
        CustomTextInputField(
            value = phone,
            onValueChange = {
                phone = it
            },
            modifier = Modifier.fillMaxWidth(.9f),
            keyboardType = KeyboardType.Phone,
            placeholder = "Enter your number"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Email",
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
            keyboardType = KeyboardType.Email,
            placeholder = "something@gmail.com"
        )
        Spacer(modifier = Modifier.height(10.dp))
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
            }, modifier = Modifier.fillMaxWidth(.9f), hintText = "New Password"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Confirm Password",
            textAlign = TextAlign.Start,
            style = TextStyle(color = labelTextColor),
            modifier = Modifier.fillMaxWidth(.9f)
        )
        Spacer(modifier = Modifier.height(5.dp))
        PasswordTextInputField(
            value = conPass, onValueChange = {
                conPass = it
            }, modifier = Modifier.fillMaxWidth(.9f), hintText = "Confirm Password"
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(.9f)
        ) {
            Checkbox(checked = checked, onCheckedChange = {
                checked = it
            }, modifier = Modifier.padding(10.dp))
            Spacer(modifier = Modifier.width(5.dp))
            val text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 12.sp, color = Color.Black
                    )
                ) {
                    append("Be creating your account you have to agree with our ")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 14.sp, color = superNova
                    )
                ) {
                    append("Teams and conditions")
                }
            }
            Text(text = text,
                fontSize = 14.sp,
                style = TextStyle(color = Color.Black),
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        navController.navigate(Screens.Login.route)
                    })

        }
        Spacer(modifier = Modifier.height(10.dp))
        CustomButton(text = "Registration", modifier = Modifier.fillMaxWidth(.9f)) {
            navController.navigate(Screens.RegistrationOtp.route)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = "Already have account?",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(color = Color.Black),
                modifier = Modifier.wrapContentWidth()
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "Login",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(color = superNova),
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screens.Login.route)
                    }
                    .wrapContentWidth())

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreRegistration() {
    RegistrationScreen(navController = rememberNavController())

}