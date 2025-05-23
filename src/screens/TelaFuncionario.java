package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Funcionario;
import entities.dao.FuncionarioDao;

public class TelaFuncionario implements ActionListener {
	Funcionario fun;
	FuncionarioDao fd = new FuncionarioDao();

	JFrame tela = new JFrame("Cadastro de Funcionarios");
	JPanel painel = new JPanel();

	JLabel lbmatricula = new JLabel("Matricula: ");
	JLabel lbnome = new JLabel("Nome: ");
	JLabel lbnasc = new JLabel("Nascimento: ");
	JLabel lbcargo = new JLabel("Cargo: ");
	JLabel lbemail = new JLabel("Email: ");
	JLabel lbsenha = new JLabel("Senha: ");

	JTextField txtmatricula = new JTextField();
	JTextField txtnome = new JTextField();
	JTextField txtnasc = new JTextField();
	JTextField txtcargo = new JTextField();
	JTextField txtemail = new JTextField();
	JTextField txtsenha = new JTextField();

	JButton btsalvar = new JButton("Salvar");
	JButton btlistar = new JButton("Listar");
	JButton btalterar = new JButton("Alterar");
	JButton btexcluir = new JButton("Excluir");
	JButton btpesq = new JButton("Pesquisar");

	void criarTela() {

		tela.setSize(500, 400);
		tela.setLocation(550, 250);
		painel.setLayout(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// MATRÍCULA + BOTÃO PESQUISAR
		lbmatricula.setBounds(30, 20, 100, 30);
		txtmatricula.setBounds(120, 20, 180, 30);
		txtmatricula.setEnabled(false);

		btpesq.setBounds(310, 20, 120, 30);
		btpesq.addActionListener(this);
		btpesq.setEnabled(false);

		// NOME + BOTÃO PESQUISAR
		lbnome.setBounds(30, 60, 100, 30);
		txtnome.setBounds(120, 60, 180, 30);

		// NASCIMENTO
		lbnasc.setBounds(30, 100, 100, 30);
		txtnasc.setBounds(120, 100, 180, 30);

		// CARGO
		lbcargo.setBounds(30, 140, 100, 30);
		txtcargo.setBounds(120, 140, 180, 30);

		// EMAIL
		lbemail.setBounds(30, 180, 100, 30);
		txtemail.setBounds(120, 180, 180, 30);

		// SENHA
		lbsenha.setBounds(30, 220, 100, 30);
		txtsenha.setBounds(120, 220, 180, 30);

		// BOTÕES
		btsalvar.setBounds(30, 280, 90, 30);
		btsalvar.addActionListener(this);
		btlistar.setBounds(130, 280, 90, 30);
		btlistar.addActionListener(this);
		btalterar.setBounds(230, 280, 90, 30);
		btalterar.addActionListener(this);
		btexcluir.setBounds(330, 280, 90, 30);
		btexcluir.addActionListener(this);


		painel.add(lbnome);
		painel.add(txtnome);
		painel.add(btpesq);

		painel.add(lbnasc);
		painel.add(txtnasc);

		painel.add(lbcargo);
		painel.add(txtcargo);

		painel.add(lbmatricula);
		painel.add(txtmatricula);

		painel.add(lbemail);
		painel.add(txtemail);

		painel.add(lbsenha);
		painel.add(txtsenha);

		painel.add(btsalvar);
		painel.add(btlistar);
		painel.add(btalterar);
		painel.add(btexcluir);

		tela.getContentPane().add(painel);
		tela.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btsalvar) {

			if (txtnome.getText().isEmpty() || txtnasc.getText().isEmpty() || txtcargo.getText().isEmpty()
					|| txtemail.getText().isEmpty() || txtsenha.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de salvar!");
				return;
			}

			try {
				String n = txtnome.getText();
				int i = Integer.parseInt(txtnasc.getText()); // nascimento
				String c = txtcargo.getText();
				int m = fd.retornaTamanhoLista() + 1;
				String a = txtemail.getText();
				String s = txtsenha.getText();

				fun = new Funcionario(n, i, c, m, a, s);
				fd.salvar(fun);
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

				// Limpa os campos
				txtnome.setText("");
				txtnasc.setText("");
				txtcargo.setText("");
				txtmatricula.setText("");
				txtemail.setText("");
				txtsenha.setText("");

				btpesq.setEnabled(true);
				txtmatricula.setEnabled(true);

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Erro: os campos 'Nascimento' e 'Matrícula' devem conter números válidos.");
			}
		}

		if (e.getSource() == btlistar) {
			fd.listar();
		}

		if (e.getSource() == btpesq) {
			Integer matricula = Integer.valueOf(txtmatricula.getText());

			fun = fd.pesquisar(matricula);

			if (fun == null) {
				JOptionPane.showMessageDialog(null, "Funcionario nao encontrado");
			} else {

				txtnome.setText(fun.getNome());
				txtnasc.setText(String.valueOf(fun.getIdade()));
				txtcargo.setText(fun.getCargo());
				txtmatricula.setText(String.valueOf(fun.getMatricula()));
				txtemail.setText(fun.getEmail());
				txtsenha.setText(fun.getSenha());
			}

		}

		if (e.getSource() == btalterar) {
			Integer matricula = Integer.valueOf(txtmatricula.getText());

			fun = fd.pesquisar(matricula);

			if (fun == null) {
				JOptionPane.showMessageDialog(null, "Matricula invalida!");
			} else {

				fun.setNome(txtnome.getText());
				fun.setIdade(Integer.parseInt(txtnasc.getText()));
				fun.setCargo(txtcargo.getText());
				fun.setEmail(txtemail.getText());
				fun.setSenha(txtsenha.getText());

				JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

				txtnome.setText("");
				txtnasc.setText("");
				txtcargo.setText("");
				txtmatricula.setText("");
				txtemail.setText("");
				txtsenha.setText("");
			}
		}

		if (e.getSource() == btexcluir) {
			Integer matricula = Integer.valueOf(txtmatricula.getText());

			fd.excluir(matricula);

			JOptionPane.showMessageDialog(null, "Excluido com sucesso");

			txtnome.setText("");
			txtnasc.setText("");
			txtcargo.setText("");
			txtmatricula.setText("");
			txtemail.setText("");
			txtsenha.setText("");

			if (fd.retornaTamanhoLista() < matricula) {

			}
		}
	}
}
