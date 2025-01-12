import java.util.ArrayList;

public class EstoqueProdutos {
    ProdutoEstoque[] estoque; 
    public int qtd_produtos;

    public int get_quantidade()
    {
        return this.qtd_produtos;
    }

    public EstoqueProdutos()
    {
        this.estoque = new ProdutoEstoque[100];
        this.qtd_produtos=0;
    }

    public void adicionaProduto(ProdutoEstoque produto)
    {
        for (int i=0; i<qtd_produtos; i++)
        {
            if (estoque[i].nome.equals(produto.nome))
            {
                 if (estoque[i].valor != produto.valor)
                 {
                     estoque[i].valor = produto.valor;
                 } 
                estoque[i].quantidade += produto.quantidade;
                return;
            }
        }
        estoque[qtd_produtos]=produto;
        qtd_produtos++;
    }

    public void imprimeCatalogo(){
        for (int i=0; i<qtd_produtos; i++){
            System.out.println("Item: "+ estoque[i].getNome() + "  - Valor: " + estoque[i].getValor
            () + "  - Quantidade: " + estoque[i].getQuantidade());
        }
        System.out.println("");
    }
}