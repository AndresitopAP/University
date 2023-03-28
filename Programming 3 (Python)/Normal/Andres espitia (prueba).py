subjects = ["Matemáticas", "Física", "Química", "Historia", "Deporte", "Informatica", "Ingles"]
passed = []
for subject in subjects:
    score = float(input("¿Qué nota has sacado en " + subject + "? "))
    if score >= 9.5:
        passed.append(subject)
for subject in passed:
    subjects.remove(subject)
print("Tienes que repetir " + str(subjects))