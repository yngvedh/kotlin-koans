package v_builders

import util.TODO
import javax.swing.UIManager.put

fun buildStringExample(): String {
    fun buildString(build: StringBuilder.() -> Unit): String {
        val stringBuilder = StringBuilder()
        stringBuilder.build()
        return stringBuilder.toString()
    }

    return buildString {
        this.append("Numbers: ")
        for (i in 1..10) {
            // 'this' can be omitted
            append(i)
        }
    }
}

class MapBuilder<K,V> {
    val map = LinkedHashMap<K,V>()

    fun put(key:K, value:V) = map.put(key, value)
}

fun <K,V> buildMap(build:MapBuilder<K,V>.() -> Unit): Map<K,V> {
    val builder = MapBuilder<K,V>()
    build(builder)
    return builder.map
}

fun task37(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
