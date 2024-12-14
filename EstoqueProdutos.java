import java.util.ArrayList;

public class EstoqueProdutos{
    
    ArrayList<ProdutoEstoque> estoque;
    public EstoqueProdutos(){
        estoque = new ArrayList<ProdutoEstoque>(); // Inicializando o array de produtos pelo construtor
    }
    public void adicionaProduto(ProdutoEstoque x){
        estoque.add(x);
    }
}