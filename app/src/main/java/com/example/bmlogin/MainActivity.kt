package com.example.bmlogin

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmlogin.ui.theme.BMLoginTheme
import org.intellij.lang.annotations.Language
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.VisualTransformation
import androidx.constraintlayout.compose.Visibility
import com.example.bmlogin.ui.theme.Pink40


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Header()
            Login()
        }
    }
}

@Composable
fun Header(modifier: Modifier = Modifier){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 28.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Image(

            painter = painterResource(id = R.drawable.bm_icon),
            contentDescription = "Banque Misr Logo",
            modifier = modifier.size(150.dp),

        )
        Text(
            text = "العربية",
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )



    }


}
@Composable
fun Login(modifier: Modifier = Modifier){
    var username by remember{ mutableStateOf("") }
    var password by rememberSaveable{ mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility) {
        Icons.Filled.Visibility //
    } else {
        Icons.Filled.VisibilityOff //
    }
    val isButtonEnabled = username.isNotEmpty() && password.isNotEmpty()




    Column(

    ) {
        Text(text = "",
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 190.dp)
        )
        OutlinedTextField(value =username , onValueChange ={username = it},
            label = { Text(text = "Username")},

            modifier = modifier
                .fillMaxWidth()
                .padding(all = 25.dp)

        )

        OutlinedTextField(
            value = password, onValueChange = { password = it },
            label = { Text(text = "password") },

            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Visibility password"
                    )
                    
                }
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp),

            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else{
                PasswordVisualTransformation()


            }

            )


        Text(
            text = "Forgot username/password?",
            color = Color.Blue,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 22.dp)
                .clickable { /* Handle click */ }
        )



        TextButton(
            onClick = { /* Handle login */ },
            enabled = isButtonEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
                .background(if (isButtonEnabled) Color(0xFF750A2D) else Color(0xFF7D5260)),


        ) {
            Text(
                text = "Login",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }


    }

}

@Composable
fun Footer(modifier: Modifier = Modifier){

}



@Preview(wallpaper = Wallpapers.NONE, showSystemUi = true, showBackground = true)
@Composable
fun HeaderPreview(){
        Header()
        Login()
        Footer()
}
