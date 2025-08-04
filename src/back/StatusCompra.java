package back;


public enum StatusCompra {
    APROVADA("Compra aprovada!", "Sucesso"),
    AGUARDANDO_CONFIRMACAO("Aguardando confirmação da operação.", "Confirmação"),
    RECUSADA("Compra recusada.", "Aviso"),
    CARTAO_NAO_ENCONTRADO("Cartão não encontrado.", "Erro"),
    ERRO_VALIDACAO("Digite um valor válido para a compra.", "Erro"),
    ERRO_BANCO("Erro ao acessar o banco de dados.", "Erro");

    private final String mensagem;
    private final String titulo;

    StatusCompra(String mensagem, String titulo) {
        this.mensagem = mensagem;
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getTitulo() {
        return titulo;
    }
}
