package com.kelver.ui;

import java.util.List;
import java.util.Scanner;

import com.kelver.models.Pessoa;
import com.kelver.services.impl.PessoaService;
import com.kelver.services.interfaces.CrudService;

public class Main {

	private static Scanner SN = new Scanner(System.in);
	
	public static void main(String[] args) {
		int op = 0;
		
		while (op != 6) {
			System.out.println("\n1 - Listar Pessoas");
			System.out.println("2 - Inserir Pessoa");
			System.out.println("3 - Atualizar Pessoa");
			System.out.println("4 - Excluir Pessoa");
			System.out.println("5 - Pesquisar Pessoa");
			System.out.println("6 - Sair");
			
			op = SN.nextInt();
			SN.nextLine();
			switch (op) {
			case 1:
				listarPessoas();
				break;
			case 2:
				inserirPessoa();
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
	}

	private static void inserirPessoa() {
		Pessoa p = new Pessoa();
		p.setNome(SN.nextLine());
		p.setIdade(SN.nextInt());
		CrudService<Pessoa, Integer> ps = new PessoaService();
		Pessoa p2 = ps.insert(p);
		System.out.println("Pessoa: " + p2.getId() + " " + p2.getNome() + " " + p2.getIdade());
	}

	private static void listarPessoas() {
		CrudService<Pessoa, Integer> ps = new PessoaService();

		try {
			List<Pessoa> pes = ps.all();
			System.out.println("Pessoas Cadastradas: \n");
			pes.forEach(p -> {
				System.out.println("ID: " + p.getId() + " - Pessoa: " + p.getNome() + " - Idade: " + p.getIdade());
			});
			if (pes.isEmpty()) {
				System.out.println("Não existe pessoas cadastradas!");
			}
		} catch (Exception e) {
			System.out.println("Erro! " + e.getMessage());
		}
	}

}
