package dsl

data class KeyValue(
    val key: String,
    val value: String,
) : KeyValueProtocol {
    override fun xml(): String = "$key=\"$value\""
}