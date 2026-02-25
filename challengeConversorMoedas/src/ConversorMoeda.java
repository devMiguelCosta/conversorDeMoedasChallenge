import java.util.Scanner;
import java.util.Locale;

/**
 * @author Miguel Silva Costa
 */
public class ConversorMoeda {

    public static void main(String[] args) {
        // Define o local como US para aceitar ponto como separador decimal
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        ServicoCambio servico = new ServicoCambio();

        System.out.println("=== Conversor de Moedas Profissional ===");

        try {
            System.out.print("Digite a moeda base (ex: USD): ");
            String base = scanner.nextLine().trim().toUpperCase();

            System.out.print("Digite a moeda de destino (ex: BRL): ");
            String destino = scanner.nextLine().trim().toUpperCase();

            System.out.print("Informe o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            double taxa = servico.pegarTaxa(base, destino);
            double resultado = valor * taxa;

            System.out.printf("\n>>> Sucesso! <<<\n");
            System.out.printf("Valor original: %.2f %s\n", valor, base);
            System.out.printf("Taxa atual: %.4f\n", taxa);
            System.out.printf("Resultado final: %.2f %s\n", resultado, destino);

        } catch (IllegalArgumentException e) {
            System.err.println("Erro de validação: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado no processamento.");
        } finally {
            scanner.close();
        }
    }
}