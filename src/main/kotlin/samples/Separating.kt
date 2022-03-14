package samples

import dsl.XmlDsl
import dsl.XmlDslProtocol
import extensions.eq

/**
 * <?xml version="1.0"?>
 *
 * ... but not invoked yet
 */
val baseHeader: XmlDslProtocol.() -> Unit = {
    tag {
        header = true
        name = "xml"
        params += "version" eq "1.0"
    }
}

/**
 * <appointments token="1234567890">
 *     <appointment name="appointment0"/>
 *     <appointment name="appointment1"/>
 *     <appointment name="appointment2"/>
 *     <appointment name="appointment3"/>
 * </appointments>
 *
 * ... but not invoked yet
 */
val baseAppointments: XmlDslProtocol.() -> Unit = {
    tag {
        name = "appointments"
        params += "token" eq "1234567890"
        content {
            val appointmentsList = listOf(
                "appointment0",
                "appointment1",
                "appointment2",
                "appointment3",
            )

            appointmentsList.forEach { appointment ->
                tag {
                    name = "appointment"
                    params += "name" eq appointment
                }
            }
        }
    }
}

/**
 * <?xml version="1.0"?>
 * <appointments token="1234567890">
 *     <appointment name="appointment0"/>
 *     <appointment name="appointment1"/>
 *     <appointment name="appointment2"/>
 *     <appointment name="appointment3"/>
 * </appointments>
 */
val xmlComplex =
    XmlDsl.build {
        baseHeader()
        baseAppointments()
    }.xml()