package projetoPOOSistemaBiblioteca;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Emprestado {
	private Date dataEmprestimo;
	private Date dataDevolucao;
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	Calendar calendar = Calendar.getInstance();
	private Livro livroEmprestado;
	private Usuario usuarioEmprestado;
	private Funcionario funcionarioFornecedor;
	
	public Emprestado(Livro livroEmprestado, Usuario usuarioEmprestado, Funcionario funcionarioFornecedor) {
		calendar.setTime( new java.util.Date() );
		this.livroEmprestado = livroEmprestado;
		this.usuarioEmprestado = usuarioEmprestado;
		this.funcionarioFornecedor = funcionarioFornecedor;
		this.dataEmprestimo = calendar.getTime();
		calendar.add( Calendar.DAY_OF_MONTH , 20 );
		this.dataDevolucao = calendar.getTime();
	}
	public Livro getLivroEmprestado() {
		return this.livroEmprestado;
	}
	public void setLivroEmprestado(Livro novoLivroEmprestado) {
		this.livroEmprestado = novoLivroEmprestado;
	}
	public Usuario getUsuarioEmprestado() {
		return this.usuarioEmprestado;
	}
	public void setUsuarioEmprestado(Usuario novoUsuarioEmprestado) {
		this.usuarioEmprestado = novoUsuarioEmprestado;
	}
	public Funcionario getFuncionarioFornecedor() {
		return this.funcionarioFornecedor;
	}
	public void setFuncionarioFornecedor(Funcionario novoFuncionarioFornecedor) {
		this.funcionarioFornecedor = novoFuncionarioFornecedor;
	}
	public Date getDataEmprestimo() {
		return this.dataEmprestimo;
	}
	public void setDataEmprestimo(Date novaDataEmprestimo) {
		this.dataEmprestimo = novaDataEmprestimo;
	}
	public Date getDataDevolucao() {
		return this.dataDevolucao;
	}
	public void setDataDevolucao(Date novaDataDevolucao) {
		this.dataDevolucao = novaDataDevolucao;
	}
	public String toString() {
		return "\nLivro: " + getLivroEmprestado().toString() + "\nUsuário: " + getUsuarioEmprestado().toString() + 
				"\nFuncionário: " + getFuncionarioFornecedor().toString() + "\nData do Emprestimo / Devolução: " + 
				df.format(getDataEmprestimo()) + " - " + df.format(getDataDevolucao())+"\n";
	}
}