public class Teclado extends ProdutoEstoque
{
    
    public Teclado(float preco,int qtd)
    {
        this.valor = preco;
        this.quantidade = qtd;
    }
    public void imprimir_descricao()
    {
        System.out.println("Esse teclado é mecânico e possui garantia de 90 dias");
    }

    public String getNome()
    {
        return "teclado";
    }

     public ProdutoEstoque Objeto_Creation(float valor, int quantidade)
    {
        return new Teclado(valor,quantidade);
    }

    public float getValor()
    {
        return valor;
    }

    public void setValor(float value)
    {
        this.valor = value;
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(int value)
    {
        this.quantidade = value;
    }
}