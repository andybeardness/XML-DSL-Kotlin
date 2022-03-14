# XML-DSL-KOTLIN

*DSL for XML for RuPost Android Team*

## About

Simple to use DSL for XML creating

## Navigation

- [Title](#xml-dsl-kotlin)
- [About](#about)
- [Navigation](#navigation)
- [Examples](#examples)
- - [Quick view](#quick-view)
- - - [Header](#header)
- - - [Closed tag](#closed-tag)
- - - [Opened tag](#opened-tag)
- - - [Complex](#complex)
- - [Entity to XML](#entity-to-xml)
- - [Separating](#separating)
- [Author](#author)

## Examples 

### Quick view

#### Header

```kotlin
val header =
    XmlDsl.build {
        tag {
            header = true
            name = "xml"
            params += "version" eq "1.0"
        }
    }.xml()
```

```xml
<!-- header -->
<?xml version="1.0"?>
```

[see in code](src/main/kotlin/samples/Basics.kt#L6)

#### Closed tag

```kotlin
val closedTag =
    XmlDsl.build {
        tag {
            name = "policy"
            params += "server" eq "https://localhost/"
            params += "email" eq "example@mail.com"
        }
    }.xml()
```

```xml
<!-- closedTag -->
<policy server="https://localhost/" email="example@mail.com"/>
```

[see in code](src/main/kotlin/samples/Basics.kt#L18)

#### Opened tag

```kotlin
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
```

```xml
<!-- openedTag -->
<attachments token="1234567890">
    <attachment id="0"/>
    <attachment id="1"/>
    <attachment id="2"/>
</attachments>
```

[see in code](src/main/kotlin/samples/Basics.kt#L30)

#### Complex

```kotlin
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
```

```xml
<!-- complex -->
<?xml version="1.0"?>
<policy server="https://localhost/" email="example@mail.com"/>
<attachments token="1234567890">
    <attachment id="0"/>
    <attachment id="1"/>
    <attachment id="2"/>
</attachments>
```

[see in code](src/main/kotlin/samples/Basics.kt#L59)

### Entity to XML

```kotlin
/*
* Entity data-class
* */
data class Policy(
    val server: String,
    val email: String,
    val username: String,
    val tokens: List<String>,
)

/*
* Extensions : Entity -> XML
* */
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

/*
* Entity implementation
* */
val policy = Policy(
    server = "https://localhost/",
    email = "example@mail.com",
    username = "andybeardness",
    tokens = listOf(
        "1234",
        "3456",
        "5678",
        "7890",
    )
)

/*
* Result XML
* */
val policyXml = policy.toXml()
```

```xml
<!-- policyXml -->
<policy server="https://localhost/" email="example@mail.com" username="andybeardness">
    <tokens>
        <token value="1234"/>
        <token value="3456"/>
        <token value="5678"/>
        <token value="7890"/>
    </tokens>
</policy>
```

[see in code](src/main/kotlin/samples/EntityToXml.kt#L6)

### Separating

```kotlin
/*
* Separated Header
* */
val baseHeader: XmlDslProtocol.() -> Unit = {
    tag {
        header = true
        name = "xml"
        params += "version" eq "1.0"
    }
}

/*
* Separated Appointments
* */
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

/*
* Header + Appointments
* */
val xmlComplex =
    XmlDsl.build {
        baseHeader()
        baseAppointments()
    }.xml()
```

```xml
<!-- baseHeader -->
<!-- but not invoked yet -->
<?xml version="1.0"?>

<!-- baseAppointments -->
<!-- but not invoked yet -->
<appointments token="1234567890">
    <appointment name="appointment0"/>
    <appointment name="appointment1"/>
    <appointment name="appointment2"/>
    <appointment name="appointment3"/>
</appointments>

<!-- xmlComplex -->
<?xml version="1.0"?>
<appointments token="1234567890">
    <appointment name="appointment0"/>
    <appointment name="appointment1"/>
    <appointment name="appointment2"/>
    <appointment name="appointment3"/>
</appointments>
```

[see in code](src/main/kotlin/samples/Separating.kt#L7)

## Author

Created by Andy Beardness