package com.potados.newthings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    private val _dummyItems = MutableLiveData<List<Dummy.DummyItem>>().apply { value = emptyList() }
    val dummyItems: LiveData<List<Dummy.DummyItem>> = _dummyItems

    init {
        refreshDummies()
    }

    fun refreshDummies() {
        _dummyItems.value = Dummy.newDummyItems()
    }
}
