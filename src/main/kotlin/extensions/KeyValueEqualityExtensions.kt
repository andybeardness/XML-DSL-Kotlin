package extensions

import dsl.KeyValue
import dsl.KeyValueProtocol

/**
 * Extension for creating KeyValue object
 *
 * Example :
 *      "version" eq "1.0"
 * Transforms to :
 *      version="1.0"
 * ... in base implementation
 *
 * @return      object with key and value of xml-parameter
 * @see         KeyValue
 * */
infix fun Any.eq(value: Any): KeyValueProtocol =
    KeyValue(
        key = this.toString(),
        value = value.toString(),
    )