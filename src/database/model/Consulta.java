package database.model;

import java.sql.Date;

public class Consulta {

	private int idConsulta;
	private int idVeterinario;
	private int idAuxiliar;
	private int idPet;
	private Date dataHora;
	private int idEndereco;
	private String motivo;
	private String diagnostico;
	private String tratamento;

	public Consulta() {
	}

	public Consulta(int idVeterinario, int idAuxiliar, int idPet, Date dataHora, int idEndereco,
			String motivo, String diagnostico, String tratamento) {
		this.idVeterinario = idVeterinario;
		this.idAuxiliar = idAuxiliar;
		this.idPet = idPet;
		this.dataHora = dataHora;
		this.idEndereco = idEndereco;
		this.motivo = motivo;
		this.diagnostico = diagnostico;
		this.tratamento = tratamento;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public int getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(int idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	public int getIdAuxiliar() {
		return idAuxiliar;
	}

	public void setIdAuxiliar(int idAuxiliar) {
		this.idAuxiliar = idAuxiliar;
	}

	public int getIdPet() {
		return idPet;
	}

	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

}
