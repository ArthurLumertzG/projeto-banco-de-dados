package database.model;

public class TotalConsultas {

    private int idClinica;
    private String nomeClinica;
    private int totalConsultas;

    public TotalConsultas() {
    }

    public TotalConsultas(int idClinica, String nomeClinica, int totalConsultas) {
        this.idClinica = idClinica;
        this.nomeClinica = nomeClinica;
        this.totalConsultas = totalConsultas;
    }

    public int getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(int idClinica) {
        this.idClinica = idClinica;
    }

    public String getNomeClinica() {
        return nomeClinica;
    }

    public void setNomeClinica(String nomeClinica) {
        this.nomeClinica = nomeClinica;
    }

    public int getTotalConsultas() {
        return totalConsultas;
    }

    public void setTotalConsultas(int totalConsultas) {
        this.totalConsultas = totalConsultas;
    }

    public String getIdClinicaAsString() {
        return String.valueOf(idClinica);
    }

    public String getTotalConsultasAsString() {
        return String.valueOf(totalConsultas);
    }
}
