import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaLivraria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <Usuario> user = new ArrayList<>();
        ArrayList <Livro> books = new ArrayList<>();

        int opcao = 0;
        do {
            System.out.println("Seja bem vindo ao sistema de bliblioteca, digite a opção desejada: ");
            System.out.println("1 - Área do usuário\n2 - Área do acervo\n3 - Sair");
            boolean entradaValidada = false;
            while (!entradaValidada) {
                try {
                    opcao = sc.nextInt();
                    entradaValidada = true;
                }
                catch(InputMismatchException e){
                    System.err.println("Opção inválida, insira um número inteiro correspondente a uma das opções!");
                    sc.nextLine();
                }
            }
            sc.nextLine();
            switch (opcao) {
                case 1: {
                    int optionCadastro = 0;
                    do {
                        System.out.println("Digite '1' para cadastrar um usuário\nDigite '2' para excluir um usuário\nDigite '3' para visualizar os usuários cadastrados\nDigite '4' para voltar ao menu inicial");
                        boolean entradaValida = false;
                        while(!entradaValida){
                            try{
                                optionCadastro = sc.nextInt();
                                entradaValida = true;
                            } catch (InputMismatchException e){
                                System.err.println("Opção inválida insira apenas um número inteiro correspondente a uma das opções!");
                                sc.nextLine();
                            }
                        }
                        sc.nextLine();
                        switch (optionCadastro) {
                            case 1: {
                                System.out.println("Insira o nome do Usuário: ");
                                String usuario = sc.nextLine();
                                while (usuario.isBlank()) {
                                    System.err.println("Nome de usuário está vazio, tente novamente!");
                                    usuario = sc.nextLine();
                                }
                                System.out.println("Insira o número de matricula: ");
                                boolean matriculaValida = false;
                                double matricula = 0;
                                do {
                                    try {
                                        matricula = sc.nextDouble();
                                        matriculaValida = true;
                                    } catch (InputMismatchException e){
                                        System.err.println("Número de matricula inválido, insira somente números!");
                                        sc.nextLine();
                                    }
                                } while(!matriculaValida);
                                System.out.println("Deseja confirmar o cadastro?\nDigite '1' para SIM e '2' para NÃO");
                                boolean cadastroConfirmado = false;
                                int confirmaCadastro = 0;
                                while (!cadastroConfirmado) {
                                    try {
                                        confirmaCadastro = sc.nextInt();
                                        cadastroConfirmado = true;
                                    } catch (InputMismatchException e) {
                                        System.err.println("Opção inválida, insira somente um número inteiro correspondente a uma das opções na tela!");
                                        sc.nextLine();
                                    }
                                }
                                if(confirmaCadastro == 1){
                                    user.add(new Usuario(usuario, matricula));
                                    System.out.println("O usuário " + usuario + " de matricula " + matricula + " foi cadastrado com sucesso, voltando ao menu anterior!");
                                }
                                else if(confirmaCadastro == 2)
                                    System.out.println("Cadastro cancelado!");
                                else
                                    System.err.println("Opção inválida, Digite '1' para SIM ou '2' para NÃO");
                                break;
                            }
                            case 2: {
                                if(!user.isEmpty()) {
                                    System.out.println("Qual usuário você deseja excluir?\nInsira um número correspondente a sua escolha!");
                                    int cont = 1;
                                    for (Usuario usu : user) {
                                        System.out.println(cont + " - " + usu.getNome());
                                        cont++;
                                    }
                                    boolean exclusaoValida = false;
                                    while (!exclusaoValida) {
                                        try {
                                            int usuarioExcluido = (sc.nextInt() - 1);
                                            String nomeUsuarioExcluido = user.get(usuarioExcluido).getNome();
                                            user.remove(usuarioExcluido);
                                            exclusaoValida = true;
                                            System.out.println("O usuário " + nomeUsuarioExcluido + " foi excluído com sucesso!");
                                            break;
                                        } catch (InputMismatchException | IndexOutOfBoundsException e) {
                                            System.err.println("Opção inválida, insira um número inteiro correspondente a um dos usuários que deseja excluir!");
                                            sc.nextLine();
                                        }
                                    }
                                } else
                                    System.err.println("Não há usuários cadastrados para serem excuídos!");
                                break;
                            }
                            case 3: {
                                if(!user.isEmpty()) {
                                    System.out.println("Lista de usuários cadastrados: ");
                                    int cont = 1;
                                    for (Usuario usuariosCadastrados : user) {
                                        System.out.println(cont + " - " + "Nome: " + usuariosCadastrados.getNome() + ", Matricula: " + usuariosCadastrados.getMatricula());
                                        cont++;
                                    }
                                } else
                                    System.err.println("Não há usuários cadastrados!");
                                break;
                            }
                            case 4: {
                                System.out.println("Voltando ao menu principal");
                                break;
                            }
                            default: {
                                System.err.println("Opção inválida tente novamente!");
                            }
                        }
                    } while(optionCadastro != 4);
                    break;
                }
                case 2: {
                    int optionAcervo = 0;
                    do {
                        System.out.println("Bem vindo ao acervo, que deseja fazer hoje?\nDigite '1' para entrar na área de casdastro do acervo\nDigite '2' para emprestar um livro\nDigite '3' para devolver um livro\nDigite '4' para voltar ao menu principal");
                        boolean entradaAcervoValida = false;
                        while (!entradaAcervoValida) {
                            try {
                                optionAcervo = sc.nextInt();
                                entradaAcervoValida = true;
                            } catch (InputMismatchException e) {
                                System.err.println("Opção inválida, digite apenas um número inteiro que corresponda a uma das opções acima!");
                                sc.nextLine();
                            }
                        }
                        sc.nextLine();
                        switch (optionAcervo) {
                            case 1: {
                                int optionLivro = 0;
                                do {
                                    System.out.println("Digite '1' para cadastrar um livro\nDigite '2' para excluir um livro\nDigite '3' para visualizar os livros do acervo\nDigite '4' para voltar ao menu anterior");
                                    boolean areaDoLivroOk = false;
                                    while (!areaDoLivroOk){
                                        try{
                                            optionLivro = sc.nextInt();
                                            areaDoLivroOk = true;
                                        } catch (InputMismatchException e){
                                            System.err.println("Opção inválida, insira somente um número inteiro referente a uma das opções disponíveis");
                                            sc.nextLine();
                                        }
                                    }
                                    sc.nextLine();
                                    switch (optionLivro) {
                                        case 1: {
                                            System.out.println("Insira o nome do Livro: ");
                                            String nomeLivro = sc.nextLine();
                                            while(nomeLivro.isBlank()){
                                                System.err.println("O nome do livro está vazio, tente novamente!");
                                                nomeLivro = sc.nextLine();
                                            }
                                            System.out.println("Agora, o autor do livro: ");
                                            String nomeAutor = sc.nextLine();
                                            while(nomeAutor.isBlank()){
                                                System.err.println("O nome do autor está vazio, tente novamente!");
                                                nomeAutor = sc.nextLine();
                                            }
                                            System.out.println("Deseja confirmar o cadastro? Digite '1' para sim e '2' para não");
                                            int cadastro = 0;
                                            boolean confirmaCadastro = false;
                                            while (!confirmaCadastro) {
                                                try {
                                                    cadastro = sc.nextInt();
                                                    confirmaCadastro = true;
                                                } catch (InputMismatchException e) {
                                                    System.err.println("Opção inválida, insira somente números inteiros referente a uma das opções!");
                                                    sc.nextLine();
                                                }
                                            }
                                            if (cadastro == 1) {
                                                books.add(new Livro(nomeLivro, nomeAutor, true, " "));
                                                System.out.println("O livro " + nomeLivro + ", de autor(a) " + nomeAutor + "  foi cadastrado com sucesso!");
                                            } else if (cadastro == 2)
                                                System.out.println("Cadastro cancelado!");
                                            else
                                                System.err.println("Opção inválida, digite apenas um número referente a uma das opções!");
                                            break;
                                        }
                                        case 2: {
                                            if(!books.isEmpty()){
                                                System.out.println("Qual livro você deseja excluir?");
                                                int cont = 1;
                                                for(Livro livros : books){
                                                    System.out.println(cont + " - " + livros.getTitulo() + " " + (livros.isDisponivel() ? " Está no acervo" : " Está emprestado"));
                                                    cont++;
                                                }
                                                boolean exclusaoLivroOk = false;
                                                do {
                                                    try {
                                                        int El = (sc.nextInt() - 1);
                                                        String livroExcluido = books.get(El).getTitulo();
                                                        String autorLivroExcluido = books.get(El).getAutor();
                                                        books.remove(El);
                                                        System.out.println("O livro, " + livroExcluido + ", do autor, " + autorLivroExcluido + ", foi excluido com sucesso!");
                                                        exclusaoLivroOk = true;
                                                        sc.nextLine();
                                                        break;
                                                    } catch (InputMismatchException | IndexOutOfBoundsException e) {
                                                        System.err.println("Opção inválida, escolha um número inteiro correspondete a uma das opções disponíveis!");
                                                        sc.next();
                                                    }
                                                } while(!exclusaoLivroOk);
                                            }
                                            else
                                                System.err.println("Não há nenhum livro cadastrado para ser excluído!");
                                            break;
                                        }
                                        case 3: {
                                            if(!books.isEmpty()) {
                                                System.out.println("Lista de livros cadastrados no acervo da bliblioteca: ");
                                                int cont = 1;
                                                for (Livro acervo : books) {
                                                    System.out.println(cont + " - " + acervo.getTitulo() + " " + (acervo.isDisponivel() ? " - Disponível no acervo" : " - Emprestado"));
                                                    cont++;
                                                }
                                            } else
                                                System.err.println("Não há livros cadastrados na bliblioteca!");
                                            break;
                                        }
                                        case 4: {
                                            System.out.println("Voltando ao menu anterior");
                                            break;
                                        }
                                        default: {
                                            System.err.println("Opção inválida, insira um número inteiro referente a uma das opções disponíveis!");
                                            break;
                                        }
                                    }
                                } while(optionLivro != 4);
                                break;
                            }
                            case 2: {
                                if (!user.isEmpty()) {
                                    boolean emprestimoDisponivel = false;
                                    for (Livro livros : books) {
                                        if (livros.isDisponivel()) {
                                            emprestimoDisponivel = true;
                                            break;
                                        }
                                    }
                                    if (!books.isEmpty() && emprestimoDisponivel) {
                                        boolean livroEmprestado = false;
                                        do {
                                            try {
                                                System.out.println("Qual livro deseja emprestar?");
                                                int contador = 1;
                                                for (Livro livros : books) {
                                                    if (livros.isDisponivel()) {
                                                        System.out.println(contador + " - " + livros.getTitulo());
                                                    }
                                                    contador++;
                                                }
                                                int El = (sc.nextInt() - 1);
                                                System.out.println("Vai empresta-lo a quem?");
                                                int cont = 1;
                                                for (Usuario usuarios : user) {
                                                    System.out.println(cont + " - " + usuarios.getNome());
                                                    cont++;
                                                }
                                                int Ul = (sc.nextInt() - 1);
                                                books.get(El).setDisponivel(false);
                                                books.get(El).setLivroEmprestado(user.get(Ul).getNome());
                                                System.out.println("O livro, " + books.get(El).getTitulo() + " foi emprestado com sucesso para o usuário " + user.get(Ul).getNome() + " de matrícula: " + user.get(Ul).getMatricula());
                                                livroEmprestado = true;
                                            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                                                System.err.println("Opção inválida, selecione uma das opções disponíveis!");
                                                sc.next();
                                            }
                                        } while(!livroEmprestado);
                                    } else
                                        System.err.println("Não há nenhum livro disponível para empréstimo");
                                } else
                                    System.err.println("Antes de tentar emprestar um livro, primeiramente cadastre um usuário");
                                break;
                            }
                            case 3: {
                                if (!books.isEmpty()) {
                                    boolean devolucaoDisponivel = false;
                                    for (Livro livros : books) {
                                        if (!livros.isDisponivel()) {
                                            devolucaoDisponivel = true;
                                            break;
                                        }
                                    }
                                    if (devolucaoDisponivel) {
                                        boolean entradaLivroDevolvido = false;
                                        int dL = 0;
                                        do {
                                            try {
                                                System.out.println("Qual livro deseja devolver?");
                                                int contador = 1;
                                                for (Livro livros : books) {
                                                    if (!livros.isDisponivel()) {
                                                        System.out.println(contador + " - " + livros.getTitulo() + " emprestado a: " + livros.getLivroEmprestado());
                                                    }
                                                    contador++;
                                                }
                                                dL = (sc.nextInt() - 1);
                                                books.get(dL).setDisponivel(true);
                                                books.get(dL).setLivroEmprestado(" ");
                                                System.out.println("O livro, " + books.get(dL).getTitulo() + " foi devolvido com sucesso!");
                                                entradaLivroDevolvido = true;
                                                sc.nextLine();
                                                break;
                                            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                                                System.err.println("Opção inválida, tente novamente!");
                                                sc.nextLine();
                                            }
                                        } while(!entradaLivroDevolvido);
                                    } else
                                        System.err.println("Não há nenhum livro emprestado do acervo da bliblioteca!");
                                } else
                                    System.err.println("Não há nenhum livro cadastrado para ser devolvido, tente cadastrar um primeiro");
                                break;
                            }
                            case 4: {
                                System.out.println("Voltando ao menu principal...");
                                break;
                            }
                            default: {
                                System.err.println("Opção inválida, lembre-se de digitar uma das opções disponíveis!");
                                break;
                            }
                        }
                    } while(optionAcervo != 4);
                    break;
                }
                case 3: {
                    System.out.println("Saindo...");
                    break;
                }
                default: {
                    System.err.println("Opção inválida, tente novamente!");
                    break;
                }
            }
        } while (opcao != 3);
            System.out.println("Programa encerrado, até a próxima!");
    }
}
