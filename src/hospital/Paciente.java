package hospital;

public class Paciente  extends Thread{

	//atributos propios de la clase
	private String nombre;
	Hospital hospital;
	
	/**
	 * constructor de la clase
	 * @param nombre
	 * @param hospital
	 */
	public Paciente(String nombre, Hospital hospital) {
		super(nombre);
		this.nombre = nombre;
		this.hospital = hospital;
	}
	
	/**
	 * Metodos set y get de los atributos
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	
	/**
	 * Metodo que me permite observar si el paciente entro o salio del hospital
	 */
	@Override
	public void run(){
		hospital.solicitarAtencion();
		System.out.println("El "+getNombre()+" entro al hospital y esta siendo atendido");
		try {
			Thread.sleep(30000);
			hospital.cancelarAtencion();
			System.out.println("El "+getNombre() +" salio del hospital");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
