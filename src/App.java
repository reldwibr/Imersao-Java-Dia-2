import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Digite 1 para Top 250 Filmes");
        System.out.println();
        System.out.println("Digite 2 para Filmes Mais Vistos");
        System.out.println();
        int choice = scan.nextInt();
        switch (choice) {
            case 1:

                // Conexão HTTP com a API dos Top 250 Filmes

                URI endereco250 = URI.create(APIs.Top250Movies);
                var client = HttpClient.newHttpClient();
                var request = HttpRequest.newBuilder(endereco250).GET().build();
                HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
                String body = response.body();
                
                // Interpreta o Json para o Java

                var parser = new JsonParser();
                List<Map<String, String>> listaDeFilmes = parser.parse(body);

                // Exibe as Infos

                for (Map<String, String> filme : listaDeFilmes) {
                    System.out.println(filme.get("title"));
                    System.out.println(filme.get("image"));
                    System.out.println(filme.get("imDbRating"));
                    System.out.println();
                }
                System.out.println("Nice!");
                System.out.println();
                break;
            case 2:

                // Conexão HTTP com a API dos Filmes Mais Vistos
                URI enderecoPopular = URI.create(APIs.MostPopularMovies);
                var client2 = HttpClient.newHttpClient();
                var request2 = HttpRequest.newBuilder(enderecoPopular).GET().build();
                HttpResponse<String> response2 = client2.send(request2, BodyHandlers.ofString());
                String body2 = response2.body();
                
                // Interpreta o Json para o Java

                var parser2 = new JsonParser();
                List<Map<String, String>> listaDeFilmes2 = parser2.parse(body2);

                // Exibe as Infos

                for (Map<String, String> filme2 : listaDeFilmes2) {
                    System.out.println(filme2.get("title"));
                    System.out.println(filme2.get("image"));
                    System.out.println(filme2.get("imDbRating"));
                    System.out.println();
                }
                System.out.println("Nice!");
                System.out.println();

                break;

            default:
                System.out.println("Bugadinho BR");

        }
    }
}