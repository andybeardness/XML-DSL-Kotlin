package dsl

import extensions.eq
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@Suppress("IllegalIdentifier")
@RunWith(JUnit4::class)
internal class XmlDslTest {

    @Test
    fun `Test 1 - Base usage`() {
        val expected = "<?xml version=\"1.0\"?><open author=\"andybearndess\"><inner a=\"true\" b=\"B\"/></open>"

        val actual = XmlDsl.build {
            tag {
                header = true
                name = "xml"
                params += "version" eq "1.0"
            }
            tag {
                name = "open"
                params += "author" eq "andybearndess"
                content {
                    tag {
                        name = "inner"
                        params += "a" eq true
                        params += "b" eq "B"
                    }
                }
            }
        }.xml()

        assertEquals(
            expected = expected,
            actual = actual,
        )
    }
}