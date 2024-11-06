import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exemplo_Tigrinho {
    private static final String LITTLE_TIGER_EVOLUTION = "Little Tiger Evolution";
    private static final int NOME = 0;
    private static final int ENDERECO = 1;
    private static final int EMAIL = 2;

    private static List<String[]> doadores = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(LITTLE_TIGER_EVOLUTION);
        exibirMenu();
    }

    private static void exibirMenu() {
        String menu = ("""
                 ---------------------------------
                | 1- Adicionar conta              |
                | 2- Exibir doadores cadastrados  |
                | 3- Alterar doador               |
                | 4- Remover doador               |
                | 5- Sair                         |
                 ---------------------------------
                """);
        Scanner leia = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println(menu);
            System.out.println("Escolha:");
            opcao = leia.nextInt();

            if (opcao == 1) System.out.println(adicionarDoador());
            if (opcao == 2) exibirDoadores();
            if (opcao == 3) System.out.println(alterarDoadores());
            if (opcao == 4) removerDoador();
            if (opcao == 5) System.out.println("Finalizando " + LITTLE_TIGER_EVOLUTION);

        } while (opcao != 5);
    }

    private static String adicionarDoador() {
        Scanner leia = new Scanner(System.in);
        String[] doador = new String[3];
        System.out.println("Qual seu nome?");
        doador[NOME] = leia.nextLine();

        System.out.println("Seu endereço?");
        doador[ENDERECO] = leia.nextLine();

        System.out.println("E seu email?");
        doador[EMAIL] = leia.nextLine();

        doadores.add(doador);
        return "Sucesso!";
    }

    private static void exibirDoadores() {
        System.out.println("Lista dos doadores:");
        int indexDoador = 0;
        for (String[] doador : doadores) {
            System.out.println("[ " + (indexDoador++) + " ]" + doador[NOME] + "-" + doador[ENDERECO] + "-" + doador[EMAIL]);
        }
    }

    private static String alterarDoadores() {
        Scanner leia = new Scanner(System.in);
        System.out.println("ALTERANDO DOADOR");
        System.out.println("Informe o index do doador: ");
        int indexDoador = leia.nextInt();

        // Consume the newline left by nextInt()
        leia.nextLine();

        System.out.println("Alterar dados do doador: " + doadores.get(indexDoador)[NOME]);
        System.out.println("Seu novo nome?");
        doadores.get(indexDoador)[NOME] = leia.nextLine();

        System.out.println("Seu novo endereço?");
        doadores.get(indexDoador)[ENDERECO] = leia.nextLine();

        System.out.println("E seu novo email?");
        doadores.get(indexDoador)[EMAIL] = leia.nextLine();

        return "Sucesso!";
    }

    private static void removerDoador() {
        Scanner leia = new Scanner(System.in);
        System.out.println("REMOVENDO DOADOR");
        System.out.println("Informe o index do doador que deseja remover: ");
        int indexDoador = leia.nextInt();

     

        // Verifica se o índice informado é válido
        if (indexDoador >= 0 && indexDoador < doadores.size()) {
            // Remove o doador da lista
            doadores.remove(indexDoador);
            System.out.println("Doador removido com sucesso!");
        } else {
            System.out.println("Índice inválido! Não foi possível remover o doador.");
        }
    }
}
