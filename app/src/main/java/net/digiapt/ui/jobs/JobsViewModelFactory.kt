package net.digiapt.ui.jobs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.digiapt.data.repositories.JobsRepository

@Suppress("UNCHECKED_CAST")
class JobsViewModelFactory(
    private val repository: JobsRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return JobsViewModel(repository) as T
    }

}