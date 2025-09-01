import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        double saldo = 2500;
        int dp = 0;
        int limiteAcumulado = 0;
        int limiteSaqueDiario = 3000;

        while (true) {
            System.out.println("""
                ==========================================
                Bem vindo ao Banco do Central
                Digite qual operação deseja?
                
                1 - Consultar Saldo
                2 - Fazer Depósito
                3 - Sacar Dinheiro
                4 - Sair  
                ==========================================
                """);

            int op = leitor.nextInt();
            try {
                if (op == 1) {
                    System.out.println("Seu Saldo é: " + saldo);
                    Thread.sleep(1000);
                } else if (op == 2) {
                    System.out.println("Qual valor deseja depositar? ");
                    double deposito = leitor.nextDouble();
                    Thread.sleep(1000);
                    if (deposito < 0) {
                        System.out.println("Valor inválido");
                        Thread.sleep(1000);
                    } else if (dp >= 3) {
                        System.out.println("Excedeu o limite de depósitos");
                        Thread.sleep(1000);
                    } else {
                        saldo += deposito;
                        dp++;
                        System.out.println("Depósito realizado com sucesso! Novo saldo: " + saldo);
                        Thread.sleep(1000);
                    }
                } else if (op == 3) {
                    System.out.println("Digite o valor a ser sacado: ");
                    double saque = leitor.nextDouble();

                    if (saque <= 0) {
                        System.out.println("Valor inválido");
                        Thread.sleep(1000);
                    } else if (saque > saldo) {
                        System.out.println("Não há saldo suficiente.");
                        Thread.sleep(1000);
                    } else if (limiteAcumulado + saque > limiteSaqueDiario) {
                        System.out.println("Excedeu o limite de saque diário.");
                        Thread.sleep(1000);
                    } else {
                        saldo -= saque;
                        limiteAcumulado += saque;
                        System.out.println("Contando notas.... Saque realizado com sucesso!");
                        Thread.sleep(1000);
                        System.out.println("Novo saldo: " + saldo);
                        Thread.sleep(1000);
                    }
                } else if (op == 4) {
                    System.out.println("Obrigado por usar o Banco do Central. Até mais!");
                    Thread.sleep(1000);
                    break;
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Erro: A thread foi interrompida.");
                e.printStackTrace();
            }
        }
        leitor.close();
    }
}