package com.example.composenav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.composenav.destinations.ForthScreenDestination
import com.example.composenav.destinations.SecScreenDestination
import com.example.composenav.destinations.ThirdScreenDestination
import com.example.composenav.model.Parson
import com.example.composenav.ui.theme.ComposeNavTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavTheme {
                // A surface container using the 'background' color from the theme
            }
            DestinationsNavHost(navGraph =NavGraphs.root)
        }
    }
}
@RootNavGraph(start = true)
@com.ramcosta.composedestinations.annotation.Destination
@Composable
fun FirstScreen(nav : DestinationsNavigator) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "first ", fontSize = 30.sp, color = Color.Red)
        //  Spacer(modifier = Modifier.padding(10.dp,10.dp))

        Button(onClick = {nav.navigate(SecScreenDestination(
            Parson(
                "Ayoub",
                26
            )
        ))
        }) {
            Text(text = "click her")

        }
    }
}

@com.ramcosta.composedestinations.annotation.Destination
@Composable
fun SecScreen(nav :DestinationsNavigator,person: Parson) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(text = "second ", fontSize = 30.sp, color = Color.Red)

        Text(text = "${person.name}")
        Text(text = "${person.Age}")


        //  Spacer(modifier = Modifier.padding(10.dp,10.dp))

        Button(onClick = {
            nav.navigate(ForthScreenDestination(Parson("ali",20)))
        }) {
            Text(text = "cldfhgfr")

        }
    }
}
@com.ramcosta.composedestinations.annotation.Destination
@Composable
fun ForthScreen(nav :DestinationsNavigator,person: Parson) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(text = "foreth ", fontSize = 30.sp, color = Color.Red)
        Text(text = "${person.Age}")

        //  Spacer(modifier = Modifier.padding(10.dp,10.dp))

        Button(onClick = {
            nav.navigate(ThirdScreenDestination)
        }) {
            Text(text = "click her")

        }
    }
}
@com.ramcosta.composedestinations.annotation.Destination
@Composable
fun ThirdScreen(nav :DestinationsNavigator) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Third 3 ", fontSize = 30.sp, color = Color.Red)
        //  Spacer(modifier = Modifier.padding(10.dp,10.dp))
        Button(onClick = {
            nav.popBackStack()
        }) {
            Text(text = "Go back")
        }
    }
}


