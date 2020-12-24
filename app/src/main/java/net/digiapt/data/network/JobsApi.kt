package net.digiapt.data.network

import net.digiapt.data.network.responses.JobResponse
import net.digiapt.data.network.responses.JobsListResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JobsApi {

    @GET("5e1db20c3600005a00c74337")
    suspend fun getJobs() : Response<JobsListResponse>

    @GET("5e206a40300000b4a4d1ef7c")
    suspend fun getJob() : Response<JobResponse>

    companion object{
        operator fun invoke() : JobsApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://www.mocky.io/v2/")
                .build()
                .create(JobsApi::class.java)
        }
    }
}
