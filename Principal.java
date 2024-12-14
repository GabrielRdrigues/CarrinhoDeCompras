public class Principal{
    public static void main (String[] args){
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.adicionaProduto(new ProdutoEstoque("monitor",500,100));
        estoque.adicionaProduto(new ProdutoEstoque("telefone",150,300));
        estoque.adicionaProduto(new ProdutoEstoque("teclado",70,50));
    }

}