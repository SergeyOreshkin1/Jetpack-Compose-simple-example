package com.example.jetpackcomposetest.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ParametersViewModel : ViewModel() {

    var isAttackFieldError by mutableStateOf(false)
    var isProtectionFieldError by mutableStateOf(false)
    var isHealthFieldError by mutableStateOf(false)
    var isMinDamageFieldError by mutableStateOf(false)
    var isMaxDamageFieldError by mutableStateOf(false)

    var attack by mutableStateOf("")
    var protection by mutableStateOf("")
    var health by mutableStateOf("")
    var minDamage by mutableStateOf("")
    var maxDamage by mutableStateOf("")

    fun validateAttackField(text: String) {
        if (text.isNotEmpty()) isAttackFieldError = text.toInt() > 20
    }

    fun validateProtectionField(text: String) {
        if (text.isNotEmpty()) isProtectionFieldError = text.toInt() > 20
    }

    fun validateHealthField(text: String) {
        if (text.isNotEmpty()) isHealthFieldError = text.toInt() !in 30..100
    }

    fun validateMinDamageField(text: String) {
        if (text.isNotEmpty()) isMinDamageFieldError = text.toInt() !in 1..3
    }

    fun validateMaxDamageField(text: String) {
        if (text.isNotEmpty()) isMaxDamageFieldError = text.toInt() !in 4..7
    }

    fun btnApplyIsEnable(): Boolean {
        return (!isAttackFieldError
                && !isProtectionFieldError
                && !isHealthFieldError
                && !isMinDamageFieldError
                && !isMaxDamageFieldError
                && attack.isNotEmpty()
                && protection.isNotEmpty()
                && health.isNotEmpty()
                && minDamage.isNotEmpty()
                && maxDamage.isNotEmpty())
    }
}