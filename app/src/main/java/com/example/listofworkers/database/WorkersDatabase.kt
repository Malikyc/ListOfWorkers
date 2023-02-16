package com.example.listofworkers.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.listofworkers.pojo.Worker


@Database(entities = [Worker::class], version = 3, exportSchema = false)
abstract class WorkersDatabase() : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "workers_database"
        private var database : WorkersDatabase? = null

        fun getInstance(context: Context): WorkersDatabase {
            database?.let { return it }
            val instance =
                Room.databaseBuilder(context, WorkersDatabase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
            return instance
        }
    }
    abstract fun dataBaseDao() : DatabaseDao
}