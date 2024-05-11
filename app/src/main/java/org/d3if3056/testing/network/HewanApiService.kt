package org.d3if3056.testing.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3056.testing.model.Hewan
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.thecatapi.com/" + "v1/images/"
private const val BASE1_URL = "https://cdn2.thecatapi.com/images/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface HewanApiService {
    @GET("search?limit=10")
    suspend fun getHewan(): List<Hewan>
}

object HewanApi {
    val service: HewanApiService by lazy {
        retrofit.create(HewanApiService::class.java)
    }

    fun getHewanUrl(imageId: String): String{
        return "$BASE1_URL$imageId.jpg"
    }
}