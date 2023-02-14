package com.example.whisper

import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.provider.Telephony.Mms.Sent
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whisper.ui.theme.Shapes
import com.example.whisper.ui.theme.WhisperTheme


const val SENT = 0
const val RECIEVED = 1

data class (val status: Int,val message: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhisperTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        MessagingUi()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MessagingUi() {
    val context = LocalContext.current.applicationContext
    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopBar()
        MessagesList()
        BottomBar()
    }
}

@Composable
fun MessagesList(messages: List<>){

}

@Composable
fun Message(status: Int){
    if (status == SENT){
        Card(shape = AbsoluteRoundedCornerShape(16.dp,1.dp,16.dp,16.dp), backgroundColor = Color.LightGray, contentColor = Color.DarkGray,modifier = Modifier.padding(16.dp)) {
            Text(modifier = Modifier.padding(16.dp), text = "hello, whats up??")
        }
    }else if (status == RECIEVED){
        Card(shape = AbsoluteRoundedCornerShape(1.dp,16.dp,16.dp,16.dp), backgroundColor = MaterialTheme.colors.background, contentColor = Color.DarkGray,modifier = Modifier.padding(16.dp)) {
            Text(modifier = Modifier.padding(16.dp), text = "hello, whats up??")
        }
    }
}


@Composable
fun BottomBar() {

    var value by remember {
        mutableStateOf("")
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(12.dp, 16.dp)
            .fillMaxWidth()
            .height(68.dp)
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = { value = it },
            label = {
                    Text(text = "Enter message ...", color = Color.LightGray)
            },
            shape = RoundedCornerShape(20.dp)
        )

        IconButton(onClick = { println("message sent!") }) {
            Icon(imageVector = Icons.Default.Send, contentDescription = "send message icon")
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .height(64.dp),
        Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back arrow")

        Image(
            painter = painterResource(id = R.drawable.user1),
            contentDescription = "user profile photo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(48.dp)
                .height(48.dp)
                .clip(RoundedCornerShape(40.dp))
        )

        Column(Modifier.width(180.dp), horizontalAlignment = Alignment.Start) {
            Text(text = "Ali Mahjoor", fontWeight = FontWeight.Bold)
            Text(
                text = "last seen 10:54 PM",
                fontWeight = FontWeight.ExtraLight,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                color = Color.LightGray
            )
        }

        Icon(imageVector = Icons.Default.Info, contentDescription = "user info icon")
    }
}
