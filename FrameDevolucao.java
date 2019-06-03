package projetoPOOSistemaBiblioteca;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class FrameDevolucao extends JFrame{
	private  static Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); 
	private JTextField tfCodigo;
	private JLabel lbParaDevolver;
	private JLabel lbCodigo;
	private JButton btDevolver;
	private JButton btCancelar;
	private static FrameDevolucao frame;


	private void inicializarComponentes() {
		setTitle("Biblioteca Ioniana");
		setBounds(0,0,tela.width/4 - tela.width/4/6,tela.height/4/3*2);
		setLayout(null);
		lbParaDevolver = new JLabel("Para devolver o livro\n insira o código:");
		tfCodigo = new JTextField(5);
		
		lbCodigo = new JLabel("Código: ");

		btDevolver = new JButton("Devolver");
		btCancelar = new JButton("Cancelar");
		
		lbParaDevolver.setBounds(tela.width/4/6, tela.height/4/6/4, 400, 25);
		lbCodigo.setBounds(tela.width/4/6, tela.height/4/6, 80, 25);
		tfCodigo.setBounds(tela.width/4/3,tela.height/4/6 , 120, 25);
		btDevolver.setBounds(tela.width/4/6, tela.height/4/3, 100, 25);
		btCancelar.setBounds(tela.width/4/2, tela.height/4/3, 100, 25);
		add(lbParaDevolver);
		add(lbCodigo);

		add(tfCodigo);
	
		add(btDevolver);
		add(btCancelar);
		
	}
	public void definirEventos() {
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k=0;
				boolean achou = false;
				while(k<FrameInterfaceFuncionario.emprestados.size() && FrameLoginFuncionario.login==true){
					if(tfCodigo.getText().equals(FrameInterfaceFuncionario.emprestados.get(k).getLivroEmprestado().getCodigoDeBarra())) {
						FrameConstrutorLivro.livros.add(FrameInterfaceFuncionario.emprestados.get(k).getLivroEmprestado());
						setVisible(false);
						achou = true;
						JOptionPane.showMessageDialog(null, "Livro devolvido");
					}
					k++;
				}
				if(FrameLoginFuncionario.login==false){
					JOptionPane.showMessageDialog(null, "É preciso ter um Funcionário logado para realizar a ação!");
				}
				else if(!achou){
					JOptionPane.showMessageDialog(null, "Codigo do livro não pertence aos livros emprestados.\nPor favor, verifique novamente!");
				}
			}
		});
	}
	public FrameDevolucao() {
		inicializarComponentes();
		definirEventos();
	}
	public static void Abrir() {
		frame=new FrameDevolucao(); 
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frame.setLocation((tela.width - frame.getSize().width)/2,
				(tela.height - frame.getSize().height)/2); 
		frame.setVisible(true); 
	}
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() { 
			frame=new FrameDevolucao(); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			frame.setLocation((tela.width - frame.getSize().width)/2,
					(tela.height - frame.getSize().height)/2); 
			frame.setVisible(true); 
		}
		});
	} */
}
