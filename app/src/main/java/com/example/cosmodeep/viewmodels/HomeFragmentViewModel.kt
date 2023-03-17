package com.example.cosmodeep.viewmodels

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cosmodeep.api.NetworkResult
import com.example.cosmodeep.models.FeedModel
import com.example.cosmodeep.repositories.HomeRepository
import com.example.cosmodeep.utils.Coroutines
import com.example.cosmodeep.utils.InternetConnectionCheck
import java.util.*


class HomeFragmentViewModel(val homeRepository: HomeRepository) : ViewModel() {

    var homeFeeds: MutableLiveData<NetworkResult<FeedModel>> = MutableLiveData()

    var startDate = MutableLiveData<String>()
    var endDate = MutableLiveData<String>()

    fun onStartDateClicked(view: View) {
        // Get Current Date
        // Get Current Date
        val c: Calendar = Calendar.getInstance()
        val mYear = c.get(Calendar.YEAR)
        val mMonth = c.get(Calendar.MONTH)
        val mDay = c.get(Calendar.DAY_OF_MONTH)


        val datePickerDialog = DatePickerDialog(
            view.context,
            { view, year, monthOfYear, dayOfMonth ->
                startDate.value =
                    (year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth.toString())
            },
            mYear,
            mMonth,
            mDay
        )
        datePickerDialog.show()
    }

    fun onEndDateClicked(view: View) {
        // Get Current Date
        // Get Current Date
        val c: Calendar = Calendar.getInstance()
        val mYear = c.get(Calendar.YEAR)
        val mMonth = c.get(Calendar.MONTH)
        val mDay = c.get(Calendar.DAY_OF_MONTH)


        val datePickerDialog = DatePickerDialog(
            view.context,
            { view, year, monthOfYear, dayOfMonth ->
                endDate.value =
                    (year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth.toString())
            },
            mYear,
            mMonth,
            mDay
        )
        datePickerDialog.show()
    }

    fun getFeeds(view: View, start_date: String, end_date: String) {
        if (InternetConnectionCheck.isOnline(view.context)) {
            Coroutines.main {
                homeFeeds.value = NetworkResult.Loading()
                val feeds = homeRepository.getFeeds(start_date = start_date, end_date = end_date)

                if (feeds.isSuccessful) {
                    homeFeeds.value = NetworkResult.Success(feeds.body()!!)
                } else {
                    homeFeeds.value = NetworkResult.Error(" Error Code : ${feeds.code()}")
                }
            }
        } else {
            NetworkResult.Error("Make sure you have connected to the network !", null)
        }
    }

}