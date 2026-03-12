package aplicacion
import datos.IReservaRepositorio
import presentacion.Consola

class ReservaService(private val repoReservas: IReservaRepositorio) {
val consola = Consola()
}