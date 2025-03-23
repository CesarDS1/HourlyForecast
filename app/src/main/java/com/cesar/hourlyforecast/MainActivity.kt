package com.cesar.hourlyforecast

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cesar.hourlyforecast.ui.theme.HourlyForecastTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HourlyForecastTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { SimpleToolbar() }) { innerPadding ->

                    HourlyForecastView(
                        modifier = Modifier.padding(
                            start = 0.dp,
                            top = 84.dp, end = 0.dp, bottom = 16.dp
                        ).background(Color(0xFF29299F))
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun HourlyForecastView(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = stringResource(R.string.mostly_clear))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(R.string.mock_temp_23), fontSize = 60.sp)
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Menu",
                tint = Color.White, modifier = Modifier.padding(16.dp)
            )
        }
        Text(text = stringResource(R.string.feels_like))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(R.string.higth),
                modifier = Modifier.padding(start = 0.dp,
                    top= 0.dp,
                    end = 8.dp,
                    bottom = 0.dp))
            Text(text = stringResource(R.string.mock_temp_28),
                modifier = Modifier.padding(start = 0.dp,
                    top= 0.dp,
                    end = 8.dp,
                    bottom = 0.dp)
                )
            Text(text = stringResource(R.string.low),
                modifier = Modifier.padding(start = 0.dp,
                    top= 0.dp,
                    end = 8.dp,
                    bottom = 0.dp))
            Text(text = stringResource(R.string.mock_temp_18))
        }

    }

}

@Preview
@Composable
fun HourlyForecastViewPreview() {
    HourlyForecastView()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleToolbar() {
    val context = LocalContext.current // Access the current context (Activity)
    CenterAlignedTopAppBar(
        title = { Text(stringResource(R.string.cdmx)) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF29299F),
            titleContentColor = Color.White,
        ),
        navigationIcon = {
            IconButton(onClick = {
                if (context is Activity) {
                    context.finish()
                }
            })
            {
                Icon(Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White)
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HourlyForecastTheme {
        Greeting("Android")
    }
}