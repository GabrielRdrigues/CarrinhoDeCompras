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

        System.out.println("Bem vindo as lojas Nuno Eletromóveis\n");

        CarrinhoCompra carrinho = new CarrinhoCompra(estoque);
        while(opcao!=5)

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
                    System.out.println("\nPor favor escolha o metodo de pagamento");
                    String pagamento = ler.nextLine();
                    carrinho.finalizaCompra(pagamento);
                    carrinho.limpar_carrinho(); // Limpando o carrinho antigo
                    System.out.println("\nDeseja voltar a comprar? (S/N)");
                    if (ler.next().charAt(0) == 'S')
                        break;
                    else {
                        System.out.println("Obrigado por comprar na Nuno Eletromóveis!");
                        opcao=5;
                        break;
                    }
                case 4:
                    System.out.println("Obrigado por acessar a Nuno Eletromóveis!");
                    opcao=5;
                    break;
                default:
                    System.out.println("Opção inválida =P");

            }

        }

    }
}
