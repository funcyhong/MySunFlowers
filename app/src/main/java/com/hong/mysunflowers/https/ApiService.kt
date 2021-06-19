package com.hong.mysunflowers.https

import com.hong.mysunflowers.base.BasePagingResp
import com.hong.mysunflowers.base.BaseRepository
import com.hong.mysunflowers.base.BaseResponse
import com.hong.mysunflowers.bean.*
import com.hong.mysunflowers.entitys.AnswersEntity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiService {

    /**
     * 注册
     */
    @POST("user/register")
    @FormUrlEncoded
    suspend fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String,
    ): BaseResponse<LoginRegisterBean>

    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String,
    ): BaseResponse<LoginRegisterBean>

    /**
     * 获取体系列表数据
     */
    @GET("tree/json")
    suspend fun getBodySystemList(): BaseResponse<List<SystemResponse>>

    /**
     * 获取问答列表数据
     */
    @GET("article/list/{page}/json")
    suspend fun getAnswersList(
        @Path("page") page: Int
    ): BaseResponse<BasePagingResp<List<PageBean>>>


    companion object {
        private const val BASE_URL = "https://www.wanandroid.com/"

        fun create(): ApiService {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
                println(level)
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}