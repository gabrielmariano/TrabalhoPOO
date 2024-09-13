import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pedido {

    // Atributos
    private List<String> bebidasAlc;
    private List<String> bebidasSemAlc;
    private List<String> petiscos;
    private List<String> outros;
    private List<String> pedido;

    // Construtor
    public Pedido() {
        // Inicializar as coleções
        bebidasAlc = Arrays.asList("Cerveja", "Vinho", "Vodka", "Rum", "Tequila");
        bebidasSemAlc = Arrays.asList("Água", "Suco de laranja", "Refrigerante", "Chá gelado", "Café");
        petiscos = Arrays.asList("Amendoim", "Batata chips", "Torresmo");
        outros = Arrays.asList("Frutas frescas", "Doces variados", "Pães e torradas", "Molhos e condimentos", "Saladas pequenas");
        pedido = new ArrayList<>();
    }

    // Método para adicionar itens ao pedido
    public void adicionarItem(int categoria, int index) {
        switch (categoria) {
            case 1:
                adicionarItem(bebidasAlc, index);
                break;
            case 2:
                adicionarItem(bebidasSemAlc, index);
                break;
            case 3:
                adicionarItem(petiscos, index);
                break;
            case 4:
                adicionarItem(outros, index);
                break;
            default:
                System.out.println("Categoria inválida.");
                break;
        }
    }

    private void adicionarItem(List<String> itens, int index) {
        if (index >= 0 && index < itens.size()) {
            pedido.add(itens.get(index));
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Método para visualizar o pedido atual
    public List<String> visualizarPedido() {
        return new ArrayList<>(pedido);
    }

    // Método para exibir todos os itens disponíveis
    public void exibirItensDisponiveis() {
        System.out.println("Bebidas Alcoólicas: " + bebidasAlc);
        System.out.println("Bebidas Não Alcoólicas: " + bebidasSemAlc);
        System.out.println("Petiscos: " + petiscos);
        System.out.println("Outros Itens: " + outros);
    }

    // Método para executar o menu de pedidos
    public void executar() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Bem-vindo ao sistema de pedidos!");
            System.out.println("Escolha uma categoria:");
            System.out.println("1. Bebidas Alcoólicas");
            System.out.println("2. Bebidas Não Alcoólicas");
            System.out.println("3. Petiscos");
            System.out.println("4. Outros");
            System.out.println("5. Finalizar Pedido");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            if (escolha == 5) {
                continuar = false;
            } else if (escolha >= 1 && escolha <= 4) {
                exibirItensDisponiveis();
                System.out.println("Escolha um item da categoria " + escolha + ":");
                int index = scanner.nextInt() - 1;
                adicionarItem(escolha, index);
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        // Exibir o pedido finalizado
        System.out.println("Seu pedido foi finalizado!");
        System.out.println("Itens do pedido: " + visualizarPedido());
        scanner.close();
    }
}
