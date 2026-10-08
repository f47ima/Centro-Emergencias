
package centroemergencias;


/**
 * Representa una alerta meteorologica.
 * Extiende Incidente e implementa Evacuables.
 */
public class AlertaMeteorologica extends Incidente implements Evacuables {

    private final String fenomenoObservado;

    /**
     * Crea una nueva alerta meteorologica.
     *
     * @param codigo Identificador unico del incidente
     * @param zona Zona donde ocurrio
     * @param prioridad Nivel de prioridad del incidente
     * @param fenomenoObservado Descripcion del fenomeno observado
     * @throws IllegalArgumentException si algun parametro esta vacio
     * @throws NullPointerException si algun parametro es nulo
     */
    public AlertaMeteorologica(String codigo, String zona, NivelPrioridad prioridad, String fenomenoObservado) {
        super(codigo, zona, prioridad);
        validarString(fenomenoObservado, "El fenomeno observado no puede ser nulo ni estar vacio.");
        this.fenomenoObservado = fenomenoObservado;
    }

    /**
     * Ordena la evacuacion por alerta meteorologica.
     * @return cadena con los datos de la evacuacion.
     */
    @Override
    public String evacuar() {
        return "Se ordeno la evacuacion por alerta meteorologica " 
                + getCodigo() + " en " + getZona() 
                + ". Fenomeno: " + fenomenoObservado + ".";
    }

    @Override
    public String getDescripcion() {
        return " fenomenoObservado=" + fenomenoObservado;
    }
}
