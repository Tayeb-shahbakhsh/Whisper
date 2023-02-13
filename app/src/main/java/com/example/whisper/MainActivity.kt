package com.example.whisper

import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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

@Preview
@Composable
fun MessagingUi(){
    val contextForToast = LocalContext.current.applicationContext

    TopAppBar(
        title = {
            Text(text = "SemicolonSpace")
        },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(contextForToast, "Back Icon Click", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back")
            }
        }
    )
}
