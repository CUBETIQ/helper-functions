package com.cubetiqs.entize.clinical.helper

import com.google.gson.GsonBuilder

class GsonHelper {
    companion object {
        val instance = GsonBuilder().setPrettyPrinting().serializeNulls().create()
    }
}