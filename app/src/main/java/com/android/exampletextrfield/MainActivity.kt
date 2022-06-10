package com.android.exampletextrfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.exampletextrfield.ui.theme.ExampleTextrFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleTextrFieldTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ChangeTextField()
                }
            }
        }
    }
}

@Composable
fun ChangeTextField() {
    val text = remember { mutableStateOf("") }
    Column {
        TextField(
            value = text.value,
            onValueChange = { text.value = it },
            label = { Text("Enter text") },
            maxLines = 1,
            textStyle = TextStyle(color = Blue, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp)
        )
        Text(
            text = text.value,
            modifier = Modifier.padding(40.dp),
            fontStyle = FontStyle( value = 1)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExampleTextrFieldTheme {
        ChangeTextField()
    }
}