package com.skillsoft.currencyconverter

import com.google.gson.JsonObject

class HomeFeed (val rates: JsonObject, val base: String)

lateinit var homeFeed : HomeFeed