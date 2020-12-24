package net.digiapt.ui.jobs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jobs.*
import net.digiapt.R
import net.digiapt.data.models.Job
import net.digiapt.data.network.JobsApi
import net.digiapt.data.repositories.JobsRepository


class JobsListFragment : Fragment(), JobsClickListener{

    private lateinit var factory: JobsViewModelFactory
    private lateinit var viewModel: JobsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_jobs, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = JobsApi()
        val repository = JobsRepository(api)

        factory = JobsViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(JobsViewModel::class.java)

        viewModel.getJobs()

        viewModel.jobs.observe(viewLifecycleOwner, Observer { jobs ->
            recycler_view_jobs.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = JobsListAdapter(jobs, this)
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, job: Job) {
        when(view.id){
            /*R.id.button_book -> {
                Toast.makeText(requireContext(), "Book Button Clicked",Toast.LENGTH_LONG).show()
            }
            R.id.layout_like ->{
                Toast.makeText(requireContext(), "Like Layout Clicked",Toast.LENGTH_LONG).show()
            }*/
            else ->
            {
                activity?.let{
                    val intent = Intent (it, JobsDescripitionActivity::class.java)
                    intent.putExtra("data","")
                    it.startActivity(intent)
                }
            }
        }
    }
}