package com.awakelab.oskar.ejercicio12kotlin

data class Usuario(
    var nombre: String,
    var aprellido: String,
    var edad: Int,
    var email: String,
    var salud: Int
)

fun main() {
    var usuarios = mutableListOf<Usuario>()
    var salir: Int = 1
    var mensaje: String = ""
    var min: Int = 0
    var max: Int = 0

    println("-------- Registro de Usuario -------")

    mensaje = "Ingrese la cantidad: "
    print(mensaje)
    var cantSrt: String = readln()
    while (!isNumeric(cantSrt)) {
        print(mensaje)
        cantSrt = readln()
    }
    val cant: Int = cantSrt.toInt()


    do {
        min = 1
        max = 20
        mensaje = "Ingrese Nombre, entre $min y $max caracteres: "
        print(mensaje)
        var nombre = readln()
        while (!lengthText(nombre, min, max)) {
            print(mensaje)
            nombre = readln()
        }

        mensaje = "Ingrese Apellido: "
        print(mensaje)
        var apellido = readln()
        while (!soloLetras(apellido)) {
            print("$mensaje, solo se aceptan letras ")
            apellido = readln()
        }

        mensaje = "Ingrese Edad: "
        print(mensaje)
        var edadStr: String = readln()
        while (!isNumeric(edadStr)) {
            print("No es un numero valido, $mensaje ")
            edadStr = readln()
        }
        var edad: Int = edadStr.toInt()
        min = 1
        max = 120
        while (!rangoNumeros(edad, min, max)) {
            print("Edad fuera de rango, debe ser entre 1 y 120 años ")
            edadStr = readln()
            while (!isNumeric(edadStr)) {
                print("No es un numero valido, $mensaje ")
                edadStr = readln()
            }
            edad = edadStr.toInt()
        }

        print("Ingrese Correo: ")
        var email: String = readln()
        while (!validarCorreo(email)) {
            print("Correo no valido, ingrese correo: ")
            email = readln()
        }

        mensaje = "Ingrese Sistema de Salud: \n 1:Fonasa, 2:Isapre, 3:Particular "
        print(mensaje)
        var saludStr: String = readln()
        while (!isNumeric(saludStr)) {
            print("Caracter no valido, $mensaje")
            saludStr = readln()
        }
        var salud = saludStr.toInt()
        min = 1
        max = 3
        while (!rangoNumeros(salud, min, max)) {
            print("Fuera de rango, $mensaje ")
            saludStr = readln()
            while (!isNumeric(saludStr)) {
                print("Caracter no valido, $mensaje")
                saludStr = readln()
            }
            salud = saludStr.toInt()
        }

        val usuario = Usuario(nombre, apellido, edad, email, salud)
        usuarios.add(usuario)
        salir++
    } while (salir <= cant)

    for (u in usuarios.sortedBy { usuario ->
        usuario.edad
    }) {
        println("Usuario: $u")
    }
}

fun rangoNumeros(num: Int, min: Int, max: Int): Boolean {
    return num in min..max
}

fun soloLetras(srt: String): Boolean {
    val srtRegex = "^[a-zA-Z]*$"
    return srt.matches(srtRegex.toRegex())
}

fun lengthText(srt: String, min: Int, max: Int): Boolean {
    return srt.length in min..max
}

fun isNumeric(s: String): Boolean {
    return try {
        s.toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }
}

fun validarCorreo(correo: String): Boolean {
    val emailRegex = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"
    return correo.matches(emailRegex.toRegex())
}



