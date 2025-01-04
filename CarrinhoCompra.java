import java.util.ArrayList;

public class CarrinhoCompra
{
    EstoqueProdutos estoque; // O estoque
    ArrayList<ProdutoEstoque> Lista_carrinho = new ArrayList<ProdutoEstoque>(); // O carrinho

    public CarrinhoCompra(EstoqueProdutos e)
    {
        estoque = e;
    }

    private int achar_indice(String n) // Metódo responsável por procurar se existe esse produto já no carrinho
    {
        for(int j=0;j<Lista_carrinho.size();j++)
        {
            if(Lista_carrinho.get(j).nome.equals(n))
                return j;
        }
        return -1;
    }


    public void adicionaItem(String nome, int quantidade)
    {
        int i;
        int indice_auxiliar = achar_indice(nome);
      
        for (i=0; i<estoque.Lista_estoque.size(); i++) 
        {
            if (estoque.Lista_estoque.get(i).nome.equals(nome)) 
            {

                if(indice_auxiliar>=0)
                {
                    if((Lista_carrinho.get(indice_auxiliar).quantidade + quantidade) > estoque.Lista_estoque.get(i).quantidade)
                    {
                        System.out.println("Quantidade acima da disponível");
                        break;
                    }
                    else
                    {
                        Lista_carrinho.get(indice_auxiliar).quantidade += quantidade;
                        break;
                    }
                }
                else
                {
                    if (estoque.Lista_estoque.get(i).quantidade >= quantidade)
                    {
                        ProdutoEstoque aux = new ProdutoEstoque(nome, estoque.Lista_estoque.get(i).valor, quantidade);
                        Lista_carrinho.add(aux);
                        System.out.println("Produto adicionado com sucesso!\n");
                        break;
                    } 
                    else 
                    {
                        System.out.println("Não há a quantidade desejada do item requisitado\n");
                        break;
                    }

                }
            }
        }

        if (i >= estoque.Lista_estoque.size())
            System.out.println("Produto requisitado em falta ou está registrado com nome diferente\n");

    }

    
    public void finalizaCompra(String metodo_pagamento)
    {
        System.out.println("A soma dos produtos: " + calculaTotal(metodo_pagamento));
        for (int i=0; i<Lista_carrinho.size(); i++)
        {
            for (int j=0; j<estoque.Lista_estoque.size(); j++)
            {
                if (Lista_carrinho.get(i).nome.equals(estoque.Lista_estoque.get(j).nome))
                {
                    estoque.Lista_estoque.get(j).quantidade -= Lista_carrinho.get(i).quantidade;
                    //Lista_carrinho.remove(i); // na main já é feito o clear do carrinho após finalizar compra
                }
                    
            }
        }
        System.out.println("Compra finalizada com sucesso. Obrigado por comprar na nossa loja!\n");
    }

    public double calculaTotal(String metodo_pagamento)
    {
        double desconto = 0;
        if(metodo_pagamento.equals("crédito"))
            desconto = 0.05;
        if(metodo_pagamento.equals("debito"))
            desconto = -0.05;
        if(metodo_pagamento.equals("dinheiro"))
            desconto = -0.1;
        double soma = 0;
        for (int i=0; i<Lista_carrinho.size(); i++){
            soma += (Lista_carrinho.get(i).valor * Lista_carrinho.get(i).quantidade);
        }
        return soma + (desconto * soma);
    }

    public void limpar_carrinho()
    {
        Lista_carrinho.clear();
    }

}
