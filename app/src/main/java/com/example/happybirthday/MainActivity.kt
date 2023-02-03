package com.example.happybirthday

import android.R.attr.contentDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    BirthdayGreetingWithImage(
                        message = "test", from = "test2")


                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun BirthCardPreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithText("Happy Birthday Sam!", "- from Emma")
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
    Row {
        Text(
            text = message,
            fontSize = 36.sp
        )
        Text(
            text = from,
            fontSize = 24.sp
        )
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(R.drawable.androidparty)

    Box {
        Image (
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from = from)
    }

}
@Preview(showBackground = false)
@Composable
private fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithImage("Happy Birthday Sam!", "- from Emma")
    }
}