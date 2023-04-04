package traffic.arbitration.test.app.ru.data

import traffic.arbitration.test.app.ru.data.nw.model.AttributionNW
import traffic.arbitration.test.app.ru.domain.model.Attribution

internal fun Attribution.toNW(): AttributionNW {
    return AttributionNW(
        adgroupId = adgroupId,
        adgroupName = adgroupName,
        afChannel = afChannel,
        afStatus = afStatus,
        appId = appId,
        buyerName = buyerName,
        campaignGroupId = campaignGroupId,
        campaignName = campaignName,
        campaignGroupName = campaignGroupName,
        campaignId = campaignId,
        creativeName = creativeName,
        deviceId = deviceId,
        geotag = geotag,
        offerLink = offerLink,
        packageName = packageName,
        reserved1 = reservedFirst,
        reserved2 = reservedSecond,
        reserved3 = reservedThird
    )
}