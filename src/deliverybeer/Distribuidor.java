package deliverybeer;

import java.time.LocalTime;

import java.util.Arrays;

public class Distribuidor {
    
    private Cliente c1;

    public void setCliente(Cliente cliente) {
        this.c1 = cliente;
    }
    
    public void ordenarEcomprar() {
        Integer[] cepList = {22270014, 22270010, 22280040, 22280004, 22260030};
        
        Arrays.sort(cepList);
        
        System.out.println("Vetor ordenado:");
        for (Integer cep : cepList) {
            System.out.println(cep);
        }
        
        Integer cepMaisProximo = encontrarCepMaisProximo(c1.getCep(), cepList);
        
        System.out.println("Distribuidor mais próximo: " + cepMaisProximo);
    }
    
    private Integer encontrarCepMaisProximo(Integer cepAtual, Integer[] listaCeps) {
        Integer cepMaisProximo = listaCeps[0];
        int menorDiferenca = Math.abs(cepAtual - listaCeps[0]);

        for (Integer cep : listaCeps) {
            int diferenca = Math.abs(cepAtual - cep);
            if (diferenca < menorDiferenca) {
                menorDiferenca = diferenca;
                cepMaisProximo = cep;
            }
        }
        
        return cepMaisProximo;
    }

    public void funcionamento() {
        LocalTime abertura = LocalTime.of(18, 0); // 09:00
        LocalTime fechamento = LocalTime.of(00, 0); // 17:00

        LocalTime horarioParaVerificar = LocalTime.now();
        System.out.println("Hora atual: " + LocalTime.now());

        if (isHorarioDentroDoIntervalo(horarioParaVerificar, abertura, fechamento)) {
            System.out.println("O horário está dentro do intervalo de funcionamento.");
        } else {
            System.out.println("O horário está fora do intervalo de funcionamento.");
        }
        System.out.println("Funcionamento do Distribuidor: 18:00 as 00:00");
    }
    public static boolean isHorarioDentroDoIntervalo(LocalTime horario, LocalTime abertura, LocalTime fechamento) {
        return !horario.isBefore(abertura) && !horario.isAfter(fechamento);
    }

    public void consultar() {
        System.out.println("Meu cep: " + c1.getCep());
    }
}
