// "Create parameter '-'" "false"
// ACTION: Create extension function 'A.minus'
// ACTION: Create member function 'minus'
// ACTION: Replace overloaded operator with function call
// ERROR: Unresolved reference. None of the following candidates is applicable because of receiver type mismatch: <br>@InlineOnly public operator inline fun BigDecimal.minus(other: BigDecimal): BigDecimal defined in kotlin<br>@InlineOnly public operator inline fun BigInteger.minus(other: BigInteger): BigInteger defined in kotlin<br>public operator fun <T> Iterable<???>.minus(elements: Array<out ???>): List<???> defined in kotlin.collections<br>public operator fun <T> Iterable<???>.minus(elements: Iterable<???>): List<???> defined in kotlin.collections<br>public operator fun <T> Iterable<???>.minus(elements: Sequence<???>): List<???> defined in kotlin.collections<br>public operator fun <T> Iterable<A>.minus(element: A): List<A> defined in kotlin.collections<br>public operator fun <T> Set<???>.minus(elements: Array<out ???>): Set<???> defined in kotlin.collections<br>public operator fun <T> Set<???>.minus(elements: Iterable<???>): Set<???> defined in kotlin.collections<br>public operator fun <T> Set<???>.minus(elements: Sequence<???>): Set<???> defined in kotlin.collections<br>public operator fun <T> Set<A>.minus(element: A): Set<A> defined in kotlin.collections<br>public operator fun <T> Sequence<???>.minus(elements: Array<out ???>): Sequence<???> defined in kotlin.sequences<br>public operator fun <T> Sequence<???>.minus(elements: Iterable<???>): Sequence<???> defined in kotlin.sequences<br>public operator fun <T> Sequence<???>.minus(elements: Sequence<???>): Sequence<???> defined in kotlin.sequences<br>public operator fun <T> Sequence<A>.minus(element: A): Sequence<A> defined in kotlin.sequences
class A

fun bar() {
    val a = A()
    return a <caret>- a
}