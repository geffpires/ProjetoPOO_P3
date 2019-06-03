package projetoPOOSistemaBiblioteca;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class FramePesquisa extends JFrame{
	
	private  static Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); 
	private JTextField tfPesquisa;
	private JLabel lbPesquisarPor;
	private JLabel lbPesquisa;
	private JButton btPesquisar;
	private JButton btCancelar;
	private static FramePesquisa frame;
	
	public static List<Integer> indices = new ArrayList<Integer>();
	public static List<String> stringDaPesquisa = new ArrayList<String>();
	
	private void inicializarComponentes() {
		setTitle("Biblioteca Ioniana");
		setBounds(0,0,tela.width/4,tela.height/4);
		setLayout(null);
		
		
		lbPesquisarPor = new JLabel("Pesquisar "+FrameInterfaceFuncionario.tipoDaPesquisa+" por "+FrameInterfaceFuncionario.nomePesquisa);
		lbPesquisa = new JLabel(FrameInterfaceFuncionario.nomePesquisa);
		tfPesquisa = new JTextField(5);

		btPesquisar = new JButton("Pesquisar");
		btCancelar = new JButton("Cancelar");
		
		lbPesquisarPor.setBounds(tela.width/4/6, tela.height/4/6/4, 200, 25);
		lbPesquisa.setBounds(tela.width/4/6, tela.height/4/6, 80, 25);
		tfPesquisa.setBounds(tela.width/4/3,tela.height/4/6 , 120, 25);
		btCancelar.setBounds(tela.width/4/2, tela.height/4/3, 120, 25);
		btPesquisar.setBounds(tela.width/4/6, tela.height/4/3, 120, 25);
		add(lbPesquisarPor);
		add(lbPesquisa);
		add(tfPesquisa);
		add(btCancelar);
		add(btPesquisar);
		
		
	}
	public void definirEventos() {
		btCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);				
			}
		});
		btPesquisar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				indices.clear();
				stringDaPesquisa.clear();
				if(FrameInterfaceFuncionario.tipoDaPesquisa.equals("Funcionário")) {
					if(FrameInterfaceFuncionario.nomePesquisa.equals("Nome")){
						for (int k = 0; k <FrameConstrutorFuncionario.funcionarios.size(); k++) {
							if(FrameConstrutorFuncionario.funcionarios.get(k).getNome().toUpperCase().equals(tfPesquisa.getText().toUpperCase())) {
							//	FrameInterfaceFuncionario.funcionariosPesquisados.add(FrameConstrutorFuncionario.funcionarios.get(k));
								stringDaPesquisa.add(FrameConstrutorFuncionario.funcionarios.get(k).toString());
								indices.add(k);
							}
						//	System.out.println(stringDaPesquisa);
						//	System.out.println(indices);
						}
						//setVisible(false);
						
					}else if(FrameInterfaceFuncionario.nomePesquisa.equals("CPF")) {
						for (int k = 0; k <FrameConstrutorFuncionario.funcionarios.size(); k++) {
							if(FrameConstrutorFuncionario.funcionarios.get(k).getCPF().equals(tfPesquisa.getText())) {
							//	FrameInterfaceFuncionario.funcionariosPesquisados.add(FrameConstrutorFuncionario.funcionarios.get(k));
								stringDaPesquisa.add(FrameConstrutorFuncionario.funcionarios.get(k).toString());
								indices.add(k);
							}
						}
						//setVisible(false);
						
					}else if(FrameInterfaceFuncionario.nomePesquisa.equals("Idade")) {
						for (int k = 0; k <FrameConstrutorFuncionario.funcionarios.size(); k++) {
							// fazer try-catch
							if(FrameConstrutorFuncionario.funcionarios.get(k).getIdade() == Integer.parseInt(tfPesquisa.getText())) {
								//FrameInterfaceFuncionario.funcionariosPesquisados.add(FrameConstrutorFuncionario.funcionarios.get(k));
								stringDaPesquisa.add(FrameConstrutorFuncionario.funcionarios.get(k).toString());
								indices.add(k);
							}
						}
						//setVisible(false);
						
					}else {
						for (int k = 0; k <FrameConstrutorFuncionario.funcionarios.size(); k++) {
							if(FrameConstrutorFuncionario.funcionarios.get(k).getCidade().toUpperCase().equals((tfPesquisa.getText().toUpperCase()))) {
								stringDaPesquisa.add(FrameConstrutorFuncionario.funcionarios.get(k).toString());
								indices.add(k);
							}
						}
						//setVisible(false);
					}
					
				}else if(FrameInterfaceFuncionario.tipoDaPesquisa.equals("Livro")) {
					if (FrameInterfaceFuncionario.nomePesquisa.equals("Autor(es)")){
						for (int k = 0; k < FrameConstrutorLivro.livros.size(); k++) {
							if(FrameConstrutorLivro.livros.get(k).getAutores().toUpperCase().equals(tfPesquisa.getText().toUpperCase())) {
								stringDaPesquisa.add(FrameConstrutorLivro.livros.get(k).toString());
								indices.add(k);
							}
						}
						//setVisible(false);
					}else if(FrameInterfaceFuncionario.nomePesquisa.equals("Título")) {
						for (int k = 0; k < FrameConstrutorLivro.livros.size(); k++) {
							if(FrameConstrutorLivro.livros.get(k).getTitulo().toUpperCase().equals(tfPesquisa.getText().toUpperCase())) {
								stringDaPesquisa.add(FrameConstrutorLivro.livros.get(k).toString());
								indices.add(k);
							}
						}
						//setVisible(false);
					}else if(FrameInterfaceFuncionario.nomePesquisa.equals("Preço")) {
						for (int k = 0; k < FrameConstrutorLivro.livros.size(); k++) {
							if(FrameConstrutorLivro.livros.get(k).getPreco() == Double.parseDouble(tfPesquisa.getText())) {
								stringDaPesquisa.add(FrameConstrutorLivro.livros.get(k).toString());
								indices.add(k);
							}
						}
						//setVisible(false);
					}else if(FrameInterfaceFuncionario.nomePesquisa.equals("Código")) {
						for (int k = 0; k < FrameConstrutorLivro.livros.size(); k++) {
							if(FrameConstrutorLivro.livros.get(k).getCodigoDeBarra().toUpperCase().equals(tfPesquisa.getText().toUpperCase())) {
								stringDaPesquisa.add(FrameConstrutorLivro.livros.get(k).toString());
								indices.add(k);
							}
						}
						//setVisible(false);
					}else {
						for (int k = 0; k < FrameConstrutorLivro.livros.size(); k++) {
							if(FrameConstrutorLivro.livros.get(k).getAnoLancado() == Integer.parseInt(tfPesquisa.getText())) {
								stringDaPesquisa.add(FrameConstrutorLivro.livros.get(k).toString());
								indices.add(k);
							}
						}
						//setVisible(false);
					}
				}else {
					if(FrameInterfaceFuncionario.nomePesquisa.equals("Nome")) {
						for (int k = 0; k < FrameConstrutorUsuario.usuarios.size(); k++) {
							if(FrameConstrutorUsuario.usuarios.get(k).getNome().toUpperCase().equals(tfPesquisa.getText().toUpperCase())) {
								stringDaPesquisa.add(FrameConstrutorUsuario.usuarios.get(k).toString());
								indices.add(k);
							}
						}
						//setVisible(false);
					}else if(FrameInterfaceFuncionario.nomePesquisa.equals("Curso")) {
						for (int k = 0; k < FrameConstrutorUsuario.usuarios.size(); k++) {
							if(FrameConstrutorUsuario.usuarios.get(k).getCurso().toUpperCase().equals(tfPesquisa.getText().toUpperCase())) {
								stringDaPesquisa.add(FrameConstrutorUsuario.usuarios.get(k).toString());
								indices.add(k);
							}
						}
						//setVisible(false);
					}else if(FrameInterfaceFuncionario.nomePesquisa.equals("CPF")) {
						for (int k = 0; k < FrameConstrutorUsuario.usuarios.size(); k++) {
							if(FrameConstrutorUsuario.usuarios.get(k).getCPF().equals(tfPesquisa.getText())) {
								stringDaPesquisa.add(FrameConstrutorUsuario.usuarios.get(k).toString());
								indices.add(k);
							}
						}
						//setVisible(false);
					}else if(FrameInterfaceFuncionario.nomePesquisa.equals("Idade")) {
						for (int k = 0; k < FrameConstrutorUsuario.usuarios.size(); k++) {
							if(FrameConstrutorUsuario.usuarios.get(k).getIdade() == Integer.parseInt(tfPesquisa.getText())) {
								stringDaPesquisa.add(FrameConstrutorUsuario.usuarios.get(k).toString());
								indices.add(k);
							}
						}
						//setVisible(false);
					}else {
						for (int k = 0; k < FrameConstrutorUsuario.usuarios.size(); k++) {
							if(FrameConstrutorUsuario.usuarios.get(k).getCidade().toUpperCase().equals(tfPesquisa.getText().toUpperCase())) {
								stringDaPesquisa.add(FrameConstrutorUsuario.usuarios.get(k).toString());
								indices.add(k);
							}
						}
						//setVisible(false);
					}
					
				}
				setVisible(false);
				FrameDeRolagemLivros.Abrir();
			}
		});
	}
	public FramePesquisa() {
		inicializarComponentes();
		definirEventos();
	}
	
	public static void Abrir() {
		FramePesquisa frame = new FramePesquisa();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);

	}
	
	
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() { 
			frame=new FramePesquisa(); 
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
