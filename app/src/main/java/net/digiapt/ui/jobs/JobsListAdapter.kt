package net.digiapt.ui.jobs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import net.digiapt.R
import net.digiapt.data.models.Job
import net.digiapt.databinding.AdapterJobsBinding

class JobsListAdapter (
    private val jobs: List<Job>,
    private val listener: JobsClickListener
) : RecyclerView.Adapter<JobsListAdapter.JobsViewHolder>(){

    override fun getItemCount() = jobs.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        JobsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.adapter_jobs,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {
        holder.recyclerviewJobBinding.job = jobs[position]
        holder.recyclerviewJobBinding.root.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewJobBinding.root, jobs[position])
        }
        /*holder.recyclerviewJobBinding.buttonBook.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewJobBinding.buttonBook, jobs[position])
        }
        holder.recyclerviewJobBinding.layoutLike.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewJobBinding.layoutLike, jobs[position])
        }*/
    }


    inner class JobsViewHolder(
        val recyclerviewJobBinding: AdapterJobsBinding
    ) : RecyclerView.ViewHolder(recyclerviewJobBinding.root)

}