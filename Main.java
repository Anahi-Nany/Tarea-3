package com.company;

// modificadores de acceso son 4 : private, public, --> para encapsuamiento
class Student { //clase
    private String name;
    private String lastName;
    private String code;

    //Constructores: de 3 parametros
    Student(String name, String lastName, String code){
        this.name = name;
        this.lastName = lastName;
        this.code = code;
    }


// metodo getters
    public String getName(){
        return name;
    }

    public String getLastName(){
        return lastName;
    }

    public String getCode(){
        return code;
    }

}

class Group{
    private String code; //null
    private Student[] students; // null declara arreglo
    private int enrolled;//0 int / float / short / byte / double /char
                        // boolean  -> false f (dato dif 0)
    private int rejected;

//alt +insert
    public Group(String code,int capacity) {
        this.code = code;
        students = new Student[capacity]; // instancia arreglo en java
    }

    //metodo agregar alumnos a mi grupo
    public boolean check (Student student){
        if(enrolled < students.length){//si los alumnos inscritos son menores q .leight
            students[enrolled++] = student;
            return true;
        }
        rejected++;
        return false;
    }

    public void addStudent (Student student){
        if(!check(student)) {
            System.out.println("Estudiante no añadido en " + code + " : " + student.getName() + " " + student.getLastName() + " " + student.getCode());
        }else {
            System.out.println("Estudiante añadido en " + code + " : " + student.getLastName() + " " + student.getCode());
        }
    }


// hay q buscar el codigo==recorrer arreglo
    public void removeStudent(String code) {
        int i;
        for (i = 0; i < enrolled && students[i].getCode() != code; i++);

        if (i != enrolled) {
            for (int j = i; j < enrolled - 1; j++) {
                students[j] = students[j + 1];
            }
            enrolled--;
            System.out.println("El codigo  " + code +"  se ha eliminado");
        }else {
            System.out.println("El codigo  " + code +"  no se encontro en el array");
        }
    }

    public void printStudents(){
        for (int i = 0; i < enrolled; i++) {
            Student student = getStudent(i);
            System.out.println(student.getCode() + ": " + student.getName() + " " + student.getLastName());
        }

    }


    public String getCode(){
        return code;
    }

    public int getEnrolled(){
        return enrolled;
    }

    public int getRejected(){
        return rejected;
    }

    public Student getStudent(int index){
        return students [index];
    }

}

public class Main {

    public static void main(String[] args) {
        Student student1; // Referencia a un Alumno
        Student student2 = new Student("Ivan", "Uresti", "972196");
        student1 = new Student("José", "González", "456789"); // Creando un objeto alumno

        Group group = new Group("230401", 8);
        Group group2 = new Group("230402", 6);

        System.out.println("ALUMNOS INGRESADOS");
        group.addStudent(student1);
        group.addStudent(student2);

        group.addStudent(new Student("Jorge", "Acosta", "1"));
        group.addStudent(new Student("Arturo", "Aleman", "2"));
        group.addStudent(new Student("Antonio", "Angel", "3"));
        group.addStudent(new Student("Francisco", "Arreguin", "4"));
        group2.addStudent(new Student("Misael", "Cabrera", "5"));
        group2.addStudent(new Student("Roberto", "Cisneros", "6"));
        group.addStudent(new Student("Juan", "Coronado", "7"));
        group.addStudent(new Student("José", "González", "8"));
        group.addStudent(new Student("Jesús", "Lara", "9"));
        group.addStudent(new Student("José", "Limón", "10"));


        /*
        group.enrolled =10;
        No puedo hacer esto: porq es privado, puedo preguntar pero no cambiar
         */

        System.out.println( "\n" +"Grupo: " + group.getCode() + ", inscritos: " + group.getEnrolled() + ", rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

        group.removeStudent("4");
        group2.removeStudent("6");
        group2.removeStudent("12");

        System.out.println("\n" +"Grupo: " + group.getCode() + ", inscritos: " + group.getEnrolled() + ", rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

        //atajo sout
        System.out.println("\n" +"ALUMNOS DEL GRUPO:  " + group.getCode());
        group.printStudents();


        System.out.println("\n" +"ALUMNOS DEL GRUPO:  " + group2.getCode());
        group2.printStudents();

    }
}
