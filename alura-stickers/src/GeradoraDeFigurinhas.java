import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria() throws Exception {

        // Leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(new File(
                "C:\\Users\\dougl\\OneDrive\\Documentos\\MeusProjetos\\Imersao-Java\\alura-stickers\\entrada\\filme.jpg"));

        // Criar uma nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // Copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // Configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);// <<<<<<<<<<< PAREI AQUI NA AULA >>>>>>>>>>>>>>>>42.44

        // Escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 100, novaAltura - 100);

        // Escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(
                "C:\\Users\\dougl\\OneDrive\\Documentos\\MeusProjetos\\Imersao-Java\\alura-stickers\\saida\\figurinha.png"));
    }

    public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();
        geradora.cria();
    }

}
