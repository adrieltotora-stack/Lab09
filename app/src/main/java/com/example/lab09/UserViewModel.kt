import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
            isLoading.value = true
            val response = RetrofitInstance.api.getUsers()
            users.addAll(response.users)
            isLoading.value = false
        }
    }

    fun loadUserById(id: Int) {
        viewModelScope.launch {
            isLoading.value = true
            selectedUser.value = RetrofitInstance.api.getUserById(id)
            isLoading.value = false
        }
    }
}