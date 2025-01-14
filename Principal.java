
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
                    System.out.println("\nPor favor escolha o método de pagamento:");
                    System.out.println("1 - Crédito (+5% de acréscimo)");
                    System.out.println("2 - Débito (5% de desconto)");
                    System.out.println("3 - Dinheiro (10% de desconto)");
                    System.out.println("4 - Pix (10% de desconto)");
                    int metodoPagamento = ler.nextInt();
                    ler.nextLine();
                    String pagamento = "";
                    switch (metodoPagamento) {
                        case 1:
                            pagamento = "crédito";
                            break;
                        case 2:
                            pagamento = "debito";
                            break;
                        case 3:
                            pagamento = "dinheiro";
                            break;
                        case 4:
                            pagamento = "pix";
                            break;
                        default:
                            System.out.println("Opção inválida. Compra cancelada.");
                            break;
                    }
                    if (metodoPagamento >= 1 && metodoPagamento <= 4) {
                        carrinho.finalizaCompra(pagamento);
                        carrinho.limpar_carrinho(); // Limpando o carrinho após a finalização
                        System.out.println("\nDeseja voltar a comprar? (S/N)");
                        if (ler.next().charAt(0) == 'S')
                            break;
                        else {
                            System.out.println("Obrigado por comprar na Nuno Eletromóveis!");
                            opcao = 5;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Obrigado por acessar a Nuno Eletromóveis!");
                    opcao=5;
                    break;
                default:
                    System.out.println("Opção inválida");

            }

        }

    }
}
