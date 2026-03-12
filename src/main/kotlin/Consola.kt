/*
La aplicación debe interactuar con el usuario a través de la consola, mostrando un menú que permita:
Crear una nueva reserva (seleccionando entre Reserva de Vuelo o Reserva de Hotel).
Listar todas las reservas registradas, mostrando el detalle de cada reserva mediante polimorfismo.
La capa de presentación debe comunicarse con la lógica de negocio a través de interfaces o abstracciones.
 */
package presentacion
class Consola() {
    fun menuPrincipal() = buildString {
        appendLine("Selecciona una opción:")
        appendLine("1) Hacer reserva")
        appendLine("2) Listar tus reservas")
    }
}