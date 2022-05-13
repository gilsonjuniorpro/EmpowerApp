package empower.ca.model

data class Operator(
    val type: String, // button or link
    val actionType: String, // open detail or open link
    val actionValue: String, // url link or detail screen
    val text: String
)
