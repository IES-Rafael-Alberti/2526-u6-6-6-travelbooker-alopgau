package aplicacion
import datos.IReservaRepositorio
import dominio.Reserva
import dominio.ReservaHotel
import dominio.ReservaVuelo
import presentacion.Consola

class ReservaService(private val repoReservas: IReservaRepositorio) {
    private val consola = Consola()
    fun iniciar(): String {
        consola.menuPrincipal()
        return consola.pedirEntrada()
    }

    fun elegirReserva(): String {
        consola.mostrarOpcionesReserva()
        return consola.pedirEntrada()
    }

    fun hacerReserva(entrada: String, descripcion: String,fechaCreacion: String) {
        when (entrada) {
            "1" -> {
                consola.imprimirMensaje("Introduce el origen del vuelo")
                val origen = consola.pedirEntrada()

                consola.imprimirMensaje("Introduce el destino del vuelo")
                val destino = consola.pedirEntrada()

                consola.imprimirMensaje("Introduce la hora del vuelo")
                val horaVuelo = consola.pedirEntrada()

                hacerReservaVuelo(descripcion,fechaCreacion, origen,destino,horaVuelo)
            }
            "2" -> {
                consola.imprimirMensaje("Introduce la ubicacion del hotel")
                val ubicacion = consola.pedirEntrada()

                hacerReservaHotel(descripcion,fechaCreacion,ubicacion,numeroCoches=90)
            }
            else -> consola.imprimirMensaje("Escoge una de las opciones indicadas")
        }
    }

    fun listarReservas(): List<Reserva> {
        consola.mostrarReservas(repoReservas.reservas)
        return repoReservas.obtenerTodas()
    }
    private fun hacerReservaVuelo(descripcion: String,fechaCreacion: String,origen: String,destino: String,horaVuelo: String) = ReservaVuelo.creaInstancia(descripcion,fechaCreacion,origen,destino,horaVuelo)
    private fun hacerReservaHotel(descripcion: String,fechaCreacion: String,ubicacion: String,numeroCoches: Int) = ReservaHotel.creaInstancia(descripcion,fechaCreacion,ubicacion,numeroCoches)
}
