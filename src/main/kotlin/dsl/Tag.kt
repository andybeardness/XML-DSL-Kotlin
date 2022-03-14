package dsl

import configurations.DslConfigurations

/**
 * Base tag implementation
 * */
class Tag : TagProtocol {
    /**
     * Flag - "Does tag is header?"
     * */
    override var header: Boolean = false

    /**
     * Name of tag
     * */
    override var name: String = ""

    /**
     * Params of tag
     * */
    override val params: MutableList<KeyValueProtocol> = mutableListOf()

    /**
     * Content of tag
     * */
    private val content: MutableList<String> = mutableListOf()

    /**
     * Setting content
     *
     * @param   builder     Lambda for setup content
     * */
    override fun content(builder: XmlDslProtocol.() -> Unit) = let { content += XmlDsl().apply(builder).xml() }

    /**
     * Creating String XML
     * */
    override fun xml(): String {
        val paramsCollected = params.joinToString(separator = " ") { param -> param.xml() }

        val isContentEmpty = content.isEmpty()
        if (isContentEmpty) {
            return if (header) {
                DslConfigurations.makeHeader(name, paramsCollected)
            } else {
                DslConfigurations.makeClosedTag(name, paramsCollected)
            }
        }

        val contentCollected = content.joinToString(separator = "")

        return DslConfigurations.makeOpenedTag(name, paramsCollected, contentCollected)
    }
}