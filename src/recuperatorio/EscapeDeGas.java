package recuperatorio;

/**
 * Representa un incidente por escape de gas
 */
public class EscapeDeGas extends IncidentesDeEstructura implements Reparables, Evacuables {

    private final int concentracion;

    /**
     * Crea un nuevo incidente por escape de gas.
     *
     * @param codigo Identificador unico del incidente
     * @param zona Zona donde ocurrio
     * @param prioridad Nivel de prioridad del incidente
     * @param edificiosAfectados Cantidad de edificios afectados
     * @param concentracion Concentracion de gas detectada, entre 0 y 100
     * @throws IllegalArgumentException si la concentracion esta fuera del rango
     * 0-100
     */
    public EscapeDeGas(String codigo, String zona, NivelPrioridad prioridad, int edificiosAfectados, int concentracion) {
        super(codigo, zona, prioridad, edificiosAfectados);
        validarConcentracion(concentracion);
        this.concentracion = concentracion;
    }

    /**
     * Valida que la concentracion de gas este entre 0 y 100.
     *
     * @param concentracion Valor a validar
     * @throws IllegalArgumentException si esta fuera del rango permitido
     */
    private void validarConcentracion(int concentracion) {
        if (concentracion < 0 || concentracion > 100) {
            throw new IllegalArgumentException("La concentracion debe estar entre 0 y 100.");
        }
    }

    @Override
    public String getDescripcion() {
        return ", edificiosAfectados=" + getEdificiosAfectados()
                + ", concentracionDetectada=" + concentracion + ".0%";

    }

    @Override
    public String evacuar() {
        return "Se ordeno la evacuacion por escape de gas "
                + getCodigo() + " en " + getZona()
                + ". Concentracion detectada: " + concentracion + "%.";
    }
}
