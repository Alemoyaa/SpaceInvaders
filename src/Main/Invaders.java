package Main;
/*
CLASE 01
*/

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Invaders extends Canvas{
    public static final int WIDTH = 800;//Largo
    public static final int HEIGHT = 600;//Alto
    
    public BufferedImage bicho = null;
    
    public Invaders(){
        JFrame ventana = new JFrame("Invaders");
        
        JPanel panel = (JPanel)ventana.getContentPane();
        setBounds(0, 0, WIDTH, HEIGHT);//Definimos tamaño de la ventana
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        panel.setLayout(null);//Al desactivar el layout debemos ingresar las coordenadas de las cosas que deseamos ponerle al panel
        panel.add(this);
        ventana.setBounds(0, 0, WIDTH, HEIGHT);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        
        ventana.addWindowListener(new WindowAdapter(){ //Con esto agregamos un evento para que cuando cerremos la ventana el programa se deje de ejecutar
            @Override
            public void windowClosing(WindowEvent e){//Este es el evento 
            System.exit(0);//Cierre el programa
            }
        });
    }
    
    public BufferedImage loadImage(String nombre){
        
        URL url=null; //Ni idea que hace 
        try{
            url = getClass().getClassLoader().getResource(nombre);//permite obtener una URL apuntando a un subdirectorio relativo al sitio del cual fue cargada la clase. Esto permite que nuestro programa funcione de forma transparente
            return ImageIO.read(url);
        } catch(Exception e){
            System.out.println("No se puedo carcar la imagen "+nombre+" de "+url);
            System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
            System.exit(0);
            return null;
        }
    }
    
    @Override
    public void paint(Graphics g){
        if(bicho == null) 
            bicho = loadImage("/src/res/bicho.gif");
        
        g.drawImage(bicho, 40, 40, this);
    }
    
    public static void main(String[] args){
        Invaders inv = new Invaders();
    }
}
