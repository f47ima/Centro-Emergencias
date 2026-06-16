package gonzalez.fatima.pp.progii122;

/**
 * Representa un Testigo clasificado. 
 * Extiende de Expediente e implementa Reportables.
 *
 */
public class TestimonioClasificado extends Expediente implements Reportables {

    private final String claveTestigo;

    /**
     * Crea un nuevo testimonio clasificado.
     *
     * @param codigo Identificador unico de Expediente
     * @param agenteSecreto Nombre del agente a cargo
     * @param nivelSecreto Nivel de clasificacion del expediente.
     * @param claveTestigo Nombre clave del testigo.
     * @throws IllegalArgumentException si algún parámetro esta vacío
     * @throws NullPointerException si algun parametro es nulo
     */
    public TestimonioClasificado(String codigo, String agenteSecreto, NivelSecreto nivelSecreto, String claveTestigo) {
        super(codigo, agenteSecreto, nivelSecreto);
        validarString(claveTestigo, "La clave del testigo no puede ser nula o estar vacia.");
        this.claveTestigo = claveTestigo;
    }

    /**
     * Devuelve un mensaje avisando que se registro un testigo junto a su codigo
     * y su nombre clave.
     *
     * @return Retorna un String con el mensaje, el codigo y el nombre clave del
     * testigo.
     */
    @Override
    public String reportar() {
        return "Reporte de testimonio clasificado : " + getCodigo() + " Nombre clave del testigo: " + claveTestigo + ".";
    }

    /**
     * Genera un mensaje con el atributo especifico de esta clase.
     *
     * @return Devuelve un String con la definicion del atributo y su valor.
     */

    @Override
    public String getDescripcion() {
        return " nombreClaveTestigo=" + claveTestigo;
    }

}
