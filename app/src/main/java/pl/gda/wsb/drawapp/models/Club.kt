package pl.gda.wsb.drawapp.models

data class Club(
    val name: String,
    val seasonOne: Double,
    val seasonTwo: Double,
    val seasonThree: Double,
    val seasonFour: Double,
    val seasonFive: Double,
    val sum: Double = seasonOne + seasonTwo + seasonThree + seasonFour + seasonFive
){
}