import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {

        // Fazer uma conexão HTTP e buscar os tops 250 filmes
 
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();

        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        String url = "http://localhost:8081/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url); //json é o body da classe ClienteHttp        

        // Exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "C:\\Users\\dougl\\OneDrive\\Documentos\\MeusProjetos\\Imersao-Java\\alura-stickers\\saida\\" + conteudo.getTitulo().replace(":", "-") + ".png";

           geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}