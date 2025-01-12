abstract class ProdutoEstoque {
    String nome;
    float valor;
    int quantidade;

    // Metódos que todas as classes filhas terão que implementar
    abstract public void imprimir_descricao();
    abstract public int getQuantidade();
    abstract public void setQuantidade(int qtd);
    abstract public float getValor();
    abstract public void setValor(float value);
    abstract public String getNome();  
    abstract public ProdutoEstoque Objeto_Creation(float valor, int quantidade);
}