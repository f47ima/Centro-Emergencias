package gonzalez.fatima.pp.progii122;

import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        ArchivoSecreto archivo = new ArchivoSecreto("Boveda 51");
        try {
            archivo.agregarExpediente(
                    new AvistamientoAereo("UAP-001", "Agente Fox", NivelSecreto.ALTO,
                            "Desierto de Nevada")
            );
            archivo.agregarExpediente(
                    new RegistroRadar("RAD-777", "Agente Dana", NivelSecreto.MEDIO,
                            12500)
            );
            archivo.agregarExpediente(
                    new TestimonioClasificado("TEST-404", "Agente Skinner",
                            NivelSecreto.BAJO, "Testigo Orion")
            );
            archivo.agregarExpediente(
                    new RegistroRadar("RAD-999", "Agente Fox", NivelSecreto.ALTO,
                            18300)
            );
            archivo.agregarExpediente(
                    new AvistamientoAereo("UAP-001", "Agente Fox", NivelSecreto.MEDIO,
                            "Roswell")
            );
        } catch (ExpedienteDuplicadoException e) {
            System.out.println("No se pudo agregar el expediente: " + e.getMessage());
        }
        System.out.println("Expedientes registrados:");
        mostrarExpedientes(archivo.obtenerExpedientes());
        System.out.println();
        System.out.println("Expedientes analizables:");
        analizarExpedientes(archivo.obtenerExpedientes());
        System.out.println();
        System.out.println("Reportes generados:");
        generarReportes(archivo.obtenerExpedientes());
        System.out.println();
        System.out.println("Expedientes de nivel ALTO:");
        mostrarExpedientes(archivo.filtrarPorNivel(NivelSecreto.ALTO));
    }

    private static void mostrarExpedientes(List<Expediente> expedientes) {
        Objects.requireNonNull(expedientes);
        StringBuilder sb = new StringBuilder();
        for (Expediente e : expedientes) {
            sb.append(e);
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());

    }

    private static void analizarExpedientes(List<Expediente> expedientes) {
        Objects.requireNonNull(expedientes);
        for (Expediente e : expedientes) {
            if (e instanceof Analizables a) {
                System.out.println(a.analizar());
            } else {
                System.out.println("El expediente '" + e.getCodigo() + "' no puede analizarse.");
            }
        }
    }

    private static void generarReportes(List<Expediente> expedientes) {
        Objects.requireNonNull(expedientes);
        for (Expediente e : expedientes) {
            if (e instanceof Reportables r) {
                System.out.println(r.reportar());
            } else {
                System.out.println("El expediente '" + e.getCodigo() + "' no genera reporte.");
            }
        }
    }

}
