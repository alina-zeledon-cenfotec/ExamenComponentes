package writer;

public class Cesar implements Encriptador {

    public final String abc = "abcdefghijklmnopqrstuvwxyz";

    public String encripta(String texto) {

        texto = texto.toLowerCase();
        String textoEncriptado = "";
        int traslacion = 3;

        for (int x = 0; x < texto.length(); x++) {
            int charPosition = abc.indexOf(texto.charAt(x));
            int keyVal = (traslacion + charPosition) % 26;
            char replaceVal = abc.charAt(keyVal);
            textoEncriptado += replaceVal;
        }

        return textoEncriptado;
    }

    @Override
    public String desencripta(String textoEncriptado) {

        int traslacion = 3;
        textoEncriptado = textoEncriptado.toLowerCase();
        String message = "";

        for (int i = 0; i < textoEncriptado.length(); i++) {
            int charPosition = abc.indexOf(textoEncriptado.charAt(i));
            int keyVal = (charPosition - traslacion) % 26;
            if (keyVal < 0) {
                keyVal = abc.length() + keyVal;
            }
            char replaceVal = abc.charAt(keyVal);
            message += replaceVal;
        }
        return message;
    }
}
