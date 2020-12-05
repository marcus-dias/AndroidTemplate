package com.template.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.base_ui.model.Loading
import com.base_ui.model.UIState
import com.base_ui.model.country.UiCountry
import com.use_cases.country.GetCountriesUseCase

class MainViewModel @ViewModelInject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
) : ViewModel() {
    private var _liveData = MutableLiveData<UIState<List<UiCountry>>>()
    val liveData: LiveData<UIState<List<UiCountry>>> = _liveData
    fun loadAllCountries() {
        _liveData.postValue(Loading())
        // viewModelScope.launch {
        // }
    }
}