public class Eletrodomestico extends ProdutoEstoque
{
    //Atributos exclusivos para todos os Eletrodomésticos:

    private String eficiencia_energetica;
    private double consumo;
    private String voltagem;

    public Eletrodomestico(String nome, double preco, int qtd, String ef, double p, String v)
    {
        this.nome = nome;
        this.valor = preco;
        this.qtd_produto = qtd;

        this.eficiencia_energetica = ef;
        this.consumo = p;
        this.voltagem = v;
    }

    //Metodo exibe moldado para a classe dos Eletrodomésticos
    public void exibe()
    {
        System.out.println("Item: "+ this.nome + "  - Valor: " + this.valor + "  - Quantidade: " + this.qtd_produto);

        System.out.println("Informações do Eletrodoméstico: " +
                "\n\tEficiência Energética - " + this.eficiencia_energetica +"\n\tConsumo - "+ this.consumo +" kWh/mês\n\tVoltagem - "+ this.voltagem +"\n");
    }

    //Metodo para retornar um objeto da classe Eletrodoméstico
    public ProdutoEstoque Objeto_Creation(int quantidade)
    {
        return new Eletrodomestico(this.nome, this.valor, quantidade, this.eficiencia_energetica, this.consumo, this.voltagem);
    }

}