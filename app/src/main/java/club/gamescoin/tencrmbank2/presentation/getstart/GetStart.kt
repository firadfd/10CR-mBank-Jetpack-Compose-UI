package club.gamescoin.tencrmbank2.presentation.getstart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import club.gamescoin.tencrmbank2.R
import club.gamescoin.tencrmbank2.presentation.common.CustomButton
import club.gamescoin.tencrmbank2.presentation.nav.Screens

@Composable
fun GetStartScreen(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(.1f))
        Image(
            painter = painterResource(id = R.drawable.objects),
            contentDescription = null,
            modifier = Modifier
                .weight(.3f)
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )
        Spacer(modifier = Modifier.weight(.1f))
        Column(
            modifier = Modifier
                .weight(.3f)
                .fillMaxWidth(.5f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.capture),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(10.dp))
                    .padding(start = 40.dp, end = 40.dp, top = 40.dp)
            )
            Text(text = "10CR mBank", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Buy, Play, Sell & Enjoy!!")
        }
        Spacer(modifier = Modifier.weight(.05f))
        CustomButton(text = "Get Started", modifier = Modifier.fillMaxWidth(.8f)) {
            navController.navigate(Screens.Login.route) {
                popUpTo(Screens.GetStart.route) { inclusive = true }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewGetStart() {
    val navHostController = rememberNavController()
    GetStartScreen(navHostController)
}