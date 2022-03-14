package configurations

import dsl.XmlDsl
import extensions.eq
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@Suppress("IllegalIdentifier")
@RunWith(JUnit4::class)
internal class DslConfigurationsTest {

    private val namePlaceholder = DslConfigurations.namePlaceholder
    private val paramsPlaceholder = DslConfigurations.paramsPlaceholder
    private val contentPlaceholder = DslConfigurations.contentPlaceholder

    private val headerBracketsTemplateNew = "[[$namePlaceholder] : [$paramsPlaceholder]]"
    private val closedTagBracketsTemplateNew = "%%$namePlaceholder %% $paramsPlaceholder%%"
    private val openedTagBracketsTemplateNew = "+=$namePlaceholder=+ _${contentPlaceholder}_ ^$paramsPlaceholder^"

    @Test
    fun `Test 1 - Base`() {
        val expected = "<?xml version=\"1.0\"?><closed key1=\"value1\" key2=\"value2\" key3=\"value3\"/><opened key1=\"value1\"><inner key1=\"value1\"/></opened>"

        val actual = XmlDsl.build {
            tag {
                header = true
                name = "xml"
                params += "version" eq "1.0"
            }
            tag {
                name = "closed"
                params += "key1" eq "value1"
                params += "key2" eq "value2"
                params += "key3" eq "value3"
            }
            tag {
                name = "opened"
                params += "key1" eq "value1"
                content {
                    tag {
                        name = "inner"
                        params += "key1" eq "value1"
                    }
                }
            }
        }.xml()

        assertEquals(
            expected = expected,
            actual = actual,
        )
    }

    @Test
    fun `Тест 2 - Disable header if content exist`() {
        /*
        * Only Header
        * */

        val expectedHeader = "<?xml version=\"1.0\"?>"

        val actualHeader = XmlDsl.build {
            tag {
                header = true
                name = "xml"
                params += "version" eq "1.0"
            }
        }.xml()

        assertEquals(
            expected = expectedHeader,
            actual = actualHeader,
        )

        /*
        * Only Content
        * */

        val expectedContent = "<xml version=\"1.0\"></xml>"

        val actualContent = XmlDsl.build {
            tag {
                name = "xml"
                params += "version" eq "1.0"
                content {  }
            }
        }.xml()

        assertEquals(
            expected = expectedContent,
            actual = actualContent,
        )

        /*
        * Header + Content
        * */

        val expectedHeaderContent = "<xml version=\"1.0\"></xml>"

        val actualHeaderContent = XmlDsl.build {
            tag {
                header = true
                name = "xml"
                params += "version" eq "1.0"
                content {  }
            }
        }.xml()

        assertEquals(
            expected = expectedHeaderContent,
            actual = actualHeaderContent,
        )
    }

    @Test
    fun `Test 3 - Change configuration test`() {
        DslConfigurations.headerBracketsTemplate = headerBracketsTemplateNew
        DslConfigurations.closedTagBracketsTemplate = closedTagBracketsTemplateNew
        DslConfigurations.openedTagBracketsTemplate = openedTagBracketsTemplateNew

        val expected = "[[xml] : [version=\"1.0\"]]%%closed %% key1=\"value1\" key2=\"value2\" key3=\"value3\"%%+=opened=+ _%%inner %% key1=\"value1\"%%_ ^key1=\"value1\"^"

        val actual = XmlDsl.build {
            tag {
                header = true
                name = "xml"
                params += "version" eq "1.0"
            }
            tag {
                name = "closed"
                params += "key1" eq "value1"
                params += "key2" eq "value2"
                params += "key3" eq "value3"
            }
            tag {
                name = "opened"
                params += "key1" eq "value1"
                content {
                    tag {
                        name = "inner"
                        params += "key1" eq "value1"
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