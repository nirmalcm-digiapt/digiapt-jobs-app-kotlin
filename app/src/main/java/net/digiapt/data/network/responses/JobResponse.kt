package net.digiapt.data.network.responses

import net.digiapt.data.models.Job

data class JobResponse (
    val status: Boolean,
    val message: String,
    val data: Job
)