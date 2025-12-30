public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;
    private String livroEmprestado;

    public Livro(String titulo, String autor, boolean disponivel, String livroEmprestado){
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
        this.livroEmprestado = livroEmprestado;
    }
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
    public void setLivroEmprestado(String livroEmprestado){
        this.livroEmprestado = livroEmprestado;
    }
    public boolean isDisponivel(){
        return disponivel;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getAutor() { return autor; }
    public String getLivroEmprestado() { return livroEmprestado; }
}
