package org.karrat.internal

import kotlin.reflect.KFunction
import kotlin.reflect.KFunction1
import kotlin.reflect.KProperty

internal fun <T, R> property(getter: KFunction<R>) =
    JavaPropertyDelegate<T, R>(getter)

internal fun <T, R> property(getter: KFunction<R>, setter: KFunction1<R, Unit>) =
    MutableJavaPropertyDelegate<T, R>(getter, setter)

internal class JavaPropertyDelegate<T, R>(
    private val getter: KFunction<R>
) {

    operator fun getValue(thisRef: T, property: KProperty<*>): R {
        return getter.call()
    }

}

internal class MutableJavaPropertyDelegate<T, R>(
    private val getter: KFunction<R>,
    private val setter: KFunction1<R, Unit>
) {

    operator fun getValue(thisRef: T, property: KProperty<*>): R {
        return getter.call()
    }

    operator fun setValue(thisRef: T, property: KProperty<*>, value: R) {
        setter.call(value)
    }

}