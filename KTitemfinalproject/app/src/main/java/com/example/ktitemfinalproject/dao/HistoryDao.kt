package com.example.ktitemfinalproject.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ktitemfinalproject.model.History

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history")
    fun getAll(): List<History>

    @Insert
    fun insertHistory(history: History)

    @Query("DELETE FROM history WHERE keyword == :keyword")
    fun deleteHistory(keyword: String)

}