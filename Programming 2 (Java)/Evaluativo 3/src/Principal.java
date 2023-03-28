import java.util.Scanner; 
import java.util.Arrays;

public class Principal {
	//Variables globales
	public static Scanner sc = new Scanner(System.in); 
	public static Principal pr = new Principal();
	
	private static int[] number = new int[0];
	private static String[] name = new String[0];
	private static double[] height = new double[0];
	private static double[] weigth = new double[0];
	private static String[] type = new String[0];
	private static String[] sex = new String[0];
	private static int X = 0;
	
	//Variables de Mayor y menor
	//double lower = 0, higher = 0, heavier = 0, ligther = 0;
	//int minor = 0, bigger = 0;

	public static void main(String arg[]) { //main()
		//Variables de ejecuccion
		int SYS = 1, opc = 0;
		
		do {
			
			pr.Menu();
			opc = sc.nextInt();
			
			System.out.println("");
			
			switch(opc) {
			case 1: 
				System.out.print("Pokemones a Registrar ");
				X = sc.nextInt();
				
				pr.RegistroPokemons(X);
				
			break;
			
			case 2: 
				//Lista de Pok�mon
				for(int i =0; i<X;i++) {
					System.out.println((i+1) + ". " + name[i]);
				}
				
				System.out.println("");
				
				System.out.print("Selecione el pokemon a visualizar completamente ");
				int ocp = sc.nextInt(); 
				
				int pokemon = ocp - 1;
				
				for(int i = 0; i < 1; i++) {
					System.out.println(number[pokemon]);
					System.out.println(name[pokemon]);
					System.out.println(height[pokemon]);
					System.out.println(weigth[pokemon]);
					System.out.println(type[pokemon]);
					System.out.println(sex[pokemon]);
				}
				
			System.out.println("");
			break;
			
			case 3: 
				//Estadisticas
				int lower = pr.getLowerNumber(number);
				System.out.println("El numero m�s bajo est� en la posici�n " + (lower + 1) + ": "+ name[lower] + "#(" + number[lower] + ")");
				
				int bigger = pr.getBiggerNumber(number);
				System.out.println("El numero m�s alto est� en la posici�n " + (bigger + 1) + ": "+ name[bigger] + "#(" + number[bigger] + ")");
				
				System.out.println("");
				
				System.out.println("La cantidad de pokemones regitrado son: " + X);
				
				System.out.println("");
				
				int male_cantidad = pr.getTotalBySex(sex, "Hombre");
				System.out.println("La cantidad total de machos es " + male_cantidad);
				
				int female_cantidad = pr.getTotalBySex(sex, "Mujer");
				System.out.println("La cantidad total de hembras es " + female_cantidad);
				
				System.out.println("");
				
				int lower_h = pr.getLowerHeight(height);
				System.out.println("El m�s pequeno est� en la posici�n " + (lower_h + 1) + ": "+ height[lower_h]+ name[lower_h]);
				
				int higher = pr.getHigher(height);
				System.out.println("El m�s alto est� en la posici�n " + (higher + 1) + ": "+ height[higher]+ name[higher]);
				
				System.out.println("");
				
				int lither = pr.getLigther(weigth);
				System.out.println("El menos pesado est� en la posici�n " + (lither + 1) + ": "+ weigth[lither]+ name[lither]);
				
				int heavier = pr.getHeavier(weigth);
				System.out.println("El m�s pesado est� en la posici�n " + (heavier + 1) + ": "+ weigth[heavier]+ name[heavier]);
				
				System.out.println("");
			break;
			
			case 4: 
				System.out.println("Programa finalizado");
				SYS = 0;
			default:
				System.err.println("ERROR, seleccione un a opcion correcta ");
			break;
			
			}
			
		}
		while (SYS == 1);
	
	}
	//FINAL DEL MAIN
	
	//M�todos y Funciones
	public void Menu() {
		//Menu principal
		System.out.println("1. Registro ");
		System.out.println("2. Lista ");
		System.out.println("3. Estadisticas ");
		System.out.println("4. Cerrar Programa ");
		System.out.print("Ingrese opc: ");
	}
			
	public void RegistroPokemons(int X) {
		int opc = 0, SYS = 1;
		//redeclaracion
		number = new int[X];
		name = new String[X];
		height = new double[X];
		weigth = new double[X];
		type = new String[X];
		sex = new String[X];
		
		for(int i = 0; i < X; i++) {
			//registro
			System.out.print("Numero de pokedex: ");
			number[i] = sc.nextInt();
			System.out.print("Nombre: ");
			name[i] = sc.next();
			System.out.print("Altura: ");
			height[i] = sc.nextDouble();
			System.out.print("Peso: ");
			weigth[i] = sc.nextDouble();
			System.out.print("Tipo: ");
			type[i] = sc.next();
			
			System.out.println("");
			
			//Seleccionar sexo de pokemon
			System.out.println("Sexo ");
			System.out.println("1. Macho ");
			System.out.println("2. Hembra ");
			System.out.println("3. No tiene ");
			System.out.print("Ingrese opc: ");
			opc = sc.nextInt();
			
			System.out.println("");
			
			do {
				switch(opc) {
					case 1:
						sex[i] = "Hombre";
						SYS = 0;
					break;
					
					case 2:
						sex[i] = "Mujer";
						SYS = 0;
					break;
					
					case 3:
						sex[i] = "No tiene";
						SYS = 0;
					break;
					
					default:
						System.err.println("ERROR, seleccione un a opcion correcta ");
					break;
			
				}
			}
			while(SYS == 1);
			
		}
	}
	
	public int getLowerNumber(int[] number) {
		int pos = 0;
		int lower = number[0];
		
		for(int i = 0; i < X; i++) {
			if(number[i] < lower) {
				//lower = number[i];
				pos = i;
			}
		}
		
		return pos;
	}
	
	public int getBiggerNumber(int[] number) {
		int pos = 0;
		int bigger = number[0];
		
		for(int i = 0; i < X; i++) {
			if(number[i] > bigger) {
				pos = i;
			}
		}
		
		return pos;
	}
	
	public int getLowerHeight(double[] height) {
		int pos = 0;
		double lower_h = height[0];
		
		for(int i = 0; i < X; i++) {
			if(height[i] < lower_h) {
				pos = i;
			}
		}
		
		return pos;
	}
	
	public int getHigher(double[] height) {
		int pos = 0;
		double higher = height[0];
		
		for(int i = 0; i < X; i++) {
			if(height[i] > higher) {
				pos = i;
			}
		}
		
		return pos;
	}
	
	public int getTotalBySex(String[] sex, String genero) {
		int cantidad = 0;
		
		for(int i =0; i < X; i++) {
			String sexo_pokemon = sex[i];
			if(sexo_pokemon.equals(genero)) {
				cantidad +=1;
			}
		}
		return cantidad;
	}
	//if(sexo_pokemon == "Hombre") 
	
	public int getLigther(double[] weigth) {
		int pos = 0;
		double ligher = weigth[0];
		
		for(int i = 0; i < X; i++) {
			if(weigth[i] < ligher) {
				pos = i;
			}
		}
		
		return pos;
	}
	
	public int getHeavier(double[] weigth) {
		int pos = 0;
		double heavier = weigth[0];
		
		for(int i = 0; i < X; i++) {
			if(weigth[i] > heavier) {
				pos = i;
			}
		}
		
		return pos;
	}

}//Principal
