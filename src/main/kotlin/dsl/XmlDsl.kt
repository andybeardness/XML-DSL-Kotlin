package dsl

class XmlDsl: XmlDslProtocol {
    private val tags = mutableListOf<Tag>()

    companion object {
        fun build(builder: XmlDslProtocol.() -> Unit): XmlDsl = XmlDsl().apply(builder)
    }

    override fun xml(): String = tags.joinToString(separator = "") { tag -> tag.xml() }

    override fun tag(builder: TagProtocol.() -> Unit) = let { tags += Tag().apply(builder) }
}