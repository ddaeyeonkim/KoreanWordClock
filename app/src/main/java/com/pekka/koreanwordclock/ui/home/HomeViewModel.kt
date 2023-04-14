package com.pekka.koreanwordclock.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDateTime
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _hour = MutableStateFlow(0)
    val hour get() = _hour.asStateFlow()

    private val _minute = MutableStateFlow(0)
    val minute get() = _minute.asStateFlow()

    private var timeJob: Job? = null

    init {
        updateCurrent()
    }

    fun start() {
        timeJob?.cancel()
        timeJob = viewModelScope.launch {
            while (true) {
                updateCurrent()
                delay(1000)
            }
        }
    }

    fun stop() {
        timeJob?.cancel()
    }

    private fun updateCurrent() {
        val current = LocalDateTime.now()
        _hour.value = current.hour
        _minute.value = current.minute
    }
}
