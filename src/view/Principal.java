package view;

import java.util.concurrent.Semaphore; 

import controller.Semáforo02;

public class Principal {

		public static void main(String[] args) {
			int permissoes = 1;
			Semaphore semaforo= new Semaphore(permissoes);
			for(int idPessoa=1; idPessoa<=4;idPessoa++) {
				Semáforo02 porta = new Semáforo02(idPessoa, semaforo);
				porta.start();
			}
		}

	}

