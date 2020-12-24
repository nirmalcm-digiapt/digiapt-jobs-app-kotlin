package net.digiapt.data.repositories

import net.digiapt.data.network.JobsApi

class JobsRepository(
    private val api: JobsApi
) : SafeApiRequest() {

    suspend fun getJobs() = apiRequest { api.getJobs() }

    suspend fun getJob() = apiRequest { api.getJob() }
}