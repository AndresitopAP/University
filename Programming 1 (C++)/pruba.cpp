//espero te ayude
#include <iostream>
#include <stdlib.h>
using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
 
int main(int argc, char** argv) {
 
float n = 0,mayor = 0,menor = 0;
int indice = 0;
bool igual = false;
 
cout<<"Ingrese un numero: ";cin>>n;
mayor = n;
menor = n;
while(indice<2){
cout<<"Ingrese un numero: ";cin>>n;
if((n == mayor) || (n == menor)){
igual = true;
}
if(n > mayor){
mayor = n;
}
if(n < menor){
menor = n;
}
indice++;
}
if(igual == true){
cout<<"Hay numeros iguales\nIngrese numeros distintos";
}
else{
cout<<"El mayor es: "<<mayor<<endl;
cout<<"El menor es: "<<menor;
}
 
system("PAUSE>NULL");
return 0;
}
