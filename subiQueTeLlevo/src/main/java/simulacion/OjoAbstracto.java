/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Usuario
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
