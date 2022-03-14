package configurations

/**
 * TODO
 * */
interface DslConfigurationsProtocol {

    /*
     * TODO
     * */
    val namePlaceholder: String
    val paramsPlaceholder: String
    val contentPlaceholder: String

    /*
     * TODO
     * */
    var headerBracketsTemplate: String
    var closedTagBracketsTemplate: String
    var openedTagBracketsTemplate: String

    /**
     * TODO
     * */
    fun makeHeader(name: String, params: String): String

    /**
     * TODO
     * */
    fun makeClosedTag(name: String, params: String): String

    /**
     * TODO
     * */
    fun makeOpenedTag(name: String, params: String, content: String): String
}