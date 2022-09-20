package com.skillsoft.currencyconverter;

class SignUpUtils {

    fun isValidEmail(email: String):Boolean{
        return email.indexOf("@") > -1
    }

    fun isValidDOB(DOB: String): Boolean{
        var regex = """^[0-9]{2}[/-]{1}[0-9]{2}[/-]{1}[0-9]{4}$""".toRegex()
        return regex.containsMatchIn(DOB)
    }

    fun getLocalPartLength(email: String): Int{
        val end = email.indexOf("@")
        val localPart = email.substring(0, end)
        return localPart.length
    }
}
