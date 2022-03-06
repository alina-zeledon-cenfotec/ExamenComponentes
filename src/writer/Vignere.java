package writer;

public class Vignere implements Encriptador {

    public String key = "HOLA";

    @Override
    public String encripta(String texto) {

      int tam = texto.length();

        for (int i = 0; ; i++)
        {
            if (tam == i)
                i = 0;
            if (key.length() == texto.length())
                break;
            key+=(key.charAt(i));
        }

        StringBuffer str =new StringBuffer(texto);
        for(int i = 0; i < texto.length(); i++)
        {
            if(Character.isLowerCase(texto.charAt(i)))
            {
                str.setCharAt(i, Character.toUpperCase(texto.charAt(i)));
            }
        }
        texto = str.toString();

        String textoEncriptado = "";

        for (int i = 0; i < texto.length(); i++)
        {

            // convierte a un rango de 0-25
            int x = (texto.charAt(i) + key.charAt(i)) %26;

            // convierte a letras del alfabeto
            x += 'A';

            textoEncriptado+=(char)(x);
        }
        return textoEncriptado;
/*
        String textoEncriptado = "";

        texto = texto.toUpperCase();

        for (int i = 0, j = 0; i < texto.length(); i++) {
            char letter = texto.charAt(i);
            textoEncriptado += (char)(((letter - 65) + (key.charAt(j)-65)) % 26 + 65);
            j = ++j % key.length();
        }
        return textoEncriptado;*/

    }

    @Override
    public String desencripta(String texto) {

        String textoDesencriptado = "";

        for (int i = 0; i < texto.length() && i < key.length(); i++) {

            // convierte a un rango de 0-25
            int x = (texto.charAt(i) -  key.charAt(i) + 26)%26;

            // convierte a letras del alfabeto
            x += 'A';
            textoDesencriptado +=(char)(x);
        }
        return textoDesencriptado;
    }

}
