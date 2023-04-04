package traffic.arbitration.test.app.ru.data.nw.model


import com.google.gson.annotations.SerializedName

data class AnswerServer(
    @SerializedName("success")
    val success: Boolean?
)