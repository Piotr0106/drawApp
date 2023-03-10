package pl.gda.wsb.drawapp

import android.media.MediaPlayer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import pl.gda.wsb.drawapp.models.Name

class DrawViewModel : ViewModel() {
    private val uiEvents = UiEvents<Event>()
    val events: Observable<Event> = uiEvents.stream()

    val elementName = MutableLiveData<String>()
    val list = MutableLiveData(
        mutableListOf(
            Name("Bayern", 1),
            Name("Milan", 1),
            Name("Chelsea", 1),
            Name("Benfica", 1)
        )
    )

    fun addName() {
        Event.OnAddNameClick.let {uiEvents.post(it)}
        list.value?.add(Name(elementName.value.toString(), 1))

    }

    sealed class Event{
        object OnAddNameClick : Event()
    }
}