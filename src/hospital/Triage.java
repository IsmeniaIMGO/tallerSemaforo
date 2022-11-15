package hospital;

public class Triage {

	//atributos propios de la clase
	int numeroCitasDisponibles = 0;
	int numeroCitasSolicitadas = 0;
	
	/**
	 * constructor en el que el traige tiene un limite(aforo) de citas que ofrecer
	 * @param aforo
	 */
	public Triage(int aforo){
		this.numeroCitasDisponibles = aforo;
	}
	
	
	/**
	 * Metodo que me permite observar que un paciente solicito una atencion
	 * de lo contrario que el paciente esta esperando por una cita disponible
	 * @throws InterruptedException
	 */
	public synchronized void solicitarAtencion() throws InterruptedException{
		while (numeroCitasSolicitadas == numeroCitasDisponibles) {
			System.out.println("El "+Thread.currentThread().getName()+" está esperando");
			wait();
		}
		numeroCitasSolicitadas++;
		notify();
	}
	
	/**
	 * Metodo que me permite observar como el paciente cancela una atencion
	 * @throws InterruptedException
	 */
	public synchronized void cancelarAtencion() throws InterruptedException{
		while(numeroCitasSolicitadas == 0){
			wait();
		}
		numeroCitasSolicitadas--;
		notify();
	}
	
}
