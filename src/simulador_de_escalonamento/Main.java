/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulador_de_escalonamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author p001067
 */
public class Main {

    // quantum
    static int qpass;
    // resolucao
    static int xr, yr;
    //janela principal
    static JFrame jprincipal;
    //tabela em que os processos são incerido
    static JTable table;
    //modelo de table
    static DefaultTableModel model;
    //campo de texto para o quantum
    static JTextField tquantum;
    //contador de processos
    static int p = 0;
    //variavel para controle da janela adicionar
    static int openJa = 0;
 
    public static void main(String[] args) {
        //inicializa frame principal
        jprincipal = new JFrame();
        jprincipal.setLayout(null);
        jprincipal.setTitle("Simulador Escalonamento de processos");

        //define resolucao
        xr = (int) Resolucao.resolucao(1);
        yr = (int) Resolucao.resolucao(2);
        jprincipal.setBounds(0, 0, xr, yr);

        //define como maximizado
        jprincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //cria modelo para a tabela
        model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        model.addColumn("Processo");
        model.addColumn("Tempo de Chegada");
        model.addColumn("Tempo de Execução");
        model.addColumn("Prioridade");

        //cria tabela
        table = new JTable(model);

        //cria Scroll
        JScrollPane scrollTable = new JScrollPane(table);
        scrollTable.setBounds(50, 50, xr - 500, yr - 400);
        scrollTable.setHorizontalScrollBar(new JScrollBar(0));

        //cria/inicializa demais componentes
        JButton badicionar = new JButton("Adicionar Processo");
        JButton bremover = new JButton("Remover");
        JButton bcalcular = new JButton("Calcular");
        JLabel lquantum = new JLabel("Quantum");
        tquantum = new JTextField();

        //define local
        badicionar.setBounds(xr - 400, 100, 150, 30);
        bremover.setBounds(xr - 400, 150, 150, 30);
        bcalcular.setBounds(xr - 400, 200, 150, 30);
        lquantum.setBounds(xr - 400, 300, 60, 20);
        tquantum.setBounds(xr - 320, 300, 50, 20);

        //adiciona componentes
        jprincipal.add(scrollTable);
        jprincipal.add(badicionar);
        jprincipal.add(bremover);
        jprincipal.add(bcalcular);
        jprincipal.add(lquantum);
        jprincipal.add(tquantum);

        //eventos
        //evento botao adicionar
        badicionar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //abre frame
                if (openJa == 0) {
                    JAdicionarProcesso ja = new JAdicionarProcesso();
                    //define janela como aberta
                    openJa = 1;
                }
            }
        });
        // evento botao remover
        bremover.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //remove linha
                int colunas = table.getSelectedColumn();
                int linhas = table.getSelectedRow();
                if (linhas == -1 || colunas == -1) {
                    //System.out.println("Selecione linha");
                } else {
                    model.removeRow(linhas);
                    //decrementa a varialvel de controle para processos
                    p--;
                }
            }
        });
        //evento botao calcular
        bcalcular.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //abre frame resultado e pega quantum
                qpass = Integer.parseInt(tquantum.getText());
                Resultado r = new Resultado();
            }
        });

        //conf. finais jprincipal
        jprincipal.setVisible(true);
        jprincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }//fim da main
//adiciona linha ao modelo

    public static void adicionaLinha(Object nl[]) {
        model.addRow(nl);

    }

}
