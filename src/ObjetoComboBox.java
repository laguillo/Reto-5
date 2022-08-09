public class ObjetoComboBox {
 
    
    String Valor="";
    String Texto="";
    
    public ObjetoComboBox(String Valor, String Texto){
        this.Texto=Texto;
        this.Valor=Valor;
    
    }
    public String toString(){
        return this.Texto;
    }
    public String getValue(){
        return this.Valor;
    }
}
