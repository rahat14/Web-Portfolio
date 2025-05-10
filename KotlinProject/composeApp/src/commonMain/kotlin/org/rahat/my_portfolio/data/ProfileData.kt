package org.rahat.my_portfolio.data

@kotlinx.serialization.Serializable
data class Experience(
    val company: String,
    val position: String,
    val duration: String,
    val responsibilities: String,
    val link: String,
    val tech_stack: List<String>,
)

@kotlinx.serialization.Serializable
data class OpenSourceContribution(
    val name: String,
    val description: String,
    val link: String,
    val tech_stack: List<String>
)

@kotlinx.serialization.Serializable
data class Project(
    val name: String,
    val link: String,
    val description: String,
    val tech_stack: List<String>,
    val image: String? = null
)

@kotlinx.serialization.Serializable
data class DeveloperProfile(
    val experience: List<Experience>,
    val open_source_contributions: List<OpenSourceContribution>,
    val projects: List<Project>
)