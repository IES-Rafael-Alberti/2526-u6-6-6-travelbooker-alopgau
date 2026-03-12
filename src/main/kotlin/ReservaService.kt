package aplicacion
import datos.IReservaRepositorio
import presentacion.Consola

class ReservaService(private val repoReservas: IReservaRepositorio) {
private val consola = Consola()
    fun iniciar(): String {
        consola.menuPrincipal()
        return readln()
    }
    fun eje
}