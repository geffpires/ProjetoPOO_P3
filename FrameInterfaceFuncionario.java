package projetoPOOSistemaBiblioteca;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class FrameInterfaceFuncionario extends JFrame{
	
	private  static Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); 
	private Container container1;
	private JMenuBar mbMenu;
	
	private JMenu mnMenu, mnCadastrar, mnPesquisar, mnExibir, mnPesqFuncionario, 
	mnPesqLivro,  mnPesqUsuario,  mnExibiHistorico;
	
	private JMenuItem miDevolucaoLivro, miSair, 
	
	miCadaFuncionario, miCadaUsuario, miCadaLivro, 
	
	miiPesqFuncionarioNome, miiPesqFuncionarioCPF, miiPesqFuncionarioIdade,
	/*miiiPesqFuncionarioIdadeMaior, miiiPesqFuncionarioIdadeMenor, miiiPesqFuncionarioIdadeIgual, */
	miiPesqFuncionarioCidade,
	
	miiPesqLivroAutor, miiPesqLivroTitulo, miiPesqLivroPreco, miiPesqLivroAno,
	/*miiiPesqLivroPrecoMaior, miiiPesqLivroPrecoMenor, miiiPesqLivroPrecoIgual,*/
	miiPesqLivroCodigo, 
	/*miiiPesqLivroAnoMaior, miiiPesqLivroAnoMenor, miiiPesqLivroAnoIgual,
	miiPesqLivroLivro,*/
	
	miiPesqUsuarioNome, miiPesqUsuarioCurso, miiPesqUsuarioCPF, miiPesqUsuarioIdade,
	/*miiiPesqUsuarioIdadeMaior, miiiPesqUsuarioIdadeMenor, miiiPesqUsuarioIdadeIgual,*/
	miiPesqUsuarioCidade,
	
	miExibiLivros, 
	
	miiExibiHistoricoEmprestados, miiExibiHistoricoVendas, 
	
	miExibiUsuarios, miExibiFuncionarios;
	public static String tipoDaPesquisa = "";
	public static String nomePesquisa = "";
	
	public static String historicoVendas = "";
	public static String historicoEmprestados = "";
	public static List<Vendido> vendidos = new ArrayList<Vendido>();
	public static List<Emprestado> emprestados = new ArrayList<Emprestado>();
	public static List<Funcionario> funcionariosPesquisados = new ArrayList<Funcionario>();
	public static List<Livro> livrosPesquisados = new ArrayList<Livro>();
	public static List<Usuario> UsuariosPesquisados = new ArrayList<Usuario>();
	public static Funcionario funcionarioLogado;
	private static FrameInterfaceFuncionario frame;
	public static String acao;
	private void inicializarComponentes() {
		
		setTitle("Biblioteca Ioniana - Menu Principal");
		setBounds(0,0,tela.width/4,tela.height/4);
		setLayout(null);
		container1 = getContentPane();
		mbMenu = new JMenuBar();
		mnMenu = new JMenu("Menu");
		mnCadastrar = new JMenu("Cadastrar");
		mnPesquisar = new JMenu("Pesquisar");
		mnExibir = new JMenu("Exibir");
		miDevolucaoLivro = new JMenuItem("Devolução de livro");
		miSair = new JMenuItem("Sair"); 
		miCadaFuncionario = new JMenuItem("Funcionario");
		miCadaUsuario = new JMenuItem("Usuario");
		miCadaLivro = new JMenuItem("Livro");
		//pesquisa funcionario
		mnPesqFuncionario = new JMenu("Funcionario");
		miiPesqFuncionarioNome = new JMenuItem("Nome");
		miiPesqFuncionarioCPF = new JMenuItem("CPF");
		miiPesqFuncionarioIdade = new JMenuItem("Idade");
	/*	miiiPesqFuncionarioIdadeMaior = new JMenuItem("Maior ou Igual");
		miiiPesqFuncionarioIdadeMenor = new JMenuItem("Menor ou Igual");
		miiiPesqFuncionarioIdadeIgual = new JMenuItem("Igual");*/
		miiPesqFuncionarioCidade = new JMenuItem("Cidade");
		//pesquisa livro
		mnPesqLivro = new JMenu("Livro");
		miiPesqLivroAutor = new JMenuItem("Autor(es)");
		miiPesqLivroTitulo = new JMenuItem("Titulo");
		miiPesqLivroPreco = new JMenuItem("Preco");
		/*miiiPesqLivroPrecoMaior = new JMenuItem("Maior ou Igual");
		miiiPesqLivroPrecoMenor = new JMenuItem("Menor ou Igual");
		miiiPesqLivroPrecoIgual = new JMenuItem("Igual");*/
		miiPesqLivroCodigo = new JMenuItem("Codigo");
		miiPesqLivroAno = new JMenuItem("Ano");
		/*miiiPesqLivroAnoMaior = new JMenuItem("Maior ou Igual");
		miiiPesqLivroAnoMenor = new JMenuItem("Menor ou Igual");
		miiiPesqLivroAnoIgual = new JMenuItem("Igual");
		miiPesqLivroLivro = new JMenuItem("Livro");*/
		//pesquisa usuario
		mnPesqUsuario = new JMenu("Usuario");
		miiPesqUsuarioNome = new JMenuItem("Nome");
		miiPesqUsuarioCPF = new JMenuItem("CPF");
		miiPesqUsuarioCurso = new JMenuItem("Curso");
		miiPesqUsuarioIdade = new JMenuItem("Idade");
		/*miiiPesqUsuarioIdadeMaior = new JMenuItem("Maior ou Igual");
		miiiPesqUsuarioIdadeMenor = new JMenuItem("Menor ou Igual");
		miiiPesqUsuarioIdadeIgual = new JMenuItem("Igual");*/
		miiPesqUsuarioCidade = new JMenuItem("Cidade");
		
		
		miExibiLivros= new JMenuItem("Livros");
		mnExibiHistorico = new JMenu("Historico");
		miiExibiHistoricoEmprestados = new JMenuItem("Emprestimos");
		miiExibiHistoricoVendas = new JMenuItem("Vendas");
		miExibiUsuarios = new JMenuItem("Usuarios");
		miExibiFuncionarios = new JMenuItem("Funcionarios");
		
		mnCadastrar.add(miCadaFuncionario);
		mnCadastrar.add(miCadaLivro);
		mnCadastrar.add(miCadaUsuario);
		mnPesqFuncionario.add(miiPesqFuncionarioNome);
		mnPesqFuncionario.add(miiPesqFuncionarioCPF);
		/*mnPesqFuncionarioIdade.add(miiiPesqFuncionarioIdadeMaior);
		mnPesqFuncionarioIdade.add(miiiPesqFuncionarioIdadeMenor);
		mnPesqFuncionarioIdade.add(miiiPesqFuncionarioIdadeIgual);*/
		mnPesqFuncionario.add(miiPesqFuncionarioIdade);
		mnPesqFuncionario.add(miiPesqFuncionarioCidade);
		
		
		mnPesqLivro.add(miiPesqLivroTitulo);
		mnPesqLivro.add(miiPesqLivroAutor);
		/*mnPesqLivroPreco.add(miiiPesqLivroPrecoMaior);
		mnPesqLivroPreco.add(miiiPesqLivroPrecoMenor);
		mnPesqLivroPreco.add(miiiPesqLivroPrecoIgual);*/
		mnPesqLivro.add(miiPesqLivroPreco);
		mnPesqLivro.add(miiPesqLivroCodigo);
		/*mnPesqLivroAno.add(miiiPesqLivroAnoMaior);
		mnPesqLivroAno.add(miiiPesqLivroAnoMenor);
		mnPesqLivroAno.add(miiiPesqLivroAnoIgual);*/
		mnPesqLivro.add(miiPesqLivroAno);
		//mnPesqLivro.add(miiPesqLivroLivro);
		
		
		
		mnPesqUsuario.add(miiPesqUsuarioNome);
		mnPesqUsuario.add(miiPesqUsuarioCurso);
		mnPesqUsuario.add(miiPesqUsuarioCPF);
		/*mnPesqUsuarioIdade.add(miiiPesqUsuarioIdadeMaior);
		mnPesqUsuarioIdade.add(miiiPesqUsuarioIdadeMenor);
		mnPesqUsuarioIdade.add(miiiPesqUsuarioIdadeIgual);*/
		mnPesqUsuario.add(miiPesqUsuarioIdade);
		mnPesqUsuario.add(miiPesqUsuarioCidade);
		
		mnExibiHistorico.add(miiExibiHistoricoVendas);
		mnExibiHistorico.add(miiExibiHistoricoEmprestados);
		
		
		mnPesquisar.add(mnPesqFuncionario);
		mnPesquisar.add(mnPesqLivro);
		mnPesquisar.add(mnPesqUsuario);
		mnExibir.add(miExibiFuncionarios);
		mnExibir.add(mnExibiHistorico);
		mnExibir.add(miExibiLivros);
		mnExibir.add(miExibiUsuarios);

		mnMenu.add(miDevolucaoLivro);
		mnMenu.add(miSair);
		
		mbMenu.add(mnMenu);
		mbMenu.add(mnCadastrar);
		mbMenu.add(mnPesquisar);
		mbMenu.add(mnExibir);
		
		setJMenuBar(mbMenu);
		
	}
	
	private void definirEventos() {
		
		//Menu
		miSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FrameLoginFuncionario.login = false;
				FrameLoginFuncionario.Abrir();
			}
		});
		miDevolucaoLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameDevolucao.Abrir();
			}
		});
		
		//Cadastrar
		miCadaFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acao = "Cadastrar";
				FrameConstrutorFuncionario.Abrir();
			}
		});
		miCadaLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acao = "Cadastrar";
				FrameConstrutorLivro.Abrir();
			}
		});
		miCadaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acao = "Cadastrar";
				FrameConstrutorUsuario.Abrir();
			}
		});
		
		//Pesquisar
		// Pesq Funcionario
		miiPesqFuncionarioNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoDaPesquisa = "Funcionário";
				nomePesquisa = "Nome";
				FramePesquisa.Abrir();
			}
		});
		miiPesqFuncionarioCPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoDaPesquisa = "Funcionário";
				nomePesquisa = "CPF";
				FramePesquisa.Abrir();
			}
		});
		miiPesqFuncionarioIdade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoDaPesquisa = "Funcionário";
				nomePesquisa = "Idade";
				FramePesquisa.Abrir();
			}
		});
		miiPesqFuncionarioCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoDaPesquisa = "Funcionário";
				nomePesquisa = "Cidade";
				FramePesquisa.Abrir();
			}
		});
		// Pesq livro
		miiPesqLivroAutor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tipoDaPesquisa = "Livro";
				nomePesquisa = "Autor(es)";
				FramePesquisa.Abrir();
			}
		});
		miiPesqLivroTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoDaPesquisa = "Livro";
				nomePesquisa = "Título";
				FramePesquisa.Abrir();
			}
		});
		miiPesqLivroPreco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoDaPesquisa = "Livro";
				nomePesquisa = "Preço";
				FramePesquisa.Abrir();
			}
		});
		miiPesqLivroCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoDaPesquisa = "Livro";
				nomePesquisa = "Código";
				FramePesquisa.Abrir();
			}
		});
		miiPesqLivroAno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoDaPesquisa = "Livro";
				nomePesquisa = "Ano";
				FramePesquisa.Abrir();
			}
		});
		//Pesq usuario
		miiPesqUsuarioNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoDaPesquisa = "Usuário";
				nomePesquisa = "Nome";
				FramePesquisa.Abrir();
			}
		});
		miiPesqUsuarioCPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoDaPesquisa = "Usuário";
				nomePesquisa = "CPF";
				FramePesquisa.Abrir();
			}
		});
		miiPesqUsuarioIdade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoDaPesquisa = "Usuário";
				nomePesquisa = "Idade";
				FramePesquisa.Abrir();
			}
		});
		miiPesqUsuarioCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoDaPesquisa = "Usuário";
				nomePesquisa = "Cidade";
				FramePesquisa.Abrir();
			}
		});
		miiPesqUsuarioCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoDaPesquisa = "Usuário";
				nomePesquisa = "Curso";
				FramePesquisa.Abrir();
			}
		});
		
		
		//Exibir
		miExibiFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, FrameConstrutorFuncionario.mostrarFuncionarios());
			}
		});
		
		miExibiUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, FrameConstrutorUsuario.mostrarUsuarios());
			}
		});
		
		miExibiLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, FrameConstrutorLivro.mostrarLivros());
			}
		});
		miiExibiHistoricoEmprestados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, MostraHistoricoEmprestados());
			}
		});
		miiExibiHistoricoVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, MostraHistoricoVendidos());
			}
		});
	}
	
	public FrameInterfaceFuncionario() {
		inicializarComponentes();
		definirEventos();
	}
	
	public String MostraHistoricoVendidos() {
		if (vendidos.size()==0) {
			return "Não há historico de vendas!";
		}
		historicoVendas = "";
		for (Vendido v: vendidos) {
			historicoVendas += v.toString() + "\n";
		}
		return historicoVendas;
	}
	public String MostraHistoricoEmprestados() {
		if (emprestados.size()==0) {
			return "Não há historico de livros emprestados!";
		}
		historicoEmprestados = "";
		for (Emprestado emp: emprestados) {
			historicoEmprestados += emp.toString() +"\n";
		}
		return historicoEmprestados;
	}
	
	public static void Abrir() {
		FrameInterfaceFuncionario frame = new FrameInterfaceFuncionario();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);

	}
	
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() { 
			frame =new FrameInterfaceFuncionario(); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			frame.setLocation((tela.width - frame.getSize().width)/2,
					(tela.height - frame.getSize().height)/2); 
			frame.setVisible(true); 
			}
		});
	}*/

}
