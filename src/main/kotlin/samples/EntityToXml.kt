package samples

import dsl.XmlDsl
import extensions.eq

/*
* val policy = Policy(
*         server = "https://localhost/",
*         email = "example@mail.com",
*         username = "andybeardness",
*         tokens = listOf(
*             "1234",
*             "3456",
*             "5678",
*             "7890",
*         )
*    )
*
* policy.toXml() ->
* <policy server="https://localhost/" email="example@mail.com" username="andybeardness">
*     <tokens>
*         <token value="1234"/>
*         <token value="3456"/>
*         <token value="5678"/>
*         <token value="7890"/>
*     </tokens>
* </policy>
* */

data class Policy(
    val server: String,
    val email: String,
    val username: String,
    val tokens: List<String>,
)

fun Policy.toXml(): String =
    XmlDsl.build {
        tag {
            name = "policy"
            params += "server" eq server
            params += "email" eq email
            params += "username" eq username
            content {
                tag {
                    name = "tokens"
                    content {
                        tokens.forEach { token ->
                            tag {
                                name = "token"
                                params += "value" eq token
                            }
                        }
                    }
                }
            }
        }
    }.xml()