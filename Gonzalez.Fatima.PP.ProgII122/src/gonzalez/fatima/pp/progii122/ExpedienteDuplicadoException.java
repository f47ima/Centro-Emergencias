package gonzalez.fatima.pp.progii122;

/**
 * Excepción lanzada cuando se intenta agregar un expediente que ya existe en el
 * sistema.
 */
public class ExpedienteDuplicadoException extends Exception {

    /**
     * Mensaje de error por defecto.
     */
    public static String MESSAGE = "Expediente Duplicado";

    /**
     * Construye una nueva excepción con el mensaje por defecto.
     */
    public ExpedienteDuplicadoException() {
        this(MESSAGE);
    }

    /**
     * Construye una nueva excepción con un mensaje personalizado.
     * @param mensaje Detalle específico sobre el motivo de la excepción
     */
    public ExpedienteDuplicadoException(String mensaje) {
        super(mensaje);
    }

}
