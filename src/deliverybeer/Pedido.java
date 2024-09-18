package deliverybeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pedido {

 
    private List<String> bebidasAlc;
    private List<String> bebidasSemAlc;
    private List<String> petiscos;
    private List<String> outros;
    private List<String> pedido;

   
    public Pedido() {
        bebidasAlc = Arrays.asList("Cerveja", "Vinho", "Vodka", "Whisky", "Espumante");
        bebidasSemAlc = Arrays.asList("Água", "Energético", "Refrigerante", "Tônica", "Sucos");
        petiscos = Arrays.asList("Amendoim", "Batata chips", "Torresmo");
        outros = Arrays.asList("Gelo", "Copo descartável", "Talheres descartáveis", "Abridor de garrafa", "Isqueiro");
        pedido = new ArrayList<>();
    }

    
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

    
    public List<String> visualizarPedido() {
        return new ArrayList<>(pedido);
    }

    public void exibirItensDisponiveis() {
        System.out.println("Bebidas Alcoólicas:");
        for (int i = 0; i < bebidasAlc.size(); i++) {
            System.out.println((i + 1) + ". " + bebidasAlc.get(i));
        }
        System.out.println("Bebidas Não Alcoólicas:");
        for (int i = 0; i < bebidasSemAlc.size(); i++) {
            System.out.println((i + 1) + ". " + bebidasSemAlc.get(i));
        }
        System.out.println("Petiscos:");
        for (int i = 0; i < petiscos.size(); i++) {
            System.out.println((i + 1) + ". " + petiscos.get(i));
        }
        System.out.println("Outros Itens:");
        for (int i = 0; i < outros.size(); i++) {
            System.out.println((i + 1) + ". " + outros.get(i));
        }
    }

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
            scanner.nextLine();

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

        System.out.println("Seu pedido foi finalizado!");
        System.out.println("Itens do pedido: " + visualizarPedido());
        scanner.close();
    }
}
