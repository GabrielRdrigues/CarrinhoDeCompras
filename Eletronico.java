public class Eletronico extends ProdutoEstoque
{

    // Atributos exclusivos para eletrônico

    private boolean CarregadorIncluso;
    private boolean SeguroFurtoIncluso;

    public Eletronico(String nome,double preco,int qtd,boolean Carregador,boolean SeguroFurto)
    {
        this.nome=nome;
        this.valor=preco;
        this.qtd_produto=qtd;
        this.CarregadorIncluso=Carregador;
        this.SeguroFurtoIncluso=SeguroFurto;
    }


    //Metodo exibe moldado para a classe dos eletrônicos
    public void exibe(){
        System.out.println("Item: "+ this.nome + "  - Valor: " + this.valor + "  - Quantidade: " + this.qtd_produto);
        System.out.println("Informações do Eletrônico: " +
                "\n\tCarregador - " + (this.CarregadorIncluso ? "Sim" : "Nao") +"\n\tSeguro Furto -" + (this.SeguroFurtoIncluso ? "Sim" : "Não"));
    }

    //Metodo para retornar um objeto da classe eletronicos
    public ProdutoEstoque Objeto_Creation(int quantidade)
    {
        return new Eletronico(this.nome, this.valor, quantidade, this.CarregadorIncluso, this.SeguroFurtoIncluso);
    }


}