public enum MenuOpcoes {
    IMPRIMIR_CATALOGO(1),
    INSERIR_ITEM(2),
    REMOVER_ITEM(3),
    FINALIZAR_COMPRA(4),
    SAIR(5);

    private final int codigo;

    // Construtor para associar um numero a cada opção
    MenuOpcoes(int codigo) {
        this.codigo = codigo;
    }

    // Método para obter o código da opção
    public int getCodigo() {
        return codigo;
    }

    // Método estático para converter int para enum
    public static MenuOpcoes fromCodigo(int codigo) {
        for (MenuOpcoes opcao : values()) { // Percorre todas as constantes do enum
            if (opcao.getCodigo() == codigo) {
                return opcao;
            }
        }
        return null; 
    }
}
