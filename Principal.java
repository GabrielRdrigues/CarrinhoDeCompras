public class Principal{
    public static void main (String[] args){
        EstoqueProdutos estoqueprodutos = new EstoqueProdutos();
        estoqueprodutos.adicionaProduto(new ProdutoEstoque("monitor",500,100));
        estoqueprodutos.adicionaProduto(new ProdutoEstoque("telefone",150,300));
        estoqueprodutos.adicionaProduto(new ProdutoEstoque("teclado",70,50));
        /*O Array de Produtos não é o estoqueprodutos e sim o atributo estoque do objeto estoqueprodutos
        , por isso que na chamada abaixo tem o "estoqueprodutos.estoque" , isto se deve porque no meu 
        construtor da classe CarrinhoCompra coloquei como parâmetro para receber um Array de produtos
        e não um estoque em sí. Acho que da pra alterar se quiser, mas creio que não muda muito. */
        CarrinhoCompra carrinho = new CarrinhoCompra(estoqueprodutos.estoque);
        carrinho.adiciona_item("monitor",2);
        carrinho.adiciona_item("telefone",5);
        carrinho.adiciona_item("teclado",2);
        carrinho.finalizaCompra();
        System.out.println("Imprimindo o estoque após finalizar");
        for(int k=0;k<estoqueprodutos.estoque.size();k++){
            System.out.println("nome: "+ estoqueprodutos.estoque.get(k).nome + "quantidade: "
            + estoqueprodutos.estoque.get(k).quantidade);
        }
    }

}