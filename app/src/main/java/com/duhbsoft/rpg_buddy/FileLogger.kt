package com.duhbsoft.rpg_buddy

import android.util.Log
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.*

object FileLogger {
    private const val LOG_DIRECTORY = "Tracing"
    private const val TAG = "FileLogger"
    private const val LOG_FILE_NAME = "rpg_buddy_app_log.txt"

    @JvmStatic
    fun getLogDirectory(): String {
        return "${android.os.Environment.getExternalStorageDirectory().absolutePath}/$LOG_DIRECTORY"
    }

    fun logInfo(message: String) {
        val logMessage = "[INFO] ${getCurrentTimeStamp()} $message"
        writeToLogFile(logMessage)
    }

    fun clearLogs(message: String) {
        val logMessage = "[INFO] ${getCurrentTimeStamp()} $message"
        writeToLogFile(logMessage)
    }

    fun logWarning(message: String) {
        val logMessage = "[WARNING] ${getCurrentTimeStamp()} $message"
        writeToLogFile(logMessage)
    }

    fun logError(message: String) {
        val logMessage = "[ERROR] ${getCurrentTimeStamp()} $message"
        writeToLogFile(logMessage)
    }

    private fun getCurrentTimeStamp(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return dateFormat.format(Date())
    }

    @Synchronized
    private fun writeToLogFile(message: String) {
        try {
            val logFile = File("${getLogDirectory()}/$LOG_FILE_NAME")
            if (!logFile.exists()) {
                logFile.createNewFile()
            }

            val fileWriter = FileWriter(logFile, true)
            fileWriter.appendLine(message)
            fileWriter.flush()
            fileWriter.close()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to write log message to file: ${e.message}")
        }
    }
}