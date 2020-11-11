package com.example.game;

import java.util.List;

/**
 * Created by dev on 30/09/15.
 * Importado en 31/10/20 para codeAlong de Packages
 */
public interface ISaveable {
    List<String> write();
    void read(List<String> savedValues);

}
