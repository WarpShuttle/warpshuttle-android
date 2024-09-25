package com.android.warpshuttle.presentation.feature.authentication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.android.warpshuttle.data.network.SingleLiveEvent
import com.android.warpshuttle.data.repository.ResponseEvent
import com.android.warpshuttle.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {
    private var _isLoggedIn = userRepository.loggedInStateFromPref
    var isLoggedIn = _isLoggedIn.asLiveData()

    fun updateLogInStatus(isLoggedIn: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.saveLoginStatus(isLoggedIn)
        }
    }

    private var _email = MutableStateFlow("")
    var email = _email.asStateFlow()

    fun updateEmail(email: String) = viewModelScope.launch {
        _email.update { email }
    }

    private var _password = MutableStateFlow("")
    var password = _password.asStateFlow()

    fun updatePassword(password: String) = viewModelScope.launch{
        _password.update { password }
    }

    fun verifyLogin(
        email: String,
        password: String,
    ): SingleLiveEvent<ResponseEvent> {
        return userRepository.verifyLogin(
            email = email,
            password = password
        )
    }

    class ViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            LoginViewModel(userRepository) as T
    }
}