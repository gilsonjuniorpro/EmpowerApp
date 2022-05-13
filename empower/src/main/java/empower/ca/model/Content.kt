package empower.ca.model


data class Content(
    val contentType: String,
    val header: String,
    val title: String,
    val description: String,
    val image: String,
    val operators: List<Operator>
)

