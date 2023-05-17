/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_de_escalonamento;

import java.awt.Dimension;
import java.awt.Toolkit;
/**
 *
 * @author p001067
 */
public class Resolucao {
 
    public static double resolucao(int tipo) {
        //1=x; 2=y
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        double x = dim.getWidth();//largura
        double y = dim.getHeight();//altura
        if (tipo == 1) {
            return x;
        } else {
            return y;
        }
    }    
    
}
