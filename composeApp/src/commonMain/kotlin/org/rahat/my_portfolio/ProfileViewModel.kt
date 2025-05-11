package org.rahat.my_portfolio

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.rahat.my_portfolio.data.DeveloperProfile
import org.rahat.my_portfolio.repo.ProfileRepository

class ProfileViewModel(private val repository: ProfileRepository) : ViewModel() {
    var profileState by mutableStateOf<DeveloperProfile?>(null)
        private set

    private suspend fun loadProfile() {
        profileState = repository.loadProfile()
    }

    init {
        viewModelScope.launch {
            loadProfile()
        }
    }
}
