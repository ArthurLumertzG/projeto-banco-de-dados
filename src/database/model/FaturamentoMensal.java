package database.model;

public class FaturamentoMensal {

    private String mes;
    private Double faturamentoMensal;

    public FaturamentoMensal() {
    }

    public FaturamentoMensal(String mes, Double faturamentoMensal) {
        this.mes = mes;
        this.faturamentoMensal = faturamentoMensal;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Double getFaturamentoMensal() {
        return faturamentoMensal;
    }

    public void setFaturamentoMensal(Double faturamentoMensal) {
        this.faturamentoMensal = faturamentoMensal;
    }

    public String getFaturamentoMensalAsString() {
        return String.valueOf(faturamentoMensal);
    }
}
