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
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Invaders extends Canvas {
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	public HashMap sprites;
	public int posX,posY;
	
	public Invaders() {
		sprites = new HashMap();
		posX = WIDTH/2;
		posY = HEIGHT/2;
		
		JFrame ventana = new JFrame("Invaders");
		JPanel panel = (JPanel)ventana.getContentPane();
		setBounds(0,0,WIDTH,HEIGHT);
		panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		panel.setLayout(null);
		panel.add(this);
		ventana.setBounds(0,0,WIDTH,HEIGHT);
		ventana.setVisible(true);
		ventana.addWindowListener( new WindowAdapter() {
                        @Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		ventana.setResizable(false);
	}
	
	public BufferedImage loadImage(String nombre) {
		URL url=null;
		try {
			url = getClass().getClassLoader().getResource(nombre);
			return ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("No se pudo cargar la imagen " + nombre +" de "+url);
			System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
			System.exit(0);
			return null;
		}
	}
	
	public BufferedImage getSprite(String nombre) {
		BufferedImage img = (BufferedImage)sprites.get(nombre);
		if (img == null) {
			img = loadImage("res/"+nombre);
			sprites.put(nombre,img);
		}
		return img;
	}
	
	
        @Override
	public void paint(Graphics g) {
		g.drawImage(getSprite("bicho.gif"), posX, posY,this);
	}
	
	public void updateWorld() {
		posX = (int)(Math.random()*WIDTH);
		posY = (int)(Math.random()*HEIGHT);
	}
	
	public void game() {
		while (isVisible()) {
			updateWorld();
			paint(getGraphics());
		}
	}
	
	public static void main(String[] args) {
		Invaders inv = new Invaders();
		inv.game();
	}
}

