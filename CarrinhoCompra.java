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
        int indice_carrinho = achar_indice(nome);

        for (i=0; i<estoque_carrinho.get_qtd_estoque(); i++)
        {
            if (estoque_carrinho.estoque[i].getNome().equalsIgnoreCase(nome))
            {
                if(indice_carrinho>=0) // SE Já existe no carrinho
                {
                    if((carrinho[indice_carrinho].get_qtd_produto() + quantidade) > estoque_carrinho.estoque[i].get_qtd_produto())
                    {
                        System.out.println("Não há a quantidade desejada do item requisitado\n");
                        break;
                    }
                    else
                    {
                        carrinho[indice_carrinho].soma_qtd_produto(quantidade);
                        break;
                    }
                }
                else
                {
                    if (estoque_carrinho.estoque[i].get_qtd_produto() >= quantidade)
                    {
                        ProdutoEstoque aux = estoque_carrinho.estoque[i].Objeto_Creation(quantidade);
                        this.carrinho[qtd_carrinho]=aux;
                        qtd_carrinho++;
                        System.out.println("Inserido com sucesso!\n");
                        return;
                    }
                    else
                    {
                        System.out.println("Não há a quantidade desejada do item requisitado\n");
                        break;
                    }

                }
            }
        }

        if (i > estoque_carrinho.get_qtd_estoque())
            System.out.println("Produto requisitado em falta ou está registrado com nome diferente\n");

    }


    public void finalizaCompra(String metodo_pagamento)
    {
        System.out.println("A soma dos produtos: " + calculaTotal(metodo_pagamento));
        for (int i=0; i<this.qtd_carrinho; i++)
        {
            for (int j = 0; j<estoque_carrinho.get_qtd_estoque(); j++)
            {
                if (carrinho[i].getNome().equals(estoque_carrinho.estoque[j].getNome()))
                {
                    estoque_carrinho.estoque[j].set_qtd_produto(estoque_carrinho.estoque[j].get_qtd_produto() - carrinho[i].get_qtd_produto());
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
            soma += (carrinho[i].getValor() * carrinho[i].get_qtd_produto());
        }

        // Aplica o desconto em cima do total no carrinho
        return soma + (desconto * soma);
    }

    public void limpar_carrinho()
    {
        this.qtd_carrinho=0;
    }

}