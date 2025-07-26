package modelo;

import java.io.Serializable;

public abstract class Financing implements Serializable {
    protected double propertyValue;
    protected int financingTerm;
    protected double annualFee;

    public Financing(double propertyValue, int financingTerm, double annualFee) {
        this.propertyValue = propertyValue;
        this.financingTerm = financingTerm;
        this.annualFee = annualFee;
    }

    public double getPropertyValue() {
        return this.propertyValue;
    }

    public int getFinancingTerm() {
        return this.financingTerm;
    }

    public double getAnnualFee() {
        return this.annualFee;
    }

    // MÉTODO ABSTRATO: DEVE TERMINAR COM PONTO E VÍRGULA E NÃO TER CORPO
    public abstract double calculateMonthlyPayment();
        
    // MÉTODO fullPayment() ESTÁ CORRETO
    public double fullPayment() {
        // Calcula o pagamento total (parcela mensal * número de meses)
        double monthlyPayment = calculateMonthlyPayment();
        int totalMonths = financingTerm * 12;
        double totalPayment = monthlyPayment * totalMonths;

        // Limita a 2 casas decimais
        return Math.round(totalPayment * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Financing {" +
                "Valor do imóvel = R$ " + String.format("%.2f", propertyValue) +
                ", Prazo do financiamento = " + financingTerm + " anos" +
                ", Taxa anual = " + String.format("%.2f", annualFee) + "%" +
                '}';
    }
}