
package main;

// Imports do pacote 'util'
import util.DiscountGreaterThanInterestException;
import util.UserInterface;
import util.FinancingUtils;

// Imports do pacote 'modelo'
import modelo.Apartment;
import modelo.House;
import modelo.Terrain;
import modelo.Financing;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Financing> listFinancing = new ArrayList<>();
        UserInterface user = new UserInterface();

        // Solicitar financiamento personalizado (Casa)
        System.out.println("=== Financiamento Personalizado: Casa ===");
        double propertyValue = user.requestPropertyValue();
        int financingTerm = user.requestFinancingTerm();
        double annualFee = user.requestAnnualFee();
        double builtArea = user.requestDouble("Informe o tamanho da área construída (em m²):", 0, 10000);
        double landSize = user.requestDouble("Informe o tamanho do terreno (em m²):", 0, 10000);

        // Criar o financiamento personalizado
        House userHouse = new House(propertyValue, financingTerm, annualFee, builtArea, landSize);

        
        // Adicionar financiamentos à lista
        listFinancing.add(userHouse);
        listFinancing.add(new House(500000, 10, 10, 200, 400)); 
        listFinancing.add(new Apartment(200000, 10, 12, 1, 10));
        listFinancing.add(new Terrain(150000, 15, 11, "residencial"));

        // Arquivos
        String textFileName = "financings.txt";
        String serializedFileName = "financings.ser";

        // Salvar e ler arquivos
        FinancingUtils.saveFinancingsToTextFile(listFinancing, textFileName);
        FinancingUtils.readFinancingsFromTextFile(textFileName);

        FinancingUtils.saveFinancingsSerialized(listFinancing, serializedFileName);
        List<Financing> loadedFinancings = FinancingUtils.readFinancingsSerialized(serializedFileName);

        // Exibir dados carregados
        System.out.println("=== Financiamentos carregados (desserializados): ===");
        for (Financing financing : loadedFinancings) {
            System.out.println(financing);
        }
    }
}
