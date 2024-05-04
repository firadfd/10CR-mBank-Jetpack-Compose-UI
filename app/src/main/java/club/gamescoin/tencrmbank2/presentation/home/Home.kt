package club.gamescoin.tencrmbank2.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.CompareArrows
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person2
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.QuestionMark
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(80.dp)
                    .padding(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(.4f)
                ) {
                    Text(
                        text = "Firad Fd", style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ), modifier = Modifier.align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.weight(.2f))
                Icon(
                    Icons.Outlined.Notifications,
                    contentDescription = null,
                    tint = green,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(30.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                CustomHelpIcon(
                    title = "Help",
                    icon = Icons.Rounded.QuestionMark,
                    modifier = Modifier.weight(.3f)
                ) {

                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(80.dp)
                    .padding(10.dp)
            ) {
                OutlinedButton(onClick = {},
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxHeight()
                        .weight(.5f)
                ) {

                }
                Spacer(modifier = Modifier.weight(.2f))
                CustomHelpIcon(
                    title = "Recharge",
                    icon = Icons.Rounded.Add,
                    modifier = Modifier.weight(.4f)
                ) {

                }
            }
        }
    }
}

@Composable
fun CustomHelpIcon(
    title: String, icon: ImageVector, modifier: Modifier = Modifier, onClick: () -> Unit
) {
    Button(
        onClick = { onClick.invoke() },
        colors = ButtonDefaults.buttonColors(green),
        modifier = modifier
    ) {
        Text(text = title, style = TextStyle(color = Color.White))
        Spacer(modifier = Modifier.weight(.2f))
        Icon(
            icon, contentDescription = null, tint = green, modifier = Modifier
                .clip(
                    RoundedCornerShape(15.dp)
                )
                .background(color = superNova)
        )
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