package screens;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import entities.dao.FuncionarioDao;
import entities.Funcionario;

import resources.Cores;

public class TelaFuncionario implements ActionListener {
	Funcionario fun;
	FuncionarioDao fd = new FuncionarioDao();
	Cores cor = new Cores();
	ImageIcon icone = new ImageIcon("src/resources/images/fun.png");
	


	JFrame tela = new JFrame("Cadastro de Funcionarios");
	JPanel painel = new JPanel();

	JLabel lbImg = new JLabel(icone);

	JLabel lbmatricula = new JLabel("Matricula: ");


	JLabel lbnome = new JLabel("Nome: ");
	JLabel lbnasc = new JLabel("Nascimento: ");
	JLabel lbsexo = new JLabel("Sexo: ");
	JCheckBox checkBoxM = new JCheckBox("Masculino");
	JCheckBox checkBoxF = new JCheckBox("Feminino");
	JCheckBox checkBoxO = new JCheckBox("Outro");


	JLabel lbcargo = new JLabel("Cargo: ");
	String[] cargos = { "Selecione um cargo","Gerente", "Atendente", "Estoquista", "Estagiario" };
	JComboBox<String> menucargos = new JComboBox<>(cargos);
	JLabel lbcargos = new JLabel("Cargo: ");



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

	 public void abrirTela(){
	// ------------ Customização da tela ------------
		tela.setSize(550, 450); 
		tela.setLocation(550, 250);
		painel.setLayout(null);

		// MATRÍCULA + BOTÃO PESQUISAR
		lbmatricula.setBounds(30, 20, 100, 30);
		lbmatricula.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lbmatricula.setForeground(cor.getBranco());

		txtmatricula.setBounds(120, 20, 180, 30);
		txtmatricula.setEnabled(false);
		txtmatricula.setBackground(java.awt.Color.LIGHT_GRAY);

		 btpesq.setBounds(310, 20, 120, 30);
		 btpesq.setBackground(cor.getVerdeClaro());
		 btpesq.setForeground(java.awt.Color.WHITE);
		 btpesq.addActionListener(this);
		 btpesq.setEnabled(false);

		// IMAGEM
		lbImg.setBounds(250, 150, 300, 200);


		// NOME 
		lbnome.setBounds(30, 70, 100, 30);
		lbnome.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lbnome.setForeground(cor.getBranco()); 
		txtnome.setBounds(120, 70, 180, 30);

		// NASCIMENTO
		lbnasc.setBounds(30, 120, 100, 30);
		lbnasc.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lbnasc.setForeground(cor.getBranco()); 
		txtnasc.setBounds(120, 120, 70, 30);

		// SEXO
		lbsexo.setBounds(202, 75, 200, 100);
		lbsexo.setForeground(cor.getBranco());
		

		//CheckBox
		checkBoxM.setBounds(200, 130, 100, 30);
		checkBoxM.setBackground(cor.getVerdeEscuro());
		checkBoxM.setForeground(cor.getBranco());
		checkBoxM.setFocusPainted(false);
        checkBoxM.addActionListener(this);
        checkBoxM.setCursor(new Cursor(Cursor.HAND_CURSOR));

		checkBoxF.setBounds(300, 130, 100, 30);
		checkBoxF.setBackground(cor.getVerdeEscuro());
		checkBoxF.setForeground(cor.getBranco());
		checkBoxF.setFocusPainted(false);
		checkBoxF.addActionListener(this);
		checkBoxF.setCursor(new Cursor(Cursor.HAND_CURSOR));

		checkBoxO.setBounds(400, 130, 100, 30);
		checkBoxO.setBackground(cor.getVerdeEscuro());
		checkBoxO.setForeground(cor.getBranco());
		checkBoxO.setFocusPainted(false);
		checkBoxO.addActionListener(this);
		checkBoxO.setCursor(new Cursor(Cursor.HAND_CURSOR));


		// CARGO
		lbcargos.setBounds(30, 170, 100, 30);
		lbcargos.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lbcargos.setForeground(cor.getBranco()); 
		menucargos.setBounds(120, 170, 180, 30);
		menucargos.setBackground(cor.getBranco());
		menucargos.setBorder(new LineBorder(cor.getVerdeClaro(), 3));
		menucargos.setCursor(new Cursor(Cursor.HAND_CURSOR));

		//txtcargo.setBounds(120, 140, 180, 30);

		// EMAIL
		lbemail.setBounds(30, 220, 100, 30);
		lbemail.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lbemail.setForeground(cor.getBranco()); 
		txtemail.setBounds(120, 220, 180, 30);

		// SENHA
		lbsenha.setBounds(30, 270, 100, 30);
		lbsenha.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lbsenha.setForeground(cor.getBranco()); 
		txtsenha.setBounds(120, 270, 180, 30);

		// BOTÕES
		btsalvar.setBounds(70, 340, 90, 30);
		btsalvar.addActionListener(this);
		btsalvar.setBackground(cor.getVerdeClaro());
		btsalvar.setForeground(cor.getBranco());


		btlistar.setBounds(170, 340, 90, 30);
		btlistar.addActionListener(this);
		btlistar.setBackground(cor.getVerdeClaro());
		btlistar.setForeground(cor.getBranco());

		btalterar.setBounds(270, 340, 90, 30);
		btalterar.addActionListener(this);
		btalterar.setBackground(cor.getVerdeClaro());
		btalterar.setForeground(cor.getBranco());

		btexcluir.setBounds(370, 340, 90, 30);
		btexcluir.addActionListener(this);
		btexcluir.setBackground(cor.getVerdeClaro());
		btexcluir.setForeground(cor.getBranco());

// ------------ Adicionando os componentes ao painel ------------
		painel.add(lbnome);
		painel.add(txtnome);
		painel.add(btpesq);

		painel.add(lbnasc);
		painel.add(txtnasc);
		painel.add(checkBoxM);
		painel.add(checkBoxF);
		painel.add(checkBoxO);
		painel.add(lbsexo);

		painel.add(lbcargos);
		painel.add(menucargos);

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

		painel.add(lbImg);

		painel.setBackground(cor.getBranco());

		tela.getContentPane().add(painel);
		tela.setVisible(true);

		painel.setBackground(cor.getVerdeEscuro());
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
				txtmatricula.setBackground(cor.getBranco());
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
		
		if (e.getSource() == checkBoxM) {
			checkBoxF.setSelected(false);
			checkBoxO.setSelected(false);

    }
		if (e.getSource() == checkBoxF) {
			checkBoxM.setSelected(false);
			checkBoxO.setSelected(false);

		}
		if (e.getSource() == checkBoxO) {
			checkBoxM.setSelected(false);
			checkBoxF.setSelected(false);

		}
	}

}

