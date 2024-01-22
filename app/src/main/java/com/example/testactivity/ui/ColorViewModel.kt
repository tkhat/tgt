package com.example.testactivity.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testactivity.data.RemoteDataSource
import com.example.testactivity.data.model.CardDataItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ColorViewModel @Inject constructor(
    val remoteDataSource: RemoteDataSource
) : ViewModel() {

    private val _colorsLiveData = MutableLiveData<List<CardDataItem>>()
    val colorsLiveData: LiveData<List<CardDataItem>> get() = _colorsLiveData

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = remoteDataSource.getColors()
                _colorsLiveData.postValue(data.body())
            }
        }
    }
}