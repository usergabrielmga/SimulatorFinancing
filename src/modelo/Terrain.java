package modelo;

import java.io.Serializable;

public class Terrain extends Financing implements Serializable {
    private String typeZone;

    public Terrain(double propertyValue, int financingTerm, double annualFee, String typeZone) {
        super(propertyValue, financingTerm, annualFee);
        this.typeZone = typeZone;
    }

    public double calculateMonthlyPayment() {
        double mensalFee = annualFee / 12 / 100; // Taxa mensal
        int totalMonths = financingTerm * 12; // Número total de meses

        // Fórmula do sistema PRICE para cálculo da parcela mensal
        double fator = Math.pow(1 + mensalFee, totalMonths);
        double monthlyInstallment = propertyValue * (mensalFee * fator) / (fator - 1);

        // Acréscimo de 2% devido ao risco de inadimplência
        double monthlyInstallmentWithRisk = monthlyInstallment * 1.02;

        return Math.round(monthlyInstallmentWithRisk * 100.0) / 100.0; // Limita a 2 casas decimais
    }

    public String getTypeZone() {
        return typeZone;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Tipo de zoneamento = %s", typeZone);
    }
}