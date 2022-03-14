package dsl

/**
 * TODO
 * */
interface XmlDslProtocol : XmlProtocol, XmlBuilderProtocol

/**
 * TODO
 * */
interface TagProtocol: XmlProtocol, TagContentProtocol, ContentProtocol

/**
 * TODO
 * */
interface KeyValueProtocol: XmlProtocol

/**
 * TODO
 * */
interface XmlProtocol {
    /**
     * TODO
     * */
    fun xml(): String
}

/**
 * TODO
 * */
interface ContentProtocol {
    /**
     * TODO
     * */
    fun content(builder: XmlDslProtocol.() -> Unit)
}

/**
 * TODO
 * */
interface XmlBuilderProtocol {
    /**
     * TODO
     * */
    fun tag(builder: TagProtocol.() -> Unit)
}

/**
 * TODO
 * */
interface TagContentProtocol {
    /**
     * TODO
     * */
    var header: Boolean

    /**
     * TODO
     * */
    var name: String

    /**
     * TODO
     * */
    val params: MutableList<KeyValueProtocol>
}