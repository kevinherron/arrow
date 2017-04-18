/*
 * Copyright (C) 2017 The Katz Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package katz

interface Semigroup<A> : Typeclass {
    /**
     * Combine two [A] values.
     */
    fun combine(a: A, b: A): A

    /**
     * Combine an array of [A] values.
     */
    fun combineAll(vararg elems: A): A = combineAll(elems.asList())

    /**
     * Combine a collection of [A] values.
     */
    fun combineAll(elems: Collection<A>): A = elems.reduce { a, b -> combine(a, b) }
}

inline fun <reified A> semigroup(): Semigroup<A> =
        instance(InstanceParametrizedType(Semigroup::class.java, listOf(A::class.java)))