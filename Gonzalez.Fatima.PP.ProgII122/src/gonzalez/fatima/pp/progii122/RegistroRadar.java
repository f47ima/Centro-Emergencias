package gonzalez.fatima.pp.progii122;

/**
 * Representa un Registro de radar. Extiende de Expediente e implementa
 * Analizables y Reportables
 *
 */
public class RegistroRadar extends Expediente implements Reportables, Analizables {

    private final int altitudDetectada;

    /**
     * Crea un nuevo registro de radar.
     *
     * @param codigo Identificador unico de Expediente
     * @param agenteSecreto Nombre del agente a cargo
     * @param nivelSecreto Nivel de clasificacion del expediente.
     * @param altitudDetectada A que nivel de altura se registro el radar
     * @throws IllegalArgumentException si algún parámetro esta vacío
     * @throws NullPointerException si algun parametro es nulo
     */
    public RegistroRadar(String codigo, String agenteSecreto, NivelSecreto nivelSecreto, int altitudDetectada) {
        super(codigo, agenteSecreto, nivelSecreto);
        validarAltitud(altitudDetectada);
        this.altitudDetectada = altitudDetectada;
    }
    
    /**
     * Valida que el parametro para altitud detectada sea mayor a 0
     * 
     * @param altitud A que nivel de altura se registro el radar
     */

    private void validarAltitud(int altitud) {
        if (altitud <= 0) {
            throw new IllegalArgumentException("La altitud debe ser mayor a 0.");
        }
    }

    /**
     * Devuelve un mensaje avisando que se registro un radar junto a su codigo y
     * a que altitud.
     *
     * @return Retorna un String con el mensaje, el codigo y la altitud.
     */
    @Override
    public String reportar() {
        return "Reporte de radar: " + getCodigo() + ". Altitud detectada: " + altitudDetectada + " metros.";
    }

    /**
     * Devuelve un mensaje avisando que se analizo un registro junto a su
     * codigo.
     *
     * @return Retorna un String con el mensaje y el codigo.
     */
    @Override
    public String analizar() {
        return "Se analizo el registro de radar: " + getCodigo();
    }

    /**
     * Genera un mensaje con el atributo especifico de esta clase.
     *
     * @return Devuelve un String con la definicion del atributo y su valor.
     */

    @Override
    public String getDescripcion() {
        return " altitudDetectada=" + altitudDetectada;
    }

}
