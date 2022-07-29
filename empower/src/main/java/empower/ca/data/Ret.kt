package empower.ca.data

data class Ret(
    val componentCode: String,
    val containerTitle: String,
    val contentType: String,
    val contents: List<Content>
)