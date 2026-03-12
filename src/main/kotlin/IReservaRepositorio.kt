package datos
import dominio.Reserva
interface IReservaRepositorio {
    val reservas : Map<Int, Reserva>
}