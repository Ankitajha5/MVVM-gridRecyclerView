package eu.tutorials.assignment_task1

import eu.tutorials.assignment_task1.model.ApiData
import retrofit2.Call
import eu.tutorials.assignment_task1.model.Shopping
import retrofit2.http.GET



interface ApiInterface {
    @GET("/v1/characters")
    fun getData(): Call<ApiData>
}