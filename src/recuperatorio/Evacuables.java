
package recuperatorio;

/**
 * Define el comportamiento para objetos que pueden requerir una evacuacion.
 */
public interface Evacuables {
    /**
     * Ordena la evacuacion del incidente y devuelve el resultado.
     * @return una cadena de texto con el resultado de la evacuacion.
     */
    String evacuar();
}