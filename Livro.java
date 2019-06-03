package projetoPOOSistemaBiblioteca;

public class Livro {
	
	private String autores;
	private String titulo;
	private String edicao;
	private String codigoDeBarra;
	private double preco;
	private int anoLancado;
	
	public Livro(String autores, String titulo, String edicao, String codigoDeBarra, double preco, int anoLancado) {
		
		this.autores = autores;
		this.titulo = titulo;
		this.edicao = edicao;
		this.codigoDeBarra = codigoDeBarra;
		this.preco = preco;
		this.anoLancado = anoLancado;
		
	}
	public String getAutores() {
		return this.autores;
	}
	public void setAutores(String novosAutores) {
		this.autores = novosAutores;
	}
	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(String novoTitulo) {
		this.titulo = novoTitulo;
	}
	public String getEdicao() {
		return this.edicao;
	}
	public void setEdicao(String novaEdicao) {
		this.edicao = novaEdicao;
	}
	public String getCodigoDeBarra() {
		return this.codigoDeBarra;
	}
	public void setCodigoDeBarra(String novoCodigoDeBarra) {
		this.codigoDeBarra = novoCodigoDeBarra;
	}
	public double getPreco() {
		return this.preco;
	}
	public void setPreco(double novoPreco) {
		this.preco = novoPreco;
	}
	public int getAnoLancado() {
		return this.anoLancado;
	}
	public void setAnoLancado(int novoAnoLancado) {
		this.anoLancado = novoAnoLancado;
	}
	public String toString() {
		return this.titulo+" - "+this.autores+" - "+this.edicao+" - "+this.codigoDeBarra+" - "+this.anoLancado;
	}
}