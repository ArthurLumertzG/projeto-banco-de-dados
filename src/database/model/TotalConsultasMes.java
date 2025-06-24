package database.model;

public class TotalConsultasMes {

    private String mes;
    private int totalConsultasMes;

    public TotalConsultasMes() {
    }

    public TotalConsultasMes(String mes, int totalConsultasMes) {
        this.mes = mes;
        this.totalConsultasMes = totalConsultasMes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getTotalConsultasMes() {
        return totalConsultasMes;
    }

    public void setTotalConsultasMes(int totalConsultasMes) {
        this.totalConsultasMes = totalConsultasMes;
    }

    public String getTotalConsultasMesAsString() {
        return String.valueOf(totalConsultasMes);
    }
}
