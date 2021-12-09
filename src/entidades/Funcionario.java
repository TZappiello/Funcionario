package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enuns.NivelFuncionario;


public class Funcionario {
	private String nome;
	private NivelFuncionario nivel;
	private Double salarioBase;

	private Departamento departamento;
	private List<ContratoHora> contratos = new ArrayList<>();

	
	public Funcionario() {
		
	}	
	public Funcionario(String nome, NivelFuncionario nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelFuncionario getNivel() {
		return nivel;
	}

	public void setNivel(NivelFuncionario nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHora> getContrato() {
		return contratos;
	}

	public void adicionarContrato(ContratoHora contrato) {
		contratos.add(contrato);
	}

	public void removeContrato(ContratoHora contrato) {
		contratos.remove(contrato);
	}

	public Double renda(int ano, int mes) {
		double soma = salarioBase;

		Calendar cale = Calendar.getInstance();

		for (ContratoHora c : contratos) {

			cale.setTime(c.getData());

			int c_ano = cale.get(Calendar.YEAR);
			int c_mes = 1 + cale.get(Calendar.MONTH);
			if (ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
}
