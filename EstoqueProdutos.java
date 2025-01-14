public class EstoqueProdutos {
    ProdutoEstoque[] estoque;
    private int qtd_estoque;

    public int get_qtd_estoque()
    {
        return this.qtd_estoque;
    }

    public EstoqueProdutos()
    {
        this.estoque = new ProdutoEstoque[100];
        this.qtd_estoque =0;
    }

    public void adicionaProduto(ProdutoEstoque produto)
    {
        for (int i = 0; i< qtd_estoque; i++)
        {
            if (estoque[i].nome.equals(produto.nome))
            {
                if (estoque[i].valor != produto.valor)
                {
                    estoque[i].valor = produto.valor;
                }
                estoque[i].qtd_produto += produto.qtd_produto;
                return;
            }
        }
        estoque[qtd_estoque]=produto;
        qtd_estoque++;
    }

    public void imprimeCatalogo(){
        for (int i = 0; i< qtd_estoque; i++){
            this.estoque[i].exibe();
        }
        System.out.println("");
    }
}
