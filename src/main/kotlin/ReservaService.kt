package aplicacion
import datos.IReservaRepositorio
import dominio.Reserva
import dominio.ReservaHotel
import dominio.ReservaVuelo
import presentacion.Consola
import presentacion.Mensajes
/*
Servicio principal que orquesta el flujo de la aplicación TravelBooker.
*
* Esta clase implementa la lógica de negocio y coordina las interacciones entre
* la interfaz de usuario y el repositorio de datos. Gestiona el ciclo completo
* de creación y listado de reservas, manteniendo una máquina de estados que
* controla el flujo de la aplicación.
*
* @param T El tipo de clave utilizado por el repositorio para almacenar las reservas
* @param repoReservas Repositorio que gestiona la persistencia de las reservas
*
* @property estado Estado actual de la aplicación (INICIANDO, RESERVANDO, TERMINADO)
* @property consola Interfaz de usuario para la comunicación con el cliente
*/



class  ReservaService<T>(private val repoReservas: IReservaRepositorio<T>) {
    private var estado = Estado.INCIANDO
    private val consola : Mensajes = Consola()
    fun ejecutar() {
        while (estado == Estado.INCIANDO) {
        val entrada = pantallaInicio()
        procesarOpcionMenu(entrada)
        while (estado == Estado.RESERVANDO) {
          val entrada = elegirReserva()
            hacerReserva(entrada, "Reserva test", "2026-03-13")
        }
        }
    }
    private fun pantallaInicio(): String {
        consola.menuPrincipal()
        return consola.pedirEntrada()
    }
    private fun procesarOpcionMenu(entrada: String) {
        when (entrada.uppercase()) {
            "1" -> {
                cambiarEstado(Estado.RESERVANDO)
            }
            "2" -> listarReservas()
            "X" -> cambiarEstado(Estado.TERMINADO)
            else -> consola.imprimirMensaje("Escoge una de las opciones indicadas")
        }
    }

    private fun elegirReserva(): String {
        consola.mostrarOpcionesReserva()
         return consola.pedirEntrada()
    }

    private fun hacerReserva(entrada: String, descripcion: String,fechaCreacion: String): Estado {
        when (entrada.uppercase()) {
            "1" -> {
                consola.imprimirMensaje("Introduce el origen del vuelo")
                val origen = consola.pedirEntrada()

                consola.imprimirMensaje("Introduce el destino del vuelo")
                val destino = consola.pedirEntrada()

                consola.imprimirMensaje("Introduce la hora del vuelo")
                val horaVuelo = consola.pedirEntrada()

                repoReservas.agregarReserva(hacerReservaVuelo(descripcion,fechaCreacion, origen,destino,horaVuelo))
                return cambiarEstado(Estado.INCIANDO)
            }
            "2" -> {
                consola.imprimirMensaje("Introduce la ubicacion del hotel")
                val ubicacion = consola.pedirEntrada()

                consola.imprimirMensaje("Introduce el número de noches de tu estancia")
                val numeroNoches = consola.pedirEntrada().toIntOrNull()?:1

                repoReservas.agregarReserva(hacerReservaHotel(descripcion,fechaCreacion,ubicacion,numeroNoches))
                return cambiarEstado(Estado.INCIANDO)
            }
            "X" -> return cambiarEstado(Estado.INCIANDO)
            else -> {
                consola.imprimirMensaje("Escoge una de las opciones indicadas")
                return cambiarEstado(Estado.RESERVANDO)
            }
        }
    }

    private fun listarReservas(): List<Reserva> {
        consola.mostrarReservas(repoReservas.reservas)
        if (repoReservas.obtenerTodas().isEmpty()) consola.imprimirMensaje("No hay reservas a tu nombre")
            return repoReservas.obtenerTodas()
    }
    private fun hacerReservaVuelo(descripcion: String,fechaCreacion: String,origen: String,destino: String,horaVuelo: String) = ReservaVuelo.creaInstancia(descripcion,fechaCreacion,origen,destino,horaVuelo)
    private fun hacerReservaHotel(descripcion: String,fechaCreacion: String,ubicacion: String,numeroNoches: Int) = ReservaHotel.creaInstancia(descripcion,fechaCreacion,ubicacion,numeroNoches)
    private fun cambiarEstado(estado: Estado): Estado {
        this.estado = estado
        return this.estado
    }
}
