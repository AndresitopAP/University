#include <iostream>
#include <stdlib.h>
#include <string.h>

using namespace std;

char frase[60], rep[100], temporal[100];
char pal;
int longitud = 0, i = 0, j = 0, inicial = 0, acertado = 0, temp = 0, oportunidades = 4;
int repetido = 0, gano = 0;

void Ingresarpalabra1();
void ProcesosDelJuego1();
void Ingresarpalabra2();
void ProcesosDelJuego2();

main(){
	
	Ingresarpalabra1();
	ProcesosDelJuego1();
	
	Ingresarpalabra2();
	ProcesosDelJuego2();
	
}

void Ingresarpalabra1(){
	printf("  **  JUEGO DEL AHORCADO  **\n\n");
    printf("  Introduzca la palabra a adivinar: ");
    
}

void Ingresarpalabra2(){
	printf("  **  JUEGO DEL AHORCADO  **\n\n");
    printf("  Introduzca la palabra a adivinar: ");
    
}

void ProcesosDelJuego1(){
	gets(frase);
    system("cls");
    longitud = 0;
    inicial = 0;
    j = 0;
    rep[0] = ' ';
    rep[1] = '\0';
    
	 do
    {
        system("cls");
        temp=0;
        if(inicial == 0){
            for(i=0;i<strlen(frase);i++){
                if(frase[i] == ' '){
                    temporal[i] = ' ';
                    longitud++;
                }
                else{
                    temporal[i] = '_';
                    longitud++;
                }
            }
        }
        inicial = 1;
        temporal[longitud] = '\0';
        for(i=0;i<strlen(rep);i++){
            if(rep[i] == pal){
                repetido = 1;
                break;
            }
            else{
               repetido = 0;
           }
        }
        if(repetido == 0){
            for(i=0;i<strlen(frase);i++){
                if(frase[i] == pal){
                    temporal[i] = pal;
                    acertado++;
                    temp=1;
                }
            }
        }
        if(repetido == 0){
            if(temp == 0){
                oportunidades = oportunidades - 1;
            }
        }
        else{
        	system("PAUSE");
            printf("  Ya se ha introducido este caracter");
            printf("\n\n");
            system("PAUSE");
        }
        printf("\n");
        for(i=0;i<strlen(temporal);i++){
            printf(" %c ",temporal[i]);
        }
        printf("\n");
        if(strcmp(frase,temporal) == 0){
            gano = 1;
            break;
        }
        printf("\n  Letras Acertadas: %d",acertado);
        printf("\n  Oportunidades Restantes: %d",oportunidades);
        printf("\n");
        rep[j] = pal;
        j++;
        if (oportunidades==0){
           break;
        }
        printf("  Introduzca una letra:");
        scanf("\n%c",&pal);
    }
    while(oportunidades != 0);
    
    if(gano){
        printf("\n\n  Has ganado.");
        cout << "Palabra utilizada: " << frase;
    }
    else{
        printf("\n\n  Has perdido.");
        cout << "Palabra utilizada: " << frase;
    }
    printf("\n\n");
    system("PAUSE");
    return;
}

void ProcesosDelJuego2(){
	gets(frase);
    system("cls");
    longitud = 0;
    inicial = 0;
    j = 0;
    rep[0] = ' ';
    rep[1] = '\0';
    
	 do
    {
        system("cls");
        temp=0;
        if(inicial == 0){
            for(i=0;i<strlen(frase);i++){
                if(frase[i] == ' '){
                    temporal[i] = ' ';
                    longitud++;
                }
                else{
                    temporal[i] = '_';
                    longitud++;
                }
            }
        }
        inicial = 1;
        temporal[longitud] = '\0';
        for(i=0;i<strlen(rep);i++){
            if(rep[i] == pal){
                repetido = 1;
                break;
            }
            else{
               repetido = 0;
           }
        }
        if(repetido == 0){
            for(i=0;i<strlen(frase);i++){
                if(frase[i] == pal){
                    temporal[i] = pal;
                    acertado++;
                    temp=1;
                }
            }
        }
        if(repetido == 0){
            if(temp == 0){
                oportunidades = oportunidades - 1;
            }
        }
        else{
        	system("PAUSE");
            printf("  Ya se ha introducido este caracter");
            printf("\n\n");
            system("PAUSE");
        }
        printf("\n");
        for(i=0;i<strlen(temporal);i++){
            printf(" %c ",temporal[i]);
        }
        printf("\n");
        if(strcmp(frase,temporal) == 0){
            gano = 1;
            break;
        }
        printf("\n  Letras Acertadas: %d",acertado);
        printf("\n  Oportunidades Restantes: %d",oportunidades);
        printf("\n");
        rep[j] = pal;
        j++;
        if (oportunidades==0){
           break;
        }
        printf("  Introduzca una letra:");
        scanf("\n%c",&pal);
    }
    while(oportunidades != 0);
    
    if(gano){
        printf("\n\n  Enhorabuena, has ganado.");
        cout << "Palabra utilizada: " << frase;
    }
    else{
        printf("\n\n  Has perdido.");
        cout << "Palabra utilizada: " << frase;
    }
    printf("\n\n");
    system("PAUSE");
    return;
}
