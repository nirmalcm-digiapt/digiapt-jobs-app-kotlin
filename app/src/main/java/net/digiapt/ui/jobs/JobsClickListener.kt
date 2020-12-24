package net.digiapt.ui.jobs

import android.view.View
import net.digiapt.data.models.Job

interface JobsClickListener {
    fun onRecyclerViewItemClick(view: View, job: Job)
}