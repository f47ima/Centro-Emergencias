package recuperatorio;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CentroEmergencias centro = new CentroEmergencias("Central Metropolitana");
        try {
            centro.agregarIncidente(
                    new FallaElectrica("INC-101", "Zona Norte", NivelPrioridad.ALTA, 8, 450));
            centro.agregarIncidente(
                    new EscapeDeGas("INC-205", "Zona Sur", NivelPrioridad.MEDIA, 3, 75));
            centro.agregarIncidente(
                    new AlertaMeteorologica("INC-308", "Zona Oeste", NivelPrioridad.BAJA,
                            "Vientos intensos"));
            centro.agregarIncidente(
                    new EscapeDeGas("INC-410", "Zona Centro", NivelPrioridad.ALTA, 6, 92));
            // Incidente repetido: mismo código y misma zona.
            centro.agregarIncidente(
                    new FallaElectrica("INC-101", "Zona Norte", NivelPrioridad.MEDIA, 2, 150));
        } catch (IncidenteDuplicadoException e) {
            System.out.println("No se pudo agregar el incidente: " + e.getMessage());
        }
        System.out.println("Incidentes registrados:");
        mostrarIncidentes(centro.obtenerIncidentes());
        System.out.println();
        int reparables = repararIncidentes(centro.obtenerIncidentes());
        System.out.println("Cantidad de incidentes reparables: " + reparables);
        System.out.println();
        int evacuaciones = ordenarEvacuaciones(centro.obtenerIncidentes());
        System.out.println("Cantidad de evacuaciones ordenadas: " + evacuaciones);
        System.out.println();
        System.out.println("Incidentes de prioridad ALTA:");
        mostrarIncidentes(centro.filtrarPorPrioridad(NivelPrioridad.ALTA));
    }

    private static void mostrarIncidentes(List<Incidente> incidentes) {
        StringBuilder sb = new StringBuilder();
        for (Incidente i : incidentes) {
            sb.append(i);
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    private static int repararIncidentes(List<Incidente> incidentes) {
        int contador = 0;
        for (Incidente i : incidentes) {
            if (i instanceof Reparables r) {
                System.out.println(r.reparar());
                contador++;
            } else {
                System.out.println("El incidente '" + i.getCodigo() + "' no puede repararse.");
            }
        }
        return contador;
    }

    private static int ordenarEvacuaciones(List<Incidente> incidentes) {
        int contador = 0;
        for (Incidente i : incidentes) {
            if (i instanceof Evacuables e) {
                System.out.println(e.evacuar());
                contador++;
            } else {
                System.out.println("El incidente '" + i.getCodigo() + "' no requiere evacuacion.");
            }
        }
        return contador;
    }
}
