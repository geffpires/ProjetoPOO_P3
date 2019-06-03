package projetoPOOSistemaBiblioteca;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class FrameLoginFuncionario extends JFrame{
	
	private  static Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); 
	static boolean login = false;
	private JTextField tfLogin;
	private JLabel lbLoginFuncionario;
	private JLabel lbSenha;
	private JLabel lbLogin;
	private JButton btLogar;
	private JButton btCadastrarFuncionario;
	private JPasswordField pfSenha;
	private static FrameLoginFuncionario frame;


	private void inicializarComponentes() {
		setTitle("Biblioteca Ioniana");
		setBounds(0,0,tela.width/4,tela.height/4);
		setLayout(null);
		lbLoginFuncionario = new JLabel("Login do Funcionario: ");
		tfLogin = new JTextField(5);
		pfSenha = new JPasswordField(5);
		
		lbLogin = new JLabel("Login: ");
		lbSenha = new JLabel("Senha: ");

		btLogar = new JButton("Entrar");
		btCadastrarFuncionario = new JButton("Cadastrar Funcionario");
		
		lbLoginFuncionario.setBounds(tela.width/4/6, tela.height/4/6/4, 200, 25);
		lbLogin.setBounds(tela.width/4/6, tela.height/4/6, 80, 25);
		lbSenha.setBounds(tela.width/4/6, tela.height/4/3, 80, 25);
		tfLogin.setBounds(tela.width/4/3,tela.height/4/6 , 120, 25);
		pfSenha.setBounds(tela.width/4/3, tela.height/4/3, 120, 25);
		btLogar.setBounds(2*tela.width/4/3, tela.height/4/4, 100, 25);
		btCadastrarFuncionario.setBounds(tela.width/4/6, tela.height/4/2, 200, 25);
		add(lbLoginFuncionario);
		add(lbLogin);
		add(lbSenha);
		add(tfLogin);
		add(pfSenha);
		add(btLogar);
		add(btCadastrarFuncionario);
		
	}
	//ajeitar onde mexi, nos frame para abrir
	private void definirEventos() {
		btLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = String.valueOf(pfSenha.getPassword());
				for (Funcionario f : FrameConstrutorFuncionario.funcionarios) {
					if (tfLogin.getText().toUpperCase().equals(f.getLogin().toUpperCase()) && senha.equals(f.getSenha())) {
						JOptionPane.showMessageDialog(null, "Boas Vindas, "+f.getNome());
						login = true;
						FrameInterfaceFuncionario.funcionarioLogado = f;
						setVisible(false);
						FrameInterfaceFuncionario.Abrir();
						
					} 
				}
				if (!login) {
					JOptionPane.showMessageDialog(null, "Login ou Senha invalidos");
				}
			}
		});
		btCadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameInterfaceFuncionario.acao = "Cadastrar";
				FrameConstrutorFuncionario.Abrir();
			}
		});
	}
	
	public FrameLoginFuncionario() {
		inicializarComponentes();
		definirEventos();
	}
	
	
	public static void Abrir() {
		FrameLoginFuncionario frame = new FrameLoginFuncionario();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);

	}
	public static void Fechar() {
		frame.setVisible(false);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() { 
			frame=new FrameLoginFuncionario(); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			frame.setLocation((tela.width - frame.getSize().width)/2,
					(tela.height - frame.getSize().height)/2); 
			frame.setVisible(true); 
		}
		});
	} 
	
	
	
}
