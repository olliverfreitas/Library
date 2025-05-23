package entities.dao;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.Funcionario;

public class FuncionarioDao {
		
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
		Funcionario fun;
		
		public void salvar(Funcionario f) {
			lista.add(f);
		}
		
		public void listar() {
			for(Funcionario f: lista) {
				JOptionPane.showMessageDialog(null, ""
								+ "O nome:"+f.getNome()
								+"\nAniversario:"+f.getIdade()
								+"\nO cargo:"+f.getCargo()
								+"\nA Matricula:"+f.getMatricula()
								+"\nO email:"+f.getEmail()
								+"\nA senha:"+f.getSenha());
			}
		}
		
		public Funcionario pesquisar(int cod) {
		    for (Funcionario funcionario : lista) {
		        if (funcionario.getMatricula() == cod) {
		            return funcionario;
		        }
		    }
		    return null; 
		}

		
		public void alterar(int cod, Funcionario f) {
			cod--;
			lista.set(cod, f);
		}
		
		public void excluir(int cod) {
			fun = pesquisar(cod);
			lista.remove(fun);
		}
		
		public Integer retornaTamanhoLista(){
			return lista.size();
		}
}

