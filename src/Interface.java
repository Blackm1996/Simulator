import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import static javax.swing.JToolBar.*;
/*
@Author Ghina Saad
*/
public class Interface  {

    JFrame f;
    JButton jbt1 = new JButton("addSensor");
    JButton jbt2 = new JButton("Edit");
    JButton jbt3 = new JButton("Delette");
    JButton jbt4 = new JButton("Button4");

    Interface() {

        f = new JFrame("simulation");
        JPanel panel=new JPanel();
        JPanel p1=new JPanel();
        String data[][] = { { "Ro", "Row", "Row","g","m","","","",""}};
        String column[] = {"ID", "TYPE","CAPACITY","STATE","NBREQUEST","SERVICE","REQUEST","RANGE","POSITION"};
        final JTable jt = new JTable(data, column);
     //   jt.setBounds(0,0,300,300);

      //  jt.setCellSelectionEnabled(true);
      /*  ListSelectionModel select = jt.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String Data = null;
                int[] row = jt.getSelectedRows();
                int[] columns = jt.getSelectedColumns();
                for (int i = 0; i < row.length; i++) {
                    for (int j = 0; j < columns.length; j++) {
                        Data = (String) jt.getValueAt(row[i], columns[j]);
                    }
                }
                System.out.println("Table element selected is: " + Data);
            }
        });*/
        ActionListener printAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f1=new JFrame();

                JDialog d=new JDialog(f1,"Meassage",true);
                d.setSize(200,200);
                JLabel text=new JLabel();
                text.setText("are you sure");
                JButton b=new JButton("ok");
                JButton b1=new JButton("cancel");
               Box box=Box.createHorizontalBox();

               box.add(b);
                box.add(Box.createHorizontalStrut(10));
               box.add(b1);
                d.add(text,BorderLayout.NORTH);

               d.add(box,BorderLayout.SOUTH);

                d.setVisible(true);
            }
        };
        ActionListener printAction1 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f1=new JFrame();

                JDialog d=new JDialog(f1,"Add sensor",true);
                d.setSize(500,500);
                JLabel type=new JLabel("type:");
                JLabel service=new JLabel("service:");
                JLabel capacity=new JLabel("capacity:");
                JLabel request=new JLabel("request;");
                JLabel nbrequest=new JLabel("nbrequest:");
                JLabel range=new JLabel("range:");
                JLabel position=new JLabel("position:");
                JLabel state=new JLabel("state:");
                JButton button =new JButton("add");
                button.setBounds(470,13,50,20);
                Box box=Box.createVerticalBox();
                box.add(type);
                box.add(Box.createVerticalStrut(40));
                box.add(service);
                box.add(Box.createVerticalStrut(40));
                box.add(capacity);
                box.add(Box.createVerticalStrut(40));
                box.add(request);
                box.add(Box.createVerticalStrut(40));
                box.add(nbrequest);
                box.add(Box.createVerticalStrut(40));
                box.add(range);
                box.add(Box.createVerticalStrut(40));
                box.add(position);
                box.add(Box.createVerticalStrut(40));
                box.add(state);
                box.add(Box.createVerticalStrut(50));


                JTextField typet=new JTextField();
                typet.setPreferredSize(new Dimension(30,5));
                JTextField servicet=new JTextField();
                servicet.setPreferredSize(new Dimension(30,5));
                JTextField capacityt=new JTextField();
                capacityt.setSize(100,20);
                JTextField requestt=new JTextField();
                requestt.setSize(100,20);
                JTextField nbrequestt=new JTextField();
                JTextField ranget=new JTextField();
                JTextField positiont=new JTextField();
                JTextField statet=new JTextField();
                Box boxt=Box.createVerticalBox();
                boxt.add(typet);
                boxt.add(servicet);
                boxt.add(capacityt);
                boxt.add(requestt);
                boxt.add(nbrequestt);
                boxt.add(ranget);
                boxt.add(positiont);
                boxt.add(statet);
                JButton b1=new JButton("cancel");
                Box box2=Box.createHorizontalBox();
                box2.add(button);
                box2.add(Box.createHorizontalStrut(20));
                box2.add(b1);

                d.add(box,BorderLayout.WEST);
                d.add(boxt,BorderLayout.CENTER);
                d.add(box2,BorderLayout.SOUTH);
                d.setVisible(true);
            }
        };
       jt.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                jbt3.setEnabled(true);
                System.out.println(jt.getValueAt(jt.getSelectedRow(), 0).toString());
            }
        });
      JScrollPane sp = new JScrollPane(jt);

        panel.add(sp,BorderLayout.EAST);

        panel.setBounds(1,1,500,800);

        panel.setBackground(Color.CYAN);

        p1.setBackground(Color.blue);
        p1.setSize(300,500);

        jbt1.setPreferredSize(new Dimension(100,50));
        jbt1.addActionListener(printAction1);
        jbt3.setPreferredSize(new Dimension(100,50));
        jbt3.setEnabled(false);
        jbt3.addActionListener( printAction);

        Box box = Box.createVerticalBox();
        box.add(jbt1);
        box.add(Box.createVerticalStrut(10));
        box.add(jbt2);
        box.add(Box.createVerticalStrut(10));
        box.add(jbt3);
        box.add(Box.createVerticalStrut(10));
        box.add(jbt4);
       p1.add(box);

        f.add(panel,BorderLayout.LINE_START);

        f.add(p1,BorderLayout.CENTER);
        f.setSize(800, 500);
        f.setVisible(true);
    }
    public Box BoxTest(){
        Box box = Box.createVerticalBox();
        box.add(jbt1);
        box.add(jbt2);
        box.add(jbt3);
        box.add(jbt4);

        return box;
    }
    public static void main(String[] args) {
        new Interface();
    }
}

