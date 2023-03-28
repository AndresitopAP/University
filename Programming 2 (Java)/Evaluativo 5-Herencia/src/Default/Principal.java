package Default;

import java.util.Scanner; 
import com.urbe.calculo.Calculos;
//import javax.swing.JOptionPane;

public class Principal {
	
	//variables de ejecucion 
	public static int Xj = 0, Xe = 0;
	
	//arreglo de objetos
	public static Entrenador entrenador[] = new Entrenador[1000000];
	public static Jugador jugadr[] = new Jugador[1000000];
	
	public static Scanner sc = new Scanner(System.in);
	public static Calculos calculate = new Calculos();
	
	public static void main(String arg[]) {
		
		Principal pr = new Principal();
		
		//variables de ejecucion
		int SYS = 1, opc = 0;
		int SYS_3 = 1, option = 0;
		int SYS_4 = 1, opcion = 0;
		
		do {
			
			pr.Menu();
			opc = sc.nextInt();
			System.out.println("");
			
			switch(opc) {
				
				case 1:
					//registrar jugadores
					System.out.print("Ingrese cantidad de jugadores: ");
					Xj = sc.nextInt();
					
					pr.CargarJugadores();
				break;
				
				case 2:
					//registrar entrenadores
					System.out.print("Ingrese cantidad de entrenadores: ");
					Xe = sc.nextInt();
					
					pr.CargarEntrenadores();
				break;
				
				case 3:
					//listado
					do {
						
						pr.MenuImprimir();
						option = sc.nextInt();
						System.out.println("");
						
						switch(option) {
							case 1:
								//info de 1 jugador
								System.out.println("Impresión de jugadores: ");
								pr.ListadoJugadores();
								
								System.out.println("Seleciona el jugador a visualizar");
								
								pr.InfoJugador();
							break;
							
							case 2:
								//info de 1 entrenador
								System.out.println("Impresión de entrenador: ");
								pr.ListadoEntrenadores();
								
								pr.InfoEntrenador();
							break;
							
							case 3:
								//vuelta atras
								SYS_3 = 0;
							break;
							
							default:
								System.err.println("ERROR, seleccione un a opcion correcta ");
							break;
						}
					}
					while(SYS_3 == 1);
				break;
				
				case 4:
					//estadisticas					
					do {
						
						pr.MenuEstadisticas();
						opcion = sc.nextInt();
						System.out.println("");
						
						switch(opcion) {
							case 1:
								//jugador que mas gana
								int higher_salary_pos = calculate.getHigherSalary(jugadr, Xj);
								String total_name = jugadr[higher_salary_pos].getNombre() + " " + jugadr[higher_salary_pos].getApellido();
								System.out.println("El jugador con mayor salario es: " + total_name);
								System.out.println("Que gana un salario de: " + jugadr[higher_salary_pos].getSueldo());
								
							break;
							
							case 2:
								//jugador que menos gana
								int menor_salary_pos = calculate.getMenorSalary(jugadr, Xj);
								String total_name_e = jugadr[menor_salary_pos].getNombre() + " " + jugadr[menor_salary_pos].getApellido();
								System.out.println("El jugador con menos salario es: " + total_name_e);
								System.out.println("Que gana un salario de: " + jugadr[menor_salary_pos].getSueldo());
							break;
							
							case 3:
								//jugador mas alto y mas bajo
								int Higher = calculate.getHigher(jugadr, Xj);
								String Higher_name = jugadr[Higher].getNombre() + " " + jugadr[Higher].getApellido();
								System.out.println("El jugador mas pesado  es: " + Higher_name);
								System.out.println("Con un peso de: " + jugadr[Higher].getAltura());
								
								int LowerHeight = calculate.getLowerHeight(jugadr, Xj);
								String LowerHeight_name = jugadr[LowerHeight].getNombre() + " " + jugadr[LowerHeight].getApellido();
								System.out.println("El jugador mas pesado  es: " + LowerHeight_name);
								System.out.println("Con un peso de: " + jugadr[LowerHeight].getAltura());
							break;
							
							case 4:
								//jugador mas pesado y mas ligero
								int Heavier = calculate.getHeavier(jugadr, Xj);
								String Heavier_name = jugadr[Heavier].getNombre() + " " + jugadr[Heavier].getApellido();
								System.out.println("El jugador mas pesado  es: " + Heavier_name);
								System.out.println("Con un peso de: " + jugadr[Heavier].getPeso());
								
								int Ligther = calculate.getLigther(jugadr, Xj);
								String Ligther_name = jugadr[Ligther].getNombre() + " " + jugadr[Ligther].getApellido();
								System.out.println("El jugador menos es: " + Ligther_name);
								System.out.println("Con un peso de: " + jugadr[Ligther].getPeso());
								
							break;
							
							case 5:
								//cantidad de jugadores
								System.out.println("Cantidad total de jugadores: " + Xj);
								
								int Portero_cantidad = calculate.getTotalPosicion(jugadr, Xj, "Portero");
								System.out.println("La cantidad total de porteros es " + Portero_cantidad);
								
								int Defensa_cantidad = calculate.getTotalPosicion(jugadr, Xj,"Defensa");
								System.out.println("La cantidad total de defensas es " + Defensa_cantidad);
								
								int Medio_cantidad = calculate.getTotalPosicion(jugadr, Xj,"MedioCampo");
								System.out.println("La cantidad total de medios campos es " + Medio_cantidad);
								
								int Delantero_cantidad = calculate.getTotalPosicion(jugadr, Xj,"Delantero");
								System.out.println("La cantidad total de delanteros es " + Delantero_cantidad);
								
								int pie_D_cantidad = calculate.getTotalPie(jugadr, Xj,"Derecho");
								System.out.println("La cantidad de jugadores derechos es " + pie_D_cantidad);
								
								int pie_I_cantidad = calculate.getTotalPie(jugadr, Xj,"Izquierdo");
								System.out.println("La cantidad de jugadores zurdos es " + pie_I_cantidad);
							break;
							
							case 6:
								//cantidad de entrenadores
								System.out.println("Cantidad total de entrenadores: " + Xe);
							break;
							
							case 7:
								//entrenador que mas gana
								int menor_salar = calculate.getHigherSalarye(entrenador, Xe);
								String name_total = entrenador[menor_salar].getNombre() + " " + entrenador[menor_salar].getApellido();
								System.out.println("El entrenador con mayor salario es: " + name_total);
								System.out.println("Que gana un salario de: " + entrenador[menor_salar].getSueldo());
							break;
							
							case 8:
								//entrenador que menos gana
								int higher_salary = calculate.getMenorSalarye(entrenador, Xe);
								String total_e_name = entrenador[higher_salary].getNombre() + " " + entrenador[higher_salary].getApellido();
								System.out.println("El entrenador con menor salario es: " + total_e_name);
								System.out.println("Que gana un salario de: " + entrenador[higher_salary].getSueldo());
							break;
							
							case 9:
								SYS_4 = 0;
							break;
							
							default:
								System.err.println("ERROR, seleccione un a opcion correcta ");
							break;
						}
					}
					while(SYS_4 == 1);
				break;
					
				case 5:
					//final del progrma :v
					System.out.println("Programa finalizado");
					SYS = 0;
				break;
					
				default:
					System.err.println("ERROR, seleccione un a opcion correcta ");
				break;
			}
			
			
		}
		while(SYS == 1);
		
	}//final del main
	
