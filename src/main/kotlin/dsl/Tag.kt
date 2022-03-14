package dsl

import configurations.DslConfigurations

class Tag : TagProtocol {
    override var header: Boolean = false
    override var name: String = ""
    override val params: MutableList<KeyValueProtocol> = mutableListOf()

    private val content: MutableList<String> = mutableListOf()

    override fun content(builder: XmlDslProtocol.() -> Unit) = let { content += XmlDsl().apply(builder).xml() }

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