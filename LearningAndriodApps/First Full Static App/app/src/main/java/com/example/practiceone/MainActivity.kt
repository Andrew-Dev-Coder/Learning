package com.example.practiceone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practiceone.ui.theme.PracticeOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeOneTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AllText(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AllText(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column(
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
        )
        Text(
            text = stringResource(id = R.string.Title_Text),
            modifier = modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp, top = 10.dp),
            fontSize = 24.sp
        )
        Text(
            text = stringResource(id = R.string.body_text),
            modifier = modifier.padding(start = 10.dp, end = 10.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(id = R.string.pharagraph_text),
            modifier = modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp, top = 10.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticeOneTheme {
        AllText()
    }
}
