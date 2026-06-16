package gonzalez.fatima.pp.progii122;

/**
 * Representa un avistamiento aereo no identificado. Extiende Expediente e
 * implementa Analizables.
 *
 */
public class AvistamientoAereo extends Expediente implements Analizables {

    private final String ubicacion;

    /**
     * Crea un nuevo avistamiento Aereo.
     *
     * @param codigo Identificador unico de Expediente
     * @param agenteSecreto Nombre del agente a cargo
     * @param nivelSecreto Nivel de clasificacion del expediente.
     * @param ubicacion Lugar donde ocurrio el avistamiento
     * @throws IllegalArgumentException si algún parámetro esta vacío
     * @throws NullPointerException si algun parametro es nulo
     */

    public AvistamientoAereo(String codigo, String agenteSecreto, NivelSecreto nivelSecreto, String ubicacion) {
        super(codigo, agenteSecreto, nivelSecreto);
        validarString(ubicacion, "La ubicacion no puede ser nula o estar vacia");
        this.ubicacion = ubicacion;
    }

    /**
     * Devuelve un mensaje avisando que se analizo un avistamiento junto a su
     * codigo.
     *
     * @return Retorna un String con el mensaje y el codigo.
     */

    @Override
    public String analizar() {
        return "Se analizo el avistamiento aereo: " + getCodigo();
    }

    /**
     * Genera un mensaje con el atributo especifico de esta clase.
     *
     * @return Devuelve un String con la definicion del atributo y su valor.
     */
    @Override
    public String getDescripcion() {
        return " Ubicacion=" + ubicacion;
    }

}
