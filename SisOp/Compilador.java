package sisOp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Compilador {

    public ArrayList<Executavel> lerArquivo(String nomeArquivo) {
        ArrayList<Executavel> codigoExecutavel = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Processo processo = new Processo();
                linha = linha.trim();
                if (linha.startsWith("IN")) {
                    String[] partes = linha.split("[(),]");
                    processo.id = partes[1].trim();
                    processo.tamanho = Integer.parseInt(partes[2].trim());
                    codigoExecutavel.add(new Executavel(Executavel.Tipo.IN, processo));
                } else if (linha.startsWith("OUT")) {
                    String[] partes = linha.split("[(),]");
                    processo.id = partes[1].trim();
                    codigoExecutavel.add(new Executavel(Executavel.Tipo.OUT, processo));
                }
            }
            return codigoExecutavel;
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return null;
    }
}
