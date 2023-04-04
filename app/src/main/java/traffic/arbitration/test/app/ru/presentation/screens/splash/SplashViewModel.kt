package traffic.arbitration.test.app.ru.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import traffic.arbitration.test.app.ru.domain.AttributionRepository
import traffic.arbitration.test.app.ru.domain.model.Attribution
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: AttributionRepository
): ViewModel() {

    private val _action: Channel<SplashAction> = Channel(Channel.BUFFERED)
    var actionFlow = _action.receiveAsFlow()

    val utmKeys = hashMapOf<String, String?>(
        Pair("geotag", null),
        Pair("buyer_name", null),
        Pair("creative_name", null),
        Pair("af_status", null),
        Pair("ad_id", null),
        Pair("afChannel", null),
        Pair("campaign_id", null),
        Pair("campaign_group_name", null),
        Pair("campaign_id", null),
        Pair("adgroup_name", null),
        Pair("adgroup_id", null),
        Pair("campaign_name", null),
        Pair("utm_term", null),
        Pair("app_id", null),
        Pair("device_id", null),
        Pair("reserved_1", null),
        Pair("reserved_2", null),
        Pair("reserved_3", null),
        Pair("offer_link", null),
        Pair("package_name", null),
    )

    fun sendLocalData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.sendData(
                    utmKeys.toDomain()
                )
                sendAction(SplashAction.NavigateToMain)
            } catch (_: Throwable) {
                sendAction(SplashAction.NavigateToMain)
            }
        }
    }

    private fun sendAction(action: SplashAction){
        viewModelScope.launch(Dispatchers.Main){
            _action.send(action)
        }
    }

}

internal fun HashMap<String, String?>.toDomain(): Attribution {
    return Attribution(
        geotag = getValue("geotag"),
        buyerName = getValue("buyer_name"),
        creativeName = getValue("creative_name"),
        afStatus = getValue("af_status"),
        afChannel = getValue("afChannel"),
        adId = getValue("ad_id"),
        campaignId = getValue("campaign_id"),
        campaignGroupName = getValue("campaign_group_name"),
        campaignGroupId = getValue("campaign_id"),
        adgroupName = getValue("adgroup_name"),
        adgroupId = getValue("adgroup_id"),
        campaignName = getValue("campaign_name"),
        appId = getValue("app_id"),
        deviceId = getValue("device_id"),
        reservedFirst = getValue("reserved_1"),
        reservedSecond = getValue("reserved_2"),
        reservedThird = getValue("reserved_3"),
        offerLink = getValue("offer_link"),
        packageName = getValue("package_name"),
    )
}
