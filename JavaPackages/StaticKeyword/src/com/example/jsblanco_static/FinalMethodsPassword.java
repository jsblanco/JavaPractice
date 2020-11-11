package com.example.jsblanco_static;

public class FinalMethodsPassword {
    private static final int key = 19457215;
    private final int encryptedPassword;

    public FinalMethodsPassword(int encryptedPassword) {
        this.encryptedPassword = encryptDecrypt(encryptedPassword);
    }

    private int encryptDecrypt(int password){
        return password^key;
    }

    public final void storePassword(){
        System.out.println("Guardando la contraseña encriptada como el siguiente código: "+ this.encryptedPassword);
    }

    public boolean enterPassword(int inputPassword){
        if (encryptDecrypt(inputPassword) == this.encryptedPassword){
            System.out.println("¡Contraseña correcta! Bienvenido.");
            return true;
        }
        System.out.println("¡Fuera de aquí, impostor!");
        return false;
    }
}
