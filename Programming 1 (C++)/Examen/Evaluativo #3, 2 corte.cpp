#include <iostream>
//Andres Espitia C.I. 28.428.690.

using namespace std;

int pokemons = 0;
int opc = 0;
int SYS = 1;
string *name, *sexo, *tipo, *activo;  

void impresionMenu();
void cantidadPokemones();
int validarSexo(int opc, int posicion);
void imprimirSexoMenu();
void imprimirTipoMenu();
int validartipo(int ocp, int posicion);
void imprimirActivoMenu();
int validarActivo(int opushon, int posicion);
void imprimirLista();

main(){

	do{
		impresionMenu();
		switch(opc) {
			case 1: 
				cantidadPokemones();
				system("pause");			
			break;
	
			case 2: {
				system("cls");
				cout << "Seleccione el pokemon a editar" << endl << endl;
				imprimirLista();
				cout << "Ingrese el numero del pokemon a editar " << endl;
				int opc = 0;
				cin >> opc;
				
				int pokemon = opc - 1;
				
				system("cls");
				
				cout << "Nombre: ";
				cin >> name[pokemon];
				
				int controlValidar = 0;
				int opcion = 0;
				do {
					imprimirSexoMenu();
					cin >> opcion;	
					controlValidar = validarSexo(opcion, pokemon);
				}
				while(controlValidar == 0);
			
				int Validarcontrol = 0;
				int ocp;
				do {
					imprimirTipoMenu();
					cin >> ocp;
					Validarcontrol = validartipo(ocp, pokemon);
				}
				while(Validarcontrol == 0);
				
				int validarcontrol = 0;
				int opushon = 0;
				do{
					imprimirActivoMenu();
					cin >> opushon;
					validarcontrol = validarActivo(opushon, pokemon);
				}
				while(validarcontrol == 0);	
				
				break;
			}
			
			case 3: 
				system("cls");
				cout << "Lista de Pokemones activos" << endl << endl;
				
				for (int i = 0; i < pokemons; i++){
					if(activo[i] == "Activo") {
						cout << (i+1) << ". \t"; 
						cout << name[i] << "\t"; 
						cout << sexo[i] << "\t"; 
						cout << tipo[i] << "\t";  
						cout << activo[i] << "\n"; 
					}
				}
				system("pause");
			break;
			
			case 4: 
				system("cls");
				imprimirLista();
				system("pause");
			break;
			
			case 5:
				SYS = 0;
			break;
			
			default: 
				cout << "OPCION INVALIDA :( " << endl;
			break;
		}
	
	}
	while(SYS == 1); 
	
}

void cantidadPokemones(){
	system("cls");
	cout << "Ingrese cantidad de pokemones atrapados: ";
	cin >> pokemons;
	
	name = new string[pokemons];
	sexo = new string[pokemons];
	tipo = new string[pokemons];
	activo = new string[pokemons];
	
	for(int i = 0; i < pokemons; i++) {
		system("cls");
		cout << "Datos del pokemon " << (i+1) << endl << endl;
		
		cout << "Nombre: ";
		cin >> name[i];
		
		int controlValidar = 0;
		int opcion = 0;
		do {
			imprimirSexoMenu();
			cin >> opcion;	
			controlValidar = validarSexo(opcion, i);
		}
		while(controlValidar == 0);

		int Validarcontrol = 0;
		int ocp;
		do {
			imprimirTipoMenu();
			cin >> ocp;
			Validarcontrol = validartipo(ocp, i);
		}
		while(Validarcontrol == 0);
		
		int validarcontrol = 0;
		int opushon = 0;
		do{
			imprimirActivoMenu();
			cin >> opushon;
			validarcontrol = validarActivo(opushon, i);
		}
		while(validarcontrol == 0);			
	}
	
	system("cls");
}

void imprimirLista() {
	cout << "Lista de Pokemon" << endl << endl;
	for (int i = 0; i < pokemons; i++) {
		cout << (i+1) << ". \t"; 
		cout << name[i] << "\t"; 
		cout << sexo[i] << "\t"; 
		cout << tipo[i] << "\t";  
		cout << activo[i] << "\t\n"; 
	}
}

void impresionMenu() {
	system("cls");
	cout << "1.Agregar pokemon" << endl;
	cout << "2.Editar pokemon" << endl;
	cout << "3.Listado de pokemon activo" << endl;
	cout << "4.Listado de todos los pokemon" << endl;
	cout << "5.Salir" << endl;
	cout << "Ingrese opcion: ";
	cin >> opc;
}

