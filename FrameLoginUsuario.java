package projetoPOOSistemaBiblioteca;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameLoginUsuario extends JFrame{
	
	private  static Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); 
	private JTextField tfLogin;
	private JLabel lbLoginFuncionario;
	private JLabel lbSenha;
	private JLabel lbLogin;
	private JButton btAcao;
	private JButton btCancelar;
	private JPasswordField pfSenha;
	private static FrameLoginUsuario frame;
	
	private void inicializarComponentes() {
		setTitle("Biblioteca Ioniana");
		setBounds(0,0,tela.width/4,tela.height/4);
		setLayout(null);
		lbLoginFuncionario = new JLabel("Login do Usuario: ");
		tfLogin = new JTextField(5);
		pfSenha = new JPasswordField(5);
		
		lbLogin = new JLabel("Login: ");
		lbSenha = new JLabel("Senha: ");
		btAcao = new JButton(FrameDeRolagemLivros.venderEmprestar);
		btCancelar = new JButton("Cancelar");
		
		lbLoginFuncionario.setBounds(tela.width/4/6, tela.height/4/6/4, 200, 25);
		lbLogin.setBounds(tela.width/4/6, tela.height/4/6, 80, 25);
		lbSenha.setBounds(tela.width/4/6, tela.height/4/3, 80, 25);
		tfLogin.setBounds(tela.width/4/3,tela.height/4/6 , 120, 25);
		pfSenha.setBounds(tela.width/4/3, tela.height/4/3, 120, 25);
		btAcao.setBounds(2*tela.width/4/3, tela.height/4/4, 100, 25);
		btCancelar.setBounds(tela.width/4/6, tela.height/4/2, 200, 25);
		add(lbLoginFuncionario);
		add(lbLogin);
		add(lbSenha);
		add(tfLogin);
		add(pfSenha);
		add(btAcao);
		add(btCancelar);
		//System.out.println(tela.width);
		//System.out.println(tela.height);
		
	}
	
	private void definirEventos() {
		btAcao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = String.valueOf(pfSenha.getPassword());
				for (Usuario u : FrameConstrutorUsuario.usuarios) {
					if (tfLogin.getText().toUpperCase().equals(u.getLogin().toUpperCase()) && senha.equals(u.getSenha())) {
						JOptionPane.showMessageDialog(null, u.getNome());
						if (FrameDeRolagemLivros.venderEmprestar.equals("Vender")) {
							Vendido v = new Vendido(FrameConstrutorLivro.livros.get(FrameDeRolagemLivros.indiceDoItem), u,
									FrameInterfaceFuncionario.funcionarioLogado);
							FrameInterfaceFuncionario.vendidos.add(v);
							FrameConstrutorLivro.removeLivro(FrameDeRolagemLivros.indiceDoItem);
							setVisible(false);
						}else {
							Emprestado emp = new Emprestado(FrameConstrutorLivro.livros.get(FrameDeRolagemLivros.indiceDoItem),u,
									FrameInterfaceFuncionario.funcionarioLogado);
							FrameInterfaceFuncionario.emprestados.add(emp);
							FrameConstrutorLivro.removeLivro(FrameDeRolagemLivros.indiceDoItem);
							setVisible(false);
						}
					}else {
					JOptionPane.showMessageDialog(null, "Login ou Senha invalidos");
					}
				}
			}
		});
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FrameDeRolagemLivros.Abrir();
			}
		});
	}
	
	public FrameLoginUsuario() {
		inicializarComponentes();
		definirEventos();
	}
	public static void Abrir() {
		frame=new FrameLoginUsuario(); 
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frame.setLocation((tela.width - frame.getSize().width)/2,
				(tela.height - frame.getSize().height)/2); 
		frame.setVisible(true); 
	}
	
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() { 
			frame=new FrameLoginUsuario(); 
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
			frame.setLocation((tela.width - frame.getSize().width)/2,
					(tela.height - frame.getSize().height)/2); 
			frame.setVisible(true); 
		}
		});
	}*/
	

}
