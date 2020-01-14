import Option.*

sealed class Stream<out A> {
    companion object {
        //smart constructors
    }

    data class Cons<out A>(val h: () -> A, val t: () -> Stream<A>) : Stream<A>()
    object Empty : Stream<Nothing>()

    fun <A> Stream<A>.headOption(): Option<A> =
        when (this) {
            is Empty -> None
            is Cons -> Some(h())
        }
}

