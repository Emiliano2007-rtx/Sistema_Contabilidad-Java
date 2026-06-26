# Sistema_Contabilidad-Java
Sistema Financiero en Java (En desarrollo)
Actualmente tiene:

- Generacion de Balance General
- Pequeña GUI con la clase swing
- Exporta los resultados a un .txt y guarda en una carpeta

# Update: Actualizacion simple:
- Se agrego metodo PedirDatos();
- Se optimizo el codigo al usar el metodo evitando escribir lo mismo para capturar los datos del Balance tanto como del Estado

# Update: Actualizacion del Menu y Clase Estado:  
Se modifico en el menu lo siguiente:
- Se agrego condicional para distingir cuentas del Balance y Estado
- Otro condicional para decidir que cuentas usara el objeto para crearse dependiendo de lo elegido por el usuario
- Manda las cuentas del Estado a la clase Estado
  
Clase Estado:
- Se creo la clase Estado
- Por ahora solo tiene los metodos para guardar las cuentas, el metodo para pedir la fecha y el metodo CalcularEstado();
- Esta listo para comenzar con las formulas y calculos

# Update del 23 de mayo de 2026:
- Se desarrolló pendiente "Estado de Resultados". Resultado en "reportes/EstadoResultados.txt"

# Update 26 Mayo 2026 : Edición y eliminación de cuentas
- Se implementó un menú para editar cuentas en balance general y estado de resultados, así como eliminación de los mismos. Al detectar errores en la edición del archivo, se descartó la primera versión del editado.
- El menú de edición se habilita sólo si se detecta la existencia de archivos de balance y/o estados.
