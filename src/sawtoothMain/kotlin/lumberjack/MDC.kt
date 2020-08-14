/*
 * This file is part of Lumberjack.
 *
 * Lumberjack is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Lumberjack is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Lumberjack.  If not, see <https://www.gnu.org/licenses/>.
 */
package lumberjack

import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

actual class MDC actual constructor(

    private val context: Context
) : AbstractCoroutineContextElement(MDC),
    CoroutineContext.Element,
    Context by context {

    override fun toString(): String = context.toString()

    override fun equals(other: Any?): Boolean {
        return (other as? MDC)?.context == context
    }

    override fun hashCode(): Int = context.hashCode()

    actual companion object Key : CoroutineContext.Key<MDC> {

        actual val EMPTY: MDC = MDC(emptyMap())
    }
}
