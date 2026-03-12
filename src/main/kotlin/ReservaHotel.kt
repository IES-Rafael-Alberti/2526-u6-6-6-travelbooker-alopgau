import dominio.Reserva

class ReservaHotel private constructor(descripcion: String, fechaCreacion: String, ubicacion: String, numeroCoches: String) : Reserva() {
    companion object {
        fun creaInstancia(descripcion: String,fechaCreacion: String,ubicacion: String,numeroCoches: String) = ReservaHotel(descripcion,fechaCreacion,ubicacion,numeroCoches)
        val regexHora = "^[01][0-9]:[012345][0-9]|2[0123]:[012345][0-9]$".toRegex()
    }
    override val descripcion = descripcion
    override val fechaCreacion = fechaCreacion
    override val detalle: String
        get() = "${super.detalle}-$ubicacion ($numeroCoches)"
    val ubicacion = ubicacion
    val numeroCoches = numeroCoches

    override fun toString() = "$descripcion\nUbicacion: $ubicacion\nDestino: $numeroCoches"
}