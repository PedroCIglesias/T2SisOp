import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;




public class Compilador {

    public ArrayList<Executavel> lerArquivo(String nomeArquivo) {
        ArrayList<Executavel> codigoExecutavel = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(" ");
                String comando = partes[0];
                Processo processo = new Processo();

                if (comando.equals("IN")) {
                    processo.id = partes[1].substring(1, partes[1].length() - 1);
                    processo.tamanho = Integer.parseInt(partes[2]);
                    codigoExecutavel.add(new Executavel(Executavel.Tipo.IN,processo));
                } else if (comando.equals("OUT")) {
                    processo.id = partes[1].substring(1, partes[1].length() - 1);
                    codigoExecutavel.add(new Executavel(Executavel.Tipo.OUT,processo));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return codigoExecutavel;
    }
}
