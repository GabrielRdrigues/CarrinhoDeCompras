import java.util.ArrayList;

public class CarrinhoCompra
{
    EstoqueProdutos estoque_carrinho; // O estoque
    ProdutoEstoque[] carrinho; // O carrinho
    int qtd_carrinho;

    public CarrinhoCompra(EstoqueProdutos e)
    {
        this.qtd_carrinho=0;
        this.carrinho = new ProdutoEstoque[100];
        this.estoque_carrinho = e;
    }

    private int achar_indice(String n) // Metódo responsável por procurar se existe esse produto já no carrinho
    {
        for(int j=0;j<qtd_carrinho;j++)
        {
            if(carrinho[j].getNome().equals(n))
                return j;
        }
        return -1;
    }


    public void adicionaItem(String nome, int quantidade)
    {
        int i;
        int indice_auxiliar = achar_indice(nome);
      
        for (i=0; i<estoque_carrinho.get_quantidade(); i++) 
        {
            if (estoque_carrinho.estoque[i].getNome().equals(nome)) 
            {

                if(indice_auxiliar>=0)
                {
                    if((carrinho[indice_auxiliar].quantidade + quantidade) > estoque_carrinho.estoque[i].quantidade)
                    {
                        System.out.println("Quantidade acima da disponível");
                        break;
                    }
                    else
                    {
                        carrinho[indice_auxiliar].quantidade += quantidade;
                        break;
                    }
                }
                else
                {
                    if (estoque_carrinho.estoque[i].quantidade >= quantidade)
                    {
                        /* O loop abaixo é responsável pela criação do objeto adequado, comparando
                        com o que foi pedido pelo usuário */
                        for(int m=0;m<estoque_carrinho.qtd_produtos;m++)
                        {
                            if(estoque_carrinho.estoque[m].getNome().equalsIgnoreCase(nome))
                            {
                                ProdutoEstoque aux = estoque_carrinho.estoque[m].Objeto_Creation(estoque_carrinho.estoque[m].getValor(),quantidade);
                                this.carrinho[qtd_carrinho]=aux;
                                qtd_carrinho++;
                                System.out.println("Inserido com sucesso!\n");
                            }
                                
                        }
                    } 
                    else 
                    {
                        System.out.println("Não há a quantidade desejada do item requisitado\n");
                        break;
                    }

                }
            }
        }

        if (i > estoque_carrinho.get_quantidade())
            System.out.println("Produto requisitado em falta ou está registrado com nome diferente\n");

    }

    
    public void finalizaCompra(String metodo_pagamento)
    {
        System.out.println("A soma dos produtos: " + calculaTotal(metodo_pagamento));
        for (int i=0; i<this.qtd_carrinho; i++)
        {
            for (int j=0; j<estoque_carrinho.qtd_produtos; j++)
            {
                if (carrinho[i].getNome().equals(estoque_carrinho.estoque[j].getNome()))
                {
                    estoque_carrinho.estoque[j].quantidade -= carrinho[i].quantidade;
                }
                    
            }
        }
        System.out.println("Compra finalizada com sucesso. Obrigado por comprar na nossa loja!\n");
    }

    public double calculaTotal(String metodo_pagamento)
{
    double desconto = 0;
    
    // Determina o desconto ou acréscimo baseado no método de pagamento
    if(metodo_pagamento.equalsIgnoreCase("crédito"))
        desconto = 0.05; // Acréscimo de 5%
    if(metodo_pagamento.equalsIgnoreCase("debito"))
        desconto = -0.05; // Desconto de 5%
    if(metodo_pagamento.equalsIgnoreCase("dinheiro"))
        desconto = -0.1; // Desconto de 10%
    if(metodo_pagamento.equalsIgnoreCase("pix"))
        desconto = -0.1; // Desconto de 10% 

    double soma = 0;
    
    // Calcula o total
    for (int i = 0; i < this.qtd_carrinho; i++) {
        soma += (carrinho[i].getValor() * carrinho[i].getQuantidade());
    }
    
    // Aplica o desconto em cima do total no carrinho
    return soma + (desconto * soma);
}

    public void limpar_carrinho()
    {
        this.qtd_carrinho=0;
    }

}