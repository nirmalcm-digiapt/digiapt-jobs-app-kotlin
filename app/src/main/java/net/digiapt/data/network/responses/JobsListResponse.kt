package net.digiapt.data.network.responses

import net.digiapt.data.models.Job

data class JobsListResponse (
    val status: Boolean,
    val message: String,
    val data: List<Job>
)