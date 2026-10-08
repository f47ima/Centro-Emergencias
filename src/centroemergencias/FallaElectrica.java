package centroemergencias;

public class FallaElectrica extends IncidentesDeEstructura {

    private int potenciaInterrumpida;

    /**
     * Crea una nueva falla eléctrica y valida que la potencia no sea negativa.
     *
     * @param codigo Identificador unico del incidente
     * @param zona Zona donde ocurrio
     * @param prioridad Nivel de Prioridad del incidente
     * @param edificiosAfectados Cantidad de edificios afectatos
     * @param potenciaInterrumpida Registran la potencia interrumpida, expresada
     * en kilovatios(entero).
     * @throws IllegalArgumentException si algún parámetro esta vacío
     * @throws NullPointerException si algun parametro es nulo
     * @throws IllegalArgumentException si la cantidad de edficios afectados es
     * menor o igual a cero.
     * @throws IllegalArgumentException Si la potencia es negativa.
     */
    public FallaElectrica(String codigo, String zona, NivelPrioridad prioridad, int edificiosAfectados, int potenciaInterrumpida) {
        super(codigo, zona, prioridad, edificiosAfectados);
        validarEntero(potenciaInterrumpida,"La potencia interrumpida no puede ser negativa.");
        this.potenciaInterrumpida = potenciaInterrumpida;
    }

    /**
     * Obtiene una descripcion de la cantidad de edifcios afectados y cual fue la potencia interrumpida
     * * @return Una cadena de texto con la cantidad de edificios afectados.
     */
    @Override
    public String getDescripcion() {
        return " edificiosAfectados=" + getEdificiosAfectados() 
               + ", potenciaInterrumpida=" + potenciaInterrumpida + ".0 kW";
    }
}
