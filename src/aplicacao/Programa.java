package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.ContratoHora;
import entidades.Departamento;
import entidades.Funcionario;
import entidades.enuns.NivelFuncionario;


public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.print("Entre com o nome do departamento");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Entre com os dados do funcionario");
		System.out.print("Name: ");
		String nomeFuncionario = sc.nextLine();
		System.out.print("Nivel: ");
		String nivel = sc.nextLine();
		System.out.print("Salario Base: ");
		double salarioBase = sc.nextDouble();
		
		Funcionario funcionario = new Funcionario(nomeFuncionario, NivelFuncionario.valueOf(nivel), salarioBase, new Departamento(nomeDepartamento));
		
		System.out.println("Quantos contratos esse funcionario vai ter? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Entre com os dados do "  + (i + 1) + "º contrato: e data: ");
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por Hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração (Horas)");
			int horas = sc.nextInt();
			
			ContratoHora contrato = new ContratoHora(dataContrato, valorPorHora, horas);
			funcionario.adicionarContrato(contrato);
		}
				
		System.out.println();
		System.out.println("Entre com o mes e ano para calcular o salario (MM/YYYY): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0,2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		
		System.out.println("Nome : " + funcionario.getNome());
		System.out.println("Departamento: "+ funcionario.getDepartamento().getNome());
		System.out.println("Renda para: "+mesEAno +": "+ String.format("%.2f", funcionario.renda(ano, mes)));
		
		sc.close();	
	}
}
