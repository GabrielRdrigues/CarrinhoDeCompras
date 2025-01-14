public class Movel extends ProdutoEstoque
{

    //Atributos exclusivos para todos os Móveis:

    private String material;
    private double largura;
    private double comprimento;
    private double altura;

    public Movel(String nome, double preco, int qtd, String m, double l, double c, double a){
        this.nome = nome;
        this.valor = preco;
        this.qtd_produto = qtd;

        this.material = m;
        this.largura = l;
        this.comprimento = c;
        this.altura = a;
    }

    //Metodo exibe moldado para a classe dos Móveis
    public void exibe(){
        System.out.println("Item: "+ this.nome + "  - Valor: " + this.valor + "  - Quantidade: " + this.qtd_produto);
        System.out.println("Informações do Móvel: " +
                "\n\tMaterial - " + this.material +"\n\tLargura - "+ this.largura +"m\n\tComprimento - "+ this.comprimento +"m\n\tAltura - " + this.altura + "m\n");
    }

    //Metodo para retornar um objeto da classe Movel
    public ProdutoEstoque Objeto_Creation(int quantidade)
    {
        return new Movel(this.nome, this.valor, quantidade, this.material, this.largura, this.comprimento, this.altura);
    }
}