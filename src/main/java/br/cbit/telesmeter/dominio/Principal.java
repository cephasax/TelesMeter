package br.cbit.telesmeter.dominio;


public class Principal {
	
		public static void main(String[] args) {
			
			Usuario usuario1 = new Usuario();
			Usuario usuario2 = new Usuario();
			Usuario usuario3 = new Usuario();
			Usuario usuario4 = new Usuario();
			Usuario usuario5 = new Usuario();
			
			Estacao estacao1 = new Estacao();
			Estacao estacao2 = new Estacao();
			Estacao estacao3 = new Estacao();
			Estacao estacao4 = new Estacao();
			Estacao estacao5 = new Estacao();
			
			Dado dados1 = new Dado();	
			Dado dados2 = new Dado();
			Dado dados3 = new Dado();
			Dado dados4 = new Dado();
			Dado dados5 = new Dado();
			
			usuario1.setLogin("Joao");
			usuario1.setSenha("abc");
			
			usuario2.setLogin("Maria");
			usuario2.setSenha("abc");
			
			usuario3.setLogin("Alice");
			usuario3.setSenha("abc");
			
			usuario4.setLogin("Ana");
			usuario4.setSenha("abc");
			
			usuario5.setLogin("Tiago");
			usuario5.setSenha("abc");
			
			estacao1.setNome("nomeEstacao1");
			estacao1.setData("10/08/2016");
			estacao1.setValor(1000.0);
			
			estacao2.setNome("nomeEstacao2");
			estacao2.setData("10/08/2016");
			estacao1.setValor(2000.0);
			
			estacao3.setNome("nomeEstacao3");
			estacao3.setData("10/08/2016");
			estacao1.setValor(3000.0);
			
			estacao4.setNome("nomeEstacao4");
			estacao4.setData("10/08/2016");
			estacao1.setValor(4000.0);
			
			estacao5.setNome("nomeEstacao5");
			estacao5.setData("10/08/2016");
			estacao1.setValor(5000.0);
			
			dados1.getEstacoes().add(estacao1);
			dados1.getEstacoes().add(estacao2);
			dados1.getEstacoes().add(estacao3);
			dados1.setNome("nomeDados1");
			dados2.getEstacoes().add(estacao1);
			dados2.getEstacoes().add(estacao1);
			dados2.getEstacoes().add(estacao1);
			dados2.setNome("nomeDados2");
			dados3.getEstacoes().add(estacao1);
			dados3.getEstacoes().add(estacao1);
			dados3.getEstacoes().add(estacao1);
			dados3.setNome("nomeDados3");
			dados4.getEstacoes().add(estacao1);
			dados4.getEstacoes().add(estacao1);
			dados4.getEstacoes().add(estacao1);
			dados4.setNome("nomeDados4");
			dados5.getEstacoes().add(estacao1);
			dados5.getEstacoes().add(estacao1);
			dados5.getEstacoes().add(estacao1);
			dados5.setNome("nomeDados5");
		}
	

}
