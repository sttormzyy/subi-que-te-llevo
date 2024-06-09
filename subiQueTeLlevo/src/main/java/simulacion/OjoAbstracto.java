/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import java.util.Observable;
import java.util.Observer;

/**
 *Clase abstracta que implementa observer y sirve para ser extendida por clases observadoras mas especificas<br>
 * brindando una herencia comun entre ellas
 */
public class OjoAbstracto implements Observer{
    protected Observable observado;
    
    @Override
    public void update(Observable o, Object arg) {
        if(o != observado)
        {
            throw new IllegalArgumentException();
        }
    }
    
}
