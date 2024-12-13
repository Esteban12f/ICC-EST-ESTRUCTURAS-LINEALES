package Ejercicio_01_sign;
import java.util.Scanner;
import Materia.Stacks.StackGeneric;

public class SingValidator {

    private Scanner scanner = new Scanner(System.in);

    public void program(){
        System.out.println("Menu");
                System.out.println("1. Ingresar caracteres");
                System.out.println("0. Salir");
                System.out.println("Seleccione una opcion: "); 
                int opcion = scanner.nextInt();

        while (opcion != 0) {
            if( opcion == 1){
                System.out.println("Ingrese una cadena de caracteres que contenga corchetes, parentesis y llaves: ");
                String s = scanner.next();
                boolean resultado = isValid(s);
                if(resultado){
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
                System.out.println("1. Ingresar caracteres");
                System.out.println("0. Salir");
                System.out.println("Seleccione una opcion: ");
                opcion = scanner.nextInt();
                } else {
                    System.out.println("Opcion invalida :/, intente de nuevo");
                    System.out.println("1. Ingresar caracteres");
                    System.out.println("0. Salir");
                    System.out.println("Seleccione una opcion: ");
                    opcion = scanner.nextInt();
                }
        }
    }

    public boolean isValid(String s){
        StackGeneric<Character> caracteres = new StackGeneric<>();
                for (Character caracter : s.toCharArray() ){
                    if (caracter == '(' || caracter == '{' || caracter == '['){
                        caracteres.push(caracter);
                    } else if (caracter == ')' && !caracteres.isEmpty() && caracteres.peek() == '('){
                        caracteres.pop();
                    } else if (caracter == ']' && !caracteres.isEmpty() && caracteres.peek() == '['){
                        caracteres.pop();
                    } else if (caracter == '}' && !caracteres.isEmpty() && caracteres.peek() == '{'){
                        caracteres.pop();
                    } else {
                        return false;
                    }
                
            
        }
    return true;
    }
}
