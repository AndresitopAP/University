#include <iostream>
#include <math.h>
//Andres Espitia C.I. 28.428.690
using namespace std;
	
main() {
		
	double nt1, nt2, nt3, prom, pon1, pon2, pon3;
	
	cout << "Ingrese el valor de la nota #1: " << endl;
	cin >> nt1;
	cout << "Ingrese el valor de la nota #2: " << endl;
	cin >> nt2;
	cout << "Ingrese el valor de la nota #3: " << endl;
	cin >> nt3;
	
	pon1 =	nt1 * 0.3;
	pon2 = nt2 * 0.3;
	pon3 = nt3 * 0.4;	
		
	prom = pon1 + pon2 + pon3;
		
	if (prom >= 9.5 && prom <= 20)	{
		cout << "El alumno esta aprobado con: " << prom << endl;
	}	
	else if (prom < 9.5 && prom >= 0) {
		cout << "El alumno esta reprobado con: " << prom << endl;
	}	
	else {
		cout << "Error a promediar la nota del alumno " << endl;
	}	
		
	if (nt1 >= nt2 && nt1 >= nt3) {
	    cout << "La nota mayor del alumno fue: " << nt1 << endl;
	}	
	else if (nt2 >= nt1 && nt2 >= nt3) {
		cout << "La nota mayor del alumno fue: " << nt2 << endl;
	}	
	else if (nt3 >= nt1 && nt3 >= nt2){
		cout << "La nota mayor del alumno fue: " << nt3 << endl;
	}	
	
    if (nt1 <= nt2 && nt1 <= nt3) {
	    cout << "La nota menor del alumno fue: " << nt1 << endl;
	}	
	else if (nt2 <= nt1 && nt2 <= nt3) {
		cout << "La nota menor del alumno fue: " << nt2 << endl;
	}	
	else if (nt3 <= nt1 && nt3 <= nt2){
		cout << "La nota menor del alumno fue: " << nt3 << endl;
	}	


	}