	//metodos y funciones
	
	public void Menu() {
		//Menu principal
		System.out.println("1. Registrar jugador ");
		System.out.println("2. Registrar entrenador ");
		System.out.println("3. Listado ");
		System.out.println("4. Estadisticas ");
		System.out.println("5. Cerrar Programa ");
		System.out.print("Ingrese opc: ");
	}
	
	public void CargarJugadores() {
		//agregar jugadores
		System.out.println("**** AGREGAR JUGADOR ****");
		
		for(int i = 0; i < Xj; i++) {
			System.out.print("Nombre: ");
			String name = sc.next();
			
			System.out.print("Apellido: ");
			String lastName = sc.next();
			
			System.out.print("Pais: ");
			String country = sc.next();
			
			System.out.print("Edad:¨");
			int age = sc.nextInt();
			
			System.out.print("Sueldo: ");
			float salary = sc.nextFloat();
			
			System.out.print("Número: ");
			String number = sc.next();
			
			System.out.println("Pie preferido: ");
			System.out.print("Colocar Derecho o  Izquierdo: ");
			
			String preferred_foot = sc.next();
			
			System.out.print("Altura: ");
			double height = sc.nextDouble();
			
			System.out.print("Peso: ");
			double weight = sc.nextDouble();
			
			System.out.println("Posición: ");
			System.out.print("Colocar si es Portero, Defensa, MedioCampo o Delantero: ");
			String position = sc.next();
			
			//creando y almacenando en el arreglo del objeto jugador
			Jugador player = new Jugador(name, lastName, country, age, salary, number, preferred_foot, height, weight, position);
			
			jugadr[i] = player;
			System.out.println("");
		}
		
	}
	
