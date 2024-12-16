public class Main {
    public static void main(String[] args){
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.adicionaProduto(new ProdutoEstoque("monitor",500,100));
        estoque.adicionaProduto(new ProdutoEstoque("telefone",150,300));
        estoque.adicionaProduto(new ProdutoEstoque("teclado",70,50));

        CarrinhoCompra carrinho = new CarrinhoCompra(estoque);

        carrinho.adicionaItem("teclado", 40);

        estoque.imprimeCatalogo();

        carrinho.finalizaCompra();

        System.out.println("A soma dos produtos : " + carrinho.calculaTotal());

    }
}
