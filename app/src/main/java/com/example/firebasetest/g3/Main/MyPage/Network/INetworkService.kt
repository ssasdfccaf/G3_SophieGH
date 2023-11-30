package com.example.androidscaffolding.ui.Main.MyPage.Network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface INetworkService {
    // https://newsapi.org/v2/everything?q=Apple&from=2023-10-10&sortBy=popularity&apiKey=87af28a1123a4fcc9c869c0b81bd243c
    // baseurl :https://newsapi.org
    // 주소 기본값에 이어서 뒤에 추가 주소 설정. -> v2/everything
    // 쿼리 설정으로 파라미터값 설정.  ->?q=Apple&from=2023-10-10&sortBy=popularity&apiKey=87af28a1123a4fcc9c869c0b81bd243c

    //http://apis.data.go.kr/6260000/WalkingService/getWalkingKr?serviceKey=인증키&numOfRows=10&pageNo=1
    //예시
    //https://apis.data.go.kr/6260000/WalkingService/getWalkingKr?serviceKey=ALRX9GpugtvHxcIO%2FiPg1vXIQKi0E6Kk1ns4imt8BLTgdvSlH%2FAKv%2BA1GcGUQgzuzqM3Uv1ZGgpG5erOTDcYRQ%3D%3D&pageNo=1&numOfRows=100&resultType=json
    @GET("board/boardsList")
    fun getList2(

    ): retrofit2.Call<List<Boards>>

    //board/boardsWrite
    @POST("board/boardsWrite")
    fun writeBoards(
        @Body boards: Boards
    ) : retrofit2.Call<Unit>

}