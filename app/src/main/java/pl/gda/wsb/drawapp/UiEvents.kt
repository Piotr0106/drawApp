package pl.gda.wsb.drawapp

import androidx.annotation.MainThread
import androidx.annotation.UiThread
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject

class UiEvents<T : Any> {
    private val internalEvents = PublishSubject.create<T>()

    @MainThread
    @UiThread
    fun post(event: T) = internalEvents.onNext(event)

    fun stream(): Observable<T> = internalEvents.hide()
}