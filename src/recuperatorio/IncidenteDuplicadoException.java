package recuperatorio;

/**
 * Excepción lanzada cuando se intenta agregar un objeto que ya existe en el
 * sistema.
 */
public class IncidenteDuplicadoException extends Exception {

    /**
     * Mensaje de error por defecto.
     */
    public static String MESSAGE = "Incidente Duplicado";

    /**
     * Construye una nueva excepción con el mensaje por defecto.
     */
    public IncidenteDuplicadoException() {
        this(MESSAGE);
    }

    /**
     * Construye una nueva excepción con un mensaje personalizado.
     * @param mensaje Detalle específico sobre el motivo de la excepción
     */
    public IncidenteDuplicadoException(String mensaje) {
        super(mensaje);
    }

}
