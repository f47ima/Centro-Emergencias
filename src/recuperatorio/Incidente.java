package recuperatorio;

import java.util.Objects;

/**
 * Representa un Incidente generico.
 *
 */

public abstract class Incidente {

    private final String codigo;
    private final String zona;
    private final NivelPrioridad prioridad;

    public Incidente(String codigo, String zona, NivelPrioridad prioridad) {
        validarString(codigo, "El codigo no puede ser nulo ni estar vacio.");
        validarString(zona, "La zona no puede ser nulo ni estar vacio.");
        this.codigo = codigo;
        this.zona = zona;
        validarNivel(prioridad);
        this.prioridad = prioridad;
    }

    /**
     * Consulte por la validacion del formato del codigo y se me dijo que no era
     * necesario. Por eso solo valide que no sea nulo o este vacio 9:35 hs
     */
    /**
     * Valida que una cadena no sea nula ni este vacia.
     *
     * @param cadena Parametro a validar
     * @param mensaje Mensaje para los metodos internos de la funcion.
     */
    protected static void validarString(String cadena, String mensaje) {
        Objects.requireNonNull(cadena, mensaje);
        if (cadena.isEmpty()) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    /**
     * Valida que la priridad no sea nula.
     *
     * @param prioridad Tipo de prioridad
     * @throws NullPointerException si la prioridad es nula
     */
    private void validarNivel(NivelPrioridad prioridad) {
        Objects.requireNonNull(prioridad, "El nivel de prioridad no puede ser nula");
    }

    /**
     * Devuelve una descripcion de los atributos propios de la subclase.
     *
     * @return Un String con los atributos.
     */
    public abstract String getDescripcion();

    /**
     * Genera una cadena con los atributos del Incidente.
     *
     * @return Una cadena de atributos.
     */
    @Override
    public String toString() {
        String nombreSimple = getClass().getSimpleName();
        return nombreSimple
                + "[ codigo=" + codigo
                + ", zona=" + zona
                + ", prioridad=" + prioridad + ','
                + getDescripcion() + ']';
    }

    /**
     * Compara dos objetos e identifica si son iguales por la zona donde ocurren
     * y su codigo
     *
     * @param obj El objeto a comparar con este Indicente.
     * @return True si son iguales, False si no lo son.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Incidente i)) {
            return false;
        }
        return zona.equals(i.zona)
                && codigo.equals(i.codigo);
    }

    /**
     * Calcula el hashcode basado en codigo y zona.
     *
     * @return un hashcode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.codigo);
        hash = 53 * hash + Objects.hashCode(this.zona);
        return hash;
    }

    /**
     * Devuelve el codigo del incidente.
     *
     * @return Un String con el codigo.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Devuelve la zona del incidente
     *
     * @return Un String con la zona.
     */
    public String getZona() {
        return zona;
    }

    /**
     * Devuelvela prioridad del incidente.
     *
     * @return Una opcion de nivel de prioridad.
     */

    public NivelPrioridad getPrioridad() {
        return prioridad;
    }

}
