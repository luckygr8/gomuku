/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maingui;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author lakshay
 */
public class Music {

    //public static final File BUTTON_CLICK_SOUND = new File("\\Extragui\\maingui/button.wav");
    public static final File x_SOUND = new File("music/X_SOUND.wav");
    public static final File O_SOUND = new File("music/O_SOUND.wav");
    public static final File SONG1 = new File("music/song1.wav");  
    public static final File LOGIN = new File("music/alogin.wav");
    public static final File WIN= new File("music/win.wav");
    public static AudioInputStream ais;
    private static Clip c;
    public static void playSong(File file) {
        
            new Thread(new Runnable() {

                @Override
                public void run() {
                       try {
            ais = AudioSystem.getAudioInputStream(file.getAbsoluteFile());
            c = AudioSystem.getClip();
            c.open(ais);
            c.start();
           // c.loop(c.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
                }
            }).start();
    }
    
    public static void stop()
    {
        c.stop();
        c.close();
    }
}
