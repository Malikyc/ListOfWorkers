package com.example.listofworkers.database

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.listofworkers.api.ApiFactory
import com.example.listofworkers.pojo.Worker
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class WorkerViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()
    val database = WorkersDatabase.getInstance(application)
    var listOfWorkers = database.dataBaseDao().getWorkerList()

    fun getParticularWorker(id:Int):LiveData<Worker>{
        return database.dataBaseDao().getParticularWorker(id)
    }



     fun loadData(){
        val disposable= ApiFactory.apiService.getListOfWorkers()
            .subscribeOn(Schedulers.io())
            .map { it.response }
            .subscribe({
                database.dataBaseDao().deleteAllWorkers()
                database.dataBaseDao().insertWorkers(it)
                listOfWorkers = database.dataBaseDao().getWorkerList()
                Log.i("SeeingParams",it.toString())
            },{
                Log.i("SeeingParams",it.message.toString())
            })
        compositeDisposable.add(disposable)
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}