#include <iostream>
#include <math.h>

//Andres Espitia C.I. 28.428.690

using namespace std;


main(){ 
    //Variables globales
    string *name, *last_name, *se, *id, F;
    
    int day = 18, month = 7, year = 2021, *day_brt, *month_brt, *year_brt, *age, SYS = 1, SOS = 1;
    
    int student = 0, *note, cnt_note = 0;
    
    double notes = 0, prom_note = 0, aux_notes;
    
    int cnt_apr = 0, cnt_repro = 0, total_f = 0, total_m = 0;
    
    int opc = 0;
    
    bool year_co = false;
    

	do {
		cout << "1. Agregar estudiantes" << endl;
		cout << "2. Lista de estudiantes" << endl;
		cout << "3. Modificar estudiantes" << endl;
		cout << "4. Estadisticas" << endl; 
	    cout << "5. Configuracion" << endl;
	    cout << "6. Salir del programa" << endl;
	    cout << endl;
	    cout << "Ingrese una opcion" << endl;
	    cin >> opc;
	    cout << endl;
		
			switch(opc) {
				case 1: {
					system("cls");
					
					cout << "Ingrese la cantidad de estudiantes a registar: " << endl;
					cin >> student;
					
					name = new string[student];
					
					for(int i = 0; i < student; i++) {
						system("cls");
						cout << "Del Estudiante # " << (i+1) << "." << endl << endl;
						cout << "Ingresar el Nombre: ";
						cin >> name[i];
					}
					
					last_name = new string[student];
					
					for(int i = 0; i < student; i++) {
						system("cls");
						cout << "Del Estudiante # " << (i+1) << "." << endl << endl;
						cout << "Ingresar el Apellido: ";
						cin >> last_name[i];
					}
					
					id = new string[student];
					
					for(int i = 0; i < student; i++) {
						system("cls");
						cout << "Del Estudiante # " << (i+1) << "." << endl << endl;
						cout << "Ingresar la Cedula de Identidad: ";
						cin >> id[i];
					}
					
					se = new string[student];
					
					for(int i = 0; i < student; i++) {
						system("cls");
						cout << "Del Estudiante # " << (i+1) << "." << endl << endl;
						cout << "Utilizar (F) para femenino y (M) para masculino " << endl;
						cout << "Ingresar Sexo: ";
						cin >> se[i];
						
						if (se[i] == F){
							total_f = total_f + 1;
						}
						else {
							total_m = total_m + 1;
						}
							
					}
					
					day_brt = new int[student];
					
					for(int i = 0; i < student; i++) {
						system("cls");
						cout << "Estudiante # " << (i+1) << "." << endl << endl;
						cout << "Ingresar dia de nacimiento: ";
						cin >> day_brt[i];
					}
					
					month_brt = new int[student];
					
					for(int i = 0; i < student; i++) {
						system("cls");
						cout << "Estudiante # " << (i+1) << "." << endl << endl;
						cout << "Ingresar mes de nacimiento: ";
						cin >> month_brt[i];
					}
					
					year_brt = new int[student];
					
					
					for(int i = 0; i < student; i++) {
						system("cls");
						cout << "Estudiante # " << (i+1) << "." << endl << endl;
						
						bool year_brt_co = false;
						
						while(year_brt_co == false){
							cout << "Ingresar año de nacimiento: ";
						    cin >> year_brt[i];
								    
							if (year_brt[i] < 1900){
								cout << "El año que usted a ingresado es invalido " << endl << endl; 	
							}
							else {
								year_brt_co = true;			
							}		
					    } 
					    
					}
					
					age = new int[student];
					
					for(int i = 0; i < student; i++) {
						if (day_brt[1] >= day && month_brt[i] >= month){
			              age[i] = year - year_brt[i] - 1 ;
		                }
		                else {
			              age[i] = year - year_brt[i];
		                }
		               
					}
					
					note = new int[student];
					
					for(int i = 0; i < student; i++) {
						system("cls");
						cout << "Del Estudiante # " << (i+1) << "." << endl << endl;
						cout << "Ingresar cantidad de notas a evaluar: ";
						cin >> cnt_note;
						
						for (int i = 0; i < cnt_note; i++){
							
							bool notes_co = false;
							
		                    while(notes_co == false){
								cout << "Ingrese la nota del estudiante: " << endl;
							    cin >> notes;
									    
								if (notes < 1 && notes > 20){
									cout << "La nota que usted a ingrsado es invalidad " << endl << endl; 	
								}
								else {
									notes_co = true;			
								}	
							
								aux_notes = aux_notes + notes;
			                    note[i] = aux_notes / cnt_note;
								
					        }
		                    
		                    if (note[i] >= 1 && note[i] < 9.5){
							 cnt_repro = cnt_repro + 1;
						    }
					        else {
							 cnt_apr = cnt_apr + 1;
						    }
						    
						}
						
					}
					
					break;
				}
					
				//break;
		
				case 2: 
					system("cls");

					for (int i = 0; i < student; i++) {
						cout << "Estudiante # " << (i+1) << ": " << name[i] << " "<< last_name[i] << " " << id[i] << endl;
					}
					cout << "Programa no apto para seguir con estos procedimientos " << endl;
					cout << "Le pedimos una disculpa :( " << endl;
					
					
				break;
				
				case 3: 
					system("cls");
					
					do{
						cout << "1. Modificar Nombres de los estudiantes" << endl;
						cout << "2. Modificar Apellido de los estudiantes" << endl;
						cout << "3. Modificar Cedula de los estudiantes" << endl;
						cout << "4. Modificar Sexo de los estudiantes" << endl; 
					    cout << "5. Modificar Fecha de nacimiento de los estudiantes" << endl;
					    cout << "6. Modificar Notas de los estudiantes" << endl;
					    cout << "7. Volver al menu anterior" << endl;
					    cout << endl;
					    cout << "Ingrese una opcion" << endl;
					    cin >> opc;
					
						switch(opc) {
							case 1: 
								system("cls");
								
								for(int i = 0; i < student; i++) {
									system("cls");
									cout << "Del Estudiante # " << (i+1) << "." << endl << endl;
									cout << "Ingresar el Nombre: ";
									cin >> name[i];	
					  			}
											
							break;
					
							case 2: 
								system("cls");
								
								for(int i = 0; i < student; i++) {
									system("cls");
									cout << "Del Estudiante # " << (i+1) << "." << endl << endl;
									cout << "Ingresar el Apellido: ";
									cin >> last_name[i];
								}
								
							break;
							
							case 3: 
								system("cls");
								
								for(int i = 0; i < student; i++) {
									system("cls");
									cout << "Del Estudiante # " << (i+1) << "." << endl << endl;
									cout << "Ingresar la Cedula de Identidad: ";
									cin >> id[i];
								}
								
							break;
							
							case 4: 
								system("cls");
								
								for(int i = 0; i < student; i++) {
									system("cls");
									cout << "Del Estudiante # " << (i+1) << "." << endl << endl;
									cout << "Utilizar (F) para femenino y (M) para masculino " << endl;
									cout << "Ingresar Sexo: ";
									cin >> se[i];
									
									if (se[i] == F){
										total_f = total_f + 1;
									}
									else {
										total_m = total_m + 1;
									}
										
								}
								
							break;
							
							case 5:
								system("cls");
					
								for(int i = 0; i < student; i++) {
									system("cls");
									cout << "Estudiante # " << (i+1) << "." << endl << endl;
									cout << "Ingresar dia de nacimiento: ";
									cin >> day_brt[i];
								}
								
								for(int i = 0; i < student; i++) {
									system("cls");
									cout << "Estudiante # " << (i+1) << "." << endl << endl;
									cout << "Ingresar mes de nacimiento: ";
									cin >> month_brt[i];
								}
								
								for(int i = 0; i < student; i++) {
									system("cls");
									cout << "Estudiante # " << (i+1) << "." << endl << endl;
									
									bool year_brt_co = false;
									
									while(year_brt_co == false){
										cout << "Ingresar año de nacimiento: ";
									    cin >> year_brt[i];
											    
										if (year_brt[i] < 1900){
											cout << "El año que usted a ingresado es invalido " << endl << endl; 	
										}
										else {
											year_brt_co = true;			
										}		
								    } 
								    
								}
								
								for(int i = 0; i < student; i++) {
									if (day_brt[1] >= day && month_brt[i] >= month){
						              age[i] = year - year_brt[i] - 1 ;
					                }
					                else {
						              age[i] = year - year_brt[i];
					                }
					               
								}		
							break;
							
							case 6:
								system("cls");
								
								for(int i = 0; i < student; i++) {
									system("cls");
									cout << "Del Estudiante # " << (i+1) << "." << endl << endl;
									cout << "Ingresar cantidad de notas a evaluar: ";
									cin >> cnt_note;
									
									for (int i = 0; i < cnt_note; i++){
										
										bool notes_co = false;
										
					                    while(notes_co == false){
											cout << "Ingrese la nota del estudiante: " << endl;
										    cin >> notes;
												    
											if (notes < 1 && notes > 20){
												cout << "La nota que usted a ingrsado es invalidad " << endl << endl; 	
											}
											else {
												notes_co = true;			
											}	
										
											aux_notes = aux_notes + notes;
						                    note[i] = aux_notes / cnt_note;
											
								        }
					                    
					                    if (note[i] >= 1 && note[i] < 9.5){
										 cnt_repro = cnt_repro + 1;
									    }
								        else {
										 cnt_apr = cnt_apr + 1;
									    }
									    
									}
									
								}
								
							break;
							
							case 7:
								SOS = 0;
							break;
							
							default: 
								cout << "Opcion no valida " << endl;
							break;
						}
						
						system("pause");
						system("cls");
					}
					while(SOS == 1);
								 
				break;
				
				case 4: 
					system("cls");
				
					cout << "Total de estudiantes: " << student << endl;
					cout << "Total de Hombres: " << total_m << endl;
					cout << "Total de Mujeres: " << total_f << endl;
					cout << "Cantidad de aprobados: " << cnt_apr << endl;
					cout << "Cantidad de reprobados: " << cnt_repro << endl;
					
				break;
				
				case 5:
					system("cls");
					
					cout << "Cambiar fecha actual "	<< endl;
					
					cout << "Dia " << endl;
					cin >> day;
					
					cout << "Mes " << endl;
					cin >> month;
					
					while(year_co == false){
						cout << "Año " << endl;
					    cin >> year;
							    
						if (year < 1900){
							cout << "El año que usted a ingresado es invalido " << endl << endl; 	
						}
						else {
							year_co = true;			
						}		
					}
					
					
				break;
				
				case 6:
					SYS = 0;
				break;
				
				default: 
					cout << "Opcion no valida " << endl;
				break;
			}
			
			system("pause");
			system("cls");
	}
	while (SYS == 1);
	
}

