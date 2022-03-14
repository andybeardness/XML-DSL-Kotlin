package extensions

import dsl.KeyValue
import dsl.KeyValueProtocol

/**
 * TODO
 * */
infix fun Any.eq(value: Any): KeyValueProtocol =
    KeyValue(
        key = this.toString(),
        value = value.toString(),
    )