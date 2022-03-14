package dsl

/**
 * Base XML DSL Builder
 * */
class XmlDsl: XmlDslProtocol {
    /**
     * Container for tags
     * */
    private val tags = mutableListOf<Tag>()

    companion object {
        /**
         * Start point to build XML by DSL
         *
         * @param   builder     Lambda for setup
         * */
        fun build(builder: XmlDslProtocol.() -> Unit): XmlDsl = XmlDsl().apply(builder)
    }

    /**
     * Creating String XML
     * */
    override fun xml(): String = tags.joinToString(separator = "") { tag -> tag.xml() }

    /**
     * Collect tag to tags
     * */
    override fun tag(builder: TagProtocol.() -> Unit) = let { tags += Tag().apply(builder) }
}