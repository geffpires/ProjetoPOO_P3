package projetoPOOSistemaBiblioteca;

public class Usuario extends Pessoa{
	private String curso;
	private String login;
	private String senha;
	
	public Usuario(String nome, String curso, String CPF, int idade, String cidade, String login, String senha) {
		super(nome,CPF,idade,cidade);
		this.curso = curso;
		this.login = login;
		this.senha = senha;
	}
	public String getCurso() {
		return this.curso;
	}
	public void setCurso(String novoCurso) {
		this.curso = novoCurso;
	}
	public String getLogin() {
		return this.login;
	}
	public void setLogin(String novoLogin) {
		this.login = novoLogin;
	}
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String novaSenha) {

		this.senha = novaSenha;
	}
	public boolean validaLogin(String login, String senha) {
		if (this.login.toUpperCase().equals(login.toUpperCase()) && this.senha.equals(senha)) {
			return true;
		}
		return false;
	}
	public String toString() {
		return getNome()+" - "+getCurso()+" - "+getCPF()+" - "+getIdade()+" - "+getCidade();
	}
}