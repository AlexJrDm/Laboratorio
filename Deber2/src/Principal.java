/*
    Realizar un programa el cual ingrese un arreglo de personas, que permita la compra de una entrada
    para n personas a un enfrentamiento del clásico, Barcelona vs Emelec.
    Debe ingresar nombres, apellidos, número de cédula, Ubicacion de observación (palco o tribuna)
    una vez terminado el programa mostrará la entrada en pantalla con todos los datos ingresados e incluyendo la factura
    de lo pedido.
    El programa guardará en un archivo todo lo ingresado por cada compra.
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Principal {

    public static void main(String[] args) throws Exception {
        Scanner imput = new Scanner(System.in); //Variable imput para entrada de datos
        int optionPrincipal;
        int numberPers, age;
        String names, surnames;
        Long cedula; 
        //VARIABLES DEL MENU (PARA TIPO DE ENTRADAS)
        int optionType; //Opcion de selección
        String type; //tipo de entrada
        double price; //esta variable servirá para definir el precio total de la compra
        Person arrayPerson [] = null; //Variable del arreglo vacía para poder generar el archivo fuera del caso 1

        do{
            System.out.println("****____MENU____****");
            System.out.println("1. Ejercicio");
            System.out.println("2. Generador del archivo");
            System.out.println("3. Salir");
            System.out.print("\tIngrese una opcion: ");
            optionPrincipal = imput.nextInt();
            imput.nextLine(); //Evitar guardar archivos basura.
            switch(optionPrincipal){
                case 1: {
                        //Tamaño del arreglo
                        System.out.println("");
                        System.out.println("BIENVENIDOS AL SYSTEMA DE COMPRAS DE ENTRADAS PARA EL PARTIDO 'Barcelona vs Emelec'");
                        System.out.print("Ingrese el numero de entradas a comprar: ");
                        numberPers = imput.nextInt();
                        while(numberPers<0 || numberPers>10){
                            System.out.print("Invalido, el numero de entradas limites esta entre (1-10), vuelva a intentar: ");
                            numberPers = imput.nextInt();
                        }
                        System.out.println(" ");//Salto de linea para dezplazar 2 lineas hacia abajo

                        //Objeto de la clase Persona
                        arrayPerson = new Person[numberPers]; //arreglo de tipo persona principal.

                            for (int i = 0; i <arrayPerson.length; i++){
                                imput.nextLine();
                                System.out.println("Por favor, ingrese datos de la persona"+(i+1)+":  ");
                                System.out.print("Ingrese unicamente sus nombres: ");
                                names = imput.nextLine();
                                System.out.print("Ingrese unicamente sus apellidos: ");
                                surnames = imput.nextLine();
                                System.out.print("Ingrese la edad: ");
                                age = imput.nextInt(); 
                                while(age <8 || age> 80){
                                    System.out.print("Edad no admitida, por favor intente nuevamente: ");
                                    age = imput.nextInt();
                                }
                                imput.nextLine(); //Evitar guardar archivos basura.
                                System.out.print("Ingrese el numero de cédula: ");
                                cedula = imput.nextLong();
                                while (cedula <0){
                                    System.out.print("Cedula incorrecta, por favor vuelva a ingresar: ");
                                    cedula = imput.nextLong();
                                }
                                imput.nextLine(); //Evitar guardar archivos basura.

                                System.out.println(""); //salto de linea
                                System.out.println("¿EN QUE LUGAR DEL ESTADIO LE GUSTARIA OBTENER PUESTO?");
                                System.out.println("1. Palco. \nPrecio: 254.59$");
                                System.out.println("2. Tribuna. \nPrecio: 65.99$");
                                System.out.print("Seleccione una opción: ");
                                optionType = imput.nextInt();
                                while (optionType<0 || optionType>3){
                                    System.out.print("Opcion invalida: ");
                                    optionType = imput.nextInt();
                                }
                                imput.nextLine(); //Evitar guardar archivos basura.

                                switch (optionType) {
                                    case 1: {
                                        type = "Palco";
                                        price = 254.59;
                                        System.out.println("Se ha agregado correctamente al carrito. ");
                                        System.out.println("Presione enter para continuar...");
                                        break;
                                    }
                                case 2: {
                                    type = "Tribuna";
                                    price = 65.99;
                                    System.out.println("Se ha agregado correctamente al carrito. ");
                                    break;
                                }
                                default: {
                                    type = "Desconocido";
                                    price = 0.0;
                                }
                                }
                                
                                    arrayPerson[i] = new Person(names, surnames, age, cedula, type, price);
                                }
                                
                                System.out.println("");
                                System.out.println(" ");
                                System.out.println("_______________________________________");
                                System.out.println("A CONTINUACION SE MOSTRARÁ LA FACTURA DE SU COMPRA");
                                for (int i = 0; i < arrayPerson.length; i++){
                                    System.out.println("Boleto numero "+(1+i)+": ");
                                    System.out.println("Nombres y Apellidos: "+arrayPerson[i].getNames()+" "+arrayPerson[i].getSurnames());
                                    System.out.println("Edad: "+arrayPerson[i].getAge());
                                    System.out.println("Numero de cedula: "+arrayPerson[i].getCedula());
                                    System.out.println("Tipo de entrada: "+arrayPerson[i].getTicketType());
                                    System.out.println("Precio a pagar: "+arrayPerson[i].getTicketPrice());
                                    System.out.println("____________________________________________");
                                }
                    break;
                }
                case 2: {
                    try{
                        FileWriter archive = new FileWriter("estadio.txt");
                        for (int i = 0; i < arrayPerson.length;i++){
                            archive.write("Boleto numero "+(i+1)+": \n");
                            archive.write("Nombres y apellidos del comprador: "+arrayPerson[i].getNames()+" "+ arrayPerson[i].getSurnames());
                            archive.write("\n");
                            archive.write("Edad "+arrayPerson[i].getAge());
                            archive.write("\n");
                            archive.write("Numero de cedula: "+arrayPerson[i].getCedula());
                            archive.write("\n");
                            archive.write("Ubicacion en el estadio: "+arrayPerson[i].getTicketType());
                            archive.write("\n");
                            archive.write("Precio a pagar: "+arrayPerson[i].getTicketPrice());
                            archive.write("\n");
                            archive.write("_______________________________________________________");
                            archive.write("\n");
                            archive.write("\n");
                        }
                        archive.close();
                        System.out.println("Archivo generado correctamente. ");
                    } catch (IOException e){
                        System.out.println("Error al guardar el archivo. ");
                    }
                    break;
                }
                case 3: {
                    System.out.println("SALIENDO...");
                    break;
                }
                default :{
                    System.out.println("Opcion invalida. ");
                    break;
                }
                }
        }while(optionPrincipal!=3);
    }
}
