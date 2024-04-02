package com.example.caelarea

// GLOBAL VARIABLES
val integerChars = '0'..'9'

// FUNCION CALCULO AREA TRIANGULO
fun calculateTrianArea(height: Double, base: Double): Double {
    return (height * base) / 2
}
// FUNCION CALCULO AREA RECTANGULO
fun calculateRectArea(height: Double, base: Double): Double {
    return height * base
}
// FUNCION CALCULO DE AREA CIRCULO
fun calculateCirArea(radio: Double): Double{
    return (radio * radio) * kotlin.math.PI
}
// FUNCION CALCULO DE AREA ROMBO
fun calculateRomArea(dm:Double, d:Double): Double{
    return (dm * d) / 2
}
// FUNCION CALCULO AREA DE TRAPECIO
fun calculateTrapArea(height: Double, base: Double, mbase: Double): Double {
    return ((mbase * base) * height) / 2
}



// FUNCION COMPROBACION NUMEROS
fun isNumber( input:String):Boolean{
    var dotOcurred = 0
    return input.all { it in integerChars || it == ',' && dotOcurred++ < 1}
}

// COMPROBACION POSITIVO-NEGATIVO
fun isPosOrNeNumber(input:String):Boolean{
    val regex = """^(-)?[0-9]{0,}((\.){1}[0-9]{1,}){0,1}$""".toRegex()
    return if (input.isEmpty()) false
        else regex.matches(input)
}