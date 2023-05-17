/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador_de_escalonamento;

import java.awt.Color;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author p001067
 */
public class Resultado {

    JFrame jResultado;
    Calcular calc;
    int linhas;
 
    public Resultado() {
        calc = new Calcular();
        //conf frame
        jResultado = new JFrame();
        jResultado.setLayout(null);
        jResultado.setTitle("Resultado");
        jResultado.setSize(1000, 725);
        jResultado.setLocationRelativeTo(null);
        //chama calcula
        calc.getFIFO();
        calc.getSJF();
        calc.getPrioridade();
        calc.getRR();
 
        //cria modelos
        DefaultTableModel modelFIFO = new DefaultTableModel() {
 
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        DefaultTableModel modelSJF = new DefaultTableModel() {
 
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        DefaultTableModel modelPrio = new DefaultTableModel() {
 
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        DefaultTableModel modelRR = new DefaultTableModel() {
 
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        //cria coluna models
        modelFIFO.addColumn("Processo");
        modelFIFO.addColumn("Tempo de Espera");
        modelFIFO.addColumn("Tempo de Turnaround");
 
        modelSJF.addColumn("Processo");
        modelSJF.addColumn("Tempo de Espera");
        modelSJF.addColumn("Tempo de Turnaround");
 
        modelPrio.addColumn("Processo");
        modelPrio.addColumn("Tempo de Espera");
        modelPrio.addColumn("Tempo de Turnaround");
 
        modelRR.addColumn("Processo");
        modelRR.addColumn("Tempo de Espera");
        modelRR.addColumn("Tempo de Turnaround");
 
        //popula models
        linhas = Main.table.getRowCount();
 
        int contLinha = 0;
        while (contLinha < linhas) {
 
            modelFIFO.addRow(new Object[]{"P" + (contLinha + 1), Calcular.tEspFIFO[contLinha], Calcular.tTurFIFO[contLinha]});
            modelSJF.addRow(new Object[]{"P" + (contLinha + 1), Calcular.tEspSJF[contLinha], Calcular.tTurSJF[contLinha]});
            modelPrio.addRow(new Object[]{"P" + (contLinha + 1), Calcular.tEspPrio[contLinha], Calcular.tTurPrio[contLinha]});
            modelRR.addRow(new Object[]{"P" + (contLinha + 1), Calcular.tEspRR[contLinha], Calcular.tTurRR[contLinha]});
            contLinha++;
        }
        //tabela
        JTable tableFIFO = new JTable(modelFIFO);
        JTable tableSJF = new JTable(modelSJF);
        JTable tablePrio = new JTable(modelPrio);
        JTable tableRR = new JTable(modelRR);
 
        JScrollPane stableFIFO = new JScrollPane(tableFIFO);
        stableFIFO.setHorizontalScrollBar(new JScrollBar(0));
        JScrollPane stableSJF = new JScrollPane(tableSJF);
        stableSJF.setHorizontalScrollBar(new JScrollBar(0));
        JScrollPane stablePrio = new JScrollPane(tablePrio);
        stablePrio.setHorizontalScrollBar(new JScrollBar(0));
        JScrollPane stableRR = new JScrollPane(tableRR);
        stableRR.setHorizontalScrollBar(new JScrollBar(0));
 
        stableFIFO.setBounds(50, 50, 400, 250);
        stableSJF.setBounds(550, 50, 400, 250);
        stablePrio.setBounds(50, 400, 400, 250);
        stableRR.setBounds(550, 400, 400, 250);
 
        //campos de texto tempo de espera e tempo de turnaround
        JTextField temFIFO = new JTextField();
        JTextField ttmFIFO = new JTextField();
        JTextField temSJF = new JTextField();
        JTextField ttmSJF = new JTextField();
        JTextField temPrio = new JTextField();
        JTextField ttmPrio = new JTextField();
        JTextField temRR = new JTextField();
        JTextField ttmRR = new JTextField();
 
        temFIFO.setEditable(false);
        ttmFIFO.setEditable(false);
        temSJF.setEditable(false);
        ttmSJF.setEditable(false);
        temPrio.setEditable(false);
        ttmPrio.setEditable(false);
        temRR.setEditable(false);
        ttmRR.setEditable(false);
 
        temFIFO.setBounds(150, 315, 100, 20);
        ttmFIFO.setBounds(370, 315, 100, 20);
        temSJF.setBounds(650, 315, 100, 20);
        ttmSJF.setBounds(870, 315, 100, 20);
        temPrio.setBounds(150, 665, 100, 20);
        ttmPrio.setBounds(370, 665, 100, 20);
        temRR.setBounds(650, 665, 100, 20);
        ttmRR.setBounds(870, 665, 100, 20);
 
        //formata tempos e passa para tfs
        temFIFO.setText("" + NumberFormat.getNumberInstance().format(calc.getEsperaFIFO()));
        ttmFIFO.setText("" + NumberFormat.getNumberInstance().format(calc.getTurnaroundFIFO()));
        temSJF.setText("" + NumberFormat.getNumberInstance().format(calc.getEsperaSJF()));
        ttmSJF.setText("" + NumberFormat.getNumberInstance().format(calc.getTurnaroundSJF()));
        temPrio.setText("" + NumberFormat.getNumberInstance().format(calc.getEsperaPrioridade()));
        ttmPrio.setText("" + NumberFormat.getNumberInstance().format(calc.getTurnaroundPrioridade()));
        temRR.setText("" + NumberFormat.getNumberInstance().format(calc.getEsperaRR()));
        ttmRR.setText("" + NumberFormat.getNumberInstance().format(calc.getTurnaroundRR()));
 
        //labels
        JLabel ltemFIFO = new JLabel("T.Espera Médio");
        JLabel lttmFIFO = new JLabel("T.Turnaround Médio");
        JLabel ltemSJF = new JLabel("T.Espera Médio");
        JLabel lttmSJF = new JLabel("T.Turnaround Médio");
        JLabel ltemPrio = new JLabel("T.Espera Médio");
        JLabel lttmPrio = new JLabel("T.Turnaround Médio");
        JLabel ltemRR = new JLabel("T.Espera Médio");
        JLabel lttmRR = new JLabel("T.Turnaround Médio");
 
        JLabel lFIFO = new JLabel("FIFO");
        JLabel lSJF = new JLabel("SJF");
        JLabel lPrio = new JLabel("Prioridade");
        JLabel lRR = new JLabel("RR");
 
        ltemFIFO.setBounds(50, 315, 100, 20);
        lttmFIFO.setBounds(250, 315, 120, 20);
        ltemSJF.setBounds(550, 315, 100, 20);
        lttmSJF.setBounds(750, 315, 120, 20);
 
        ltemPrio.setBounds(50, 665, 100, 20);
        lttmPrio.setBounds(250, 665, 120, 20);
        ltemRR.setBounds(550, 665, 100, 20);
        lttmRR.setBounds(750, 665, 120, 20);
 
        lFIFO.setBounds(50, 30, 100, 20);
        lSJF.setBounds(550, 30, 100, 20);
        lPrio.setBounds(50, 380, 100, 20);
        lRR.setBounds(550, 380, 100, 20);
 
        //l bordas para o melhor
        int posicao = calc.getMelhor();
 
        if (posicao == 1) {
            stableFIFO.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        if (posicao == 2) {
            stableSJF.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        if (posicao == 3) {
            stablePrio.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        if (posicao == 4) {
            stableRR.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
 
        //adiciona ao frame
        jResultado.add(stableFIFO);
        jResultado.add(stableSJF);
        jResultado.add(stablePrio);
        jResultado.add(stableRR);
        jResultado.add(temFIFO);
        jResultado.add(ttmFIFO);
        jResultado.add(temSJF);
        jResultado.add(ttmSJF);
        jResultado.add(temPrio);
        jResultado.add(ttmPrio);
        jResultado.add(temRR);
        jResultado.add(ttmRR);
        jResultado.add(ltemFIFO);
        jResultado.add(lttmFIFO);
        jResultado.add(ltemSJF);
        jResultado.add(lttmSJF);
        jResultado.add(ltemPrio);
        jResultado.add(lttmPrio);
        jResultado.add(ltemRR);
        jResultado.add(lttmRR);
        jResultado.add(lFIFO);
        jResultado.add(lSJF);
        jResultado.add(lPrio);
        jResultado.add(lRR);
 
 
        //fin frame
        jResultado.setVisible(true);
        jResultado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  
}
