#include <iostream>
#include <math.h>

using namespace std;

main(){
     double r, a, rr, exponente;
	 
	 cout << "Ingrese el valor del radio: " ;	
 	 cin >> r;
 	 
 	 exponente = 2;
 	 rr = pow (r, exponente);
	 a = 4 * M_PI * rr;
	 
	 cout << "El Area de esta esfera es = " << a;
	
	
}



