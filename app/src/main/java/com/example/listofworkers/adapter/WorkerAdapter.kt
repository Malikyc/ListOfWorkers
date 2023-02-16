package com.example.listofworkers.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.listofworkers.R
import com.example.listofworkers.databinding.CardOfEmployeeBinding
import com.example.listofworkers.pojo.Worker

class WorkerAdapter :Adapter<WorkerAdapter.WorkerViewHolder>(){

    interface WorkerOnClickListener{
        fun onWorkerClick(worker: Worker)
    }

    var workerOnClickListener : WorkerOnClickListener ?= null
    set(value){
        field=value
    }

     var list: List<Worker> = mutableListOf()
    set(value) {
        field=value
        notifyDataSetChanged()
    }

    inner class WorkerViewHolder(itemView: View) : ViewHolder(itemView){
       val name = itemView.findViewById<TextView>(R.id.Name)
        val lastName = itemView.findViewById<TextView>(R.id.LastName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_of_employee,parent,false)
        return WorkerViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkerViewHolder, position: Int) {
        val worker : Worker = list[position]
        with(holder){
            name.text = worker.fName
            lastName.text = worker.lName
            itemView.setOnClickListener{
                workerOnClickListener?.onWorkerClick(worker)
            }
        }


    }

    override fun getItemCount(): Int {
     return list.size
    }

}