package com.example.jsblanco_static;

public class ExtendedPassword extends FinalMethodsPassword {

    private int decryptedPassword;

    public ExtendedPassword(int password){
        super(password);
        this.decryptedPassword = password;
    }

/*
    Como el método original es final, no lo podemos sobreescribir
    @Override
    public void storePassword() {
        System.out.println("Contraseña guardada como "+this.decryptedPassword+" saltándonos la encriptación");
    }*/
}
