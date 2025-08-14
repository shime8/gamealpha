package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // opcje eranu
    final int originalTileSize = 16; // 16x16 płytki
    final int scale = 4;

    final int tileSize = originalTileSize * scale; //64x64
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 1024
    final int screenHeight = tileSize * maxScreenRow; // 768

    // FPS
    int FPS = 60;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //set players default position
    int playerX = 100;
    int playerY = 100;
    int playerspeed = 4;


    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }

@Override
public void run() {

    double drawInterval = (double) 1000000000 /FPS;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;
    long timer = 0;
    long drawCount = 0;

    while(gameThread != null){

        currentTime =  System.nanoTime();

        delta += (currentTime - lastTime) / drawInterval;
        timer += (currentTime - lastTime);
        lastTime = currentTime;

        if(delta >= 1){
            // 1.update
            update();
            // 2. draw on screen
            repaint();
            delta --;
            drawCount++;
        }
        if(timer>= 1000000000){
            if(drawCount<50){System.out.println("LOW FPS:"+drawCount);}
            drawCount = 0;
            timer = 0;
        }
    }
}

    public void update(){
        playerY -= keyH.upPressed ? playerspeed : 0;
        playerY += keyH.downPressed ? playerspeed : 0;
        playerX -= keyH.leftPressed ? playerspeed : 0;
        playerX += keyH.rightPressed ? playerspeed : 0;
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);

        g2.fillRect(playerX,playerY,tileSize, tileSize);

        g2.dispose();
    }
}