	public void CargarEntrenadores() {
		//registro de entrenadores
		System.out.println("**** AGREGAR ENTRENADOR ****");
		
		for(int i = 0; i < Xe; i++) {
			System.out.print("Nombre: ");
			String name_e = sc.next();
			
			System.out.print("Apellido: ");
			String lastName_e = sc.next();
			
			System.out.print("Pais: ");
			String country_e = sc.next();
			
			System.out.print("Edad:¨");
			int age_e = sc.nextInt();
			
			System.out.print("Sueldo: ");
			float salary_e = sc.nextFloat();
			
			System.out.print("Experiencia:¨");
			int experience = sc.nextInt();
			
			System.out.println("Tipo: ");
			System.out.print("Colocar si es Tecnico, Masajista o Personal");
			String type = sc.next();
			
			//creando y almacenando en el arreglo del objeto entrenador
			Entrenador coach = new Entrenador(name_e, lastName_e, country_e, age_e, salary_e, type, experience);
			
			entrenador[i] = coach;
			System.out.println("");
		}
	}
	
	public void MenuImprimir() {
		//sub-menu para el caso 2, visualizar
		System.out.println("1. Visualizar jugador ");
		System.out.println("2. Visualizar entrenador ");;
		System.out.println("3. Volver al menu anterior ");
		System.out.print("Ingrese opc: ");
	}
	
	public void ListadoJugadores() {
		//mostar jugadores registrados
		System.out.println("Selecciona el jugador a visualizar");
		
		for(int i = 0; i < Xj; i++) {
			System.out.println((i+1) + "Nombre: " + jugadr[i].getNombre());
		}
		System.out.println("");
	}
	
	public void InfoJugador() {
		//muestra la info de un jugador en espeifico
		
		System.out.println("Seleciona el jugador a visualizar");
		int ocp = sc.nextInt(); 
		
		int J = ocp - 1;
		
		for(int i = 0; i < 1; i++) {
			System.out.println("Nombre: " + jugadr[J].getNombre());
			System.out.println("Apellido: " + jugadr[J].getApellido());
			System.out.println("Pais: " + jugadr[J].getPais());
			System.out.println("Edad: " + jugadr[J].getEdad());
			System.out.println("Sueldo: " + jugadr[J].getSueldo());
			System.out.println("Numero: " + jugadr[J].getNumero());
			System.out.println("Pie preferido: " + jugadr[J].getPie_preferido());
			System.out.println("Altura: " + jugadr[J].getAltura());
			System.out.println("Peso: " + jugadr[J].getPeso());
			System.out.println("Posicion: " + jugadr[J].getPosicion());
		}
		System.out.println("");
	}
	
	
	public void ListadoEntrenadores() {
		//muestra de los entrenadores registrados
		System.out.println("Selecciona el Entrenador a visualizar");
		for(int i = 0; i < Xe; i++) {
			System.out.println((i+1) + "Nombre: " + entrenador[i].getNombre());
		}
		System.out.println("");
	}
	
	public void InfoEntrenador() {
		//muestra la info de un entrenador en espeifico
		System.out.println("Seleciona el entrenador a visualizar");
		int ocp = sc.nextInt(); 
		
		int E = ocp - 1;
		
		for(int i = 0; i < 1; i++) {
			System.out.println("Nombre: " + entrenador[E].getNombre());
			System.out.println("Apellido: " + entrenador[E].getApellido());
			System.out.println("Pais: " + entrenador[E].getPais());
			System.out.println("Edad: " + entrenador[E].getEdad());
			System.out.println("Sueldo: " + entrenador[E].getSueldo());
			System.out.println("Tipo: " + entrenador[E].getTipo());
			System.out.println("Experiencia: " + entrenador[E].getExperiencia());
		}
		System.out.println("");
	}
	
	public void MenuEstadisticas() {
		//sub-menu para la opcion 4, mostrar estadisticas 
		System.out.println("1. Jugador que mas gana ");
		System.out.println("2. Jugador que menos gana ");
		System.out.println("3. Jugador mas bajo y mas alto ");
		System.out.println("4. Jugador mas pesado y mas ligero ");
		System.out.println("5. Cantidad de jugadores ");
		System.out.println("6. Cantidad de entrenadores ");
		System.out.println("7. Entrenador que mas gana ");
		System.out.println("8. Entrenador que menos gana ");
		System.out.println("9. Volver al menu anterior ");
		System.out.print("Ingrese opc: ");
	}
	
	
}



