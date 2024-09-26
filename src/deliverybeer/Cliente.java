package deliverybeer;

public class Cliente {
    private String nome;
    private Integer tel;
    private String email;
    private String endereco;
    private Integer cep;
    private Integer[] cep_distr;

  
    public Cliente() {
    }

    
    public Cliente(String nome, Integer tel, String email, String endereco, Integer cep) {
        this.nome = nome;
        this.tel = tel;
        this.email = email;
        this.endereco = endereco;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
        
    }

    public Integer[] getCep_distr() {
        return cep_distr;
    }

    public void setCep_distr(Integer[] cep_distr) {
        this.cep_distr = cep_distr;
    }

    
    public void cadastrar() {
        System.out.println("Cadastrado realizado com sucesso!");
    }
}
