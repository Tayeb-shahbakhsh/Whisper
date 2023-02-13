package com.example.whisper

import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whisper.ui.theme.Shapes
import com.example.whisper.ui.theme.WhisperTheme

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

@Composable
fun MessagingUi() {
    val context = LocalContext.current.applicationContext
    TopBar()
}

@Preview
@Composable
fun TopBar() {
    Row(
        modifier = Modifier
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
