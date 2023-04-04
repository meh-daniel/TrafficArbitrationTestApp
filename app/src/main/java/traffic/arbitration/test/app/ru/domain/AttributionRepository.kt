package traffic.arbitration.test.app.ru.domain

import traffic.arbitration.test.app.ru.domain.model.Attribution

interface AttributionRepository {

    suspend fun sendData(attribution: Attribution): Boolean

}