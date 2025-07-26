package util;
import java.util.Scanner;

public class UserInterface {

    // Método para solicitar o valor do imóvel ao usuário
    public double requestPropertyValue() {
        // Instancia o Scanner para ler a entrada do usuário
        Scanner sc = new Scanner(System.in);
        Boolean validEntry = false; // Variável para controlar a validade da entrada
        double response = 0; // Variável para armazenar o valor do imóvel

        // Laço para garantir que a entrada seja válida
        while(!validEntry) {
            System.out.println("Informe o valor do imóvel: ");
            try {
                // Lê a entrada do usuário
                response = sc.nextDouble();
                // Verifica se o valor é negativo, o que não é válido
                if(response < 0) {
                    System.out.println("Valor do imóvel ínvalido!Tente um valor válido.");
                } else {
                    validEntry = true; // Entrada válida, sai do laço
                }
            } catch (Exception e) {
                // Caso ocorra um erro (entrada inválida), exibe uma mensagem
                System.out.println("Erro: Digite apenas números inteiros.");
                sc.next(); // Limpa o buffer do Scanner para evitar loop infinito
            }
        }
        
        return response; // Retorna o valor do imóvel
    }

    // Método para solicitar o prazo do financiamento em anos
    public int requestFinancingTerm() {
        // Instancia o Scanner para ler a entrada do usuário
        Scanner sc = new Scanner(System.in);
        Boolean validEntry = false; // Variável para controlar a validade da entrada
        int response = 0; // Variável para armazenar o prazo do financiamento

        // Laço para garantir que a entrada seja válida
        while(!validEntry) {
            System.out.println("Informe o prazo do financiamento em anos: ");
            try {
                // Lê a entrada do usuário
                response = sc.nextInt();
                // Verifica se o prazo é negativo, o que não é válido
                if(response < 0) {
                    System.out.println("Prazo ínvalido!Tente um valor válido.");
                } else {
                    validEntry = true; // Entrada válida, sai do laço
                }
            } catch (Exception e) {
                // Caso ocorra um erro (entrada inválida), exibe uma mensagem
                System.out.println("Erro: Digite apenas números inteiros.");
                sc.next(); // Limpa o buffer do Scanner para evitar loop infinito
            }
        }
        
        return response; // Retorna o prazo do financiamento
    }

    // Método para solicitar a taxa anual de juros ao usuário
    public double requestAnnualFee() {
        // Instancia o Scanner para ler a entrada do usuário
        Scanner sc = new Scanner(System.in);
        Boolean validEntry = false; // Variável para controlar a validade da entrada
        double response = 0; // Variável para armazenar a taxa anual

        // Laço para garantir que a entrada seja válida
        while(!validEntry) {
            System.out.println("Informe a taxa anual: ");
            try {
                // Lê a entrada do usuário
                response = sc.nextDouble();
                // Verifica se a taxa está dentro do intervalo válido (0 a 60)
                if(response < 0 || response > 60 ) {
                    System.out.println("Taxa anual ínvalida! Tente um número válido.");
                } else {
                    validEntry = true; // Entrada válida, sai do laço
                    System.out.println("Cadastrado com sucesso!"); // Mensagem de sucesso
                }
                
            } catch (Exception e) {
                // Caso ocorra um erro (entrada inválida), exibe uma mensagem
                System.out.println("Erro: Digite apenas números inteiros.");
                sc.next(); // Limpa o buffer do Scanner para evitar loop infinito
            }
        }
        
        return response; // Retorna a taxa anual de juros
    }


    // Método genérico para valores numéricos (double)
    public double requestDouble(String message, double min, double max) {
        Scanner sc = new Scanner(System.in);
        double response = 0;
        boolean valid = false;
        
        while (!valid) {
            System.out.println(message);
            try {
                response = sc.nextDouble();
                if (response >= min && response <= max) {
                    valid = true;
                } else {
                    System.out.printf("Erro: Digite um valor entre %.2f e %.2f.\n", min, max);
                }
            } catch (Exception e) {
                System.out.println("Erro: Digite um número válido.");
                sc.next();
            }
        }
        return response;
    }


    // Método genérico para valores inteiros
    public int requestInt(String message, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int response = 0;
        boolean valid = false;

        while (!valid) {
            System.out.println(message);
            try {
                response = sc.nextInt();
                if (response >= min && response <= max) {
                    valid = true;
                } else {
                    System.out.printf("Erro: Digite um valor entre %d e %d.\n", min, max);
                }
            } catch (Exception e) {
                System.out.println("Erro: Digite um número inteiro válido.");
                sc.next();
            }
        }
        return response;
    }


    // Método para solicitar um texto
    public String requestText(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }

    // Método para selecionar opções específicas (exemplo: tipo de zona)
    public String requestZoneType() {
        Scanner sc = new Scanner(System.in);
        String response = "";
        boolean valid = false;

        while (!valid) {
            System.out.println("Informe o tipo de zona (residencial ou comercial): ");
            response = sc.nextLine().toLowerCase();
            if (response.equals("residencial") || response.equals("comercial")) {
                valid = true;
            } else {
                System.out.println("Erro: Escolha apenas entre 'residencial' ou 'comercial'.");
            }
        }
        return response;
    }

   
}
