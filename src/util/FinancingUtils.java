package util;

import modelo.Financing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FinancingUtils {

    // Método para salvar financiamentos em arquivo de texto
    public static void saveFinancingsToTextFile(List<Financing> financings, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Financing financing : financings) {
                writer.write(financing.toString());
                writer.newLine();
            }
            System.out.println("Dados salvos com sucesso no arquivo de texto.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados no arquivo de texto: " + e.getMessage());
        }
    }

    // Método para ler financiamentos de arquivo de texto
    public static void readFinancingsFromTextFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("=== Dados Lidos do Arquivo de Texto ===");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler os dados do arquivo de texto: " + e.getMessage());
        }
    }

    // Método para salvar financiamentos em arquivo serializado
    public static void saveFinancingsSerialized(List<Financing> financings, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(financings);
            System.out.println("Dados serializados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados serializados: " + e.getMessage());
        }
    }

    // Método para carregar financiamentos de arquivo serializado
    @SuppressWarnings("unchecked")
    public static List<Financing> readFinancingsSerialized(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Financing> financings = (List<Financing>) ois.readObject();
            System.out.println("Dados serializados carregados com sucesso.");
            return financings;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados serializados: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
