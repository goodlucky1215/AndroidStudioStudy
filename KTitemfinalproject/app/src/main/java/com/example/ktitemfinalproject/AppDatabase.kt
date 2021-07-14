package com.example.ktitemfinalproject

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ktitemfinalproject.dao.HistoryDao
import com.example.ktitemfinalproject.model.History

@Database(entities = [History::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}