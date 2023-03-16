package controller;

import java.util.concurrent.Semaphore;

public class Semáforo02 extends Thread {
	
	private int idPessoa;
	private Semaphore semaforo;
	
	public Semáforo02(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
		
	}
	
	public void run() {
		pessoaandando();
		try {
			semaforo.acquire();
			pessoaespera();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		pessoapassa();
	}
	
	private void pessoaandando(){ 
		int temp = 1000;
		int distperco = 0;
		
		while(distperco < 200) {
			distperco = distperco + (int) ((Math.random() * 3) + 4);
			// (0 * 3 = 0 + 4 = 4) (0,999999 * 3 = 2.999999 + 4 = 6,99999)
			try {
				Thread.sleep(temp);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("A pessoa " +idPessoa + " do corredor " +idPessoa +" andou " +distperco +" metros");
			
		}
	}
	
	private void pessoaespera() {
		System.out.println("A Pessoa " + idPessoa + " do corredor " +idPessoa + " chegou na porta e abriu");
		int abrirporta = (int) (Math.random() * 1001 + 1000);
		try {
			Thread.sleep(abrirporta);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void pessoapassa() {
		System.out.println("A Pessoa " + idPessoa + " do corredor " +idPessoa + " passou pela porta");
		
	}
	
	

}
