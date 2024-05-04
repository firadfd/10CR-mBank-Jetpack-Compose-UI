package club.gamescoin.tencrmbank2.presentation.help

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import club.gamescoin.tencrmbank2.R
import club.gamescoin.tencrmbank2.presentation.common.CustomRateButton
import club.gamescoin.tencrmbank2.presentation.common.CustomTopBar
import club.gamescoin.tencrmbank2.presentation.ui.theme.labelTextColor
import club.gamescoin.tencrmbank2.presentation.ui.theme.lineColor

@Composable
fun HelpScreen(
    navController: NavHostController
) {
    Column(
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopBar(text = "Help") {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(30.dp))
        HelpItem(title = "Send a Complaint")
        HelpItem(title = "Complain list")
        HelpItem(title = "Search Trxid")
        Spacer(modifier = Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(.9f)
        ) {
            Image(
                painterResource(id = R.drawable.youtube),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Image(
                painterResource(id = R.drawable.facebook),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Image(
                painterResource(id = R.drawable.whatsapp),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Image(
                painterResource(id = R.drawable.messenger),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        CustomRateButton(modifier = Modifier.fillMaxWidth(.9f)) {

        }
    }
}


@Composable
fun HelpItem(title: String, modifier: Modifier = Modifier) {
    Column {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth(.9f)
                .height(50.dp)
                .padding(top = 10.dp, bottom = 10.dp)
        ) {
            Text(
                text = title,
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.Default.ArrowForwardIos, contentDescription = null, tint = labelTextColor)
            Spacer(modifier = Modifier.width(10.dp))
        }
        Divider(
            color = lineColor,
            modifier = Modifier
                .fillMaxWidth(.9f)
                .height(1.dp)
        )
    }

}