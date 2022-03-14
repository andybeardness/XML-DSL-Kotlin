package samples

import dsl.XmlDsl
import extensions.eq

fun main() {
    val xml = XmlDsl.build {
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

    println(
        "xml = $xml"
    )
}