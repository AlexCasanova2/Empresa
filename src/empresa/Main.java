package empresa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import tools.Fichero;
import tools.InputData;

public class Main {

    private static Lista_cliente misClientes;
//    private static Lista_presupuesto misPresupuestos;

    private static Fichero miFichero;

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        miFichero = new Fichero("clientes.xml");
        misClientes = (Lista_cliente) miFichero.leer();
        if (misClientes == null) {
            misClientes = new Lista_cliente();
        }
        int opcion;
        do {
            mostrarMenu();
            opcion = InputData.pedirEntero("Escoge una opción");
            switch (opcion) {
                case 1:
                    altaCliente();
                    break;
                case 2:
                    nuevoPresupuesto();
                    break;
                case 3:
                    lispre();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        } while (opcion != 8);
    }

    public static void lispre() {

        
    }

    public static void nuevoPresupuesto() {
        String telefono = InputData.pedirCadena("¿A que cliente quieres añadir el presupuesto?");
        Cliente c = misClientes.encontrar(telefono);
        if (c != null) {
            int num = pedirEntero("Num presupuesto");
            String concepto = InputData.pedirCadena("Concepto: ");
            int precio_neto = pedirEntero("Precio neto");
            String estado = InputData.pedirCadena("Estado: ");
            
            Presupuesto p = new Presupuesto(num, concepto, precio_neto, estado);
            // Añades el presupuesto al cliente
            c.getPresupuestos().regisPresupuesto(p);
            miFichero.grabar(misClientes);
        }
        else{
             String res = InputData.pedirCadena("El usuario no existe, ¿Quieres crearlo?");
            if(res.equalsIgnoreCase("Si")){
                altaCliente();
            }else if(res.equalsIgnoreCase("No")){
                mostrarMenu();
            } else{
                System.out.println("Debes responder Si o No");
            }
        }
    }

    public static void altaCliente() {
        String nombre = InputData.pedirCadena("Nombre: ");
        String apellido = InputData.pedirCadena("Apellido: ");
        String telefono = InputData.pedirCadena("Telefono: ");

        String respuesta;
        boolean vip = false;
        do {
            respuesta = InputData.pedirCadena("¿Eres miembro VIP?");
            if (respuesta.equalsIgnoreCase("SI")) {
                vip = true;
            } else if (respuesta.equalsIgnoreCase("NO")) {
                vip = false;
            } else {
                System.out.println("Debes responder SI o NO");
            }
        } while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no"));

        Cliente c = new Cliente(nombre, apellido, telefono, vip);
        misClientes.regisCliente(c);
        miFichero.grabar(misClientes);
    }

    private static int pedirEntero(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numero = 0;
        boolean error;
        do {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error entrada salida");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("No has introducido un nº entero.");
                error = true;
            }
        } while (error); 
        return numero;
    }

    private static String cadenaNoVacia(String msg) {
        String cadena;
        do {
            cadena = InputData.pedirCadena(msg);
            if (cadena.equals("")) {
                System.out.println("No se puede dejar en blanco");
            }
        } while (cadena.equals(""));
        return cadena;
    }

    public static void mostrarMenu() {
        System.out.println("MENU");
        System.out.println("1. Alta Cliente");
        System.out.println("2. Nuevo presupuesto");
        System.out.println("3. Presupuestos pendientes");
        System.out.println("4. Listado de presupuestos de un cliente en concreto");
        System.out.println("5. Listado de presopuestos rechazados");
        System.out.println("6. Listado de clientes,con  el total de presupuestos que tiene cada uno");
        System.out.println("7.Cambiar estado de ");
        System.out.println("8. Salir esto de presupuesto");
    }

}
