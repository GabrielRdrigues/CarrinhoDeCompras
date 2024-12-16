import java.util.ArrayList;

public class CarrinhoCompra{
    EstoqueProdutos estoque;
    ArrayList<ProdutoEstoque> Lista_carrinho = new ArrayList<ProdutoEstoque>();

    public CarrinhoCompra(EstoqueProdutos e){
        estoque = e;
    }

    public void adicionaItem(String nome, int quantidade){
        int i;
        for (i=0; i<estoque.Lista_estoque.size(); i++) {
            if (estoque.Lista_estoque.get(i).nome.equals(nome)) {
                if (estoque.Lista_estoque.get(i).quantidade >= quantidade) {
                    ProdutoEstoque aux = new ProdutoEstoque(nome, estoque.Lista_estoque.get(i).valor, quantidade);
                    Lista_carrinho.add(aux);
                    break;
                } else {
                    System.out.println("Não há a quantidade desejada do item requisitado");
                    break;
                }
            }
        }
        if (i >= estoque.Lista_estoque.size())
            System.out.println("Produto requisitado em falta ou está registrado com nome diferente");
    }

    public void finalizaCompra(){
        for (int i=0; i<Lista_carrinho.size(); i++){
            for (int j=0; j<estoque.Lista_estoque.size(); j++){
                if (Lista_carrinho.get(i).nome.equals(estoque.Lista_estoque.get(j).nome))
                    estoque.Lista_estoque.get(j).quantidade -= Lista_carrinho.get(i).quantidade;
            }
        }
        System.out.println("Compra finalizada com sucesso. Obrigado por comprar na nossa loja!");
    }

    public float calculaTotal(){
        int soma = 0;
        for (int i=0; i<Lista_carrinho.size(); i++){
            soma += (Lista_carrinho.get(i).valor * Lista_carrinho.get(i).quantidade);
        }
        return soma;
    }
}
