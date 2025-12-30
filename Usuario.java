public class Usuario {
    private String nome;
    private double matricula;

    public Usuario(String nome, double matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    public String getNome(){
        return nome;
    }
    public double getMatricula(){
        return matricula;
    }

}
