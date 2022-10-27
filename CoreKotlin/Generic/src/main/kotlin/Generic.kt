/**
 * how to use generic `out`
 */
interface CollectionOut<out E> {
    fun addAll(items: CollectionOut<@UnsafeVariance E>)
}

fun copyAllOut(to: CollectionOut<CharSequence>, from: CollectionOut<String>) {
    to.addAll(from)
    // Collection<String> is a subtype of Collection<CharSequence> => out
}

/**
 * how to use generic `in`
 */
interface CollectionIn<in E> {
    fun addAll(items: CollectionIn<@UnsafeVariance E>)
}

fun copyAllIn(to: CollectionIn<String>, from: CollectionIn<CharSequence>) {
    to.addAll(from)
    // Collection<CharSequence> is a super of Collection<String> => in
}