package projetoPOOSistemaBiblioteca;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class FrameDeRolagemLivros extends JFrame {
	
	private  static Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	private JList encontrados; 
	private JScrollPane spLista;
	private JButton btVender, btEmprestar, btCancelar, btRemover, btEditar;
	public static String venderEmprestar = "";
	private static FrameDeRolagemLivros frame;
	public static int indiceDoItem;
	
	private void inicializarComponentes() {
		setTitle("Biblioteca Ioniana");
		setBounds(0,0,tela.width/4,tela.height/4);
		setLayout(null);
		
		int quantidade = FramePesquisa.indices.size();
		String [] elementos = new String[quantidade];
		for (int k = 0; k<quantidade; k++) {
			elementos[k] = FramePesquisa.stringDaPesquisa.get(k);
		}
		btVender = new JButton("Vender");
		btEmprestar = new JButton("Emprestar");
		btCancelar = new JButton("Cancelar");
		btRemover = new JButton("Remover");
		btEditar = new JButton("Editar");
		
		encontrados = new JList(elementos);
		spLista = new JScrollPane(encontrados);
		
		spLista.setBounds(tela.width/4/12, (tela.height/4/3 - tela.height/4/4)*2, 200, tela.height/4/6*3);
		
		
		btVender.setBounds(2*tela.width/4/3, (tela.height/4/3 - tela.height/4/4)*3, 100, 25);
		btEmprestar.setBounds(2*tela.width/4/3, (tela.height/4/3 - tela.height/4/4)*2, 100, 25);
		btEditar.setBounds(2*tela.width/4/3, (tela.height/4/3 - tela.height/4/4)*4, 100,25);
		btRemover.setBounds(2*tela.width/4/3, (tela.height/4/3 - tela.height/4/4)*5, 100, 25);
		btCancelar.setBounds(2*tela.width/4/3, (tela.height/4/3 - tela.height/4/4)*7, 100, 25);
		
		add(spLista);
		if (FrameInterfaceFuncionario.tipoDaPesquisa.equals("Livro")) {
			add(btCancelar);
			add(btRemover);
			add(btEditar);
			add(btEmprestar);
			add(btVender);
		}else {
			add(btCancelar);
			add(btRemover);
			add(btEditar);
		}
		
	}
	public void definirEventos() {
		btCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);				
			}
		});
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(FrameLoginFuncionario.login==false) {
						setVisible(false);
						throw new Exception("Funcionario foi deslogado!");
					}
					if (encontrados.getSelectedIndex() == -1) {
						throw new Exception("Selecione um item da lista");
					} else {
						for (int x = 0; x < FramePesquisa.indices.size(); x++) {
							if (encontrados.getSelectedIndex() == x) {
								if (FrameInterfaceFuncionario.tipoDaPesquisa.equals("Livro")) {
									FrameConstrutorLivro.removeLivro(FramePesquisa.indices.get(x));
								} else if (FrameInterfaceFuncionario.tipoDaPesquisa.equals("Funcionário")) {
									FrameConstrutorFuncionario.removeFuncionario(FramePesquisa.indices.get(x));
								} else {
									FrameConstrutorUsuario.removeUsuario(FramePesquisa.indices.get(x));
								}
							}
						}
						setVisible(false);
					}
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
			}
		});
		btVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if(FrameLoginFuncionario.login==false) {
					setVisible(false);
					throw new Exception("Funcionario foi deslogado");
				}
				if(encontrados.getSelectedIndex()==-1) { 
					throw new Exception("Selecione um item da lista");
				}else {
					venderEmprestar = "Vender";
					indiceDoItem = FramePesquisa.indices.get(encontrados.getSelectedIndex());
					FrameLoginUsuario.Abrir();
					setVisible(false);
				}
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
			}
		});
		btEmprestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(FrameLoginFuncionario.login==false) {
						throw new Exception("Funcionario foi deslogado");
					}
				if(encontrados.getSelectedIndex()== -1) {
					throw new Exception( "Selecione um item da lista");
				}else {
					venderEmprestar = "Emprestar";
					indiceDoItem = FramePesquisa.indices.get(encontrados.getSelectedIndex());
					FrameLoginUsuario.Abrir();
					setVisible(false);
				}
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
			}
		});
		btEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(FrameLoginFuncionario.login==false) {
						throw new Exception("Funcionario foi deslogado!");
					}
				
				if(encontrados.getSelectedIndex()==-1) {
					throw new Exception("Selecione um item da lista");
				}else {
					FrameInterfaceFuncionario.acao = "Editar";
					if(FrameInterfaceFuncionario.tipoDaPesquisa.equals("Livro")) {
						FrameConstrutorLivro.Abrir();
					}else if(FrameInterfaceFuncionario.tipoDaPesquisa.equals("Funcionário")) {
						FrameConstrutorFuncionario.Abrir();
					}else {
						FrameConstrutorUsuario.Abrir();
					}
				}
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
			}
		});
	}
	public FrameDeRolagemLivros() {
		inicializarComponentes();
		definirEventos();
	}
	public static void Abrir() {
		FrameDeRolagemLivros frame = new FrameDeRolagemLivros();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() { 
			frame=new FrameDeRolagemLivros(); 
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
			frame.setLocation((tela.width - frame.getSize().width)/2,
					(tela.height - frame.getSize().height)/2); 
			frame.setVisible(true); 
			//System.out.println(frame.getSize().height);
			//System.out.println(frame.getSize().width);
		}
		});
	} */

}
