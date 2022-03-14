package dsl

interface XmlDslProtocol : XmlProtocol, XmlBuilderProtocol

interface TagProtocol: XmlProtocol, TagContentProtocol, ContentProtocol

interface KeyValueProtocol: XmlProtocol

interface XmlProtocol {
    fun xml(): String
}

interface ContentProtocol {
    fun content(builder: XmlDslProtocol.() -> Unit)
}

interface XmlBuilderProtocol {
    fun tag(builder: TagProtocol.() -> Unit)
}

interface TagContentProtocol {
    var header: Boolean
    var name: String
    val params: MutableList<KeyValueProtocol>
}