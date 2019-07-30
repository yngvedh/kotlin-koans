package iv_properties

import util.TODO
import util.doc34
import kotlin.reflect.KProperty

class LazyPropertyUsingDelegates(initializer: () -> Int) {
    val lazyValue: Int by LazyProperty(initializer)
}

private operator fun LazyProperty.getValue(lazyPropertyUsingDelegates: LazyPropertyUsingDelegates, property: KProperty<*>): Int
        = this.lazy

private operator fun LazyProperty.setValue(lazyPropertyUsingDelegates: LazyPropertyUsingDelegates, property: KProperty<*>, value:Int) {
    this.lazy = value
}

fun todoTask34(): Lazy<Int> = TODO(
    """
        Task 34.
        Read about delegated properties and make the property lazy by using delegates.
    """,
    documentation = doc34()
)
