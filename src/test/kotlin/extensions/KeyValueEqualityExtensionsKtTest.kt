package extensions

import dsl.KeyValue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@Suppress("IllegalIdentifier")
@RunWith(JUnit4::class)
internal class KeyValueEqualityExtensionsKtTest {

    @Test
    fun `Test 1 - String and String`() {
        val key = "key"
        val value = "value"

        val expected = KeyValue(key = key, value = value)
        val actual = key eq value

        assertEquals(
            expected = expected,
            actual = actual
        )
    }

    @Test
    fun `Test 2 - String and Boolean`() {
        val key = "key"
        val value = true

        val expected = KeyValue(key = key, value = "true")
        val actual = key eq value

        assertEquals(
            expected = expected,
            actual = actual
        )
    }

    @Test
    fun `Test 3 - String and Float`() {
        val key = "key"
        val value = 1.0f

        val expected = KeyValue(key = key, value = "1.0")
        val actual = key eq value

        assertEquals(
            expected = expected,
            actual = actual
        )
    }

    @Test
    fun `Test 4 - String and Double`() {
        val key = "key"
        val value = 1.0

        val expected = KeyValue(key = key, value = "1.0")
        val actual = key eq value

        assertEquals(
            expected = expected,
            actual = actual
        )
    }

    @Test
    fun `Test 5 - String and Int`() {
        val key = "key"
        val value = 1

        val expected = KeyValue(key = key, value = "1")
        val actual = key eq value

        assertEquals(
            expected = expected,
            actual = actual
        )
    }
}