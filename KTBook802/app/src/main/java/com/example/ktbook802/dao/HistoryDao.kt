package com.example.ktbook802.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ktbook802.model.History

@Dao
interface HistoryDao {
    //조건 검색 이력 전체를 가져오는 함수
    @Query("SELECT * FROM history")
    fun getAll():List<History>
    //검색시 키워드 등록
    @Insert
    fun insertHistory(history: History)
    //검색이력에서 X버튼 클릭시 삭제처리
    @Query("DELETE FROM history WHERE keyword == :keyword")
    fun delete(keyword: String)
}