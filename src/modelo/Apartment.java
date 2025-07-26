package modelo;

import java.io.Serializable;

public class Apartment extends Financing implements Serializable{
    private int numberVacancies;
    private int floorNumber;

    public Apartment(double propertyValue, int financingTerm, double annualFee, int numberVacancies, int floorNumber) {
        super(propertyValue, financingTerm, annualFee);
        this.numberVacancies = numberVacancies;
        this.floorNumber = floorNumber;

    }

    public double calculateMonthlyPayment() {
        double mensalFee = annualFee / 12 / 100; // Taxa mensal
        int totalMonths = financingTerm * 12; // Número total de meses

        // Fórmula do sistema PRICE para cálculo da parcela mensal
        double fator = Math.pow(1 + mensalFee, totalMonths);
        double monthlyInstallment = propertyValue * (mensalFee * fator) / (fator - 1);

        return Math.round(monthlyInstallment * 100.0) / 100.0; // Limita a 2 casas decimais
    }

    public int getNumberVacancies() {
        return numberVacancies;
    }

    public int getFloor() {
        return floorNumber;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Andar = %d, Vagas de garagem = %d", floorNumber, numberVacancies);
    }

}
