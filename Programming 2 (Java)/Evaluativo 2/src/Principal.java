import java.util.Scanner; //include

public class Principal {
	
	public static void main(String arg[]) { //main()
		
		Scanner sc = new Scanner(System.in); 
		
		//Variables para la ejecución
		String name_cos = "", name_eco = "", name_quantity = "" ;
		int X = 0, more_quantity = 0;
		double economico = 0, costoso = 0, IVA = 15;
		String[] name = new String[0];
		String[] description = new String[0];
		double[] price = new double[0];
		int[] quantity = new int[0];
		
		//Variables para configuraciones 
		int SYS = 1, acu_quantity = 0, resta = 0, sumativo = 0;
		double bolivar = 4.18, neto = 0, bruto = 0, acu_bruto = 0, acu_neto = 0, total = 0;
		
		do {
			
			System.out.print("MENU DE OPCIONES" + "\n\n");
			System.out.print("1. Agregar articulos." + "\n");
			System.out.print("2. Ver listado." + "\n");
			System.out.print("3. Ver listado de agotados." + "\n");
			System.out.print("4. Retirar." + "\n");
			System.out.print("5. Modificar." + "\n");
			System.out.print("6. Estadística." + "\n");
			System.out.print("7. Configuraciones." + "\n");
			System.out.print("8. Salir." + "\n\n");
			System.out.print("Opción:");
			
			int opc = sc.nextInt();
			
			System.out.println();
			
			switch (opc) {
			
				case 1:
					//Agregando los Artículos
					System.out.print("Número de Artículos: ");
					X = sc.nextInt();
					
					name = new String[X];
					description = new String[X];
					price = new double[X];
					quantity = new int[X];
					
					for(int i = 0; i < X; i++) {
						
						System.out.print("ARTICULO # " + (i + 1) + "\n\n");
						
						System.out.print("Nombre: ");
						name[i] = sc.next();
						
						System.out.print("Descripcion: ");
						description[i] = sc.next();

						System.out.print("Precio: ");
						price[i] = sc.nextDouble();
					
						boolean quant_validation = false;
						
						while(!quant_validation) {
							System.out.print("Cantidad: ");
							quantity[i] = sc.nextInt();
							
							if (quantity[i] > 0) {
								quant_validation = true;
							}
						}
						
						System.out.println();
						
                        if(i == 0) {
							
							name_cos = name[i];
							costoso = price[i];

							name_eco = name[i];
							economico = price[i];
							
							name_quantity = name[i];
							more_quantity = quantity[i];
							
						}
						
						if (price[i] < economico) {
							name_eco = name[i];
							economico = price[i];
						}
						
						
						if (price[i] > costoso) {
							name_cos = name[i];
							costoso = price[i];
						}
						
						if (quantity[i] > more_quantity) {
							name_quantity = name[i];
							more_quantity = quantity[i];
						}
						
					}
					
					
					
				break;
			
				case 2:
					//Listado de Artículos
					int contador = 0;
					for(int i = 0; i < X; i++) {
						if (quantity[i] != 0) {
							contador = contador + 1;
							System.out.println((contador) + ". " + name[i] + ".");
						}
					}
					
					System.out.println();
					
				break;
				
				case 3:
					int contador_ = 0;
					for(int i = 0; i < X; i++) {
						if (quantity[i] == 0) {
							contador_ = contador_ + 1;
							System.out.println((contador_) + ". " + name[i] + ".");
						}
					}
					
					System.out.println();
					
				break;
				
				case 4:
					//Retirar artículos
					System.out.println("Selecione producto a editar: ");
					
					int accountant = 0;
					for(int i = 0; i < X; i++) {
						System.out.println((accountant + 1) + ". " + name[i] + ".");
						accountant = accountant + 1;
					}
					
					System.out.print("Ingrese el numero de la lista: ");
					int ocp = sc.nextInt();
					
					int position = ocp - 1;
				
					System.out.print("Ingrese cantidad a restar: ");
					
					resta = sc.nextInt();
					
					quantity[position] = quantity[position] - resta;
				
				break;
				
				case 5:
					//Modificar artículo - agregar más cantidad a un artículo
					
                    System.out.println("Selecione producto a editar5: ");
					
                    accountant = 0;
					for(int i = 0; i < X; i++) {
						System.out.println((accountant + 1) + ". " + name[i] + ".");
						accountant = accountant + 1;
					}
					
					System.out.print("Ingrese el numero de la lista: ");
					
					ocp = sc.nextInt();
					
					position = ocp - 1;
					
					System.out.print("Ingrese cantidad a agregar: ");
					sumativo = sc.nextInt();
					
					quantity[position] = quantity[position] + sumativo;
				break;
			
				case 6:
					//Estadística
					acu_quantity = 0;
					//total = 0;
					acu_bruto = 0;
	               for(int i = 0; i < X; i++) {
						acu_quantity = acu_quantity + quantity[i];
						total = price[i] * quantity[i];
						acu_bruto = acu_bruto + total;
					}
                   
                   	acu_neto = acu_bruto * (1 + IVA/100);
                   
                    bruto = acu_bruto * bolivar;
                    neto = acu_neto * bolivar;
                    
                    //Producto con mayor cantidad
                    for (int i = 0; i < X; i++) {
                    	if(i == 0) {
                    		name_quantity = name[i];
							more_quantity = quantity[i];
                    	}
                    	
                    	if(more_quantity < quantity[i]) {
                    		name_quantity = name[i];
                    		more_quantity = quantity[i];
                    	}
                    }
					
                    //Impresión de estadísticas
					System.out.println("Artículo más costoso: " + name_cos + " " + costoso);
					System.out.println("Artículo más económico: " + name_eco + " " + economico);
					System.out.println("Catnidad de artículos:  " + acu_quantity);
					System.out.println("Artículo mayor cantidad: " + name_quantity + " " + more_quantity);
					System.out.println("Total bruto en $: " + acu_bruto);
					System.out.println("Total bruto en Bs.: " + bruto);
					System.out.println("Total neto en $: " + acu_neto);
					System.out.println("Total neto Bs.: " + neto);
				break;
				
				case 7:
					System.out.print(" Valor del Bolivar: ");
					bolivar = sc.nextDouble();
					
					System.out.print(" Modificar IVA (%): ");
					IVA = sc.nextDouble();
				break;
				
				case 8:
					System.out.println("Programa finalizado");
					SYS = 0;
				break;
				
				default:
					System.err.print("Error, seleccione una opción correcta");
				break;
			}
			
		}
		while (SYS == 1);
		
		
	}
}
