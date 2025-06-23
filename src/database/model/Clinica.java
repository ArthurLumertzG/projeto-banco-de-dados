package database.model;

public class Clinica {

    private int idClinica;
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;
    private int idEndereco;

    public Clinica() {
    }


    public Clinica (String nome, String cnpj, String telefone, String email, int idEndereco){
    	this.nome = nome;
    	this.cnpj = cnpj;
    	this.telefone = telefone;
    	this.email = email;
    	this.idEndereco = idEndereco;
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


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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
}
