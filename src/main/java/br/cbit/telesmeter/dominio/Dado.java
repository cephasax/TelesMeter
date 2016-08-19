package br.cbit.telesmeter.dominio;

import java.util.ArrayList;

public class Dado {

	private String nome;
	private ArrayList<Estacao> estacoes;

	public Dado(){
		this.estacoes = new ArrayList<Estacao>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Estacao> getEstacoes() {
		return estacoes;
	}

	public void setEstacoes(ArrayList<Estacao> estacoes) {
		this.estacoes = estacoes;
	}

}
