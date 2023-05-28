package com.duhbsoft.rpg_buddy

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class FileLoggerInstrumentedTest {
    @Before
    fun setup() {
        FileLogger.clearLogs()
    }

    private fun checkLogMessageAndType(message: String, type: String): Boolean {
        val logFile = FileLogger.getLogFile()
        var found = false
        logFile.forEachLine { line ->
            if (line.contains(message) && line.contains(type)) {
                found = true
                return@forEachLine  // Return from the lambda expression, breaking the loop
            }
        }

        return found
    }
    
    @Test
    fun useAppContextSanity() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.duhbsoft.rpg_buddy", appContext.packageName)
    }

    @Test
    fun writeInfo() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        FileLogger.logError("Test message")
        assertTrue(checkLogMessageAndType("Test message", FileLogger.INFO_MESSAGE))
    }
}