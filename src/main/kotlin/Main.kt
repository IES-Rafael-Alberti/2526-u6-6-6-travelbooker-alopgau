package org.practicatrim2
import aplicacion.ReservaService
import datos.RepoBase

fun main() {
    val reservas = RepoBase()
    val app = ReservaService(reservas)
     app.ejecutar()


}