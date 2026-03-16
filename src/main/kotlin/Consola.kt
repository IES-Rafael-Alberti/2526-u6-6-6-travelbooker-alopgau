/*
La aplicación debe interactuar con el usuario a través de la consola, mostrando un menú que permita:
Crear una nueva reserva (seleccionando entre Reserva de Vuelo o Reserva de Hotel).
Listar todas las reservas registradas, mostrando el detalle de cada reserva mediante polimorfismo.
La capa de presentación debe comunicarse con la lógica de negocio a través de interfaces o abstracciones.
 */
package presentacion

import dominio.Reserva
import com.github.ajalt.mordant.rendering.TextColors.*
import com.github.ajalt.mordant.rendering.TextStyles.*
import com.github.ajalt.mordant.terminal.Terminal
import com.github.ajalt.mordant.rendering.TextColors.Companion.rgb


class Consola(): Mensajes {
    override fun menuPrincipal() = println(buildString {
        appendLine(cyan("Selecciona una opción:"))
        appendLine(brightYellow("1) Hacer reserva"))
        appendLine(brightYellow("2) Listar tus reservas"))
        appendLine(red("X para retroceder"))
    })
    override fun mostrarOpcionesReserva() = println(buildString {
        appendLine(brightYellow("1) Reservar un vuelo"))
        appendLine(cyan("2) Reservar un hotel"))
        appendLine(red("X para salir"))
    })
    override fun <T> mostrarReservas(reservas: Map<T, Reserva>) = println(buildString {
        reservas.forEach { id, reserva -> appendLine(cyan("ID: $id\n Detalles de la reserva: ${reserva.detalle}"))  }
    })

    override fun imprimirMensaje(mensaje: String) = println(mensaje)

    override fun pedirEntrada() = readln()
}