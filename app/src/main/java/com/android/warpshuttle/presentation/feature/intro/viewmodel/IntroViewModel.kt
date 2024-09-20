package com.android.warpshuttle.presentation.feature.intro.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.android.warpshuttle.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.asLiveData

class IntroViewModel(private val userRepository: UserRepository): ViewModel() {
    private var _isIntroViewed = userRepository.introViewedStateFromPref
    var isIntroViewed = _isIntroViewed.asLiveData()

    fun updateIsIntroViewedStatus(isIntroViewed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.saveIntroViewedStatus(isIntroViewed)
        }
    }

    class ViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            IntroViewModel(userRepository) as T
    }

}

