package com.eward.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eward.model.UserList
import com.eward.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _userList = MutableLiveData<UserList>()
    var userList: LiveData<UserList> = _userList


    init {
        try {
            getEmployees()
        } catch (e: Exception) {
            Log.i("Error", "Something error")
        }
    }

    fun getEmployees() = viewModelScope.launch {
        mainRepository.getEmployee().let {
            it.body().let { userList ->
                _userList.postValue(userList!!)
            }
        }
    }


}