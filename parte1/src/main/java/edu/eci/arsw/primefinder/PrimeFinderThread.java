package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread{

	
	int a,b;
	int counter=0;
	private boolean paused = true;
	
	private List<Integer> primes=new LinkedList<Integer>();
	
	public PrimeFinderThread(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public void run(){
		for (int i=a;i<=b;i++){
			synchronized (this) {
				while (paused) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if (isPrime(i)){
				primes.add(i);
				counter++;
				System.out.println(i);
			}
		}
		
		
	}
	
	boolean isPrime(int n) {
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

	public synchronized void pauseThread() {
		paused = true;
	}

	public synchronized void resumeThread() {
		paused = false;
		notifyAll();
	}

	public List<Integer> getPrimes() {
		return primes;
	}

	public int getCounter() {
		return counter;
	}
	
	
	
	
}
