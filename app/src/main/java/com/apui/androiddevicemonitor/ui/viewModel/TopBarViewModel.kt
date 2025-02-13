package com.apui.androiddevicemonitor.ui.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.apui.androiddevicemonitor.utils.Screens

class TopBarViewModel : ViewModel() {

    private val _isBackButtonVisible = mutableStateOf(false)
    val isBackButtonVisible: State<Boolean> = _isBackButtonVisible

    private val _screen = mutableStateOf(Screens.HOME)
    val screen: State<Screens> = _screen

    fun currentTopBar(isBackButtonVisible: Boolean, screen: Screens) {
        this._isBackButtonVisible.value = isBackButtonVisible
        this._screen.value = screen
    }
}