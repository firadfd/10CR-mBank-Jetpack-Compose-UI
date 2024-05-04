package club.gamescoin.tencrmbank2.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import club.gamescoin.tencrmbank2.R
import club.gamescoin.tencrmbank2.presentation.ui.theme.labelTextColor
import club.gamescoin.tencrmbank2.presentation.ui.theme.superNova


@Composable
fun CustomButton(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = superNova,
    textColor: Color = Color.Black,
    showIcon: Boolean = false,
    icon: ImageVector = Icons.Default.ArrowForward,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick.invoke() },
        modifier = modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .padding(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        if (showIcon) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                style = TextStyle(color = textColor),
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(icon, contentDescription = null, tint = Color.White)
        } else {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                style = TextStyle(color = textColor),
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
fun CustomTopBar(
    text: String,
    modifier: Modifier = Modifier,
    showIcon: Boolean = true,
    iconTint: Color = Color.Black,
    backColor: Color = Color.White,
    icon: ImageVector = Icons.Default.ArrowBackIosNew,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .height(70.dp)
            .background(color = backColor)
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        if (showIcon) {
            Icon(imageVector = icon, contentDescription = null, modifier = Modifier.clickable {
                if (showIcon){
                    onClick.invoke()
                }else{
                    println("Nothing")
                }
            }.padding(10.dp), tint = iconTint)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = text, maxLines = 1, style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start,
                    fontFamily = FontFamily(Font(R.font.josefinsansregular))
                ), modifier = Modifier.wrapContentWidth()
            )
            Spacer(modifier = Modifier.weight(1f))
        } else {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = text, maxLines = 1, style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.josefinsansregular))
                ), modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}


@Composable
fun CustomTextInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    placeholder: String = ""
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors(Color.Black),
        placeholder = { Text(placeholder, style = TextStyle(color = labelTextColor)) },
        textStyle = TextStyle(color = Color.Black),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = imeAction, keyboardType = keyboardType
        ),
        singleLine = true
    )
}

@Composable
fun PasswordTextInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hintText: String = ""
) {
    var passwordVisible by remember { mutableStateOf(false) }
    OutlinedTextField(value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = hintText, style = TextStyle(color = labelTextColor)) },
        colors = OutlinedTextFieldDefaults.colors(Color.Black),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = modifier,
        singleLine = true,
        textStyle = TextStyle(color = Color.Black),
        trailingIcon = {
            IconButton(onClick = {
                passwordVisible = !passwordVisible
            }) {
                Icon(
                    imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = if (passwordVisible) "Hide password" else "Show password"
                )
            }
        })
}

@Composable
fun CustomRateButton(
    modifier: Modifier = Modifier, onClick: () -> Unit
) {
    OutlinedButton(
        onClick = { onClick.invoke() },
        modifier = modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .padding(10.dp),
    ) {
        Text(
            text = "Rate us on Google play",
            style = TextStyle(color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Image(painterResource(id = R.drawable.google_play_store), contentDescription = null)
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewButton() {
    CustomRateButton(modifier = Modifier.fillMaxWidth(.9f)) {

    }
}