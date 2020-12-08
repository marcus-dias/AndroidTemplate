package com.view_models.country

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ui_model.country.UiCountry
import com.ui_model.country.toUi
import com.use_cases.country.GetCountriesUseCase
import com.view_models.extensions.executeUseCase

class ListCountriesViewModel @ViewModelInject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
) : com.view_models.base.BaseViewModel() {
    private var _countryListLiveData = MutableLiveData<List<UiCountry>>()
    val countryListLiveData: LiveData<List<UiCountry>> = _countryListLiveData
    fun loadAllCountries() {
        showLoading()
        executeUseCase(getCountriesUseCase::invoke) {
            _countryListLiveData.postValue(it.toUi())
        }
    }
}