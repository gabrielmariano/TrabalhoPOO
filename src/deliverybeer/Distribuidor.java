package deliverybeer;

import java.time.LocalTime;
import java.util.Arrays;

public class Distribuidor {
    
    private Cliente c1;

   
    private String nomeDistribuidor;
    private Integer telefoneDistribuidor;
    private String enderecoDistribuidor;
    private Integer cepDistribuidor;
    private LocalTime horarioFuncDistribuidor;
    private String[] catalogoDistribuidor;
    private Integer[] estoqueDistribuidor;

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
        LocalTime abertura = LocalTime.of(18, 0);
        LocalTime fechamento = LocalTime.of(23, 59);

        LocalTime horarioParaVerificar = LocalTime.now();
        System.out.println("Hora atual: " + LocalTime.now());

        if (isHorarioDentroDoIntervalo(horarioParaVerificar, abertura, fechamento)) {
            System.out.println("O horário está dentro do intervalo de funcionamento.");
        } else {
            System.out.println("O horário está fora do intervalo de funcionamento.");
        }
        System.out.println("Funcionamento do Distribuidor: 18:00 às 00:00");
        System.out.println("--------------------------------------------");
    }

    public static boolean isHorarioDentroDoIntervalo(LocalTime horario, LocalTime abertura, LocalTime fechamento) {
        return !horario.isBefore(abertura) && !horario.isAfter(fechamento);
    }

    public void consultar() {
        System.out.println("Meu cep: " + c1.getCep());
    }

  
    public String getNomeDistribuidor() {
        return nomeDistribuidor;
    }

    public void setNomeDistribuidor(String nomeDistribuidor) {
        this.nomeDistribuidor = nomeDistribuidor;
    }

    public Integer getTelefoneDistribuidor() {
        return telefoneDistribuidor;
    }

    public void setTelefoneDistribuidor(Integer telefoneDistribuidor) {
        this.telefoneDistribuidor = telefoneDistribuidor;
    }

    public String getEnderecoDistribuidor() {
        return enderecoDistribuidor;
    }

    public void setEnderecoDistribuidor(String enderecoDistribuidor) {
        this.enderecoDistribuidor = enderecoDistribuidor;
    }

    public Integer getCepDistribuidor() {
        return cepDistribuidor;
    }

    public void setCepDistribuidor(Integer cepDistribuidor) {
        this.cepDistribuidor = cepDistribuidor;
    }

    public LocalTime getHorarioFuncDistribuidor() {
        return horarioFuncDistribuidor;
    }

    public void setHorarioFuncDistribuidor(LocalTime horarioFuncDistribuidor) {
        this.horarioFuncDistribuidor = horarioFuncDistribuidor;
    }

    public String[] getCatalogoDistribuidor() {
        return catalogoDistribuidor;
    }

    public void setCatalogoDistribuidor(String[] catalogoDistribuidor) {
        this.catalogoDistribuidor = catalogoDistribuidor;
    }

    public Integer[] getEstoqueDistribuidor() {
        return estoqueDistribuidor;
    }

    public void setEstoqueDistribuidor(Integer[] estoqueDistribuidor) {
        this.estoqueDistribuidor = estoqueDistribuidor;
    }
}
