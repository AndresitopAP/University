package Default;

public class Entrenador extends Persona{
	
	private int Experiencia;
	private String Tipo;
	
	public Entrenador(String Nombre, String Apellido, String Pais, int Edad, float Sueldo, String Tipo, int Experiencia) {
		super(Nombre, Apellido, Pais, Edad, Sueldo);
		this.Experiencia = Experiencia;
		this.Tipo = Tipo;
	}
	
	public int getExperiencia() {
		return this.Experiencia;
	}
	
	public String getTipo() {
		return this.Tipo;
	}
	
}
