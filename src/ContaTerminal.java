import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Por favor, digite o número da Agência!");
            String agencia = scanner.nextLine();

            int numero = 0;
            boolean validaEntrada = false;
            while (!validaEntrada) {
                System.out.println("Por favor, digite o número da Conta!");
                try {
                    numero = scanner.nextInt();
                    validaEntrada = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Tente novamente!.");
                    scanner.nextLine();
                }
            }
            scanner.nextLine();

            System.out.println("Por favor, digite o nome do Cliente!");
            String nomeCliente = scanner.nextLine();

            BigDecimal saldo = BigDecimal.ZERO;
            validaEntrada = false;
            while (!validaEntrada) {
                System.out.println("Por favor, digite o saldo inicial!");
                try {
                    String saldoStr = scanner.nextLine().replace(',', '.');
                    saldo = new BigDecimal(saldoStr);
                    validaEntrada = true;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Tente novamente!");
                    scanner.nextLine(); 
                }
            }
            
            System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é "
                    + agencia + ", conta " + numero + " e seu saldo " + NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR")).format(saldo) + " já está disponível para saque.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
