package empresa;

import java.util.ArrayList;

public class Lista_presupuesto {
    
    private ArrayList<Presupuesto> lista_presupuesto;
    
    public Lista_presupuesto(){
        lista_presupuesto= new ArrayList<>();
    }

    public void regisPresupuesto(Presupuesto c){
        lista_presupuesto.add(c);
        
    }
    public ArrayList<Presupuesto> getPresupuesto() {
        return lista_presupuesto;
    }

    public void setPresupuesto(ArrayList<Presupuesto> presupuesto) {
        this.lista_presupuesto = presupuesto;
    }

    public Lista_presupuesto(ArrayList<Presupuesto> lista_presupuesto) {
        this.lista_presupuesto = lista_presupuesto;
    }
    
    public boolean lispres(String estado){
        for(Presupuesto presupuesto : lista_presupuesto){
            if(presupuesto.getEstado().equals(estado)){
                return true;
            }
        }
        return false;
    }
    
    
}
