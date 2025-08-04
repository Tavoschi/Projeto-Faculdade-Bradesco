package back;

public class Cartao {
    private String limite;
    private double limiteDouble;
    private String numCart;
    
    private int id; 
    
            
    public Cartao(int aInt, String aString, String bString) {}
    
    public Cartao(int id, String limite, String numCart, double limiteDouble) {
        this.limite = limite;
        this.id = id;
        this.numCart = numCart;
        this.limiteDouble = Double.parseDouble(limite);
    }

    
    

        
        public double getLimiteDouble() { return limiteDouble; } 
        public int getId() { return id; }  
        
        public String getLimite() { return limite;}
        public String getNumCart() { return numCart; }
        public void setLimite(String limite) { this.limite = limite; }
        public void setId(int id) { this.id = id; }
        public void setNumCart(String numCart) {this.numCart = numCart; }
        
    }
        


    

   
    
    

