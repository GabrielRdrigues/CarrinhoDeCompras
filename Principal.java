import java.util.Scanner;
public class Principal {
    public static void main(String[] args){
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.adicionaProduto(new ProdutoEstoque("monitor",500,100));
        estoque.adicionaProduto(new ProdutoEstoque("telefone",150,300));
        estoque.adicionaProduto(new ProdutoEstoque("teclado",70,50));
        

        // Começando a fazer o "menu"
        Scanner ler = new Scanner(System.in); // o scanf do java é essa classe Scanner
        int opcao=0;
        System.out.println("Bem vindo as lojas Nuno Eletromóveis");

        CarrinhoCompra carrinho = new CarrinhoCompra(estoque);
        while(opcao!=4)
        {
            System.out.println("Selecione uma das opções abaixo:");
            System.out.println("1-Inserir item no carrinho\n2-Imprimir catalogo\n3-Finalizar Compra\n4-Sair");
            opcao = ler.nextInt();
            ler.nextLine(); // Se não colocar isso, o buffer fica parado no \n quando a gente digita a opção e
            // dá ruim na linha 29 (quando tentamos ler uma string)

            switch(opcao)
            {
                case 1:
                    // Inserir item no carrinho
                    System.out.print("Digite o nome do item:");
                    String item = ler.nextLine();
                    System.out.println("Digite a quantidade do item:");
                    int quantidade_item = ler.nextInt();
                    carrinho.adicionaItem(item,quantidade_item);
                    break;
                case 2:
                    // Imprimir catalogo
                    estoque.imprimeCatalogo();
                    break;
                case 3:
                    // Finalizar compra
                    carrinho.finalizaCompra();
                    System.out.println("A soma dos produtos : " + carrinho.calculaTotal());
                    opcao=4;
                    break;
                default:
                    System.out.println("Opção inválida =P");
            }

        }


        /*CarrinhoCompra carrinho = new CarrinhoCompra(estoque);

        carrinho.adicionaItem("teclado", 40);

        estoque.imprimeCatalogo();

        carrinho.finalizaCompra();

        System.out.println("A soma dos produtos : " + carrinho.calculaTotal());*/

    }
}
