package database.model;

public class Endereco {

	private int idEndereco;
	private String cep;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String complemento;

	public Endereco() {

	}

	public Endereco(int idEndereco, String cep, String rua, String numero, String bairro, String cidade, String estado, String complemento) {
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
