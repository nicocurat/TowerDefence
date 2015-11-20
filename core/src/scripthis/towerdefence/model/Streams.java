package scripthis.towerdefence.model;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by mariano chiang on 20/11/2015.
 */
public class Streams {
    private Game game;

    public Streams(Game game){
        this.game = game;
    }

        public void writeFile(){
            BufferedWriter writer = null;
            try{
                String string = "High Score";
                File logFile = new File(string);
                writer = new BufferedWriter(new FileWriter(logFile));
                writer.write("High Score: " + score());
            } catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    writer.close();
                }catch(Exception e){

                }
            }
        }

    public String score(){
        return "" + game.getScore()*1000 + "";
    }
}
