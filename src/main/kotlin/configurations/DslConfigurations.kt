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
    override val spaceForParamsPlaceholder = "{%spaceforparams%}"

    /*
     * Default templates
     * */
    private val headerBracketsTemplateDefault = "<?$namePlaceholder$spaceForParamsPlaceholder$paramsPlaceholder?>"
    private val closedTagBracketsTemplateDefault = "<$namePlaceholder$spaceForParamsPlaceholder$paramsPlaceholder/>"
    private val openedTagBracketsTemplateDefault = "<$namePlaceholder$spaceForParamsPlaceholder$paramsPlaceholder>$contentPlaceholder</$namePlaceholder>"
    private val spaceForParamsTemplateDefault = " "

    /*
     * Base templates
     * */
    override var headerBracketsTemplate = headerBracketsTemplateDefault
    override var closedTagBracketsTemplate = closedTagBracketsTemplateDefault
    override var openedTagBracketsTemplate = openedTagBracketsTemplateDefault
    override var spaceForParamsTemplate = spaceForParamsTemplateDefault

    /**
     * Base implementation for making tag as header style
     * */
    override fun makeHeader(name: String, params: String): String =
        headerBracketsTemplate
            .updateName(name)
            .updateParams(params)


    /**
     * Base implementation for making tag as closed style
     * */
    override fun makeClosedTag(name: String, params: String): String =
        closedTagBracketsTemplate
            .updateName(name)
            .updateParams(params)

    /**
     * Base implementation for making tag as opened style
     * */
    override fun makeOpenedTag(name: String, params: String, content: String): String =
        openedTagBracketsTemplate
            .updateName(name)
            .updateParams(params)
            .updateContent(content)

    /**
     * Reset state of singleton
     */
    override fun resetState() {
        headerBracketsTemplate = headerBracketsTemplateDefault
        closedTagBracketsTemplate = closedTagBracketsTemplateDefault
        openedTagBracketsTemplate = openedTagBracketsTemplateDefault
        spaceForParamsTemplate = spaceForParamsTemplateDefault
    }

    /**
     * Updating name
     */
    private fun String.updateName(name: String): String =
        replace(
            oldValue = namePlaceholder,
            newValue = name,
        )

    /**
     * Updating params
     */
    private fun String.updateParams(params: String): String =
        if (params.isNotEmpty()) {
            replace(
                oldValue = spaceForParamsPlaceholder,
                newValue = spaceForParamsTemplate,
            ).replace(
                oldValue = paramsPlaceholder,
                newValue = params,
            )
        } else {
            replace(
                oldValue = spaceForParamsPlaceholder,
                newValue = "",
            ).replace(
                oldValue = paramsPlaceholder,
                newValue = params,
            )
        }

    /**
     * Updating content
     */
    private fun String.updateContent(content: String): String =
        replace(
            oldValue = contentPlaceholder,
            newValue = content,
        )
}