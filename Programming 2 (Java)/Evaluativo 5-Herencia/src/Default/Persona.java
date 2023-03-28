package Default;

public class Persona{
	
	private String Nombre;
	private String Apellido;
	private String Pais;
	private Integer Edad;
	private Float Sueldo;
	
	public Persona(String Nombre, String Apellido, String Pais, Integer Edad, Float Sueldo){
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.Pais = Apellido;
		this.Edad = Edad;
		this.Sueldo = Sueldo;
	}
	
	public String getNombre(){
		return this.Nombre;
	}
	
	public String getApellido(){
		return Apellido;
	}
	
	public String getPais(){
		return Pais;
	}
	
	public int getEdad(){
		return Edad;
	}
	
	public float getSueldo(){
		return Sueldo;
	}
	
	
	
}
