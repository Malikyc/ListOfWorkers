package com.example.listofworkers.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.listofworkers.pojo.Worker
import retrofit2.http.GET


@Dao
interface DatabaseDao {
    @Query("SELECT * FROM worker_info_list ORDER BY id")
    fun getWorkerList() : LiveData<List<Worker>>

    @Query("SELECT * FROM worker_info_list WHERE id == :indexOx")
    fun getParticularWorker(indexOx:Int) : LiveData<Worker>

    @Query("DELETE FROM worker_info_list")
    fun deleteAllWorkers()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWorkers(lisOfWorkers : List<Worker>)

}