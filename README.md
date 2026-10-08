# Centro de Emergencias

Aplicación de consola en Java que gestiona los incidentes de un centro de emergencias urbano: fallas eléctricas, escapes de gas y alertas meteorológicas.

> Trabajo realizado para Programación II de la Tecnicatura en Programación de la Universidad Tecnológica Nacional (UTN).

## Qué hace

Un `CentroEmergencias` (en el ejemplo, "Central Metropolitana") registra incidentes de tres tipos. Permite:

- Agregar incidentes. No se aceptan duplicados: dos incidentes son iguales si tienen el mismo código y la misma zona.
- Listar todos los incidentes registrados.
- Filtrar los incidentes por prioridad (`BAJA`, `MEDIA` o `ALTA`).
- Iniciar la reparación y ordenar la evacuación de los incidentes que lo permiten.

| Tipo de incidente | Dato propio | Se puede reparar | Se puede evacuar |
|---|---|---|---|
| `FallaElectrica` | Potencia interrumpida (kW) | Sí | No |
| `EscapeDeGas` | Concentración detectada (0–100 %) | Sí | Sí |
| `AlertaMeteorologica` | Fenómeno observado | No | Sí |

## Conceptos de POO aplicados

- **Clases abstractas:** `Incidente` define los datos comunes (código, zona y prioridad) y obliga a las subclases a implementar `getDescripcion()`. `IncidentesDeEstructura` agrega los edificios afectados y es la base de `FallaElectrica` y `EscapeDeGas`.
- **Herencia e interfaces:** los incidentes se combinan con las interfaces `Reparables` y `Evacuables` según lo que pueden hacer.
- **Polimorfismo:** `Main` recorre una lista de `Incidente` y decide con `instanceof` cuáles se pueden reparar o evacuar.
- **Enum:** `NivelPrioridad` representa la prioridad de cada incidente.
- **Excepción propia:** `IncidenteDuplicadoException` se lanza al intentar agregar un incidente repetido.
- **Encapsulamiento:** `obtenerIncidentes()` devuelve una copia de la lista, y `equals`/`hashCode` se basan en zona y código.

## Cómo ejecutarlo

Requiere **Java 17 o superior** (probado con JDK 21). Desde la carpeta del repositorio:

```bash
javac -d out src/centroemergencias/*.java
java -cp out centroemergencias.Main
```

También se puede abrir la carpeta del proyecto en un IDE como NetBeans o IntelliJ y ejecutar la clase `Main`.

## Ejemplo de salida

```
No se pudo agregar el incidente: Ya existe un incidente con codigo 'INC-101' en la 'Zona Norte'.
Incidentes registrados:
FallaElectrica[ codigo=INC-101, zona=Zona Norte, prioridad=ALTA, edificiosAfectados=8, potenciaInterrumpida=450.0 kW]
EscapeDeGas[ codigo=INC-205, zona=Zona Sur, prioridad=MEDIA,, edificiosAfectados=3, concentracionDetectada=75.0%]
AlertaMeteorologica[ codigo=INC-308, zona=Zona Oeste, prioridad=BAJA, fenomenoObservado=Vientos intensos]
EscapeDeGas[ codigo=INC-410, zona=Zona Centro, prioridad=ALTA,, edificiosAfectados=6, concentracionDetectada=92.0%]


Se inicio la reparacion del incidente INC-101 en Zona Norte. Edificios afectados: 8
Se inicio la reparacion del incidente INC-205 en Zona Sur. Edificios afectados: 3
El incidente 'INC-308' no puede repararse.
Se inicio la reparacion del incidente INC-410 en Zona Centro. Edificios afectados: 6
Cantidad de incidentes reparables: 3

El incidente 'INC-101' no requiere evacuacion.
Se ordeno la evacuacion por escape de gas INC-205 en Zona Sur. Concentracion detectada: 75%.
Se ordeno la evacuacion por alerta meteorologica INC-308 en Zona Oeste. Fenomeno: Vientos intensos.
Se ordeno la evacuacion por escape de gas INC-410 en Zona Centro. Concentracion detectada: 92%.
Cantidad de evacuaciones ordenadas: 3

Incidentes de prioridad ALTA:
FallaElectrica[ codigo=INC-101, zona=Zona Norte, prioridad=ALTA, edificiosAfectados=8, potenciaInterrumpida=450.0 kW]
EscapeDeGas[ codigo=INC-410, zona=Zona Centro, prioridad=ALTA,, edificiosAfectados=6, concentracionDetectada=92.0%]

```

La primera línea corresponde al intento de agregar por segunda vez el incidente `INC-101` de la Zona Norte.

## Estructura del proyecto

```
src/centroemergencias/
├── Main.java
├── CentroEmergencias.java
├── Incidente.java
├── IncidentesDeEstructura.java
├── FallaElectrica.java
├── EscapeDeGas.java
├── AlertaMeteorologica.java
├── NivelPrioridad.java
├── Reparables.java
├── Evacuables.java
└── IncidenteDuplicadoException.java
```

El diagrama de clases está en [UML_CentroEmergencias.pdf](UML_CentroEmergencias.pdf).

## Tecnologías

- Java
