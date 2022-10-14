import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

    public class Converter extends JFrame {
        private JComboBox input, output;
        private JTextField infoBlocs[];

        public Converter() {
            setTitle("Temperature Converter");
            setSize(250, 250);
            startFunc();
            setVisible(true);
        }

        private void startFunc() {
            setLayout(new FlowLayout(FlowLayout.CENTER));
            infoBlocs = new  JTextField[2];
            for(int i = 0; i < infoBlocs.length; i++){
                infoBlocs[i] = new JTextField();
                infoBlocs[i].setPreferredSize(new Dimension(100,50));
            }
            infoBlocs[1].setEditable(false);
            String temps[] = {"Celsius", "Fahrenheit", "Kelvin"};
            input = new JComboBox(temps);
            output = new JComboBox(temps);
            Container c = new Container();
            c.setLayout(new GridLayout(2, 2));
            JButton conversor = new JButton("Ver temperatura");
            conversor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        float a = Float.parseFloat(infoBlocs[0].getText());
                        int b = input.getSelectedIndex();
                        int c = output.getSelectedIndex();
                        if(b == c)
                            infoBlocs[1].setText(a + "");
                        else if(b == 0 && c == 1)
                            infoBlocs[1].setText((a * 1.8 + 32) + "");
                        else if(b == 0 && c == 2)
                            infoBlocs[1].setText((a + 273.15) + "");
                        else if(b == 1 && c == 0)
                            infoBlocs[1].setText(((a - 32) / 1.8) + "");
                        else if(b == 1 && c == 2)
                            infoBlocs[1].setText(((a - 32) / 1.8 + 273.15) + "");
                        else if(b == 2 && c == 0)
                            infoBlocs[1].setText((a - 273.15) + "");
                        else if(b == 2 && c == 1)
                            infoBlocs[1].setText((a - 273.15 - 32)/1.8 + "");
                    } catch (NumberFormatException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            c.add(new JLabel("From"));
            c.add(input);
            c.add(new JLabel("to"));
            c.add(output);
            add(infoBlocs[0]);
            add(c);
            add(conversor);
            add(infoBlocs[1]);
        }
    }
