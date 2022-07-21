import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerMachine {

    public void cria(InputStream inputStream, String nomeArquivo) throws IOException, FontFormatException {

        // Ler Imagem
        /*
         * Usando InputStream para ler uma imagem de um path da maquina local
         * InputStream inputStream =
         * new FileInputStream(new File("resources/images/MostPopularMovies_1.jpeg"));
         *
         * Acessando um InputStream por URL
         * InputStream inputStream =
         * new
         * URL("https://imersao-java-apis.s3.amazonaws.com/MostPopularMovies_2.jpg").
         * openStream();
         */

        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // Cria nova imagem em memória com transparência e com tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // Copiar imagem original para nova imagem (em memória)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar fonte
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("impact.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(100f);
        //var fonte = new Font(Font., Font.BOLD, 100);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        // escrever uma frase na nova imagem

        graphics.drawString("BRABO!!", 0, novaAltura - 100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
}