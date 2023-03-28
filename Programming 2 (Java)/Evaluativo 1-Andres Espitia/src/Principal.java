import java.util.Scanner; //include

public class Principal {
	public static void main(String arg[]) { //main()
		Scanner sc = new Scanner(System.in); 
		
		int Students = 0, id = 0, day_b = 0, month_b, year_b, year = 2021, month = 10, day = 8, age = 0;
		double notes = 0, note = 0, prom = 0, acu = 0;
		double prom_s = 0, acu_s = 0;
		String name="", lastname="", sex="";
		int edad_joven = 0, edad_viejo = 0; 
		double nota_alta = 0, nota_baja = 0;
		String notaAlta_name ="", notaAlta_lastName="";
		String notaBaja_name ="", notaBaja_lastName="";
		String name_young ="", name_old="", lastName_young="", lastName_old="";
		
		System.out.print("Cantidad estudiantes: ");
		 Students = sc.nextInt();
		 System.out.println();
	
		for(int i = 0; i < Students; i++) {
			
			System.out.print("Nombre: ");
			name = sc.next();
			
			System.out.println();
			
			System.out.print("Apellido: ");
			lastname = sc.next();
			
			System.out.println();
			
			System.out.print("Identificación: ");
			id = sc.nextInt();
			
			System.out.println();
			
			System.out.print("Género ('M' para el masculino y 'F'para femenino) ");
			sex = sc.next();
			
			System.out.println();
			
			System.out.print("Ingrese dia de nacimiento del estudiante: ");
			day_b = sc.nextInt();
			
			System.out.println();
			
			System.out.print("Ingrese mes de nacimiento del estudiante: ");
			month_b = sc.nextInt();
			
			System.out.println();
			
			System.out.print("Ingrese ano de nacimiento del estudiante: ");
			year_b = sc.nextInt();
			
			System.out.println();
			
			System.out.print("Ingrese candidad de notas a evaluar del estudiante: ");
			notes = sc.nextInt();
			
			System.out.println();
			acu = 0;
			for(int j = 0; j < notes; j++) {
				
				System.out.print("Ingrese la nota " + (j+1) + " del estudiante: ");
				note = sc.nextDouble();
				
				acu = acu + note;
				
			}
			
			prom = acu / notes;
			
			if(day_b >= day && month_b >= month) {
				age = year - year_b - 1;
			}
			else{
				age = year - year_b;
			}
			
			if(i == 0) {
				name_young = name;
				lastName_young = lastname;
				edad_joven = age;
				
				name_old = name;
				lastName_old = lastname;
				edad_viejo = age;
				
				notaAlta_name = name;
				notaAlta_lastName = lastname;
				nota_alta = prom;

				notaBaja_name = name;
				notaBaja_lastName = lastname;
				nota_baja = prom;
				
			}
			
			
			if (age < edad_joven) {
				name_young = name;
				lastName_young = lastname;
				edad_joven = age;
			}
			
			
			if (age > edad_viejo) {
				name_old = name;
				lastName_old = lastname;
				edad_viejo = age;
			}
			
		
			if (prom < nota_baja) {
				notaBaja_name = name;
				notaBaja_lastName = lastname;
				nota_baja = prom;
			}
			
			
			if (prom > nota_alta) {
				notaAlta_name = name;
				notaAlta_lastName = lastname;
				nota_alta = prom;
			}
			
			
			acu_s = acu_s + prom;
			
		}	
		prom_s = acu_s / Students;
	
		System.out.print("Estudiante mas joven: " + name_young + " " + lastName_young + " Edad==> " + edad_joven + "\n");
		
		System.out.print("Estudiante mas viejo: " + name_old + " " + lastName_old + " Edad==> " + edad_viejo + "\n");
		
		System.out.print("Promedio del salon: " + prom_s + "/n");
		
		System.out.print("Nota mas baja: " + notaBaja_name + " " + notaBaja_lastName + " Nota==> " + nota_baja + "\n");
		
		System.out.print("Nota mas alta: " + notaAlta_name + " " + notaAlta_lastName + " Nota==> " + nota_alta + "\n");
		
	}	
}
