package com.airstrike.core.authentification

class LoggedInUser(var id : String, var version : Int,var status: Int, var success: String,var accessToken : String, var refreshToken:String, email: String,
                   firstName: String, lastName: String, password: String, phoneNumber: String
) : RegisteredUser(email, firstName, lastName, password, phoneNumber){

}