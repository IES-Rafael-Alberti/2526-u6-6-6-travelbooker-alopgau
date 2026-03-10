package org.practicatrim2
/* Reserva (Superclase o Interfaz):
Contendrá la lógica común a todas las reservas, aunque no se permitirá la creación de una instancia de la misma.
Posee un id. Se asigna automáticamente al crear la instancia. No puede ser nula y no se puede modificar.
Posee una fechaCreacion. Se asigna automáticamente al crear la instancia. No puede ser nula y no se puede modificar.
Posee una descripcion. No puede ser nula (por ejemplo, descripción del itinerario o servicio).
Debe incluir una propiedad detalle, cuyo getter utilice la lógica común para concatenar el id y la descripción.
*/
abstract class Reserva() {
    companion object {
        var contador = 0
    }
val id: Int
private val fechaCreacion: String
private val descripcion: String
val detalle: String
    get() = "$id-$descripcion"
    init {
        contador++
        id=contador
        require()
    }
}