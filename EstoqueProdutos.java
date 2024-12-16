import java.util.ArrayList;
import java.util.List;

public class EstoqueProdutos {
    ArrayList<ProdutoEstoque> Lista_estoque = new ArrayList<ProdutoEstoque>();


    public void adicionaProduto(ProdutoEstoque produto){
        for (int i=0; i<Lista_estoque.size(); i++){
            if (Lista_estoque.get(i).nome.equals(produto.nome)){
                 if (Lista_estoque.get(i).valor != produto.valor){
                     Lista_estoque.get(i).valor = produto.valor;
                     Lista_estoque.get(i).quantidade += produto.quantidade;
                     return;
                 } else{
                     Lista_estoque.get(i).quantidade += produto.quantidade;
                     return;
                 }
            }
        }
        Lista_estoque.add(produto);
    }

    public void imprimeCatalogo(){
        for (int i=0; i<Lista_estoque.size(); i++){
            System.out.println("Item: "+ Lista_estoque.get(i).nome + "  - Valor: " + Lista_estoque.get(i).valor + "  - Quantidade: " + Lista_estoque.get(i).quantidade);
        }
    }
}
