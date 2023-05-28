package com.duhbsoft.rpg_buddy

interface iLogger {
    fun logInfo(message: String)
    fun logWarning(message: String)
    fun logError(message: String)
}