package projetoPOOSistemaBiblioteca;

public class Pessoa {
	private String nome;
	private String CPF;
	private int idade;
	private String cidade;
	
	public Pessoa(String nome, String CPF, int idade, String cidade) {
		this.nome = nome;
		this.CPF = CPF;
		this.idade = idade;
		this.cidade = cidade;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	public String getCPF() {
		return this.CPF;
	}
	public void setCPF(String novoCPF) {
		this.CPF = novoCPF;
	}
	public int getIdade() {
		return this.idade;
	}	
	public void setIdade(int novaIdade) {
		this.idade = novaIdade;
	}	
	public String getCidade() {
		return this.cidade;
	}
	public void setCidade(String novaCidade) {
		this.cidade = novaCidade;
	}
}