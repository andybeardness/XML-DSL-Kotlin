package dsl

/**
 * DTO for Key-Value
 *
 * Using at params of XML tag
 * */
data class KeyValue(
    val key: String,
    val value: String,
) : KeyValueProtocol {

    /**
     * Creating String XML
     * */
    override fun xml(): String = "$key=\"$value\""
}