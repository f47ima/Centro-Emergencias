package recuperatorio;

/**
 * Representa un incidente de estructura.
 */
public abstract class IncidentesDeEstructura extends Incidente implements Reparables {

    private final int edificiosAfectados;

    /**
     * Crea un nuevo incidente de estructura.
     *
     * @param codigo Identificador unico del incidente
     * @param zona Zona donde ocurrio
     * @param prioridad Nivel de Prioridad del incidente
     * @param edificiosAfectados Cantidad de edificios afectatos
     * @throws IllegalArgumentException si algún parámetro esta vacío
     * @throws NullPointerException si algun parametro es nulo
     * @throws IllegalArgumentException si la cantidad de edficios afectados es
     * menor o igual a cero.
     */
    public IncidentesDeEstructura(String codigo, String zona, NivelPrioridad prioridad, int edificiosAfectados) {
        super(codigo, zona, prioridad);
        validarEntero(edificiosAfectados, "La cantidad de edificios afectados debe ser mayor a cero.");
        this.edificiosAfectados = edificiosAfectados;
    }

    /**
     * Valida que el entero sea mayor a 0
     *
     * @param entero Cantidad 
     * incidente.
     * @param  mensaje Cadena con aviso 
     * @throws IllegalArgumentException si la cantidad es menor o igual a cero.
     */
    protected static void validarEntero(int entero, String mensaje) {
        if (entero <= 0) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    /**
     * Inicia el proceso de reparación del incidente actual, detallando su
     * código, la zona donde ocurre y el número de edificios que se ven
     * afectados.
     *
     * * @return Una cadena de texto con el reporte del inicio de la
     * reparación.
     */

    @Override
    public String reparar() {
        return "Se inicio la reparacion del incidente " + getCodigo() + " en " + getZona() + ". Edificios afectados: " + edificiosAfectados;
    }

    public int getEdificiosAfectados() {
        return edificiosAfectados;
    }



}
