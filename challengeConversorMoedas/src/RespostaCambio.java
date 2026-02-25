import java.util.Map;

/**
 * @author Miguel Silva Costa
 */
public record RespostaCambio(Map<String, Double> conversion_rates) {
    // Records automaticamente geram getters, equals, hashCode e toString.
}