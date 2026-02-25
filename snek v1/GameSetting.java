public class GameSetting {
    private int rSPRITE_SIZE = 10;        
    private int rGAME_WIDTH = 70;    
    private int rGAME_HEIGHT = 80;     
    private int rSCREEN_WIDTH = rGAME_WIDTH * rSPRITE_SIZE;    
    private int rSCREEN_HEIGHT = rGAME_HEIGHT * rSPRITE_SIZE;   
    private int rGAME_DELAY = 100;   

    public void setSize(int newSpriteSize) {
        rSPRITE_SIZE = newSpriteSize;
    }
    
    public void setDelay(int newDelay) {
        rGAME_DELAY = newDelay;
    }

    public int getSS() {
        return rSPRITE_SIZE;
    }
    public int getGW() {
        return rGAME_WIDTH;
    }
    public int getGH() {
        return rGAME_HEIGHT;
    }
    public int getSW() {
        return rSCREEN_WIDTH;
    }
    public int getSH() {
        return rSCREEN_HEIGHT;
    }
    public int getGD() {
        return rGAME_DELAY;
    }
}
