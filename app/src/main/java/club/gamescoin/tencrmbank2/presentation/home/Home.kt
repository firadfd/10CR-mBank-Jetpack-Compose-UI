package club.gamescoin.tencrmbank2.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.CompareArrows
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Person2
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import club.gamescoin.tencrmbank2.presentation.ui.theme.green
import club.gamescoin.tencrmbank2.presentation.ui.theme.superNova

@Composable
fun HomeScreen(navController: NavHostController) {
    val constaints = ConstraintSet {
        val userInfoLay = createRefFor("header")
        val middleLay = createRefFor("middle")
        val bottomLay = createRefFor("bottom")

        constrain(userInfoLay) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(middleLay) {
            top.linkTo(userInfoLay.bottom)
            bottom.linkTo(bottomLay.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(bottomLay) {
            top.linkTo(userInfoLay.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

    }

    ConstraintLayout(constraintSet = constaints, modifier = Modifier.fillMaxSize()) {

        UserInfoLayout(name = "", balance = "", havNotification = false)

        PopularGames {

        }

        MiddleLayout()

    }
}

@Composable
fun UserInfoLayout(name: String, balance: String, havNotification: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.3f)
            .background(color = superNova)
            .layoutId("header")
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}

@Composable
fun MiddleLayout() {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .layoutId("middle")
            .fillMaxWidth(.8f)
            .fillMaxHeight(.1f)
            .shadow(10.dp),
        elevation = CardDefaults.cardElevation(10.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MiddleItem(Icons.AutoMirrored.Filled.CompareArrows, "Share") {

            }
            MiddleItem(Icons.Default.History, "History") {

            }
            MiddleItem(Icons.Default.Person2, "FNF") {

            }
        }
    }
}

@Composable
fun PopularGames(onGameItemClick: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(1f)
            .background(color = Color.White)
            .layoutId("bottom")
    ) {

    }
}

@Composable
fun MiddleItem(icon: ImageVector, title: String, onClick: () -> Unit) {
    Column(

        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .padding(10.dp)
            .clickable {
                onClick.invoke()
            }) {
        Icon(
            icon, contentDescription = null, tint = green
        )
        Text(text = title, style = TextStyle(color = green))
    }
}

//@PreviewScreenSizes
@Preview(showSystemUi = true)
@Composable
fun PreHome() {
    HomeScreen(navController = rememberNavController())

}