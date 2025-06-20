package database.model;

public class Veterinario {

	private int idVeterinario;
	private int idClinica;
	private int idEndereco;
	private String nome;
	private String cpf;
	private String crmv;
	private String email;
	private String especialidade;
	private String telefone;
	
	public Veterinario () {
		
	}
	
	public Veterinario (int idVeterinario, int idClinica, int idEndereco, String nome, String cpf, String crmv, String email, String especialidade, String telefone) {
		this.idVeterinario = idVeterinario;
		this.idClinica = idClinica;
		this.idEndereco = idEndereco;
		this.nome = nome;
		this.cpf = cpf;
		this.crmv = crmv;
		this.email = email;
		this.especialidade = especialidade;
		this.telefone = telefone;
	}

	public int getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(int idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	public int getIdClinica() {
		return idClinica;
	}

	public void setIdClinica(int idClinica) {
		this.idClinica = idClinica;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
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

	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}