void imprimirSexoMenu() {
	system("cls");
	cout << "Sexo" << endl;
	cout << "1. Hombre" << endl;
	cout << "2. Mujer" << endl;
	cout << "3. No tiene" << endl;
	cout << "Opcion: " << endl;
}

void imprimirActivoMenu(){
	system("cls");
	cout << "Desea que este pokemon este en su equipo? " << endl;
	cout << "1. Si" << endl;
	cout << "2. No" << endl;
	cout << "Opcion: " << endl;
}

void imprimirTipoMenu() {
	system("cls");
	cout << "Tipos" << endl;
	cout << "1.Acero" << endl;
	cout << "2.Agua" << endl;
	cout << "3.Bicho." << endl;
	cout << "4.Dragon." << endl;
	cout << "5.Electrico." << endl;
	cout << "6.Fantasma." << endl;
	cout << "7.Fuego." << endl;
	cout << "8.Hada." << endl;
	cout << "9.Hielo." << endl;
	cout << "10.Lucha." << endl;
	cout << "11.Normal." << endl;
	cout << "12.Planta." << endl;
	cout << "13.Psiquico." << endl;
	cout << "14.Roca." << endl;
	cout << "15.Tierra." << endl;
	cout << "16.Veneno." << endl;
	cout << "17.Volador." << endl;
	cout << "Opcion: " << endl;

}

int validarSexo(int opc, int posicion) {
	switch(opc) {
		case 1:
			sexo[posicion] = "Hombre";
			return 1;
		break;
		
		case 2:
			sexo[posicion] = "Mujer";
			return 1;
		break;
		
		case 3:
			sexo[posicion] = "No tiene";
			return 1;
		break;
		
		default:
			cout << "Opcion incorrecta" << endl;
			system("pause");
			return 0;
		break;
	}
}

int validarActivo(int opushon, int posicion) {
	switch(opushon) {
		case 1: {
			int num_activos = 0;
			
			for(int i = 0; i < pokemons; i++) {
				if (activo[i] == "Activo") {
					num_activos += 1;
				}
			}
			
			if(num_activos < 6) {
				activo[posicion] = "Activo";
			}
			else {
				activo[posicion] = "No Activo";
				cout << "Capacidad maxima de pokemones alcanzado, el pokemon esta no activo" << endl << endl;
			}
			
			return 1;
			break;
		}
		
		case 2:
			activo[posicion] = "No Activo";
			return 1;
		break;
		
		default:
			cout << "Opcion incorrecta" << endl;
			system("pause");
			return 0;
		break;
	}
}

int validartipo(int ocp, int posicion) {
	switch(ocp) {
		case 1:
			tipo[posicion] = "Acero";
			return 1;
		break;
		
		case 2:
			tipo[posicion] = "Agua";
			return 1;
		break;
		
		case 3:
			tipo[posicion] = "Bicho";
			return 1;
		break;
		
		case 4:
			tipo[posicion] = "Dragon";
			return 1;
		break;
		
		case 5:
			tipo[posicion] = "Electico";
			return 1;
		break;
		
		case 6:
			tipo[posicion] = "Fantasma";
			return 1;
		break;
		
		case 7:
			tipo[posicion] = "Fuego";
			return 1;
		break;
		
		case 8:
			tipo[posicion] = "Hada";
			return 1;
		break;
		
		case 9:
			tipo[posicion] = "Hielo";
			return 1;
		break;
		
		case 10:
			tipo[posicion] = "Lucha";
			return 1;
		break;
		
		case 11:
			tipo[posicion] = "Normal";
			return 1;
		break;
		
		case 12:
			tipo[posicion] = "Planta";
			return 1;
		break;
		
		case 13:
			tipo[posicion] = "Psiquico";
			return 1;
		break;
		
		case 14:
			tipo[posicion] = "Roca";
			return 1;
		break;
		
		case 15:
			tipo[posicion] = "Tierra";
			return 1;
		break;
		
		case 16:
			tipo[posicion] = "Veneno";
			return 1;
		break;
		
		case 17:
			tipo[posicion] = "Volador";
			return 1;
		break;

		default:
			cout << "Opcion incorrecta" << endl;
			system("pause");
			return 0;
		break;
	}
}
