package com.maad.batteryalarmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maad.batteryalarmapp.ui.BatteryViewModel
import com.maad.batteryalarmapp.ui.theme.BatteryAlarmAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BatteryAlarmAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    BatteryImage(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BatteryImage(modifier: Modifier = Modifier, viewModel: BatteryViewModel = viewModel()) {

    val batteryState by viewModel.isBatteryLowState.collectAsState()

    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {

        val imageResource = if (batteryState) R.drawable.battery_low else R.drawable.battery_full
        val contentDescription = if (batteryState) R.string.battery_low else R.string.battery_high
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = stringResource(contentDescription),
            modifier = modifier.size(250.dp)
        )
    }

}