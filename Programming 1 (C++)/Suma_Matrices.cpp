#include<iostream>

using namespace std;

main() {
	//Variables
	int filas, columnas;

	//Asignación de valores para filas y columnas
	cout << "SUMA DE MATRICES" << endl << endl;
	
	cout << "Filas: ";
	cin >> filas;
	
	cout << "Columnas: ";
	cin >> columnas;
	
	//Variables para las matrices a sumar
	double matriz_A[filas][columnas];
	double matriz_B[filas][columnas];
	double suma[filas][columnas];
	
	//Ingresar datos de la matriz A
	cout << endl << "DATOS MATRIZ A" << endl << endl;
	for(int i=0; i<filas; i++) {
		for(int j=0; j<columnas; j++) {
			cout << "A[" << (i+1) << "][" << (j+1) << "]= ";
			cin >> matriz_A[i][j];
		}
		cout << endl;
	}
	
	//Ingresar datos de la matriz B
	cout << endl << "DATOS MATRIZ B" << endl << endl;
	for(int i=0; i<filas; i++) {
		for(int j=0; j<columnas; j++) {
			cout << "B[" << (i+1) << "][" << (j+1) << "]= ";
			cin >> matriz_B[i][j];
		}
		cout << endl;
	}
	
	//Cálculo de la suma 
	for(int i=0; i<filas; i++) {
		for(int j=0; j<columnas; j++) {
			suma[i][j] = matriz_A[i][j] + matriz_B[i][j];
		}
	}
	
	//Imprimir el resultado
	cout << endl << "Matriz A" << endl << endl;
	for(int i=0; i<filas; i++) {
		for(int j=0; j<columnas; j++) {
			cout << matriz_A[i][j] << "\t";
		}
		cout << endl;
	}
	
	cout << endl << "Matriz B" << endl << endl;
	for(int i=0; i<filas; i++) {
		for(int j=0; j<columnas; j++) {
			cout << matriz_B[i][j] << "\t";
		}
		cout << endl;
	}
	
	cout << endl << "Suma: A+B" << endl << endl;
	for(int i=0; i<filas; i++) {
		for(int j=0; j<columnas; j++) {
			cout << suma[i][j] << "\t";
		}
		cout << endl;
	}	
}

/*
	Comentarios de la explicación
	ITERACION # 1 --> i=0; j=0 
	ITERACION # 2 --> i=0; j=1 
	ITERACION # 3 --> i=0; j=2 
	ITERACION # 4 --> i=1; j=0
	ITERACION # 5--> i=1; j=1  
	ITERACION # 6--> i=1; j=2 
	ITERACION # 7 --> i=2; j=0
	ITERACION # 8--> i=2; j=1  
	ITERACION # 9--> i=2; j=2 
*/
