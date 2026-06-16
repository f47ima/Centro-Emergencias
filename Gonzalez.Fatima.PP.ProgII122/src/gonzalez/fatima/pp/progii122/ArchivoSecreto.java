package gonzalez.fatima.pp.progii122;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa un Archivo secreto que cuenta con un conjunto de Expedientes.
 */
public class ArchivoSecreto {

    private final List<Expediente> expedientes;
    private final String nombre;

    /**
     * Crea un Archivo secreto.
     *
     * @param nombre Nombre del archivo
     * @throws IllegalArgumentException si el nombre esta vacio
     * @throws NullPointerException si el nombre es nulo
     */
    public ArchivoSecreto(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
        expedientes = new ArrayList<>();
    }

    /**
     * Valida que el nombre no este vacio o sea un nulo.
     *
     * @param nombre Nombre del archivo
     * @throws IllegalArgumentException si el nombre esta vacio
     * @throws NullPointerException si el nombre es nulo
     */
    private void validarNombre(String nombre) {
        Objects.requireNonNull(nombre, "El nombre no puede ser nulo.");
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }
    }

    /**
     * Agrega un expediente al archivo
     *
     * @param expediente Expediente a agregar
     * @throws ExpedienteDuplicadoException si el expediente esta duplicado
     * @throws NullPointerException si es un expediente nulo
     */

    public void agregarExpediente(Expediente expediente) throws ExpedienteDuplicadoException {
        Objects.requireNonNull(expediente, "Expediente Nulo");
        validarExpedienteDuplicado(expediente);
        expedientes.add(expediente);
    }

    /**
     * Valida que un Expediente no esta duplicado o sea nulo
     *
     * @param expediente Recibe un expediente
     * @throws ExpedienteDuplicadoException si el expediente esta duplicado
     */
    private void validarExpedienteDuplicado(Expediente expediente) throws ExpedienteDuplicadoException {
        if (expedientes.contains(expediente)) {
            throw new ExpedienteDuplicadoException("No se pudo agregar el expediente: Ya existe un expediente con codigo '"
                    + expediente.getCodigo() + "' y agente '" + expediente.getAgenteSecreto() + "'.");
        }
    }
    /**
     * Genera y retorna una copia de la lista de los expedientes
     * @return copia de la lista de los expedientes
     */

    public List<Expediente> obtenerExpedientes() {
        return new ArrayList<>(expedientes);
    }

    /**
     * Filtra los expedientes segun el Nivel secreto recibido
     * @param nivelSecreto Recibe el tipo de nivel secreto a filtrar
     * @return Una lista vacia si no hay expedientes de ese tipo o Una lista con todos los expedientes de ese tipo
     */
    public List<Expediente> filtrarPorNivel(NivelSecreto nivelSecreto) {
        List<Expediente> privacidadExpedientes = new ArrayList<>();
        for (Expediente e : expedientes) {
            if (e.getNivelSecreto() == nivelSecreto) {
                privacidadExpedientes.add(e);
            }
        }
        return privacidadExpedientes;
    }

}
