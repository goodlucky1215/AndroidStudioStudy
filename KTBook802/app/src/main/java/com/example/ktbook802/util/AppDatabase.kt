package com.example.ktbook802.util

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ktbook802.dao.HistoryDao
import com.example.ktbook802.model.History


@Database(entities = [History::class], version=1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}