package configurations

/**
 * TODO
 */
object DslConfigurations: DslConfigurationsProtocol {
   /*
    * TODO
    * */
    override val namePlaceholder = "{%name%}"
    override val paramsPlaceholder = "{%params%}"
    override val contentPlaceholder = "{%content%}"

   /*
    * TODO
    * */
    override var headerBracketsTemplate = "<?$namePlaceholder $paramsPlaceholder?>"
    override var closedTagBracketsTemplate = "<$namePlaceholder $paramsPlaceholder/>"
    override var openedTagBracketsTemplate = "<$namePlaceholder>$contentPlaceholder</$namePlaceholder>"

   /**
    * TODO
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
     * TODO
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
     * TODO
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