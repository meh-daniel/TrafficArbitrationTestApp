package traffic.arbitration.test.app.ru.data.nw

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import traffic.arbitration.test.app.ru.data.nw.model.AnswerServer
import traffic.arbitration.test.app.ru.data.nw.model.AttributionNW

private const val BEARER = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwicm9sZXMiOlt7ImlkIjoyfV0sImlhdCI6MTY3MjE4NDQ0NH0.ONCAZr_r8Cdu1cePZz4FRP75ytLrDGtul2qzgkoqnCc"

interface ServerApi {

    @POST("app")
    @Headers(
        "Authorization: Bearer $BEARER",
        "Content-Type: application/json",
    )
    suspend fun postAttributions(
        @Body attributionNW: AttributionNW
    ) : AnswerServer

}