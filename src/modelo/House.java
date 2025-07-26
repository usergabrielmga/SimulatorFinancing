package modelo;

import java.io.Serializable;

import util.DiscountGreaterThanInterestException;

public class House extends Financing implements Serializable{
    private double landArea;
    private double landSize;


    public House(double propertyValue, int financingTerm, double annualFee, double landArea, double landSize) {

        super(propertyValue, financingTerm, annualFee);
        this.landArea = landArea;
        this.landSize = landSize;

    }

    public double calculateMonthlyPayment() {
        // Calcula a taxa de juros mensal
        double mensalFee = annualFee / 12 / 100;  // Taxa de juros mensal em formato decimal
        int totalMonths = financingTerm * 12;  // Número total de meses

        // Calcula a parcela mensal (usando fórmula do sistema PRICE)
        double fator = Math.pow(1 + mensalFee, totalMonths); // Fator (1 + i)^n
        double mensalPayment = propertyValue * (mensalFee * fator) / (fator - 1);  // Fórmula de financiamento

        // Limita a 2 casas decimais
        double totalMonthlyPayment = Math.round(mensalPayment * 100.0) / 100.0;
        return totalMonthlyPayment + 80; // Adiciona R$ 80 ao valor da parcela
    }

    public double getBuiltArea() {
       return landArea;
    }

    public double getLandSize() {
       return landSize;
    }

    public void applyDiscount(double discount) throws DiscountGreaterThanInterestException {
        double mensalFee = annualFee / 12 / 100;  // Taxa de juros mensal em formato decimal
        double jurosMensal = propertyValue * mensalFee;  // Valor dos juros mensais
    
        if (discount > jurosMensal) {
            throw new DiscountGreaterThanInterestException(
                "O desconto aplicado (" + discount + ") é maior do que os juros mensais (" + jurosMensal + ")."
            );
        }
    
        propertyValue -= discount; // Aplica o desconto ao valor do imóvel
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Área construída = %.2f m², Tamanho do terreno = %.2f m²", landArea, landSize);
    }
}