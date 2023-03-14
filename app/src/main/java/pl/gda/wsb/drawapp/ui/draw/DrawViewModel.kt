package pl.gda.wsb.drawapp.ui.draw

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import pl.gda.wsb.drawapp.UiEvents
import pl.gda.wsb.drawapp.models.Name

class DrawViewModel : ViewModel() {
    private val uiEvents = UiEvents<Event>()
    val events: Observable<Event> = uiEvents.stream()
    val counter = MutableLiveData(0)
    val elementName = MutableLiveData<String>()
    val list = MutableLiveData(
        mutableListOf(
            Name("1", 1),
            Name("2", 1),
            Name("3", 1),
            Name("4", 1)
        )
    )

    init{
        counter.postValue(list.value?.size)
    }


    fun addName() {
        Event.OnAddNameClick.let {uiEvents.post(it)}
        list.value?.add(Name(elementName.value.toString(), 1))
        counter.postValue(list.value?.size)
        if(counter.value?.rem(2) ==0){

        }
    }

    sealed class Event{
        object OnAddNameClick : Event()
    }
}