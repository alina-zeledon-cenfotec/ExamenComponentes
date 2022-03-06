package bean;
import org.springframework.beans.factory.annotation.Autowired;
import writer.Encriptador;

import java.util.Scanner;

public class WriterBeanWithDependency {

    private Encriptador writer;
    Scanner scan = new Scanner(System.in);

    @Autowired
    public void setWriter (Encriptador pWriter){
        this.writer = pWriter;
    }

    public void menu(){

        int opc = 0;
        String test = "";

        do {
            imprimir(" ");
            imprimir("*************************************************");
            imprimir("Menú - Examen I - Componentes - Alina Zeledón O.");
            imprimir("*************************************************");
            imprimir("Seleccione una de las siguientes opciones:");
            imprimir("1. Encriptar texto");
            imprimir("2. Desencriptar texto (Retornar texto original).");
            imprimir("3. Salir");

            opc = scan.nextInt();
            procesarOpc(opc);

        }while (opc != 3);

    }

    public void procesarOpc (int opc){

        switch (opc){
            case 1:

                imprimir("Ingrese el texto que desea encriptar");
                String textoEncriptar = scan.next();

                textoEncriptar = writer.encripta(textoEncriptar);
                imprimir(textoEncriptar);

                break;
            case 2:

                imprimir("Ingrese el texto que desea encriptar");
                String textoOriginal = scan.next();

                textoOriginal = writer.desencripta(textoOriginal);
                imprimir(textoOriginal);

                break;
            case 3:
                imprimir("See you later!");
                break;
            default:
                imprimir("Opción no valida, por favor vuelva a intentarlo");
                break;
        }
    }


    public static void imprimir(String dato){
        System.out.println(dato);
    }
}
