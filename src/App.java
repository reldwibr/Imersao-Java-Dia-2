import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        /*API Top 250 Movies = Top250Movies
         * API Most Popular Movies = MostPopularMovies
         * API Nasa = APOD
          */
        String url = APIs.APOD;
        ExtratorDeConteudoNASA extrator = new ExtratorDeConteudoNASA();
        //ExtratorDeConteudoIMDB extrator = new ExtratorDeConteudoIMDB();
        var http = new HttpCalls();
        String json = http.buscaDados(url);

        // exibir e manipular os dados

        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var stickers = new StickerMachine();
        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "resources/images/" + conteudo.getTitulo() + ".png";

            stickers.cria(inputStream, nomeArquivo);
            //
            System.out.println(conteudo.getTitulo());
            System.out.println();

        }
    }
}