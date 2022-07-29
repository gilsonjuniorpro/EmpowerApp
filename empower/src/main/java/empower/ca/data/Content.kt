package empower.ca.data

data class Content(
    val componentCode: String,
    val description: String,
    val header: String,
    val image: String,
    val operators: List<Operator>,
    val title: String
)