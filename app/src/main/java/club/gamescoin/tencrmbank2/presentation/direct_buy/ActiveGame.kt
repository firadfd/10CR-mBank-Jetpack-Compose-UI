package club.gamescoin.tencrmbank2.presentation.direct_buy

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import club.gamescoin.tencrmbank2.domain.model.GameList
import club.gamescoin.tencrmbank2.presentation.nav.Screens
import coil.compose.AsyncImage

@Composable
fun ActiveGameScreen(navController: NavHostController) {

    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val games = listOf(
            GameList(
                game_id = "1",
                title = "Teen Patti",
                images_url = "https://10crmbank.com/game-image/65e7f056d5957Frame 18347.png"
            ), GameList(
                game_id = "2",
                title = "KK",
                images_url = "https://10crmbank.com/game-image/65e7f0506ddb7Frame 18357.png"
            ), GameList(
                game_id = "3",
                title = "Lux",
                images_url = "https://10crmbank.com/game-image/65e7f048b369cFrame 18358.png"
            ), GameList(
                game_id = "4",
                title = "Ace Pro",
                images_url = "https://10crmbank.com/game-image/65e7f040ade23Frame 18354.png"
            ), GameList(
                game_id = "5",
                title = "legends",
                images_url = "https://10crmbank.com/game-image/65e7f02d8462aFrame 18355.png"
            ), GameList(
                game_id = "6",
                title = "Boss",
                images_url = "https://10crmbank.com/game-image/65e7f03800a46Frame 18356.png"
            )
        )

        GameLists(games = games) { gameName ->
            navController.navigate("${Screens.DirectBuy.route}/$gameName")
        }

    }
}

@Composable
fun GameLists(
    games: List<GameList>,
    modifier: Modifier = Modifier,
    onItemClicked: (gameName: String) -> Unit
) {
    LazyHorizontalGrid(rows = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxWidth(.9f)
            .fillMaxHeight(.2f),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalArrangement = Arrangement.SpaceEvenly,

        content = {
            itemsIndexed(games) { index, item ->
                GameItem(imageUrl = item.images_url) {
                    onItemClicked.invoke(item.title)
                }
            }
        })
}

@Composable
fun GameItem(imageUrl: String, modifier: Modifier = Modifier, onItemClicked: () -> Unit) {
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = modifier
            .size(70.dp)
            .clickable {
                onItemClicked.invoke()
            })
}


@Preview(showSystemUi = true)
@Composable
fun PreActiveGame() {
    ActiveGameScreen(navController = rememberNavController())

}