package Ejercicio_02_sorting;

import java.util.Scanner;

import Materia.Models.NodeGeneric;
import Materia.Stacks.StackGeneric;

public class StackSorter {
    private NodeGeneric<Integer> head;
    private Scanner scanner = new Scanner(System.in);
    StackGeneric<Integer> stack = null;
    
    public void program(){
        System.out.println("Menu");
        System.out.println("1. Ingresar numeros al stack");
        System.out.println("2. Ordenar stack");
        System.out.println("3. Imprimir stack");
        System.out.println("0. Salir");
        System.out.println("Seleccione una opcion: ");
        int opcion = scanner.nextInt();

        while (opcion != 0) {
            
            switch (opcion) {
                case 1:
                    stack = inputElements(); 
                    break;
            
                case 2:
                    if (stack == null){
                        System.out.println("El stack esta vacio :/");
                    } else {
                        sortStack(stack);
                    }
                    break;

                case 3:
                    print();
                    break;

                default:
                    System.out.println("Opcion invalida :/");
                    break;
            }
            System.out.println("Menu");
            System.out.println("1. Ingresar numeros al stack");
            System.out.println("2. Ordenar stack");
            System.out.println("3. Imprimir stack");
            System.out.println("0. Salir");
            System.out.println("Seleccione una opcion: ");
            opcion = scanner.nextInt();
        }
    }
    
    
    public StackGeneric<Integer> inputElements(){
        StackGeneric<Integer> stack = new StackGeneric<>();
        System.out.println("Ingrese la cantidad de elementos:");
        int valores = scanner.nextInt();

        if(valores < 0){
            System.out.println("Valor no valido :/");
        } else {
            for (int i = 0; i < valores; i++){
                System.out.print("Ingrese un numero: ");
                stack.push(scanner.nextInt());
            }
        }
        return stack;
    }
    
    public void sortStack(StackGeneric<Integer> stack){
        StackGeneric<Integer> stackAux = new StackGeneric<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!stackAux.isEmpty() && stackAux.peek() > temp) {
                stack.push(stackAux.pop());
            }
            stackAux.push(temp);
        }
        
        while (!stackAux.isEmpty()) {
            stack.push(stackAux.pop());
        }
    }

    public void print(){
        if(stack == null){
            System.out.println("No se han ingresado numeros al stack :/");
            return;
        }
        StackGeneric<Integer> stackAux = new StackGeneric<>();
        System.out.print("[");
        boolean isFirst = true;
        while (!stack.isEmpty()) {
            int value = stack.pop();
            if (!isFirst){
                System.out.print(", ");
            }
            System.out.print(value);
            isFirst = false;
            stackAux.push(value);
        }
        System.out.println("]");
        while (!stackAux.isEmpty()) {
            stack.push(stackAux.pop());
        }
    }

}
