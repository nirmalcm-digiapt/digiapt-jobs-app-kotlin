package net.digiapt.ui.jobs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jobs.*
import net.digiapt.R
import net.digiapt.data.network.JobsApi
import net.digiapt.data.repositories.JobsRepository
import net.digiapt.databinding.ActivityJobsDescripionBinding


class JobsDescripitionActivity : AppCompatActivity() {

    private lateinit var factory: JobsViewModelFactory
    private lateinit var viewModel: JobsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Job Description"
        val api = JobsApi()
        val repository = JobsRepository(api)

        factory = JobsViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(JobsViewModel::class.java)

        val binding: ActivityJobsDescripionBinding = DataBindingUtil.setContentView(this, R.layout.activity_jobs_descripion)
        val viewModel = ViewModelProviders.of(this, factory).get(JobsViewModel::class.java)

        viewModel.getJob()

        viewModel.job.observe(this,Observer { job ->
            binding.job = job
        })
    }
}