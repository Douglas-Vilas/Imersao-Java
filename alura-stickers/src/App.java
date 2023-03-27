import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Fazer uma conexão HTTP e buscar os tops 250 filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereço = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereço).GET().build();

        // Pegar só os dados que interessam (titulo, poster, classififcação) 

        // Exibir e manipular os dados

    }
}
