package database.model;

public class Auxiliar {

	private int idAuxiliar;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private int idEndereco;
    private String crmv;
    private int idClinica;


	public Auxiliar() {
	}

	public Auxiliar(String nome, String cpf, String crmv, String email, int idClinica ,String telefone, int idEndereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.idClinica = idClinica;
		this.email = email;
		this.crmv = crmv;
		this.idEndereco = idEndereco;
	}

	public Auxiliar(int idAuxiliar, String nome, String cpf, String crmv, String email, int idClinica ,String telefone, int idEndereco) {
		this.idAuxiliar = idAuxiliar;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.idClinica = idClinica;
		this.email = email;
		this.crmv = crmv;
		this.idEndereco = idEndereco;
	}

	public int getIdAuxiliar() {
		return idAuxiliar;
	}

	public String getIdAuxiliarAsString() {
		return String.valueOf(idAuxiliar);
	}

	public void setIdAuxiliar(int idAuxiliar) {
		this.idAuxiliar = idAuxiliar;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public String getIdEnderecoAsString() {
        return String.valueOf(this.idEndereco);
    }

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}

	public int getIdClinica() {
		return idClinica;
	}

	public String getIdClinicaAsString() {
        return String.valueOf(this.idClinica);
    }

	public void setIdClinica(int idClinica) {
		this.idClinica = idClinica;
	}
	
	
}