import java.util.Scanner; 
import com.urbe.mathlib.MathLib;

public class Principal {
	//variables principales
	public static Scanner sc = new Scanner(System.in); 
	public static Principal pr = new Principal();
	
	//vectores de productos
	public static String[] product = new String[0];
	public static double[] price = new double[0];
	public static int[] quantity = new int[0];
	
	//vectores de la factura
	public static String[] name = new String[0];
	public static String[] id = new String[0];
	public static int X = 0;
	
	//configuracion
	public static double bolivar = 4.42;
	public static double iva = 15;
	
	//Conteo de clientes
	public static int cant_clientes = 0;
	
	//Calculos para las compras
	public static int cant_articulo = 0;
	public static int[] option = new int[0];
	public static int[] cant_comprar = new int[0];
	public static double[] descuento = new double[0];
	public static double[] total_bruto = new double[0];
	public static double[] total_neto = new double[0];
	
	public static void main(String arg[]) { //main()
		MathLib ml = new MathLib();
		
		//variables de ejecucion
		int SYS = 1, opc = 0;
		int SOS = 1, opcion = 0;
		
		boolean cnt_co = false;
		
		while(cnt_co == false) {
			System.out.print("Ingrese cantidad de productos a registrar: ");
			X = sc.nextInt();
			
			System.out.println("");
			
			if(X < 1) {
				System.out.println("Error al ingresar la cantidad");
				
				System.out.println("Intentelo nuevamente");
				
				System.out.println("");
			}
			else {
				cnt_co = true;
			}
		}
		
		pr.Registro(X);
		
		do {
			cant_articulo = 0;
			SOS = 1;
			pr.Menu();
			opc = sc.nextInt();
			
			System.out.println("");
			
			switch(opc) {
				
				case 1:
					//realizar compra	
					pr.Persona(X);
					
					do {
						pr.SubMenu();
						opcion = sc.nextInt();
						
						switch(opcion) {
							
							case 1:
								//ALMACENAMIENTO DE LA INFORMACION
								int cant_temp = cant_articulo;
								
								//DATOS TEMPORALES
								int[] option_temp = new int[cant_articulo];
								int[] cant_comprar_temp = new int[cant_articulo];
								double[] descuento_temp = new double[cant_articulo];
								
								if (cant_temp > 0) {
									for(int i = 0; i < cant_articulo; i++) {
										option_temp[i] = option[i];
										cant_comprar_temp[i] = cant_comprar[i];
										descuento_temp[i] = descuento[i];
									}
								}
								
								cant_articulo = cant_articulo + 1;
								
								option = new int[cant_articulo];
								cant_comprar = new int[cant_articulo];
								descuento = new double[cant_articulo];
								
								for(int i = 0; i < (cant_articulo - 1); i ++) {
									option[i] = option_temp[i];
									cant_comprar[i] = cant_comprar_temp[i];
									descuento[i] = descuento_temp[i];
								}
								
								//Nuevo artículo
								pr.ImprimirLista();
								//PRODUCTO A LLEVAR
								System.out.println("Selecione el producto a llevar: ");
								int opt = sc.nextInt();
								option[cant_articulo - 1] = opt;
								
								//CANTIDAD
								System.out.print("Ingrese cantidad a comprar: ");
								int resta = sc.nextInt();
								cant_comprar[cant_articulo - 1] = resta;
								//quantity[position] = quantity[position] - resta;
								
								//DESCUENTO
								System.out.print("Ingrese descuento en %: ");
								double DESC = sc.nextDouble();
								descuento[cant_articulo - 1] = DESC;
									
							break;
							
							case 2:
								//PROCESAMIENTO DE LA INFORMACION
								System.out.println("NOMBRE\t" + "CANTIDAD\t" + "DESCUENTO\t" + "PU\t" + "TOTAL BRUTO\t"+ "TOTAL NETO");
								for(int i = 0; i < cant_articulo; i++) {
									double t_bruto = ml.totalBruto(price[option[i]-1], descuento[i], cant_comprar[i]);
									double t_neto = ml.totalNeto(price[option[i]-1], iva, descuento[i], cant_comprar[i]);
									System.out.println(product[option[i]-1] + "\t" + cant_comprar[i] + "\t" + descuento[i] + "\t" + 
								price[option[i]-1] + "\t" + "$ "+ t_bruto + "(Bs " + (t_bruto*bolivar) +")" + "\t" + "$" + t_neto +
								"(Bs " + (t_neto*bolivar) + ")" );
								}
								
								//ACTUALIZANDO CANTIDADES
								for(int i = 0; i < cant_articulo; i++) {
									quantity[option[i] - 1] = quantity[option[i] - 1] - cant_comprar[i];
								}
								
								//CALCULO DE TOTALES
								double[] totales = ml.totalesCompra(option, cant_comprar, descuento, price, cant_articulo, iva);
								double totalCompra_bruto = totales[0];
								double totalCompra_neto = totales[1];
								
								double[] total_bruto_temp = new double[cant_clientes-1];
								double[] total_neto_temp = new double[cant_clientes-1];
								
								if(cant_clientes > 1) {
									for(int i = 0; i < cant_clientes - 1; i++) {
										total_bruto_temp[i] = total_bruto[i];
										total_neto_temp[i] = total_neto[i];
									}
								}
								
								total_bruto = new double[cant_clientes];
								total_neto = new double[cant_clientes];
								
								for(int i = 0; i < cant_clientes - 1; i++) {
									total_bruto[i] = total_bruto_temp[i];
									total_neto[i] = total_neto_temp[i];
								}
								
								total_bruto[cant_clientes-1] = totalCompra_bruto;
								total_neto[cant_clientes-1] = totalCompra_neto;
								
								double totalCompra_bruto_bs = ml.dollarToBs(totalCompra_bruto, bolivar);
								double totalCompra_neto_bs = ml.dollarToBs(totalCompra_neto, bolivar);
								
								System.out.println("Sub total: " + "$ " + totalCompra_bruto + "(Bs " + totalCompra_bruto_bs + ")");
								System.out.println("Total: " + "$ " +totalCompra_neto + "(Bs " + totalCompra_neto_bs + ")");
								
								SOS = 0;
							break;
							
							default:
								System.err.println("ERROR, seleccione una opcion correcta ");
							break;
						}
					}
					while(SOS == 1);
				break;
				
				case 2:
					//lista de articulos
					pr.ImprimirLista();
				break;
				
				case 3:
					//modificar
					pr.ImprimirLista();
					
					System.out.print("Selecione producto a editar: ");
					int ocp = sc.nextInt();
					
					int posicion = ocp - 1;
					
					System.out.print("Ingrese nombre del producto: ");
					product[posicion] = sc.next();
					System.out.print("Ingrese el precio del producto: ");
					price[posicion] = sc.nextDouble();
					System.out.print("Ingrese la cantidad de productos: ");
					quantity[posicion] = sc.nextInt();
				break;
				
				case 4:
					//lsitado en 0
					pr.Lista0();
				break;
					
				case 5:
					//total de ventas
					double[] suma_totales = ml.suma_totales(total_bruto, total_neto, cant_clientes);
					double suma_total_bruto = suma_totales[0];
					double suma_total_neto = suma_totales[1];
					double suma_total_bruto_bs = ml.dollarToBs(suma_total_bruto, bolivar);
					double suma_total_neto_bs = ml.dollarToBs(suma_total_neto, bolivar);
					
					System.out.println("Total de ventas: " + cant_clientes);
					System.out.println("Total bruto: " + "$" + suma_total_bruto + "(Bs " + suma_total_bruto_bs + ")");
					System.out.println("Total neto: " + "$" + suma_total_neto + "(Bs " + suma_total_neto_bs + ")");
				break;
				
				case 6:
					//configuraciones
					System.out.print(" Valor del Bolivar: ");
					bolivar = sc.nextDouble();
					
					System.out.print(" Modificar IVA (%): ");
					iva = sc.nextDouble();
					
					System.out.println("");
				break;
					
				case 7:
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
		System.out.println("1. Realizar compra ");
		System.out.println("2. Lista ");
		System.out.println("3. Modificar ");
		System.out.println("4. lista en 0 ");
		System.out.println("5. Total en ventas ");
		System.out.println("6. Configuracion ");
		System.out.println("7. Cerrar Programa ");
		System.out.print("Ingrese opc: ");
	}
	
	public void Registro(int X) {
		product = new String[X];
		price = new double[X];
		quantity = new int[X];
		
		
		for(int i = 0; i < X; i ++) {
			System.out.print("Ingrese nombre del producto: ");
			product[i] = sc.next();
			System.out.print("Ingrese el precio del producto: ");
			price[i] = sc.nextDouble();
			System.out.print("Ingrese la cantidad de productos: ");
			quantity[i] = sc.nextInt();
		}
	}
	
	public void ImprimirLista() {
		int accountant = 0;
		for(int i = 0; i < X; i++) {
			System.out.println((accountant + 1) + ". " + product[i] + ".");
			accountant = accountant + 1;
		}
		
		System.out.println();
	}
	
	public void SubMenu() {
		System.out.println("1. Comprar ");
		System.out.println("2. Finalizar compra ");
		System.out.print("Ingrese opc: ");
	}
	
	public void Lista0() {
		int contador = 0;
		for(int i = 0; i < X; i++) {
			if (quantity[i] == 0) {
				contador = contador + 1;
				System.out.println((contador) + ". " + product[i] + ".");
			}
		}
		
		System.out.println();
	}
	
	public void Persona(int X) {
		String[] name_temp = new String[cant_clientes];
		String[] id_temp = new String[cant_clientes];
		
		if (cant_clientes > 0) {
			for(int i = 0; i < cant_clientes; i++) {
				name_temp[i] = name[i];
				id_temp[i] = id[i];
			}
		}
		
		cant_clientes = cant_clientes + 1;
		
		name = new String[cant_clientes];
		id = new String[cant_clientes];
		
		for(int i = 0; i < (cant_clientes - 1); i ++) {
			name[i] = name_temp[i];
			id[i] = id_temp[i];
		}
		//Nuevo cliente
		System.out.print("Ingrese nombre de la persona: ");
		name[cant_clientes - 1] = sc.next();
		System.out.print("Ingrese la ID de la persona: ");
		id[cant_clientes - 1] = sc.next();
	}

}//final de la clase
