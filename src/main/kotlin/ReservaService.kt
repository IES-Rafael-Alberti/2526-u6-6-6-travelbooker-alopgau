package aplicacion
import datos.IReservaRepositorio
import dominio.Reserva
import dominio.ReservaHotel
import dominio.ReservaVuelo
import presentacion.Consola

class ReservaService(private val repoReservas: IReservaRepositorio) {
    fun ejecutar() {
        pantallaInicio()
    }
    private val consola = Consola()
    private fun pantallaInicio() {
        consola.menuPrincipal()
        val entrada = consola.pedirEntrada()
        procesarOpcionMenu(entrada)
    }
    private fun procesarOpcionMenu(entrada: String) {
        when (entrada) {
            "1" -> elegirReserva()
            "2" -> listarReservas()
            "X" -> consola.imprimirMensaje("Ejecución terminada")
            else -> consola.imprimirMensaje("Escoge una de las opciones indicadas")
        }
    }

    private fun elegirReserva() {
        consola.mostrarOpcionesReserva()
        val entrada = consola.pedirEntrada()
        hacerReserva(entrada, "Reserva test", "2026-03-13")
    }

    private fun hacerReserva(entrada: String, descripcion: String,fechaCreacion: String) {
        when (entrada) {
            "1" -> {
                consola.imprimirMensaje("Introduce el origen del vuelo")
                val origen = consola.pedirEntrada()

                consola.imprimirMensaje("Introduce el destino del vuelo")
                val destino = consola.pedirEntrada()

                consola.imprimirMensaje("Introduce la hora del vuelo")
                val horaVuelo = consola.pedirEntrada()

                repoReservas.agregarReserva(hacerReservaVuelo(descripcion,fechaCreacion, origen,destino,horaVuelo))
            }
            "2" -> {
                consola.imprimirMensaje("Introduce la ubicacion del hotel")
                val ubicacion = consola.pedirEntrada()

                consola.imprimirMensaje("Introduce el número de noches de tu estancia")
                val numeroNoches = consola.pedirEntrada().toIntOrNull()?:1

                repoReservas.agregarReserva(hacerReservaHotel(descripcion,fechaCreacion,ubicacion,numeroNoches))
            }
            else -> consola.imprimirMensaje("Escoge una de las opciones indicadas")
        }
    }

    private fun listarReservas(): List<Reserva> {
        consola.mostrarReservas(repoReservas.reservas)
        if (repoReservas.obtenerTodas().isEmpty()) consola.imprimirMensaje("No hay reservas a tu nombre")
            return repoReservas.obtenerTodas()
    }
    private fun hacerReservaVuelo(descripcion: String,fechaCreacion: String,origen: String,destino: String,horaVuelo: String) = ReservaVuelo.creaInstancia(descripcion,fechaCreacion,origen,destino,horaVuelo)
    private fun hacerReservaHotel(descripcion: String,fechaCreacion: String,ubicacion: String,numeroNoches: Int) = ReservaHotel.creaInstancia(descripcion,fechaCreacion,ubicacion,numeroNoches)
}
