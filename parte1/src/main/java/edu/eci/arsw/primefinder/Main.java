package edu.eci.arsw.primefinder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		int threadsN = 1;
		int totalData = 100000000;

		int range = totalData / threadsN;

		PrimeFinderThread[] threads = new PrimeFinderThread[threadsN];

		int start = 0;

		for (int i = 0;i<threadsN;i++) {
			int end = start + range;
			threads[i] = new PrimeFinderThread(start, end);
			start = end;
		}

		for (PrimeFinderThread t:threads){
			t.start();
		}

		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			boolean allFinished = true;
			for (PrimeFinderThread t : threads) {
				if (t.isAlive()) {
					allFinished = false;
					break;
				}
			}
			if (allFinished) {
				break;
			}

			for (PrimeFinderThread t : threads) {
				t.pauseThread();
			}

			int totalPrimes = 0;
			for (PrimeFinderThread t : threads) {
				totalPrimes += t.getCounter();
			}

			System.out.println("Primos encontrados: " + totalPrimes);
			System.out.println("Presiona ENTER para continuar la busqueda");
			System.in.read();

			for (PrimeFinderThread t : threads) {
				t.resumeThread();
			}
		}
	}
}
