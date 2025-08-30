package arsw.threads;

public class RegistroLlegada {

	private int ultimaPosicionAlcanzada=1;

	private String ganador=null;

	public int llegada(String galgo) {
		int puesto = 0;
		synchronized (this) {
			if (ganador == null) {
				ganador = galgo;
			}
			puesto = ultimaPosicionAlcanzada;
			ultimaPosicionAlcanzada++;
		}
		return puesto;
	}

	public synchronized String getGanador() {
		return ganador;
	}

	public synchronized int getUltimaPosicionAlcanzada() {
		return ultimaPosicionAlcanzada;
	}

}
