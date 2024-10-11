package com.simple.snakegame;
import java.awt.Color;	
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

@SuppressWarnings({ "serial", "unused" })
public class Panel1 extends JPanel implements ActionListener {
	
	
	static final int SCREEN_WIDTH=600;
	static final int SCREEN_HEIGHT=600;
	static final int UNIT_SIZE=25;
	static final int GAME_UNITS= (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	static  int DELAY=75;
	final int x[]= new int[  GAME_UNITS ];
	final int y[]= new int[  GAME_UNITS ];
	int bodyParts=6;
	int applesEaten=0;
	int applex;
	int appley;
	char direction='R';
	boolean running= true;
	Timer timer;
	Random random;
	
	 int x1 = SCREEN_WIDTH/3;
	 int y1 = (SCREEN_HEIGHT/2)+100;
	 int squareW = 45;
	 int squareH = 210;
	
	Graphics n2;
	
	 
	
	
	
	Panel1()
	{
		random = new Random();
		this.addKeyListener(new MyKeyAdapter());
		//this.setPreferredSize(new Dimension(  SCREEN_WIDTH,SCREEN_HEIGHT ));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
		this.setPreferredSize(new Dimension( SCREEN_WIDTH,SCREEN_HEIGHT  ));
		startGame();
	}
	
	
//	public Dimension getPreferredSize() 
//	{
//        return new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT);
//    }
	
	public void reset()
	{
		 x[0]=300;
		 y[0]=300;
//		timer=(1000,  );
		 
		startGame();
		if(DELAY==0)
		{
			DELAY+=999999999;
		}
		
	}
	
	
	public void startGame( )
	{
//		DELAY=d;
		newApple();
		running = true;
		timer= new Timer( DELAY, this  );
		timer.start();
//		newApple();
		System.out.println("no error1");
		
	}
	
	
	
	 public void paintComponent(Graphics g) 
	 {
	        super.paintComponent(g);       
//	        g.setColor(Color.PINK);
	        // Draw Text
//	        g.drawString("This is my custom Panel!",30,40);
	        draw(g);
	 }
	 

	 public void draw( Graphics g)
	{
		 if(running)
			 
			 
		 {
			 
			 
//		System.out.println("no error3");
		
		g.setColor(Color.red);
//		g.drawString("This is my custom Panel!",10,20);
		for( int i =0; i<(SCREEN_HEIGHT/UNIT_SIZE);i++)
		{
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
			g.drawLine(0,i*UNIT_SIZE, i*SCREEN_WIDTH, i*UNIT_SIZE);
//			System.out.println("no error4");
//			g.drawString("helo", i*15, i*15);
			g.setColor(Color.red);
			
		}
		
		
//		newApple();
		g.fillOval(applex, appley, UNIT_SIZE, UNIT_SIZE);
		
		for(int i=0; i<bodyParts; i++)
		{
			 
			if(i==0)
			{
				g.setColor(Color.red);
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				
			}
			else
			{
				g.setColor(  new Color(  random.nextInt(255),random.nextInt(255),random.nextInt(255)  ));
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
			
			Font f=new Font("Ink Free", Font.BOLD, 35);
			 g.setColor(Color.red);
			 g.setFont(f);
			 FontMetrics metrics= getFontMetrics(g.getFont());
			 g.drawString("Score :"+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score :"+applesEaten))/2, SCREEN_HEIGHT/20 );
				
				
		}
		 }
		 else {
			 gameOver(g);
		 }
		
	}
	 
	 
	 
	 public void newApple()
	 {
//		 for(  int a=0; a<4;a++ )
	    {
			applex = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
			appley = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
		}
	 }
	 
	 public void move()
	 {
		 for(int i =bodyParts;i>0;i-- )
		 {
			 x[i]=x[i-1];
			 y[i]=y[i-1];
			 
		 }
		 switch(direction)
		 {
		 case 'U':
			 y[0]=y[0]-UNIT_SIZE;
			 break;
		 case 'D':
			 y[0]=y[0]+UNIT_SIZE;
			 break;
		 case 'L':
		 	 x[0]=x[0]-UNIT_SIZE;
		  	 break;
		 case 'R':
			 x[0]=x[0]+UNIT_SIZE;
			 break;
		 }
		 
		 
	 }
	 
	 
	 public void checkApple() 
	    {
		 if((   x[0]== applex && y[0]==appley  ))
		 {
			 bodyParts+=3;
			 applesEaten++;
			 newApple();
		 }
			
		 
		}
	 
	 
	 public void checkCollision()
	 {
		 for( int i=bodyParts; i>0;i--)
		 {   
			 if(x[0]==x[i]  && y[0] ==y[i])
			 {
				 running = false;
			 }
		 }
		 if(x[0]<0)
		 {
			 running =false;
		 }
		 if(y[0]<0)
		 {
			 running =false;
		 }
		 if(x[0]> SCREEN_WIDTH)
		 {
			 running =false;
		 }
		 if(y[0]> SCREEN_HEIGHT)
		 {
			 running =false;
		 }
		 if(running==false)
		 {
			 timer.stop();
		 }
	 }
	 
	 
	 
	 
	 public void gameOver(Graphics g) 
	 {
		 Font f=new Font("Ink Free", Font.BOLD, 75);
		 g.setColor(Color.red);
		 g.setFont(f);
		 FontMetrics metrics1= getFontMetrics(g.getFont());
		 g.drawString("GAME OVER", (SCREEN_WIDTH - metrics1.stringWidth("GEME OVER"))/2, SCREEN_HEIGHT/2 );
			
		 Font f1=new Font("Ink Free", Font.BOLD, 35);
		 g.setColor(Color.red);
		 g.setFont(f1);
		 FontMetrics metrics2= getFontMetrics(g.getFont());
		 g.drawString("Score :"+applesEaten, (SCREEN_WIDTH - metrics2.stringWidth("Score :"+applesEaten))/2, SCREEN_HEIGHT/20 );
		
		 
		
//		 JButton b= new JButton( "plAy @gEn?? " );
		 playAgain(g);
		 
		 
		}
//	 Font f1=new Font("Ink Free", Font.BOLD, 35);
	 
	 JButton b= new JButton( "Play again " );
//	 b.setVisible(false);
	 
	 public void playAgain(Graphics g )
	 {
//		 JButton b= new JButton( "plAy @gEn?? " );
//		 JButton b= new JButton( "plAy @gEn?? " );
		   b.setBounds(x1+5,y1+5,squareH-10,squareW-10);
//		   Frame1 f= new Frame1();
		   this.add(b);  
//		   this.setSize(400,400);  
		   this.setLayout(null);  
//		   this.setVisible(false);
		 
		 g.setColor( new Color(  random.nextInt(255),random.nextInt(255),random.nextInt(255)  ));
//		 setBorder(BorderFactory.createLineBorder( new Color(  random.nextInt(255),random.nextInt(255),random.nextInt(255)  ),3));
		
	        g.fillRect(x1,y1,squareH,squareW);
	        g.setColor(Color.BLACK);
	       g.drawRect(x1,y1,squareH,squareW);
//	        g.setColor(Color.yellow);
//			 g.drawString("plAy @gEn?? ",x1,y1+30);
			 
			 
			  
			    
//		 repaint()   ;
	        
		 
	 }
	 
	 
	 
	 
	 
	 
	 @Override
	public void actionPerformed(ActionEvent e)
	 {
		 if(running)
		 {
			 move();
			 checkApple();
			 checkCollision();
			 
	     }
		 repaint();
		
		 b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					reset();
					
				}
			});  
		
		
	}
	 
	 
	 
	 public class MyKeyAdapter extends KeyAdapter
	 {
		 public void keyPressed(KeyEvent e)
		 {
		 switch(e.getKeyCode())
		 {
		 case KeyEvent.VK_LEFT:
			 if(direction!='R')
			 {
				 direction = 'L';
			 }
			 break;
		 case KeyEvent.VK_RIGHT:
			 if(direction!='L')
			 {
				 direction='R';
				 
			 }
			 break;
			 
		 case KeyEvent.VK_UP:
		 	 if(direction!='D')
		 	 {
		 		 direction='U';
		 	 }
		 	 break;
		 case KeyEvent.VK_DOWN:
			 if(direction!='U')
			 {
				 direction='D';
				 
			 }
			 break;
			 
		 
		 
		 }
		 
		 
		 
		 
		 
	 }
	 
		 
		 
	 }


	 
				
	   
      
	 
    
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
