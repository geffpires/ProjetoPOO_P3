package projetoPOOSistemaBiblioteca;

public class Funcionario extends Pessoa{
	private String login;
	private String senha;
	
	public Funcionario(String nome, String CPF, int idade, String  cidade, String login, String senha) {
		super(nome, CPF, idade, cidade);
		this.login = login;
		this.senha = senha;	
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
		return getNome()+" - "+getCPF()+ " - "+getIdade()+" - "+getCidade();
	}
}