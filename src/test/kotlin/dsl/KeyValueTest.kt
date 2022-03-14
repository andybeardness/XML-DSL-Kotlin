package dsl

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@Suppress("IllegalIdentifier")
@RunWith(JUnit4::class)
internal class KeyValueTest {

    @Test
    fun `Test 1 - Base xml() implementation`() {
        val expected = "xml=\"1.0\""

        val actual = KeyValue(key = "xml", value = "1.0").xml()

        assertEquals(
            expected = expected,
            actual = actual,
        )
    }
}