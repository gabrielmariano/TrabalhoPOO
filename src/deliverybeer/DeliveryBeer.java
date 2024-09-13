package deliverybeer;

public class DeliveryBeer {
    public static void main(String[] args) {
        Cliente c1 = new Cliente();
        c1.setNome("Danilo Enrico Carlos da Costa");
        c1.setTel(2136429580);
        c1.setEmail("danilo-dacosta78@superacomunicacao.com.br");
        c1.setEndereco("Rua Voluntários da Pátria 70");
        c1.setCep(22270000);
        c1.cadastrar();
        
        Distribuidor d1 = new Distribuidor();
        d1.setCliente(c1);
        d1.consultar();
        d1.ordenarEcomprar();
        d1.funcionamento();
        
//        Pedido p1 = new Pedido();;
//        p1.adicionarItem(1, 0);;
    }
}
