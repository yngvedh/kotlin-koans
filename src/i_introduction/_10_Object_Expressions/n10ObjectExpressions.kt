package i_introduction._10_Object_Expressions

import util.TODO
import util.doc10
import java.util.*
import kotlin.Comparator

fun todoTask10(): Comparator<Int> = Comparator {
    a: Int, b: Int -> b - a
}

fun task10(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, todoTask10())
    return arrayList
}