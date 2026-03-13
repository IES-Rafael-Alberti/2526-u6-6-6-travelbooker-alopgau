package dominio

class ReservaVuelo private constructor(descripcion: String, fechaCreacion: String,origen: String, destino: String, horaVuelo: String) : Reserva() {
    companion object {
        fun creaInstancia(descripcion: String,fechaCreacion: String,origen: String,destino: String,horaVuelo: String) = ReservaVuelo(descripcion,fechaCreacion,origen,destino,horaVuelo)
         val regexHora = "^[01][0-9]:[012345][0-9]|2[0123]:[012345][0-9]$".toRegex()
    }
    override val descripcion = descripcion
    override val fechaCreacion = fechaCreacion
    override val detalle: String
        get() = "${super.detalle}-$origen -> $destino [$horaVuelo]"
    val origen = origen
    val destino = destino
    val horaVuelo = horaVuelo
    init {
        require(regexHora.matches(horaVuelo))
        require(regex.matches(fechaCreacion))
    }

    override fun toString() = "$descripcion\nOrigen: $origen\nDestino: $destino\nHora del vuelo: $horaVuelo"
}

