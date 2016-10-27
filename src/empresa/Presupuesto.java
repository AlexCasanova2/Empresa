package empresa;

public class Presupuesto {

    private Integer num;
    private String concepto;
    private Integer precio_neto;
    private String estado;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Integer getPrecio_neto() {
        return precio_neto;
    }

    public void setPrecio_neto(Integer precio_neto) {
        this.precio_neto = precio_neto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Presupuesto(Integer num, String concepto, Integer precio_neto, String estado) {
        this.num = num;
        this.concepto = concepto;
        this.precio_neto = precio_neto;
        this.estado = estado;
    }
    
    public Presupuesto(){
        
    }
    
    
    
}
