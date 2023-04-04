package traffic.arbitration.test.app.ru.data

import traffic.arbitration.test.app.ru.data.nw.ServerApi
import traffic.arbitration.test.app.ru.domain.AttributionRepository
import traffic.arbitration.test.app.ru.domain.model.Attribution

class AttributionRepositoryImpl(
    private val nw: ServerApi
): AttributionRepository {
    override suspend fun sendData(attribution: Attribution): Boolean {
        return nw.postAttributions(attribution.toNW()).success!!
    }
}


