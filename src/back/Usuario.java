package back;


public class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private String senha;

    // Construtores
    public Usuario() {}
    
    public Usuario(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }
    
    public Usuario(int id, String nome, String cpf, String senha ) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
     
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getSenha() {return senha;}
    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setEmail() { this.senha = senha; }
    
}
 