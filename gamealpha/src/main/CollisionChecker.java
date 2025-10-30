package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }
    public void checkTile(Entity entity, int l){
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;
        try {
            if (entity.direction.y < 0) {
                entityTopRow = (entityTopWorldY + entity.stepY) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow][l];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow][l];
            } else {
                entityBottomRow = (entityBottomWorldY + entity.stepY) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow][l];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow][l];
            }
            if (entity.direction.y != 0 && (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)) {
                entity.collisionYOn = true;
            }
        }catch(Exception ignored){}
        try {
            if (entity.direction.x < 0) {
                entityLeftCol = (entityLeftWorldX + entity.stepX) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow][l];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow][l];
            } else {
                entityRightCol = (entityRightWorldX + entity.stepX) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow][l];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow][l];
            }
            if (entity.direction.x != 0 && (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)) {
                entity.collisionXOn = true;
            }
        }catch(Exception ignored){}
    }
}
