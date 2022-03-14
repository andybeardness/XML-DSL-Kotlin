package dsl

/**
 * TODO
 * */
class XmlDsl: XmlDslProtocol {
    /**
     * TODO
     * */
    private val tags = mutableListOf<Tag>()

    companion object {
        /**
         * TODO
         * */
        fun build(builder: XmlDslProtocol.() -> Unit): XmlDsl = XmlDsl().apply(builder)
    }

    /**
     * TODO
     * */
    override fun xml(): String = tags.joinToString(separator = "") { tag -> tag.xml() }

    /**
     * TODO
     * */
    override fun tag(builder: TagProtocol.() -> Unit) = let { tags += Tag().apply(builder) }
}