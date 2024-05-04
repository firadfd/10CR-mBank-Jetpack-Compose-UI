package club.gamescoin.tencrmbank2.presentation.direct_buy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import club.gamescoin.tencrmbank2.R
import club.gamescoin.tencrmbank2.presentation.common.CustomButton
import club.gamescoin.tencrmbank2.presentation.common.CustomTextInputField
import club.gamescoin.tencrmbank2.presentation.common.CustomTopBar
import club.gamescoin.tencrmbank2.presentation.nav.Screens
import club.gamescoin.tencrmbank2.presentation.ui.theme.green
import club.gamescoin.tencrmbank2.presentation.ui.theme.lineColor
import club.gamescoin.tencrmbank2.presentation.ui.theme.superNova

@Composable
fun DirectBuyScreen(navController: NavHostController, gameName: String?) {
    var playerId by remember {
        mutableStateOf("")
    }
    var chipsAmount by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopBar(
            text = gameName!!, showIcon = true, iconTint = Color.Red, backColor = superNova
        ) {
            navController.popBackStack()
        }
        Divider(
            modifier = Modifier
                .height(2.dp)
                .background(color = lineColor)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Input your player ID",
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            style = TextStyle(color = Color.Black, fontSize = 16.sp),
            modifier = Modifier.fillMaxWidth(.9f)
        )
        Spacer(modifier = Modifier.height(5.dp))
        CustomTextInputField(
            value = playerId,
            onValueChange = {
                playerId = it
            },
            modifier = Modifier.fillMaxWidth(.9f),
            keyboardType = KeyboardType.Text,
            placeholder = "A123456"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Select / Input Chips Amount",
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            style = TextStyle(color = Color.Black, fontSize = 16.sp),
            modifier = Modifier.fillMaxWidth(.9f)
        )
        Spacer(modifier = Modifier.height(5.dp))
        CustomTextInputField(
            value = chipsAmount,
            onValueChange = {
                chipsAmount = it
            },
            modifier = Modifier.fillMaxWidth(.9f),
            keyboardType = KeyboardType.Number,
            placeholder = "10"
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomRow(
            amounts = listOf("5", "10", "15", "20"),
            modifier = Modifier
                .fillMaxWidth(.9f)
                .height(170.dp)
        ) {

        }
        if (gameName.toLowerCase() == "teen patti") {
            Divider(
                modifier = Modifier
                    .height(5.dp)
                    .background(color = lineColor)
            )
            CustomGulItem(icon = R.drawable.gullak, title = "Gullak")
            Divider(
                modifier = Modifier
                    .height(5.dp)
                    .background(color = lineColor)
            )
            CustomGulItem(icon = R.drawable.goldpass, title = "Gold Pass")

        }
        Divider(
            modifier = Modifier
                .height(5.dp)
                .background(color = lineColor)
        )
        CustomButton(
            text = "NEXT",
            color = green,
            textColor = Color.White,
            showIcon = true,
            icon = Icons.Filled.ArrowForward,
            modifier = Modifier.fillMaxWidth(.9f)
        ) {
            navController.navigate("${Screens.DirectBuyPaymentMethod.route}/$gameName/$gameName")
        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun PreDirectBuyAmount() {
    DirectBuyScreen(navController = rememberNavController(), gameName = "Teen Patti")
}

@Composable
fun CustomRow(
    amounts: List<String>, modifier: Modifier = Modifier, onItemClick: (amount: String) -> Unit
) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalArrangement = Arrangement.SpaceAround,
        content = {
            itemsIndexed(amounts) { _, item ->
                CustomButton(
                    text = "$item Cr",
                    modifier = Modifier.fillMaxWidth(.4f),
                    color = Color(0xFFFDE8E9)
                ) {
                    onItemClick.invoke(item)
                }
            }
        })
}

@Composable
fun CustomGulItem(icon: Int, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}


