package configurations

/**
 * Configuration for DSL
 *
 * Base implementation
 */
object DslConfigurations : DslConfigurationsProtocol, ResetStateProtocol {
    /*
     * Base placeholders
     * */
    override val namePlaceholder = "{%name%}"
    override val paramsPlaceholder = "{%params%}"
    override val contentPlaceholder = "{%content%}"

    /*
     * Default templates
     * */
    private val headerBracketsTemplateDefault = "<?$namePlaceholder $paramsPlaceholder?>"
    private val closedTagBracketsTemplateDefault = "<$namePlaceholder $paramsPlaceholder/>"
    private val openedTagBracketsTemplateDefault = "<$namePlaceholder $paramsPlaceholder>$contentPlaceholder</$namePlaceholder>"

    /*
     * Base templates
     * */
    override var headerBracketsTemplate = headerBracketsTemplateDefault
    override var closedTagBracketsTemplate = closedTagBracketsTemplateDefault
    override var openedTagBracketsTemplate = openedTagBracketsTemplateDefault

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

    /**
     * Reset state of singleton
     */
    override fun resetState() {
        headerBracketsTemplate = headerBracketsTemplateDefault
        closedTagBracketsTemplate = closedTagBracketsTemplateDefault
        openedTagBracketsTemplate = openedTagBracketsTemplateDefault
    }
}