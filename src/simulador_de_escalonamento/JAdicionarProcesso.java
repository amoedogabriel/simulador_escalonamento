/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_de_escalonamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author p001067
 */
public class JAdicionarProcesso {
 
    static JFrame jAdicionar;
    static Object[] nl;
    JTextField tprocesso;
    JTextField ttc;
    JTextField tte;
    JTextField tprioridade;
 
    //cria janela
    public JAdicionarProcesso() {
        Main.p++;
 
        //inicializa janela
        jAdicionar = new JFrame();
 
        //define propriedades
        jAdicionar.setTitle("Adicionar Processo");
        jAdicionar.setLayout(null);
        jAdicionar.setSize(400, 300);
        jAdicionar.setLocationRelativeTo(null);
 
        //cria componentes
        JLabel lprocesso = new JLabel("Processo");
        JLabel ltc = new JLabel("Tempo de Chegada");
        JLabel lte = new JLabel("Tempo de Execução");
        JLabel lprioridade = new JLabel("Prioridade");
 
         tprocesso = new JTextField();
         ttc = new JTextField();
         tte = new JTextField();
         tprioridade = new JTextField();
 
        JButton bok = new JButton("OK");
        JButton bcancel = new JButton("CANCELAR");
 
        //define propriedade dos componentes
        lprocesso.setBounds(30, 30, 100, 20);
        ltc.setBounds(30, 70, 150, 20);
        lte.setBounds(30, 110, 150, 20);
        lprioridade.setBounds(30, 150, 100, 20);
 
        tprocesso.setBounds(170, 30, 80, 20);
        ttc.setBounds(170, 70, 80, 20);
        tte.setBounds(170, 110, 80, 20);
        tprioridade.setBounds(170, 150, 80, 20);
 
        bok.setBounds(160, 220, 100, 30);
        bcancel.setBounds(280, 220, 100, 30);
 
        //define processo ("P"+var)
        tprocesso.setEditable(false);
        tprocesso.setText("P" + Main.p);
 
        //adiciona a janela
        jAdicionar.add(lprocesso);
        jAdicionar.add(ltc);
        jAdicionar.add(lte);
        jAdicionar.add(lprioridade);
        jAdicionar.add(tprocesso);
        jAdicionar.add(ttc);
        jAdicionar.add(tte);
        jAdicionar.add(tprioridade);
        jAdicionar.add(bok);
        jAdicionar.add(bcancel);
 
        //eventos
        bok.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                //adiciona lina
                nl = new Object[]{tprocesso.getText(),ttc.getText() ,tte.getText() ,tprioridade.getText() };
                Main.adicionaLinha(nl);
                Main.openJa=0;
                jAdicionar.dispose();
            }
        });
        bcancel.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                Main.p--;
                Main.openJa=0;
                jAdicionar.dispose();
 
            }
        });
        //opcoes finais da janela
        jAdicionar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jAdicionar.setVisible(true);
    }
 
    public static void main(String args[]) {
        JAdicionarProcesso ja = new JAdicionarProcesso();
    }
}
