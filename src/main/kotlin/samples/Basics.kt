package samples

import dsl.XmlDsl
import extensions.eq

/**
 * <?xml version="1.0"?>
 */
val header =
    XmlDsl.build {
        tag {
            header = true
            name = "xml"
            params += "version" eq "1.0"
        }
    }.xml()

/**
 * <policy server="https://localhost/" email="example@mail.com"/>
 */
val closedTag =
    XmlDsl.build {
        tag {
            name = "policy"
            params += "server" eq "https://localhost/"
            params += "email" eq "example@mail.com"
        }
    }.xml()

/**
 * <attachments token="1234567890">
 *     <attachment id="0"/>
 *     <attachment id="1"/>
 *     <attachment id="2"/>
 * </attachments>
 */
val openedTag =
    XmlDsl.build {
        tag {
            name = "attachments"
            params += "token" eq "1234567890"
            content {
                tag {
                    name = "attachment"
                    params += "id" eq "0"
                }
                tag {
                    name = "attachment"
                    params += "id" eq "1"
                }
                tag {
                    name = "attachment"
                    params += "id" eq "2"
                }
            }
        }
    }.xml()

/**
 * <?xml version="1.0"?>
 * <policy server="https://localhost/" email="example@mail.com"/>
 * <attachments token="1234567890">
 *     <attachment id="0"/>
 *     <attachment id="1"/>
 *     <attachment id="2"/>
 * </attachments>
 */
val complex =
    XmlDsl.build {
        tag {
            header = true
            name = "xml"
            params += "version" eq "1.0"
        }
        tag {
            name = "policy"
            params += "server" eq "https://localhost/"
            params += "email" eq "example@mail.com"
        }
        tag {
            name = "attachments"
            params += "token" eq "1234567890"
            content {
                tag {
                    name = "attachment"
                    params += "id" eq "0"
                }
                tag {
                    name = "attachment"
                    params += "id" eq "1"
                }
                tag {
                    name = "attachment"
                    params += "id" eq "2"
                }
            }
        }
    }.xml()