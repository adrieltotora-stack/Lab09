import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("id")        val id: Int,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName")  val lastName: String,
    @SerializedName("email")     val email: String,
    @SerializedName("phone")     val phone: String,
    @SerializedName("age")       val age: Int,
    @SerializedName("image")     val image: String,
    @SerializedName("company")   val company: CompanyModel
)

data class CompanyModel(
    @SerializedName("name")       val name: String,
    @SerializedName("department") val department: String
)