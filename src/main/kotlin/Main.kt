import kotlin.random.Random

fun main() {
    println("===========Bienvenido al Juego de Dados===========")
    println()
    print("Ingresa tu nombre: ")
    val user = readLine()
    if (user == null || user == "") {
        println("Termino el programa, por favor ingresar un usuario!")
        return
    }
    println()
    println("Comenzamos $user!")



    do {
        var contarJuegos = 1
        var contarUser = 0
        var contarPC = 0

        do {
            println()
            println("Juego #$contarJuegos!")
            val jugadaUser = Jugada(user)
            val jugadaPC = Jugada("PC")

            if (jugadaPC > jugadaUser) {
                contarPC += 1
                println("Ganó la partida, PC")
            } else if (jugadaPC == jugadaUser) {
                contarPC += 0
                contarUser += 0
                println("Empate")
            } else {
                contarUser += 1
                print("Ganó la partida, $user")
            }

            contarJuegos += 1
            println()
        }while ((contarPC < 3) && (contarUser < 3))

        println()
        println("Resultado: PC = $contarPC y $user = $contarUser")
        println()

        if (contarPC > contarUser) {
            println("Ganó el juego PC")
        } else {
            println("Ganó el juego, $user")
        }

        println()
        println("¿Desea segui jugando? 1-Si / 2-No")
        var loop: Boolean
        val volverJugar = readLine()

        if ( volverJugar == "1") {
            loop = true
        } else if (volverJugar == "2") {
            println()
            println("Hasta Luego, gracias por jugar!")
            loop = false
        } else {
            println()
            println("Opción no válida")
            return
        }

    } while (loop)

}

fun Jugada(user:String): Int {
    val numeroUno = Random.nextInt(1,6)
    val numeroDos = Random.nextInt(1,6)
    val totalUser = numeroUno + numeroDos
    println("$user, tus numeros son: $numeroUno y $numeroDos, sumando $totalUser")
    return totalUser
}