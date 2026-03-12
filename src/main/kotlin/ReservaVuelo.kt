package dominio

class ReservaVuelo private constructor(descripcion: String, fechaCreacion: String,origen: String, destino: String, horaVuelo: String) : Reserva() {
    companion object {
        fun creaInstancia(descripcion: String,fechaCreacion: String,origen: String,destino: String,horaVuelo: String) = ReservaVuelo(descripcion,fechaCreacion,origen,destino,horaVuelo)
    }
    override val descripcion = descripcion
    override val fechaCreacion = fechaCreacion
    override val detalle: String
        get() = "${super.detalle}-$origen -> $destino [$horaVuelo]"
    val origen = origen
    val destino = destino
    val horaVuelo = horaVuelo
}

