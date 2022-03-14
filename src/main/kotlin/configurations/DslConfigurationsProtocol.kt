package configurations

interface DslConfigurationsProtocol {
    val namePlaceholder: String
    val paramsPlaceholder: String
    val contentPlaceholder: String

    var headerBracketsTemplate: String
    var closedTagBracketsTemplate: String
    var openedTagBracketsTemplate: String

    fun makeHeader(name: String, params: String): String
    fun makeClosedTag(name: String, params: String): String
    fun makeOpenedTag(name: String, params: String, content: String): String
}