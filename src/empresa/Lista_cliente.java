package empresa;

import java.io.Serializable;
import java.util.ArrayList;

public class Lista_cliente implements Serializable{

    private ArrayList<Cliente> lista_cliente;

    public Lista_cliente() {
        lista_cliente = new ArrayList<>();
    }
    public void regisCliente (Cliente p){
        lista_cliente.add(p);
    }
    
    public Cliente encontrar(String telefono) {
        for(Cliente cliente : lista_cliente) {
            if (cliente.getTelefono().equals(telefono)) {
                return cliente;
            }
        }
      return null;
    }

    public ArrayList<Cliente> getLista_cliente() {
        return lista_cliente;
    }

    public void setLista_cliente(ArrayList<Cliente> lista_cliente) {
        this.lista_cliente = lista_cliente;
    }
    
}
