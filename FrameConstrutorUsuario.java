package projetoPOOSistemaBiblioteca;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Interface.Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class FrameConstrutorUsuario extends JFrame {
	
	private static Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); 
	
	public static List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private JTextField tfNome;
	private JTextField tfCurso;
	private JTextField tfCPF;
	private JTextField tfIdade;
	private JTextField tfCidade;
	private JTextField tfLogin;
	private JPasswordField pfSenha;
	
	private JLabel lbNome;
	private JLabel lbCurso;
	private JLabel lbCPF;
	private JLabel lbIdade;
	private JLabel lbCidade;
	private JLabel lbLogin;
	private JLabel lbSenha;
	
	private JButton btCadastrar;
	private JButton btCancelar;
	
	private static FrameConstrutorUsuario frame;
	
	private void inicializarComponentes() {
		
		setTitle("Dados do novo Usuario");
		setBounds(0,0,tela.width/4 - tela.width/4/6/2,tela.height/3+(tela.height/3 - tela.height/4));
		setLayout(null);
		
		tfNome = new JTextField(5);
		tfCurso = new JTextField(5);
		tfCPF = new JTextField(5);
		tfIdade = new JTextField(5);
		tfCidade = new JTextField(5);
		tfLogin = new JTextField(5);
		pfSenha = new JPasswordField(5);
		
		lbNome = new JLabel("Nome: ");
		lbCurso = new JLabel("Curso: ");
		lbCPF = new JLabel("CPF: ");
		lbIdade = new JLabel("Idade: ");
		lbCidade = new JLabel("Cidade: ");
		lbLogin = new JLabel("Login :");
		lbSenha = new JLabel("Senha: ");
		
		btCadastrar = new JButton("Cadastrar");
		btCancelar = new JButton("Cancelar");
		
		lbNome.setBounds(tela.width/4/6, tela.height/4/6, 80, 25);
		lbCurso.setBounds(tela.width/4/6, tela.height/4/3, 80, 25);
		lbCPF.setBounds(tela.width/4/6, (tela.height/4/2 - tela.height/4/3)*3, 80, 25);
		lbIdade.setBounds(tela.width/4/6, (tela.height/4/2 - tela.height/4/3)*4, 80, 25);
		lbCidade.setBounds(tela.width/4/6, (tela.height/4/2 - tela.height/4/3)*5, 80, 25);
		lbLogin.setBounds(tela.width/4/6, (tela.height/4/2 - tela.height/4/3)*6, 80, 25);
		lbSenha.setBounds(tela.width/4/6, (tela.height/4/2 - tela.height/4/3)*7, 80, 25);
		
		tfNome.setBounds(tela.width/4/3, tela.height/4/6, 200, 25);
		tfCurso.setBounds(tela.width/4/3, (tela.height/4/3 - tela.height/4/6)*2, 200, 25);
		tfCPF.setBounds(tela.width/4/3, (tela.height/4/3 - tela.height/4/6)*3, 200, 25);
		tfIdade.setBounds(tela.width/4/3, (tela.height/4/3 - tela.height/4/6)*4, 200, 25);
		tfCidade.setBounds(tela.width/4/3, (tela.height/4/3 - tela.height/4/6)*5, 200, 25);
		tfLogin.setBounds(tela.width/4/3, (tela.height/4/3 - tela.height/4/6)*6, 200, 25);
		pfSenha.setBounds(tela.width/4/3, (tela.height/4/3 - tela.height/4/6)*7, 200, 25);
		
		btCadastrar.setBounds(tela.width/4/6, (tela.height/4/2 - tela.height/4/3)*8, 100, 25);
		btCancelar.setBounds(tela.width/4/2, (tela.height/4/2 - tela.height/4/3)*8, 100, 25);
		if (FrameInterfaceFuncionario.acao.equals("Editar")) {
			tfNome.setText(usuarios.get(FrameDeRolagemLivros.indiceDoItem).getNome());
			tfCurso.setText(usuarios.get(FrameDeRolagemLivros.indiceDoItem).getCurso());
			tfCPF.setText(usuarios.get(FrameDeRolagemLivros.indiceDoItem).getCPF());
			tfIdade.setText(""+(usuarios.get(FrameDeRolagemLivros.indiceDoItem).getIdade()));
			tfCidade.setText(usuarios.get(FrameDeRolagemLivros.indiceDoItem).getCidade());
			tfLogin.setText(usuarios.get(FrameDeRolagemLivros.indiceDoItem).getLogin());
			pfSenha.setText(usuarios.get(FrameDeRolagemLivros.indiceDoItem).getSenha());
			btCadastrar.setText("Editar");
		}
		add(tfNome);
		add(tfCurso);
		add(tfCPF);
		add(tfIdade);
		add(tfCidade);
		add(tfLogin);
		add(pfSenha);
		add(lbNome);
		add(lbCurso);
		add(lbCPF);
		add(lbIdade);
		add(lbCidade);
		add(lbLogin);
		add(lbSenha);
		add(btCadastrar);
		add(btCancelar);
		
	}
	private void definirEventos() {
		btCadastrar.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {
				try {
					if (FrameLoginFuncionario.login == false) {
						setVisible(false);
						throw new Exception("É preciso que um funcionário esteja logado para realizar o cadastro!");
					}
					String nome = tfNome.getText();
					if (nome.length() == 0) {
						throw new Exception("Sem nome!");
					}
					String curso = tfCurso.getText();
					if (curso.length() ==0) {
						throw new Exception("O campo do curso está vázio!");
					}
					String CPF = tfCPF.getText();
					if (CPF.length()==0) {
						throw new Exception("CPF inválido!");
					}
					// fazer try-cath pra idade -> java.lang.NumberFormatException <-
					int idade = Integer.parseInt(tfIdade.getText());
					String cidade = tfCidade.getText();
					if (cidade.length()==0) {
						throw new Exception("Preencha o campo da cidade!");
					}
					// verificar se login e senha são validos
					String login = tfLogin.getText();
					if (login.length()==0) {
						throw new Exception("Login inválido");
					}
					for (Usuario u : usuarios) {
						if (u.getLogin().toUpperCase().equals(login.toUpperCase())) {
							throw new Exception("Este login já está em uso!");
						}else if(u.getCPF().equals(CPF)) {
							throw new Exception("Este CPF já existe em outro usuário!");
						}
					}
					String senha = String.valueOf(pfSenha.getPassword());
					if(senha.length()==0) {
						throw new Exception("Senha inválida!");
					}
					Usuario u = new Usuario(nome, curso, CPF, idade, cidade, login, senha);
					if (FrameInterfaceFuncionario.acao.equals("Editar")) {
						usuarios.remove(FrameDeRolagemLivros.indiceDoItem);
					}
					usuarios.add(u);
					JOptionPane.showMessageDialog(null, "Usuario Cadastrado com Sucesso", "Cadastro",
							JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				} catch(NumberFormatException erro){
					JOptionPane.showMessageDialog(null, "Informe apenas números Reais e Inteiros!");
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
		//Melhorar os acontecimentos*/
	}
	
	public FrameConstrutorUsuario() {
		//this.usuarios = new ArrayList<Usuario>();
		inicializarComponentes();
		definirEventos();
	}
	
	public static String mostrarUsuarios() {
		if (usuarios.size()==0) {
			return "Não há usuários cadastrados!";
		}
		String dadosUsuarios = "";
		for (Usuario u: usuarios) {
			dadosUsuarios += u.toString()+"\n";
		}
		return dadosUsuarios;
	}
	
	public static void removeUsuario(int indice) {
		usuarios.remove(indice);
	}
	
	public static void Abrir() {
		
		FrameConstrutorUsuario frame=new FrameConstrutorUsuario(); 
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frame.setLocation((tela.width - frame.getSize().width)/2,
					(tela.height - frame.getSize().height)/2); 
		frame.setVisible(true); 
	}
}
