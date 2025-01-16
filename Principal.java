import java.util.Scanner;
public class Principal
{
    public static void main(String[] args){
        EstoqueProdutos estoque = new EstoqueProdutos();
        //estoque.adicionaProduto(new Monitor(1000,10));
        //estoque.adicionaProduto(new Telefone(3000,5));
        estoque.adicionaProduto(new Eletrodomestico("geladeira", 5000,100, "A+", 54, "Bivolt"));
        estoque.adicionaProduto(new Eletrodomestico("tv", 1000,10, "A++", 20, "110"));
        estoque.adicionaProduto(new Movel("sofa", 2000, 10, "Madeira", 2, 1.50, 1.25));
        estoque.adicionaProduto(new Eletronico("celular",2000,10,true,false));

        // Começando a fazer o "menu"
        Scanner ler = new Scanner(System.in); // o scanf do java é essa classe Scanner
        int opcaoCodigo = 0;

        System.out.println("Bem vindo as lojas Nuno Eletromóveis\n");

        CarrinhoCompra carrinho = new CarrinhoCompra(estoque);
        while(opcaoCodigo != 5)

        {
            System.out.println("Selecione uma das opções abaixo:");
            System.out.println("1-Imprimir catálogo\n2-Inserir item no carrinho\n3-Remover item do carrinho\n4-Finalizar Compra\n5-Sair");
            opcaoCodigo = ler.nextInt();
            ler.nextLine(); // Se não colocar isso, o buffer fica parado no \n quando a gente digita a opção e
            // dá ruim na linha 29 (quando tentamos ler uma string)

            MenuOpcoes opcao = MenuOpcoes.fromCodigo(opcaoCodigo); // Converte o código numérico para o enum

            if (opcao == null) {
                System.out.println("Opção inválida");
                continue;
            }

            switch(opcao) {
                case IMPRIMIR_CATALOGO:
                    // Imprimir catálogo
                    estoque.imprimeCatalogo();
                    break;
                case INSERIR_ITEM:
                    // Inserir item no carrinho
                    System.out.print("Digite o nome do item: ");
                    String item = ler.nextLine();
                    System.out.println("Digite a quantidade do item:");
                    int quantidade_item = ler.nextInt();
                    carrinho.adicionaItem(item, quantidade_item);
                    break;
                case REMOVER_ITEM:
                    // Remover item do carrinho
                    System.out.print("Digite o nome do item a ser removido: ");
                    String itemRemover = ler.nextLine();
                    System.out.println("Digite a quantidade do item a ser removida:");
                    int quantidadeRemover = ler.nextInt();
                    carrinho.removeItem(itemRemover, quantidadeRemover);
                    break;
                case FINALIZAR_COMPRA:
                    // Finalizar compra
                    System.out.println("\nPor favor escolha o método de pagamento:");
                    System.out.println("1 - Crédito (+5% de acréscimo)");
                    System.out.println("2 - Débito (5% de desconto)");
                    System.out.println("3 - Dinheiro (10% de desconto)");
                    System.out.println("4 - Pix (10% de desconto)");
                
                    int metodoPagamento = ler.nextInt();
                    ler.nextLine(); // Limpa o buffer
                
                    if (metodoPagamento >= 1 && metodoPagamento <= 4) {

                        carrinho.finalizaCompra(metodoPagamento); 
                        carrinho.limpar_carrinho();
                        System.out.println("\nDeseja voltar a comprar? (S/N)");
                        if (ler.next().charAt(0) == 'S')
                            break;
                            
                        else {
                            System.out.println("Obrigado por comprar na Nuno Eletromóveis!");
                            opcaoCodigo = 5;
                        }
                    } else {
                        System.out.println("Opção inválida. Compra cancelada.");
                    }
                    break;
                case SAIR:
                    System.out.println("Obrigado por acessar a Nuno Eletromóveis!");
                    opcaoCodigo = 5;
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }

    }
}
