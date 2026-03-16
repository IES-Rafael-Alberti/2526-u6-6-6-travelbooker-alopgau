package presentacion

import dominio.Reserva

interface Mensajes {
    fun menuPrincipal()
    fun pedirEntrada(): String
    fun <T> mostrarReservas(reservas: Map<T, Reserva>)
    fun imprimirMensaje(mensaje: String)
    fun mostrarOpcionesReserva()

}