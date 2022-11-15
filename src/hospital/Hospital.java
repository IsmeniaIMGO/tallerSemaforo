package hospital;

public class Hospital {

	//atrbutos propios de la clase
	private String nombre;
	Triage triage;
	
	/**
	 * constructor con atributos
	 * @param nombre
	 * @param aforo
	 */
	public Hospital(String nombre, int aforo ) {
		super();
		this.nombre = nombre;
		this.triage = new Triage(aforo);//el Triage va tener un aforo
	}


	/**
	 * Metodos get y set de los atributos
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Triage getTriage() {
		return triage;
	}
	
	public void setTriage(Triage triage) {
		this.triage = triage;
	}

	
	/**
	 * Metodo que le pide al triage una solicitud de una atencion
	 */
	public void solicitarAtencion(){
		try{
			triage.solicitarAtencion();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que le pide al triage cancelar una atencion
	 */
	public void cancelarAtencion(){
		try {
			triage.cancelarAtencion();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que me inicializa y simula un paciente
	 */
	public void simularPacientes(){
		Paciente paciente = null;
		for (int i = 1; i < 10; i++) {
			paciente = new Paciente("Paciente "+i,this);
			paciente.start();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
	
	
}
