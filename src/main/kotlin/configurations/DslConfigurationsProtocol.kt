package configurations

/**
 * Protocol for DSL Configurations
 *
 * User can change settings to change tag's styles
 *
 * Example :
 *      DslConfigurations.headerBracketsTemplate =
 *          "[DslConfigurations.namePlaceholder|DslConfigurations.paramsPlaceholder]"
 *
 * Then header will collect like :
 *      [name|key1=value1 key2=value2 key3=value3]
 * Instead of :
 *      <?name key1=value1 key2=value2 key3=value3?>
 * */
interface DslConfigurationsProtocol {

    /*
     * Placeholders constants for replacing
     * */
    val namePlaceholder: String
    val paramsPlaceholder: String
    val contentPlaceholder: String

    /*
     * Templates with placeholders
     *
     * User able to change their implementations
     * */
    var headerBracketsTemplate: String
    var closedTagBracketsTemplate: String
    var openedTagBracketsTemplate: String

    /**
     * Protocol for making tag as header style
     *
     * @param    name    Name of tag
     * @param    params  Key-values params of tag
     * @return           Header tag as String
     * */
    fun makeHeader(name: String, params: String): String

    /**
     * Protocol for making tag as closed style
     *
     * @param   name    Name of tag
     * @param   params  Key-values params of tag
     * @return          Closed tag as String
     * */
    fun makeClosedTag(name: String, params: String): String

    /**
     * Protocol for making tag as closed style
     *
     * @param   name    Name of tag
     * @param   params  Key-values params of tag
     * @param   content Content of opened tag, that includes inner tags
     * @return          Opened tag as String
     * */
    fun makeOpenedTag(name: String, params: String, content: String): String
}

/**
 * Protocol for reset states
 */
interface ResetStateProtocol {
    fun resetState()
}