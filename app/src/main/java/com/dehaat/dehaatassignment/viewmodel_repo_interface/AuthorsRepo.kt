package com.dehaat.dehaatassignment.viewmodel_repo_interface

import androidx.lifecycle.MutableLiveData
import com.dehaat.dehaatassignment.data.AuthorsData
import com.dehaat.dehaatassignment.data.Resource
import com.dehaat.dehaatassignment.rest.AppRestClient
import retrofit2.Callback
import retrofit2.Response

class AuthorsRepo {

    var authorsData : MutableLiveData<Resource<AuthorsData.Data?>>?

    init {
        authorsData=MutableLiveData()
    }

    fun getAuthors()
    {
        authorsData?.value=Resource.loading()
        var apiInterface=AppRestClient.getInstance().getAppRestClientService("https://673941ce-1e8f-4a94-ae11-7f490105f07f.mock.pstmn.io/getAuthors/");

        var call=apiInterface.listOfAuthors

        call.enqueue(object:Callback<AuthorsData.Data>{

            override fun onFailure(call: retrofit2.Call<AuthorsData.Data>, t: Throwable) {
                var a=1;
            }

            override fun onResponse(call: retrofit2.Call<AuthorsData.Data>, response: Response<AuthorsData.Data>) {
                var response=response.body()

                authorsData?.value=Resource.success(response)

            }
        })

    }




}