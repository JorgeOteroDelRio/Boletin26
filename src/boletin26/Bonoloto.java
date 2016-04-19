
package boletin26;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
/**
 *
 * @author jota
 */
public class Bonoloto extends JFrame implements ActionListener{
    
    private JPanel lienzo;
    private JLabel aciertos,nSalidos;
    private JButton comprobar;
    private JComboBox opcion1,opcion2,opcion3,opcion4,opcion5,opcion6;
    
    public Bonoloto(){
        initComponents();
    }
    
    private void initComponents(){
        lienzo=new JPanel(new GridLayout(3,2,20,20));
        lienzo.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        aciertos=new JLabel();
        nSalidos=new JLabel();
        Vector modelo = new Vector();
        for(int i = 1;i<=49;i++){
            modelo.add(i);
        }
        opcion1=new JComboBox(modelo);
        opcion2=new JComboBox(modelo);    
        opcion3=new JComboBox(modelo);
        opcion4=new JComboBox(modelo);
        opcion5=new JComboBox(modelo);
        opcion6=new JComboBox(modelo);
        comprobar=new JButton("Comprobar");
        comprobar.addActionListener(this);
        lienzo.add(opcion1);
        lienzo.add(opcion2);
        lienzo.add(opcion3);
        lienzo.add(opcion4);
        lienzo.add(opcion5);
        lienzo.add(opcion6);
        lienzo.add(comprobar);
        lienzo.add(nSalidos);
        lienzo.add(aciertos);
        add(lienzo);
        this.setBounds(400, 150, 500, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bonoloto");
        this.setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nSalidos.setText("");
        int[] nEscogidos = new int[6];
        int[] numAleatorio = generarEnteros(6);
        nEscogidos[0]=opcion1.getSelectedIndex()+1;
        nEscogidos[1]=opcion2.getSelectedIndex()+1;
        nEscogidos[2]=opcion3.getSelectedIndex()+1;
        nEscogidos[3]=opcion4.getSelectedIndex()+1;
        nEscogidos[4]=opcion5.getSelectedIndex()+1;
        nEscogidos[5]=opcion6.getSelectedIndex()+1;
        int count=0;
        for(int i=0;i<numAleatorio.length;i++){
            nSalidos.setText(nSalidos.getText()+String.valueOf(numAleatorio[i]));
            for(int j=0;j<nEscogidos.length;j++){
                if(nEscogidos[j]==numAleatorio[i]){
                    count++;
                }
            }
            if(i<5){
                nSalidos.setText(nSalidos.getText()+",");
            }
        }
        
        aciertos.setText(String.valueOf("Aciertos: "+ count));
        
    }
    
    private int[] generarEnteros(int tamanho){
        int[] numeros = new int[tamanho];
        for(int i=0;i<numeros.length;i++){
            numeros[i]=(int)Math.floor(Math.random()*(1-49)+49);
        }
        return numeros;
    }

    
    
    
}
