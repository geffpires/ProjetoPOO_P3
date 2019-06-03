package projetoPOOSistemaBiblioteca;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Vendido {
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	Calendar calendar = Calendar.getInstance();
	private Date dataVenda;
	private Livro livroVendido;
	private Usuario usuarioComprador;
	private Funcionario funcionarioFornecedor;
	
	
	public Vendido(Livro livroVendido, Usuario usuarioComprador, Funcionario funcionarioFornecedor) {
		
		calendar.setTime( new java.util.Date() );
		this.livroVendido = livroVendido;
		this.usuarioComprador = usuarioComprador;
		this.funcionarioFornecedor = funcionarioFornecedor;
		this.dataVenda = calendar.getTime();
		
	}
	public Livro getLivroVendido() {
		return this.livroVendido;
	}
	public void setLivroVendido(Livro novoLivroVendido) {
		this.livroVendido = novoLivroVendido;
	}
	public Usuario getUsuarioComprador() {
		return this.usuarioComprador;
	}
	public void setUsuarioComprador(Usuario novoUsuarioComprador) {
		this.usuarioComprador = novoUsuarioComprador;
	}
	public Funcionario getFuncionarioFornecedor() {
		return this.funcionarioFornecedor;
	}
	public void setFuncionarioFornecedor(Funcionario novoFuncionarioFornecedor) {
		this.funcionarioFornecedor = novoFuncionarioFornecedor;
	}
	public Date getDataVenda() {
		return this.dataVenda;
	}
	public void setDataEmprestimo(Date novaDataVenda) {
		this.dataVenda = novaDataVenda;
	}
	
	public String toString() {
		return "\nLivro: "+getLivroVendido().toString() + "\nUsuário: " + getUsuarioComprador().toString() + 
				"\nFuncionário: " + getFuncionarioFornecedor().toString() + "\nData da Venda: " + 
				df.format(getDataVenda());
	}
}