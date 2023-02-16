package com.example.listofworkers

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.listofworkers.adapter.WorkerAdapter
import com.example.listofworkers.database.WorkerViewModel
import com.example.listofworkers.databinding.ActivityMainBinding
import com.example.listofworkers.pojo.Worker

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding
private lateinit var workerViewModel : WorkerViewModel
companion object{
    lateinit var workerAdapter: WorkerAdapter
}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        workerViewModel = ViewModelProvider(this).get(WorkerViewModel::class.java)
        workerViewModel.loadData()
        val listOfWorkers = workerViewModel.listOfWorkers
        workerAdapter = WorkerAdapter()
        workerAdapter.workerOnClickListener = object : WorkerAdapter.WorkerOnClickListener{
            override fun onWorkerClick(worker: Worker) {
                val intent = WorkerDetails.newIntent(this@MainActivity,worker.id)
                startActivity(intent)

            }
        }
        binding.RecyclerView.adapter = workerAdapter

        listOfWorkers.observe(this,{
            workerAdapter.list = it
        })




    }
}