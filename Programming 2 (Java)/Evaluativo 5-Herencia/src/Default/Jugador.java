package Default;

public class Jugador extends Persona{
	/*
	 * private String Nombre;
	private String Apellido;
	private String Pais;
	private int Edad;
	private float Sueldo;
	 */
	private String Numero;
	private String Pie_preferido;
	private double Altura;
	private double Peso;
	private String Posicion;
	
	public Jugador(String Nombre, String Apellido, String Pais, int Edad, float Sueldo, String Numero, String Pie_preferido, double Altura, double Peso, String Posicion) {
		super(Nombre, Apellido, Pais, Edad, Sueldo);
		this.Numero = Numero;
		this.Pie_preferido = Pie_preferido;
		this.Altura = Altura;
		this.Peso = Peso;
		this.Posicion = Posicion;
	}
	
	public String getNumero() {
		return this.Numero;
	}
	
	public String getPie_preferido() {
		return this.Pie_preferido;
	}
	
	public double getAltura() {
		return this.Altura;
	}
	
	public double getPeso() {
		return this.Peso;
	}
	
	public String getPosicion() {
		return this.Posicion;
	}
	
	
	
}
