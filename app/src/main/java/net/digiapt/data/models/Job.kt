package net.digiapt.data.models

data class Job(
    val id: Int,
    val job_position: String,
    val company_name: String,
    val job_experience_required: String,
    val job_location: String,
    val salary: String,
    val skill_set_required: String,
    val job_posted_date: String,
    val vacancy: String,
    val industry_type: String,
    val functional_area: String,
    val role: String,
    val desired_candidate_profile: String,
    val company_website: String,
    val youtube_url: String,
    val contact_name: String,
    val contact_phone: String,
    val contact_email: String
)