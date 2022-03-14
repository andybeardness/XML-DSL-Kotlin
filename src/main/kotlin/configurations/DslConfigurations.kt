package configurations

/**
 * Configuration for DSL
 *
 * Base implementation
 */
object DslConfigurations : DslConfigurationsProtocol {
    /*
     * Base placeholders
     * */
    override val namePlaceholder = "{%name%}"
    override val paramsPlaceholder = "{%params%}"
    override val contentPlaceholder = "{%content%}"

    /*
     * Base templates
     * */
    override var headerBracketsTemplate = "<?$namePlaceholder $paramsPlaceholder?>"
    override var closedTagBracketsTemplate = "<$namePlaceholder $paramsPlaceholder/>"
    override var openedTagBracketsTemplate = "<$namePlaceholder>$contentPlaceholder</$namePlaceholder>"

    /**
     * Base implementation for making tag as header style
     * */
    override fun makeHeader(name: String, params: String): String =
        headerBracketsTemplate
            .replace(
                oldValue = namePlaceholder,
                newValue = name,
            )
            .replace(
                oldValue = paramsPlaceholder,
                newValue = params
            )

    /**
     * Base implementation for making tag as closed style
     * */
    override fun makeClosedTag(name: String, params: String): String =
        closedTagBracketsTemplate
            .replace(
                oldValue = namePlaceholder,
                newValue = name,
            )
            .replace(
                oldValue = paramsPlaceholder,
                newValue = params
            )

    /**
     * Base implementation for making tag as opened style
     * */
    override fun makeOpenedTag(name: String, params: String, content: String): String =
        openedTagBracketsTemplate
            .replace(
                oldValue = namePlaceholder,
                newValue = name,
            )
            .replace(
                oldValue = paramsPlaceholder,
                newValue = params
            )
            .replace(
                oldValue = contentPlaceholder,
                newValue = content,
            )
}