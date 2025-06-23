package database.model;

import java.sql.Date;

public class Recibo {

	private int idRecibo;
	private int idConsulta;
	private Double valor;
	private Date dataEmissao;
	private String formaPagamento;
	private String detalhes;
    
	public Recibo() {
	}
	
	public Recibo(int idConsulta, Double valor, Date dataEmissao, String formaPagamento, String detalhes) {
		this.idConsulta = idConsulta;
		this.valor = valor;
		this.dataEmissao = dataEmissao;
		this.formaPagamento = formaPagamento;
		this.detalhes = detalhes;
		}

	public int getIdRecibo() {
		return idRecibo;
	}

	public String getIdReciboAsString() {
    	return String.valueOf(this.idRecibo);
	}

	public void setIdRecibo(int idRecibo) {
		this.idRecibo = idRecibo;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public String getIdConsultaAsString() {
    	return String.valueOf(this.idConsulta);
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Double getValor() {
		return valor;
	}

	public String getValorAsString() {
		return String.valueOf(this.valor);
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Date getDataEmissao() {
		return dataEmissao;
	}

	public String getDataEmissaoAsString() {
		return String.valueOf(this.dataEmissao);
	}
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
	
}
