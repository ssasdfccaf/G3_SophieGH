package com.example.firebasetest.g3.Project

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidscaffolding.ui.Main.MyPage.Network.Boards
import com.example.androidscaffolding.ui.Main.MyPage.Network.MyApplication
import com.example.firebasetest.g3.databinding.FragmentBBSBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BBSFragment : BottomSheetDialogFragment() {

    lateinit var binding : FragmentBBSBinding
//    private var bottomSheetBinding: FragmentBBSBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBSBinding.inflate(layoutInflater, container, false)

// 1차로, 토스트, 로그캣 다 찍고,
        binding.sendBoardBtn.setOnClickListener {
            val title = binding.boardTitle.text
            val category = binding.boardCategory.text
// 1차로, 토스트, 로그캣 다 찍고,
            Log.d("lsy","title : ${title}, category : ${category}")
            Toast.makeText(context,"title : ${title}, category : ${category}",Toast.LENGTH_SHORT).show()
            // 2차, 백에 보내기. 쓰기 작업.
            val networkService = (context?.applicationContext as MyApplication).networkService

            var boards = Boards()
            boards.user_id = title.toString()
            Log.d("lsy","title.toString() : ${title.toString()}")
            val boardsWriteCall: Call<Unit> = networkService.writeBoards(boards)

            //변경3
            // 실제 통신이 시작이 되는 부분, 이 함수를 통해서 데이터를 받아옴.
            boardsWriteCall.enqueue(object : Callback<Unit> {
                //익명 클래스가, Callback , 레트로핏2에서 제공하는 인터페이스를 구현했고,
                // 반드시 재정의해야하는 함수들이 있음.
                // 변경4
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    // 데이터를 성공적으로 받았을 때 수행되는 함수
//                    val shopMainList = response.body()
//
//                    // 변경8
//                    Log.d("lsy","데이터 받기 성공=========================================================================")
//                    Log.d("lsy","shopMainList 값 : ${shopMainList?.items?.content}")
//                    Log.d("lsy","shopMainList 값 : ${shopMainList?.items?.content?.get(0)?.itemNm}")
//
//
//                    // 데이터를 성공적으로 받았다면, 여기서 리사이클러 뷰 어댑터에 연결하면 됨.
//                    // 리사이클러뷰 의 레이아웃 정하는 부분, 기본인 LinearLayoutManager 이용했고,
//
//                    // 기본 값으로 세로 방향 출력.
////        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//                    // 가로 방향으로 출력 해보기.
////                layoutManager = LinearLayoutManager(this@PagingTestActivity)
//                    recycler.layoutManager = layoutManager
////        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
//                    shopMainList?.items?.content?.let { datasSpring.addAll(it) }
////             recycler.adapter = shopMainList?.items?.content?.let { PagingRecyclerAdapter(it) }
//
//                    Log.d("lsy","최초 어댑터 추가하기 전 datasSpring.size  =========================================  : ${datasSpring.size}")
//                    recycler.adapter = PagingRecyclerAdapter(datasSpring)
//                    Log.d("lsy","최초 어댑터 추가하기 후 datasSpring.size  =========================================  : ${datasSpring.size}")
//
//
//                    // 구분선 넣기, 나중에 옵션으로 배경이미지도 넣기 가능.
//                    recycler.addItemDecoration(
//                        DividerItemDecoration(this@PagingTestActivity,
//                            LinearLayoutManager.VERTICAL)
//                    )

                }

                //변경5
                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    Log.d("lsy"," 통신실패")
                    // 데이터를 못 받았을 때 수행되는 함수
                    call.cancel()
                }

            })

        }

        return binding.root

    }


}