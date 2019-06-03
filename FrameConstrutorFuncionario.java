package projetoPOOSistemaBiblioteca;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class FrameConstrutorFuncionario extends JFrame{
	
	private  static Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); 
	
	public static List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfIdade;
	private JTextField tfCidade;
	private JTextField tfLogin;
	private JPasswordField pfSenha;
	
	private JLabel lbNome;
	private JLabel lbCPF;
	private JLabel lbIdade;
	private JLabel lbCidade;
	private JLabel lbLogin;
	private JLabel lbSenha;
	
	private JButton btCadastrar;
	private JButton btCancelar;
	
	private static FrameConstrutorFuncionario frame;
	
	private void inicializarComponentes() {
		
		setTitle("Dados do novo Funcionário");
		setBounds(0,0,tela.width/4 - tela.width/4/6/2,tela.height/3+(tela.height/3 - tela.height/4));
		setLayout(null);
		
		tfNome = new JTextField(5);
		tfCPF = new JTextField(5);
		tfIdade = new JTextField(5);
		tfCidade = new JTextField(5);
		tfLogin = new JTextField(5);
		pfSenha = new JPasswordField(5);
		
		lbNome = new JLabel("Nome: ");
		lbCPF = new JLabel("CPF: ");
		lbIdade = new JLabel("Idade: ");
		lbCidade = new JLabel("Cidade: ");
		lbLogin = new JLabel("Login :");
		lbSenha = new JLabel("Senha: ");
		
		btCadastrar = new JButton("Cadastrar");
		btCancelar = new JButton("Cancelar");
		
		lbNome.setBounds(tela.width/4/6, tela.height/4/6, 80, 25);
		lbCPF.setBounds(tela.width/4/6, tela.height/4/3, 80, 25);
		lbIdade.setBounds(tela.width/4/6, tela.height/4/2, 80, 25);
		lbCidade.setBounds(tela.width/4/6, (tela.height/4/2 - tela.height/4/3)*4, 80, 25);
		lbLogin.setBounds(tela.width/4/6, (tela.height/4/2 - tela.height/4/3)*5, 80, 25);
		lbSenha.setBounds(tela.width/4/6, (tela.height/4/2 - tela.height/4/3)*6, 80, 25);
		
		tfNome.setBounds(tela.width/4/3, tela.height/4/6, 120, 25);
		tfCPF.setBounds(tela.width/4/3, tela.height/4/3, 120, 25);
		tfIdade.setBounds(tela.width/4/3, (tela.height/4/3 - tela.height/4/6)*3, 120, 25);
		tfCidade.setBounds(tela.width/4/3, (tela.height/4/3 - tela.height/4/6)*4, 120, 25);
		tfLogin.setBounds(tela.width/4/3, (tela.height/4/3 - tela.height/4/6)*5, 120, 25);
		pfSenha.setBounds(tela.width/4/3, (tela.height/4/3 - tela.height/4/6)*6, 120, 25);
		
		btCadastrar.setBounds(tela.width/4/6, (tela.height/4/2 - tela.height/4/3)*7, 100, 25);
		btCancelar.setBounds(tela.width/4/2, (tela.height/4/2 - tela.height/4/3)*7, 100, 25);
		if (FrameInterfaceFuncionario.acao.equals("Editar")) {
			tfNome.setText(funcionarios.get(FrameDeRolagemLivros.indiceDoItem).getNome());
			tfCPF.setText(funcionarios.get(FrameDeRolagemLivros.indiceDoItem).getCPF());
			tfIdade.setText(""+(funcionarios.get(FrameDeRolagemLivros.indiceDoItem).getIdade()));
			tfCidade.setText(funcionarios.get(FrameDeRolagemLivros.indiceDoItem).getCidade());
			tfLogin.setText(funcionarios.get(FrameDeRolagemLivros.indiceDoItem).getLogin());
			pfSenha.setText(funcionarios.get(FrameDeRolagemLivros.indiceDoItem).getSenha());
			btCadastrar.setText("Editar");
		}
		add(tfNome);
		add(tfCPF);
		add(tfIdade);
		add(tfCidade);
		add(tfLogin);
		add(pfSenha);
		add(lbNome);
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
					String nome = tfNome.getText();
					if(nome.length()==0) {
						throw new Exception("Sem nome!");
					}
					String CPF = tfCPF.getText();
					if (CPF.length() == 0) {
						throw new Exception("CPF! inválido");
					}
					// fazer try-cath pra idade -> java.lang.NumberFormatException <-
					int idade = Integer.parseInt(tfIdade.getText());
					String cidade = tfCidade.getText();
					if (cidade.length() == 0) {
						throw new Exception("Preencha o campo da Cidade");
					}
					// verificar se login e senha são validos
					String login = tfLogin.getText();
					if (login.length()==0) {
						throw new Exception("Login inválido");
					}
					for (Funcionario f : funcionarios) {
						if (f.getLogin().toUpperCase().equals(login.toUpperCase())) {
							//JOptionPane.showMessageDialog(null, "Funcionario ja existe");
							throw new Exception("Este login já está em uso");
						}else if(f.getCPF().equals(CPF)) {
							throw new Exception("Este CPF já existe em outro Funcionario");
						}
					}
					String senha = String.valueOf(pfSenha.getPassword());
					if(senha.length()==0) {
						throw new Exception("Senha Invalida");
					}
					Funcionario f = new Funcionario(nome, CPF, idade, cidade, login, senha);
					if (FrameInterfaceFuncionario.acao.equals("Editar")) {
						funcionarios.remove(FrameDeRolagemLivros.indiceDoItem);
					}
					funcionarios.add(f);
					JOptionPane.showMessageDialog(null, "Funcionario Cadastrado com Sucesso");
					setVisible(false);
				} catch (NumberFormatException erro) {
					JOptionPane.showMessageDialog(null, "Informe apenas números Reais e Inteiros");
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage()/*"Dados invalidos, verifique novamente"*/);
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
	
	public FrameConstrutorFuncionario() {
		inicializarComponentes();
		definirEventos();
	}
	public static void removeFuncionario(int indice) {
		funcionarios.remove(indice);
	}
	
	public static String mostrarFuncionarios() {
		if (funcionarios.size()==0) {
			return "Não há funcionários!";
		}
		String dadosFuncionarios = "";
		for (Funcionario f: funcionarios) {
			dadosFuncionarios += f.toString()+"\n";
		}
		return dadosFuncionarios;
	}
	public static void Abrir() {
			FrameConstrutorFuncionario frame = new FrameConstrutorFuncionario(); 
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
			frame.setLocation((tela.width - frame.getSize().width)/2,
					(tela.height - frame.getSize().height)/2); 
			frame.setVisible(true); 
	}
	
}
