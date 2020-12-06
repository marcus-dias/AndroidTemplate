package com.view_models.country

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ui_model.mappers.country.toUi
import com.ui_model.model.country.UiCountry
import com.use_cases.country.GetCountriesUseCase
import com.view_models.extensions.executeUseCase

class ListCountriesViewModel @ViewModelInject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
) : com.view_models.base.BaseViewModel() {
    private var _liveData = MutableLiveData<List<UiCountry>>()
    val liveData: LiveData<List<UiCountry>> = _liveData
    fun loadAllCountries() {
        showLoading()
        executeUseCase(getCountriesUseCase::invoke) {
            _liveData.postValue(it.toUi())
        }
    }
}