package datos
import dominio.Reserva
interface IReservaRepositorio<T> {
    val reservas : MutableMap<T, Reserva>
    fun agregarReserva(reserva: Reserva): Reserva?
    fun obtenerTodas() : List<Reserva>

}
