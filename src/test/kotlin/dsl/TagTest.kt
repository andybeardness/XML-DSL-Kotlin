package dsl

import extensions.eq
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@Suppress("IllegalIdentifier")
@RunWith(JUnit4::class)
internal class TagTest {

    @Test
    fun `Test 1 - Base usage`() {
        val header0 = true
        val name0 = "name0"
        val param0 = "key0" eq "value0"
        val param1 = "key1" eq "value1"
        val param2 = "key2" eq "value2"

        val expected =
            Tag().apply {
                header = true
                name = "name0"
                params += "key0" eq "value0"
                params += "key1" eq "value1"
                params += "key2" eq "value2"
            }

        assertEquals(expected.header, header0)
        assertEquals(expected.name, name0)
        assertEquals(expected.params[0], param0)
        assertEquals(expected.params[1], param1)
        assertEquals(expected.params[2], param2)
    }

    @Test
    fun `Test 2 - Base xml() implementation`() {
        val expected =
            "<name0 key0=\"value0\" key1=\"value1\" key2=\"value2\"><name0 key0=\"value0\" key1=\"value1\" key2=\"value2\"/></name0>"

        val actual =
            Tag().apply {
                name = "name0"
                params += "key0" eq "value0"
                params += "key1" eq "value1"
                params += "key2" eq "value2"
                content {
                    tag {
                        name = "name0"
                        params += "key0" eq "value0"
                        params += "key1" eq "value1"
                        params += "key2" eq "value2"
                    }
                }
            }.xml()

        assertEquals(
            expected = expected,
            actual = actual,
        )
    }
}