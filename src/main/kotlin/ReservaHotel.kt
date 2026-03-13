package dominio

class ReservaHotel private constructor(descripcion: String, fechaCreacion: String, ubicacion: String, numeroNoches: Int) : Reserva() {
    companion object {
        fun creaInstancia(descripcion: String,fechaCreacion: String,ubicacion: String,numeroNoches: Int) = ReservaHotel(descripcion,fechaCreacion,ubicacion,numeroNoches)
    }
    override val descripcion = descripcion
    override val fechaCreacion = fechaCreacion
    override val detalle: String
        get() = "${super.detalle}-$ubicacion ($numeroNoches)"
    val ubicacion = ubicacion
    val numeroNoches = numeroNoches

    override fun toString() = "$descripcion\nUbicacion: $ubicacion\n Numero de noches: $numeroNoches"
    init {
        require(regex.matches(fechaCreacion))
    }
}