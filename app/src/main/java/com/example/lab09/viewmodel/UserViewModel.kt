package com.example.lab09.viewmodel

import com.example.lab09.model.UserModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab09.network.RetrofitInstance
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    var users = mutableStateListOf<UserModel>()
        private set

    var selectedUser = mutableStateOf<UserModel?>(null)
        private set

    var isLoading = mutableStateOf(false)
        private set

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            try {
                isLoading.value = true
                val response = RetrofitInstance.api.getUsers()
                users.clear()
                users.addAll(response.users)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                isLoading.value = false
            }
        }
    }

    fun loadUserById(id: Int) {
        viewModelScope.launch {
            try {
                isLoading.value = true
                selectedUser.value = RetrofitInstance.api.getUserById(id)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                isLoading.value = false
            }
        }
    }
}
