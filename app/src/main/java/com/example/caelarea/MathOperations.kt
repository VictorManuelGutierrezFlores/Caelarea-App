package com.example.caelarea

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
    return ((mbase + base) * height) / 2
}