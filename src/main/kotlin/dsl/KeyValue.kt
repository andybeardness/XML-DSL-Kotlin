package dsl

/**
 * TODO
 * */
data class KeyValue(
    val key: String,
    val value: String,
) : KeyValueProtocol {

    /**
     * TODO
     * */
    override fun xml(): String = "$key=\"$value\""
}