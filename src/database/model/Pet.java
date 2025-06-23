package database.model;

import java.sql.Date;

public class Pet {

	private int idPet;
	private int idTutor;
	private String nome;
	private Date dataNascimento;
	private String especie;
	private String raca;

	public Pet() {
	}

	public Pet(int idTutor, String nome, Date dataNascimento, String especie, String raca) {
		this.idTutor = idTutor;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.especie = especie;
		this.raca = raca;
	}

	public Pet(int idPet, int idTutor, String nome, Date dataNascimento, String especie, String raca) {
		this.idPet = idPet;
		this.idTutor = idTutor;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.especie = especie;
		this.raca = raca;
	}

	public int getIdPet() {
		return idPet;
	}

	public String getIdPetAsString() {
    	return String.valueOf(this.idPet);
	}

	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}

	public int getIdTutor() {
		return idTutor;
	}

	public String getIdTutorAsString() {
    	return String.valueOf(this.idTutor);
	}

	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public String getDataNascimentoAsString() {
		return String.valueOf(this.dataNascimento);
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

}
