#include <iostream>
#include <math.h>

using namespace std;

main() {
	
	string nom, ape;
	  
	int dia_n, mes_n, a_n, dia, mes, a, e;
	
	int est = 0;
	
	int cnt = 0;
	
	double nt, prnt, prnta, cant = 0;
	
	cout << "Ingrese la cant. deseada de estudiantes a evaluar: " << endl;
	cin >> est;
	
	cout << endl;
	
	for (int i = 0; i < est; i++) {
		
		cout << "Ingrese el Nombre de estudiante: " << endl;
		cin >> nom;
		
		cout << "Ingrese el Apellido del estudiante: " << endl;
		cin >> ape; 
		
		cout << endl;
		
		cout << "Ingrese dia de nacimiento del estudiante: " << endl;
		cin >> dia_n;
		
		cout << "Ingrese mes de nacimiento del estudiante: " << endl;
		cin >> mes_n;
		
		cout << "Ingrese año de nacimiento del estuante: " << endl;
		cin >> a_n ;
		
		cout << endl;
		
		cout << "Ingrese cant. de notas a evaluar del estudiante" << endl;
		cin >> cnt;
		
		for (int i = 0; i < cnt; i++) {
			
		    cout << "Ingrese la nota del estudiante: " << endl;
		    cin >> nt;
		    cant = cant + nt;
		}

			prnt = cant / cnt;
		    prnta = (prnt/20)*100;
		cout << endl;		
		cout << "Ingrese el dia de la entrega de notas" << endl;
		cin >> dia; 
		cout << "Ingrese mes de la entrega de notas" << endl;
		cin >> mes;
		cout << "Ingrese año de la entrega de notas" << endl;
		cin >> a;
		
		cout << endl;
		
		if (dia_n < dia && mes_n < mes){
			e = a - a_n - 1 ;
		}
		else {
			e = a - a_n;
		}
	  
	   cout << "El/La estuantiante" << endl << nom <<endl << ape << endl;
	   cout << "Con una edad de: " << e << endl;
	   cout << "Con promedio Venezolano de: " << prnt << endl;
	   cout << "y con un promedio Americano de: " << prnta << endl << endl;
	}


}
