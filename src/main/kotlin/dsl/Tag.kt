package dsl

import configurations.DslConfigurations

/**
 * TODO
 * */
class Tag : TagProtocol {
    /**
     * TODO
     * */
    override var header: Boolean = false

    /**
     * TODO
     * */
    override var name: String = ""

    /**
     * TODO
     * */
    override val params: MutableList<KeyValueProtocol> = mutableListOf()

    /**
     * TODO
     * */
    private val content: MutableList<String> = mutableListOf()

    /**
     * TODO
     * */
    override fun content(builder: XmlDslProtocol.() -> Unit) = let { content += XmlDsl().apply(builder).xml() }

    /**
     * TODO
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