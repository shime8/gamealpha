package main;

import UI.BaseUI;
import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // opcje eranu
    final int originalTileSize = 16; // 16x16 płytki
    final int scale = 4;

    public int tileSize = originalTileSize * scale; //64x64
    public int maxScreenCol = 16;
    public int maxScreenRow = 12;
    public int screenWidth = tileSize * maxScreenCol; // 1024
    public int screenHeight = tileSize * maxScreenRow; // 768

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    // FPS
    int FPS = 60;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this,keyH);
    TileManager tileM = new TileManager(this);
    public CollisionChecker cChecker = new CollisionChecker(this);

    BaseUI inventory = new BaseUI( this, keyH, new Rectangle(screenWidth/4, screenHeight/4, screenWidth/2, screenHeight/2), Color.darkGray);

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
            delta--;
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
        player.update();
    }


    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);
        player.draw(g2);
        player.drawHitbox(g2);
        if(keyH.ePressed){inventory.draw(g2);}
        g2.dispose();
    }
}
