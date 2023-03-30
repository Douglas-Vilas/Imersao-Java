import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.Key;
import java.util.List;
import java.util.Map;
import javax.swing.text.html.HTMLEditorKit.Parser;

public class App {

    public static void main(String[] args) throws Exception {
       // Fazer uma conexão HTTP e buscar os tops 250 filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Pegar só os dados que interessam (titulo, poster, classififcação) 
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        // Exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));            
            System.out.println(filme.get("image"));            
            System.out.println(filme.get("imDbRating"));    
            System.out.println();        
        }
    }
}