#include <iostream>
#include <math.h>

using namespace std;

main(){
     double r, a, rr, exponente;
	 
	 cout << "Ingrese el valor del radio: " ;	
 	 cin >> r;
 	 
 	 exponente = 2;
 	 rr = pow (r, exponente);
	 a = M_PI * rr;
	 
	 cout << "El Area de este circulo es = " << a;
	
	
}



