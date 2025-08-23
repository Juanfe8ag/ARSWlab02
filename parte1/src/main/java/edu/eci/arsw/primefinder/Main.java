package edu.eci.arsw.primefinder;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

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

	}

}
