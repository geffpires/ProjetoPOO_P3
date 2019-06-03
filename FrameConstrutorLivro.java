package projetoPOOSistemaBiblioteca;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class FrameConstrutorLivro extends JFrame{
	
	private  static Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); 
	
	public static List<Livro> livros = new ArrayList<Livro>();
	
	private JLabel lbAutor;
	private JLabel lbTitulo;
	private JLabel lbEdicao;
	private JLabel lbCodigoBarra;
	private JLabel lbPreco;
	private JLabel lbAnoLancado;
	
	private JTextField tfAutor;
	private JTextField tfTitulo;
	private JTextField tfEdicao;
	private JTextField tfCodigoBarra;
	private JTextField tfPreco;
	private JTextField tfAnoLancado;
	
	private JButton btCadastrarLivro;
	private JButton btCancelar;
	
	private static FrameConstrutorLivro frame;
	
	private void inicializarComponentes() {
		
		setTitle("Dados do Livro");
		setBounds(0,0,tela.width/4 - tela.width/4/6/2,tela.height/3+(tela.height/3 - tela.height/4));
		setLayout(null);
		
		lbAutor = new JLabel("Autor(es): ");
		lbTitulo = new JLabel("Título: ");
		lbEdicao = new JLabel("Edição: ");
		lbCodigoBarra = new JLabel("Codigo: ");
		lbPreco = new JLabel("Preço: ");
		lbAnoLancado = new JLabel("Ano: ");
		
		tfAutor = new JTextField(5);
		tfTitulo = new JTextField(5);
		tfEdicao = new JTextField(5);
		tfCodigoBarra = new JTextField(5);
		tfPreco = new JTextField(5);
		tfAnoLancado = new JTextField(5);
		
		btCadastrarLivro = new JButton("Cadastrar");
		btCancelar = new JButton("Cancelar");
		
		lbAutor.setBounds(tela.width/4/6, tela.height/4/6, 80, 25);
		lbTitulo.setBounds(tela.width/4/6, tela.height/4/3, 80, 25);
		lbEdicao.setBounds(tela.width/4/6, tela.height/4/2, 80, 25);
		lbCodigoBarra.setBounds(tela.width/4/6, (tela.height/4/2 - tela.height/4/3)*4, 80, 25);
		lbPreco.setBounds(tela.width/4/6, (tela.height/4/2 - tela.height/4/3)*5, 80, 25);
		lbAnoLancado.setBounds(tela.width/4/6, (tela.height/4/2 - tela.height/4/3)*6, 80, 25);
		
		tfAutor.setBounds(tela.width/4/3, tela.height/4/6, 120, 25);
		tfTitulo.setBounds(tela.width/4/3, tela.height/4/3, 120, 25);
		tfEdicao.setBounds(tela.width/4/3, (tela.height/4/3 - tela.height/4/6)*3, 120, 25);
		tfCodigoBarra.setBounds(tela.width/4/3, (tela.height/4/3 - tela.height/4/6)*4, 120, 25);
		tfPreco.setBounds(tela.width/4/3, (tela.height/4/3 - tela.height/4/6)*5, 120, 25);
		tfAnoLancado.setBounds(tela.width/4/3, (tela.height/4/3 - tela.height/4/6)*6, 120, 25);
		
		btCadastrarLivro.setBounds(tela.width/4/6, (tela.height/4/2 - tela.height/4/3)*7, 100, 25);
		btCancelar.setBounds(tela.width/4/2, (tela.height/4/2 - tela.height/4/3)*7, 100, 25);
		if (FrameInterfaceFuncionario.acao.equals("Editar")) {
			tfAutor.setText(livros.get(FrameDeRolagemLivros.indiceDoItem).getAutores());
			tfTitulo.setText(livros.get(FrameDeRolagemLivros.indiceDoItem).getTitulo());
			tfEdicao.setText(livros.get(FrameDeRolagemLivros.indiceDoItem).getEdicao());
			tfCodigoBarra.setText(livros.get(FrameDeRolagemLivros.indiceDoItem).getCodigoDeBarra());
			tfPreco.setText(""+livros.get(FrameDeRolagemLivros.indiceDoItem).getPreco());
			tfAnoLancado.setText(""+livros.get(FrameDeRolagemLivros.indiceDoItem).getAnoLancado());
			btCadastrarLivro.setText("Editar");
			
		}
		add(lbAutor);
		add(lbTitulo);
		add(lbEdicao);
		add(lbCodigoBarra);
		add(lbPreco);
		add(lbAnoLancado);
		add(tfAutor);
		add(tfTitulo);
		add(tfEdicao);
		add(tfCodigoBarra);
		add(tfPreco);
		add(tfAnoLancado);
		add(btCadastrarLivro);
		add(btCancelar);
		
	}
	
	private void definirEventos() {
		btCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (FrameLoginFuncionario.login == false) {
						setVisible(false);
						throw new Exception("É necessário que um funcionario esteja logado para realizar a ação de cadastro!");
					}
					String autor = tfAutor.getText();
					if (autor.length()==0) {
						throw new Exception("Sem autores!");
					}
					String titulo = tfTitulo.getText();
					if (titulo.length()==0) {
						throw new Exception("Sem Titulo!");
					}
					String edicao = tfEdicao.getText();
					if(edicao.length()==0) {
						throw new Exception("Edição está vazia!");
					}
					String codigoBarra = tfCodigoBarra.getText();
					if (codigoBarra.length()==0) {
						throw new Exception("Codigo está em branco!");
					}for (Livro l: livros) {
						if (l.getCodigoDeBarra().equals(codigoBarra)) {
							throw new Exception("Já existe um livro cadastrado com este codigo");
						}
					}
					double preco = Double.parseDouble(tfPreco.getText());
					int anoLancado = Integer.parseInt(tfAnoLancado.getText());
					Livro l = new Livro(autor, titulo, edicao, codigoBarra, preco, anoLancado);
					if (FrameInterfaceFuncionario.acao.equals("Editar")) {
						livros.remove(FrameDeRolagemLivros.indiceDoItem);
					}
					livros.add(l);
					JOptionPane.showMessageDialog(null, "Livro Cadastrado com Sucesso");
					setVisible(false);
				} catch (NumberFormatException erro) {
					JOptionPane.showMessageDialog(null, "Informe apenas números Reais e Inteiros");
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
			}
		});
		btCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		//Melhorar os acontecimentos
		
	}
	public FrameConstrutorLivro() {
		inicializarComponentes();
		definirEventos();
	}
	/*public void removeLivro(int indice) {
		livros
	}*/
	public static String mostrarLivros() {
		if (livros.size()==0) {
			return "Não há livros cadastrados!";
		}
		String dadosLivros = "";
		for (Livro l: livros) {
			dadosLivros+= l.toString()+"\n";
		}
		return dadosLivros;
	}
	public static void removeLivro(int indice) {
		livros.remove(indice);
	}
	public static void Abrir() {
		FrameConstrutorLivro frame = new FrameConstrutorLivro();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);

	}
	
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() { 
			frame=new FrameConstrutorLivro(); 
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
			frame.setLocation((tela.width - frame.getSize().width)/2,
					(tela.height - frame.getSize().height)/2); 
			frame.setVisible(true); 
			//System.out.println(frame.getSize().height);
			//System.out.println(frame.getSize().width);
		}
		});
	}*/

}
