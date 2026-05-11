import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService {

    @GET("users?limit=20")
    suspend fun getUsers(): UsersResponse

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): UserModel
}