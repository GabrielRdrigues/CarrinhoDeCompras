abstract class ProdutoEstoque {
    String nome;
    double valor;
    int qtd_produto;


    public int get_qtd_produto()
    {
        return qtd_produto;
    }

    public void soma_qtd_produto(int soma)
    {
        this.qtd_produto += soma;
    }

    public void subtrai_qtd_produto(int soma) {
        this.qtd_produto -= soma;
    }

    public void set_qtd_produto(int value)
    {
        this.qtd_produto = value;
    }

    public String getNome()
    {
        return this.nome;
    }

    public double getValor()
    {
        return valor;
    }

    // Metódos que todas as classes filhas terão que implementar
    abstract public void exibe();
    abstract public ProdutoEstoque Objeto_Creation(int quantidade);
}
