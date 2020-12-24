package net.digiapt.ui.jobs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import net.digiapt.data.repositories.JobsRepository
import net.digiapt.util.Coroutines

class JobsViewModel(
    private val repository: JobsRepository
) : ViewModel() {

    private lateinit var coroutineJob: Job

    private val _jobs = MutableLiveData<List<net.digiapt.data.models.Job>>()
    val jobs: LiveData<List<net.digiapt.data.models.Job>>
        get() = _jobs

    private val _job = MutableLiveData<net.digiapt.data.models.Job>()
    val job: LiveData<net.digiapt.data.models.Job>
        get() = _job

    fun getJobs() {
        coroutineJob = Coroutines.ioThenMain(
            { repository.getJobs() },
            { _jobs.value = it?.data }
        )
    }

    fun getJob() {
        coroutineJob = Coroutines.ioThenMain(
            { repository.getJob() },
            { _job.value = it?.data }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::coroutineJob.isInitialized) coroutineJob.cancel()
    }
}