import java.util.ArrayList;
public class CarrinhoCompra{
    ArrayList<ProdutoEstoque> estoque_carrinho= new ArrayList<ProdutoEstoque>();
    ArrayList<ProdutoEstoque> itens_do_carrinho = new ArrayList<ProdutoEstoque>();
    
    double valor_a_pagar=0;

     public CarrinhoCompra(ArrayList<ProdutoEstoque> estoque){
        estoque_carrinho=estoque;
     }

    public void adiciona_item(String n,int qtd){
        for(int i=0;i<3;i++){
            ProdutoEstoque auxiliar = estoque_carrinho.get(i);
            if(n.equals(auxiliar.nome)){
                ProdutoEstoque ProdutoAuxiliar = new ProdutoEstoque(" ",0,0); // Variável auxiliar
                ProdutoAuxiliar.nome=n;
                ProdutoAuxiliar.quantidade=qtd;
                ProdutoAuxiliar.valor= auxiliar.valor;
                itens_do_carrinho.add(ProdutoAuxiliar); // Adicionando o ProdutoAuxiliar no carrinho
            }
        }
    }

    /*O Método finalizacompra() retira os itens do carrinho do cliente do estoque da loja  */
    public void finalizaCompra(){ 
        int tamanho_carrinho = itens_do_carrinho.size();
        int tamanho_estoque = estoque_carrinho.size();
        for(int i=0;i<tamanho_carrinho;i++){
            for(int j=0;j<tamanho_estoque;j++){
                if((itens_do_carrinho.get(i)).nome == (estoque_carrinho.get(j)).nome){
                    (estoque_carrinho.get(j)).quantidade += -(itens_do_carrinho.get(i)).quantidade;
                    valor_a_pagar += (itens_do_carrinho.get(i)).valor * (itens_do_carrinho.get(i)).quantidade;
                }
            }
        }
    }

    // Retorna o valor total das compras
    private double getValor(){
        return valor_a_pagar;
    }

    public double calcula_total(){
        return getValor();
    }


}