package dsl

/*
* ==================================
*           MAIN PROTOCOLS
* ==================================
* */

/**
 * XML DSL Protocol Main
 * */
interface XmlDslProtocol : XmlProtocol, XmlBuilderProtocol

/**
 * Tag Protocol Main
 * */
interface TagProtocol: XmlProtocol, TagContentProtocol, ContentProtocol

/**
 * Key-Value Protocol Main
 * */
interface KeyValueProtocol: XmlProtocol

/*
* ==================================
*         BASICS PROTOCOLS
* ==================================
* */

/**
 * XML to String Protocol
 * */
interface XmlProtocol {
    /**
     * Convert XML to String
     *
     * @return  String of current
     * */
    fun xml(): String
}

/**
 * Protocol for Content of opened XML tag
 * */
interface ContentProtocol {
    /**
     * Setup for XML DSL Builder
     * */
    fun content(builder: XmlDslProtocol.() -> Unit)
}

/**
 * Protocol for tag creating
 * */
interface XmlBuilderProtocol {
    /**
     * Create tag inside scope
     * */
    fun tag(builder: TagProtocol.() -> Unit)
}

/**
 * Protocol for basic tag content
 * */
interface TagContentProtocol {
    /**
     * true  -> if current XML tag should use header style
     * false -> if current XML tag is regular closed or opened tag
     * */
    var header: Boolean

    /**
     * Name of tag
     * */
    var name: String

    /**
     * Key-Value params of tag
     * */
    val params: MutableList<KeyValueProtocol>
}