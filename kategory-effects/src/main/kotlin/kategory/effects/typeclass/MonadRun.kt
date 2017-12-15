package kategory.effects

import kategory.Either
import kategory.HK
import kategory.MonadError
import kategory.Typeclass

interface MonadRun<F, E> : MonadError<F, E>, Typeclass {
    fun <A> unsafeRunSync(fa: HK<F, A>): A

    fun <A> runAsync(fa: HK<F, A>, cb: (Either<E, A>) -> HK<F, Unit>): HK<F, Unit>

    fun <A> unsafeRunAsync(fa: HK<F, A>, cb: (Either<E, A>) -> Unit): Unit
}