package datos

import dominio.Reserva

class RepoBase : IReservaRepositorio {
    override val reservas = mutableMapOf<Int, Reserva>()
    override fun agregarReserva(reserva: Reserva) = reservas.put(reserva.id,reserva)
    override fun obtenerTodas() = reservas.values.toList()
}