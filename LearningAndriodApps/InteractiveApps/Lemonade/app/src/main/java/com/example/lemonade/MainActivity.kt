package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentStep by remember{mutableStateOf(value = 1)}
    var requiredTaps by remember{mutableStateOf(value = 2)}
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when(currentStep){
            1 -> Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()){
                Spacer(modifier = Modifier.height(height = 32.dp))
                Text(text = stringResource(id = R.string.tree_text), fontSize = 18.sp)
                Image(painter = painterResource(id = R.drawable.lemon_tree), contentDescription = stringResource(id = R.string.tree_description), modifier = Modifier.wrapContentSize().clickable {currentStep = 2})
            }

            2 -> Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()){
                requiredTaps = (2..4).random()
                var taps = 0
                Spacer(modifier = Modifier.height(height = 32.dp))
                //if (taps != 0 ){Text(text = stringResource(id = R.string.lemon_text_continue), fontSize = 18.sp)}
                //if (taps == 0){Text(text = stringResource(id = R.string.lemon_text_first), fontSize = 18.sp)}
                Text(text = stringResource(id = R.string.lemon_text_first), fontSize = 18.sp)
                Image(
                    painter = painterResource(id = R.drawable.lemon_squeeze),
                    contentDescription = stringResource(id = R.string.lemon_description),
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable{
                            taps += 1
                            if (taps == requiredTaps){ currentStep = 3 }
                        }
                )
            }

            3 -> Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()){
                Spacer(modifier = Modifier.height(height = 32.dp))
                Text(text = stringResource(id = R.string.full_glass_text), fontSize = 18.sp)
                Image(painter = painterResource(id = R.drawable.lemon_drink), contentDescription = stringResource(id = R.string.full_glass_description), modifier = Modifier.wrapContentSize().clickable{currentStep = 4})
            }

            4 -> Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()){
                Spacer(modifier = Modifier.height(height = 32.dp))
                Text(text = stringResource(id = R.string.empty_glass_text), fontSize = 18.sp)
                Image(
                    painter = painterResource(id = R.drawable.lemon_restart),
                    contentDescription = stringResource(id = R.string.empty_glass_description),
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable{currentStep = 1}
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}