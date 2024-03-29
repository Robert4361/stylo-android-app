package com.airstrike.web_services.models.responses

import com.google.gson.annotations.SerializedName

open class RegisteredUser(
    @SerializedName("customer") var customer: Customer? = null,

)
data class Customer(
    @SerializedName("id") var id: String? = null,
    @SerializedName("version") var version: Int? = 0,
    @SerializedName("email") var email: String? = null,
    @SerializedName("firstName") var firstName: String? = null,
    @SerializedName("lastName") var lastName: String? = null,
    @SerializedName("password") var password: String? = null,
    @SerializedName("custom") var custom: CustomInfo? = null
)

data class CustomInfo(
    @SerializedName("fields")var fields: FieldsInfo? = null
)

data class FieldsInfo(
    @SerializedName("phoneNumber") var phoneNumber: String? = null
)
