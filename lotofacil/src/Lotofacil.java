import java.io.IOException;

public class Lotofacil {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        java.util.Random random = new java.util.Random();
        
        int opcao;
        
        do {
            System.out.println("*************************");
            System.out.println("Menu LOTOFÁCIL:");
            System.out.println("1) Apostar de 0 a 100");
            System.out.println("2) Apostar de A à Z");
            System.out.println("3) Apostar em par ou ímpar");
            System.out.println("0) Sair");
            System.out.println("*************************");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    apostarDe0a100(scanner, random);
                    break;
                case 2:
                    apostarDeAaZ();
                    break;
                case 3:
                    apostarParOuImpar(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
        
        scanner.close();
    }
    
    public static void apostarDe0a100(java.util.Scanner scanner, java.util.Random random) {
        System.out.print("Digite um número de 0 a 100: ");
        int numeroApostado = scanner.nextInt();
        
        if (numeroApostado < 0 || numeroApostado > 100) {
            System.out.println("Aposta inválida.");
            return;
        }
        
        int numeroSorteado = random.nextInt(101);
        System.out.println("Número sorteado: " + numeroSorteado);
        
        if (numeroApostado == numeroSorteado) {
            System.out.println("Você ganhou R$ 1.000,00 reais.");
        } else {
            System.out.println("Que pena! O número sorteado foi: " + numeroSorteado);
        }
    }
    
    public static void apostarDeAaZ() {
        System.out.print("Digite uma letra de A à Z: ");
        char letraApostada;
        try {
            letraApostada = (char) System.in.read();
            if (!Character.isLetter(letraApostada)) {
                System.out.println("Aposta inválida.");
                return;
            }
            letraApostada = Character.toUpperCase(letraApostada);
        } catch (IOException e) {
            System.out.println("Erro ao ler a entrada.");
            return;
        }

        char letraPremiada = 'L';
        
        if (letraApostada == letraPremiada) {
            System.out.println("Você ganhou R$ 500,00 reais.");
        } else {
            System.out.println("Que pena! A letra sorteada foi: " + letraPremiada + ".");
        }
    }
    
    public static void apostarParOuImpar(java.util.Scanner scanner) {
        System.out.print("Digite um número inteiro: ");
        int numeroApostado = scanner.nextInt();
        
        if (numeroApostado % 2 == 0) {
            System.out.println("Você ganhou R$ 100,00 reais.");
        } else {
            System.out.println("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
        }
    }
}