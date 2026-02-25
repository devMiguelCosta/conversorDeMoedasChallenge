import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author Miguel Silva Costa
 */
public class ServicoCambio {

    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private final String apiKey = "6cb6f5f41c64c4398582ab18";
    private final Gson gson = new Gson();
    private final HttpClient client = HttpClient.newHttpClient();

    public double pegarTaxa(String moedaBase, String moedaDestino) throws IOException, InterruptedException {
        String endereco = BASE_URL + apiKey + "/latest/" + moedaBase;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Falha na comunicação com a API de Câmbio. Status: " + response.statusCode());
        }

        RespostaCambio resposta = gson.fromJson(response.body(), RespostaCambio.class);

        if (resposta.conversion_rates() == null || !resposta.conversion_rates().containsKey(moedaDestino)) {
            throw new IllegalArgumentException("Moeda de destino '" + moedaDestino + "' não encontrada.");
        }

        return resposta.conversion_rates().get(moedaDestino);
    }
}