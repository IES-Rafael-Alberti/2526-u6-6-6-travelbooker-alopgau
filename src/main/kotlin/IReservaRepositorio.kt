package datos
import dominio.Reserva
interface IReservaRepositorio {
    val reservas : MutableMap<Int, Reserva>
    fun agregarReserva(reserva: Reserva): Reserva?
    fun obtenerTodas() : List<Reserva>

}
