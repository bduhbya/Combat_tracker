package com.duhbsoft.rpg_buddy

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class FileLoggerInstrumentedTest {
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
        assertEquals("com.duhbsoft.rpg_buddy", appContext.packageName)
    }
}