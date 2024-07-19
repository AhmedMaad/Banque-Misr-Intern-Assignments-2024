package com.maad.batteryalarmapp.ui

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BatteryViewModel(val app: Application) : AndroidViewModel(app) {

    private val _isBatteryLowState = MutableStateFlow(false)
    val isBatteryLowState = _isBatteryLowState.asStateFlow()

    private val myReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent?) {
            if (intent?.action == Intent.ACTION_BATTERY_LOW)
                _isBatteryLowState.update { true }
            else if (intent?.action == Intent.ACTION_BATTERY_OKAY)
                _isBatteryLowState.update { false }

        }
    }

    init {
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW)
        intentFilter.addAction(Intent.ACTION_BATTERY_OKAY)
        app.registerReceiver(myReceiver, intentFilter)
    }

    @Override
    override fun onCleared() {
        super.onCleared()
        app.unregisterReceiver(myReceiver)
    }
}