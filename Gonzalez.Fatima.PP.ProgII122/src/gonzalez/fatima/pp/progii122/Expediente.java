package gonzalez.fatima.pp.progii122;

import java.util.Objects;

/**
 * Representa un Expediente generico.
 */
public abstract class Expediente {

    private final String codigo;
    private final String agenteSecreto;
    private final NivelSecreto nivelSecreto;

    /**
     * Estructura basica de un expediente.
     *
     * @param codigo Identificador unico de Expediente
     * @param agenteSecreto Nombre del agente a cargo
     * @param nivelSecreto Nivel de clasificacion del expediente.
     *@throws IllegalArgumentException si algún parámetro esta vacío
     *@throws NullPointerException si algun parametro es nulo
     */
    public Expediente(String codigo, String agenteSecreto, NivelSecreto nivelSecreto) {
        validarString(codigo, "El codigo no puede ser nulo o vacio");
        validarString(agenteSecreto, "El Agente Secreto no puede ser nulo o vacio");
        this.codigo = codigo;
        this.agenteSecreto = agenteSecreto;
        validarNivel(nivelSecreto);
        this.nivelSecreto = nivelSecreto;
    }

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
     * Valida que un nivel no sea nulo.
     *
     * @param nivelSecreto Tipo de Nivel Secreto
     * @throws NullPointerException si el nivel secreto es nulo
     */
    private void validarNivel(NivelSecreto nivelSecreto) {
        Objects.requireNonNull(nivelSecreto, "El nivel secreto no puede ser nulo");
    }

    /**
     * Devuelve el nivel secreto del expediente.
     *
     * @return Una opcion de nivel secreto.
     */
    public NivelSecreto getNivelSecreto() {
        return nivelSecreto;
    }

    /**
     * Devuelve el codigo del expediente.
     *
     * @return Un String con el codigo.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Devuelve el agente encargado del expediente.
     *
     * @return Un String con el Agente.
     */
    public String getAgenteSecreto() {
        return agenteSecreto;
    }

    /**
     * Devuelve una descripcion de los atributos propios de la subclase.
     *
     * @return Un String con los atributos.
     */
    public abstract String getDescripcion();

    /**
     * Genera una cadena con los atributos del Expediente.
     *
     * @return Una cadena de atributos.
     */
    @Override
    public String toString() {
        String nombreSimple = getClass().getSimpleName();
        return nombreSimple
                + "[ codigo=" + codigo
                + ", agente=" + agenteSecreto
                + ", nivelSecreto=" + nivelSecreto + ','
                + getDescripcion() + ']';
    }

    /**
     * Compara dos objetos e identifica si son iguales por tipo agente secreto y
     * codigo
     *
     * @param obj El objeto a comparar con este Expediente.
     * @return True si son iguales, False si no lo son.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Expediente e)) {
            return false;
        }
        return agenteSecreto.equals(e.agenteSecreto)
                && codigo.equals(e.codigo);
    }

    /**
     * Calcula el hashcode basado en codigo y agenteSecreto.
     *
     * @return un hashcode
     */

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        hash = 37 * hash + Objects.hashCode(this.agenteSecreto);
        return hash;
    }

}
