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
                d.setSize(400,400);
                JLabel type=new JLabel("type:");
                type.setBounds(0,0,80,20);
                d.setLayout(null);
                d.add(type);
                JLabel service=new JLabel("service:");
                service.setBounds(0,20,80,20);
                JLabel capacity=new JLabel("capacity:");
                capacity.setBounds(0,40,80,20);

                JLabel range=new JLabel("range:");
                range.setBounds(0,60,80,20);
                JLabel position=new JLabel("position:");
                position.setBounds(0,80,80,20);


                JLabel typesensor=new JLabel("typeSensor:");
                typesensor.setBounds(0,100,80,20);
                d.add(service);
                d.add(capacity);
                d.add(range);
                d.add(position);
                d.add(typesensor);

                String TypeSensor[]={"Base","Router"};
                JComboBox comboBox =new JComboBox(TypeSensor);
                comboBox.setBounds(80,100,200,20);
                d.add(comboBox);
                JTextField typet=new JTextField();
                typet.setBounds(80,0,200,20);
                d.add(typet);
                JTextField servicet=new JTextField();
                servicet.setBounds(80,20,200,20);
                d.add(servicet);
                JTextField capacityt=new JTextField();
                capacityt.setBounds(80,40,200,20);
                d.add(capacityt);

                JTextField ranget=new JTextField();
                ranget.setBounds(80,60,200,20);
                d.add(ranget);
                JTextField positiont=new JTextField();
                positiont.setBounds(80,80,200,20);
                d.add(positiont);
                JButton buttonadd =new JButton("add");
                buttonadd.setBounds(0,200,60,23);
                d.add(buttonadd);
                JButton b1=new JButton("cancel");
                b1.setBounds(70,200,80,23);
                d.add(b1);


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

