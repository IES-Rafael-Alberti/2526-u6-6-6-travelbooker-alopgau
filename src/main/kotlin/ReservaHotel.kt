package dominio

class ReservaHotel private constructor(descripcion: String, fechaCreacion: String, ubicacion: String, numeroCoches: Int) : Reserva() {
    companion object {
        fun creaInstancia(descripcion: String,fechaCreacion: String,ubicacion: String,numeroCoches: Int) = ReservaHotel(descripcion,fechaCreacion,ubicacion,numeroCoches)
    }
    override val descripcion = descripcion
    override val fechaCreacion = fechaCreacion
    override val detalle: String
        get() = "${super.detalle}-$ubicacion ($numeroCoches)"
    val ubicacion = ubicacion
    val numeroCoches = numeroCoches

    override fun toString() = "$descripcion\nUbicacion: $ubicacion\n Numero de coches: $numeroCoches"
}