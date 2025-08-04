
package back;

public class SessaoUsuario {
    private static int id;
    private static String numeroCartao;

    public static void setId(int idUsuario) {
        id = idUsuario;
    }

    public static int getId() {
        return id;
    }

    public static void setNumeroCartao(String numero) {
        numeroCartao = numero;
    }

    public static String getNumeroCartao() {
        return numeroCartao;
    }
}
