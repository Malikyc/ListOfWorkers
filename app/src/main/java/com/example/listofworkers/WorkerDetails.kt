package com.example.listofworkers
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.listofworkers.database.WorkerViewModel
import com.example.listofworkers.databinding.ActivityWorkerDetailsBinding

class WorkerDetails : AppCompatActivity() {
    private lateinit var binding: ActivityWorkerDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkerDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (!intent.hasExtra(EXTRA_KEY)){
            finish()
        return
    }
        val workerId = intent.getIntExtra(EXTRA_KEY,1000)
        val viewModel = ViewModelProvider(this)[WorkerViewModel::class.java]
        if(workerId != null){
            val worker = viewModel.getParticularWorker(workerId)
            worker.observe(this){
                    var list = mutableListOf<String>()
                    var listOfSpec = it.specialty
                    for (spec in listOfSpec) {
                        list.add(spec.name)
                    }
                    binding.textViewLName.text = it.lName
                    binding.textViewBirhday.text = it.birthday
                    binding.listView.adapter = ArrayAdapter<String>(
                        applicationContext,
                        android.R.layout.simple_list_item_1,
                        list
                    )
                }
        }



    }
    companion object{
         const val EXTRA_KEY = "id_of_worker"

        fun newIntent(context: Context,id:Int?) : Intent{
            val intent = Intent(context,WorkerDetails::class.java)
            intent.putExtra(EXTRA_KEY,id)
            return intent
        }
    }
}