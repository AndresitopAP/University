#include <iostream>

using namespace std;

int dimension = 4;
int M = 2, H = 1;
string aux;
int opc, SYS = 1;

main () {
	string matriz[dimension][dimension];
	
	for (int i = 0; i < dimension; i++) {
		cout << "Datos de la persona " << (i+1) << endl << endl;
		
		cout << "Nombre: ";
		cin >> matriz[i][0];
		
		cout << "Altura: ";
		cin >> matriz[i][1];
		
		cout << "Edad: ";
		cin >> matriz[i][2];
		
		cout << "Ingresar de preferencia M (para las Mujeres) y H (para los Hombres) " << endl;
		
		cout << "Sexo: ";
		cin >> matriz[i][3];
		system("cls");
	}
		
	do{
		cout << "1. Altura (del mas alto al mas bajo)" << endl;
		cout << "2. Edad (de mayor a menor)" << endl;
		cout << "3. Edad (de menor a mayor)" << endl;
		cout << "4. Sexo (Mujeres delante Hombres detras)" << endl;
		cout << "5. Sexo (Hombres delante Mujeres detras)" << endl;
		cout << "6. Salir" << endl;
		cout << "Ingrese opcion: ";
		cin >> opc;
	
		switch(opc) {
			case 1: 
			
			   for(int z = 1; z < dimension; ++z) {
			      for(int v = 0; v < (dimension - z); v++) {
			         if(matriz[v][1] < matriz[v+1][1]){
			            aux = matriz[v][1];
			            matriz[v][1] = matriz[v+1][1];
			            matriz[v+1][1] = aux;
			         }
			      }
			    }
			    
			    for(int w = 0; w < dimension; w++) {
				    cout << matriz[w][1] << endl;
				}
							
			break;
	
			case 2: 
			
				for(int z = 1; z < dimension; ++z) {
				      for(int v = 0; v < (dimension - z); v++) {
				         if(matriz[v][2] < matriz[v+1][2]){
				            aux = matriz[v][2];
				            matriz[v][2] = matriz[v+1][2];
				            matriz[v+1][2] = aux;
				         }
				      }
			    }
				
				for(int w = 0; w < dimension; w++) {
				    cout << matriz[w][2] << endl;
				}
				
			break;
			
			case 3: 
			
				for(int z = 1; z < dimension; ++z) {
				      for(int v = 0; v < (dimension - z); v++) {
				         if(matriz[v][2] > matriz[v+1][2]){
				            aux = matriz[v][2];
				            matriz[v][2] = matriz[v+1][2];
				            matriz[v+1][2] = aux;
				         }
				      }
			    }
			    
			    for(int w = 0; w < dimension; w++) {
				    cout << matriz[w][2] << endl;
				}
				
			break;
			
			case 4: 
			
				for(int z = 1; z < dimension; ++z) {
				      for(int v = 0; v < (dimension - z); v++) {
				         if(matriz[v][3] == "H" && matriz[v+1][3] == "M"){
				            aux = matriz[v][3];
				            matriz[v][3] = matriz[v+1][3];
				            matriz[v+1][3] = aux;
				         }
				      }
				}
				
				for(int w = 0; w < dimension; w++) {
				    cout << matriz[w][3] << endl;
				}
				
			break;
			
			case 5:
				
				for(int z = 1; z < dimension; ++z) {
			      for(int v = 0; v < (dimension - z); v++) {
			         if (matriz[v][3] =="M" && matriz[v+1][3]=="H"){
			            aux = matriz[v][3];
			            matriz[v][3] = matriz[v+1][3];
			            matriz[v+1][3] = aux;
			         }
			      }
			    }
				
				for(int w = 0; w < dimension; w++) {
				    cout <<  matriz[w][3] << endl;
				}
				
			break;
			
			case 6:
				SYS = 0;
			break;
			
			default: 
				cout << "OPCION INVALIDA :( " << endl;
			break;
		}
		
		system("pause");
		system("cls");
	}
	while(SYS == 1); //condicion
	
}


