package traffic.arbitration.test.app.ru.data.nw.model


import com.google.gson.annotations.SerializedName

data class AttributionNW(
    @SerializedName("adgroup_id")
    val adgroupId: String?,
    @SerializedName("adgroup_name")
    val adgroupName: String?,
    @SerializedName("af_channel")
    val afChannel: String?,
    @SerializedName("af_status")
    val afStatus: String?,
    @SerializedName("app_id")
    val appId: String?,
    @SerializedName("buyer_name")
    val buyerName: String?,
    @SerializedName("campaign_group_id")
    val campaignGroupId: String?,
    @SerializedName("campaign_group_name")
    val campaignGroupName: String?,
    @SerializedName("campaign_id")
    val campaignId: String?,
    @SerializedName("campaign_name")
    val campaignName: String?,
    @SerializedName("creative_name")
    val creativeName: String?,
    @SerializedName("device_id")
    val deviceId: String?,
    @SerializedName("geotag")
    val geotag: String?,
    @SerializedName("offer_link")
    val offerLink: String?,
    @SerializedName("package_name")
    val packageName: String?,
    @SerializedName("reserved_1")
    val reserved1: String?,
    @SerializedName("reserved_2")
    val reserved2: String?,
    @SerializedName("reserved_3")
    val reserved3: String?
)