package recuperatorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa una claseLista que cuenta con una incidentes con un conjunto de
 * elementos.
 *
 */
public class CentroEmergencias {

    private final List<Incidente> incidentes;
    private final String nombre;

    /**
     * Crea una claseLsita
     *
     * @param nombre Nombre de la claseLista
     */
    public CentroEmergencias(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
        incidentes = new ArrayList<>();
    }

    /**
     * Valida que el nombre no este vacio o sea un nulo.
     *
     * @param nombre Recibe un String con el nombre de la
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
     * Agrega un objeto a incidentes
     *
     * @param incidente Recibe un Incidente
     * @throws IncidenteDuplicadoException si el incidente esta duplicado
     * @throws NullPointerException si es un incidente nulo
     */
    public void agregarIncidente(Incidente incidente) throws IncidenteDuplicadoException {
        Objects.requireNonNull(incidente, "Incidente Nulo");
        validarIncidenteDuplicado(incidente);
        incidentes.add(incidente);
    }

    /**
     * Valida que un objeto no esta duplicado o sea nulo
     *
     * @param expediente Recibe un objeto
     * @throws ExpedienteDuplicadoException si el objeto esta duplicado
     * @throws NullPointerException si es un objeto nulo
     */
    private void validarIncidenteDuplicado(Incidente incidente) throws IncidenteDuplicadoException {
        if (incidentes.contains(incidente)) {
            throw new IncidenteDuplicadoException("No se pudo agregar el incidente: Ya existe un incidente con codigo '"
                    + incidente.getCodigo() + "' en la '" + incidente.getZona() + "'.");
        }
    }

    /**
     * Genera y retorna una copia superficial de la incidentes de los objetos
     *
     * @return copia superficial de la incidentes de los objetos
     */
    public List<Incidente> obtenerIncidentes() {
        return new ArrayList<>(incidentes);
    }

    /**
     * Filtra los incidentes segun el nivel de prioridad recibido.
     *
     * @param prioridad Nivel de prioridad a filtrar
     * @return Lista con los incidentes de ese nivel, o vacia si no hay ninguno
     */
    public List<Incidente> filtrarPorPrioridad(NivelPrioridad prioridad) {
        List<Incidente> resultado = new ArrayList<>();
        for (Incidente i : incidentes) {
            if (i.getPrioridad() == prioridad) {
                resultado.add(i);
            }
        }
        return resultado;
    }

}
