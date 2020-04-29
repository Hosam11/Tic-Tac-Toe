/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Hagar Diab
 */
public class EntryPoint extends Application {

    public static Stage myStage;

    SignInSceneBase signIn = new SignInSceneBase();
    //SignUpSceneBase signUp = new SignUpSceneBase();
   

    MediaPlaying mediaPlaying = new MediaPlaying();
    Thread th = new Thread(mediaPlaying);

    public EntryPoint() {
        th.start();
    }
    
    public static boolean soundPlay = true;

    public static Clip clip;

    static void changeSoundStatue(ImageView soundIcon) {
        if (EntryPoint.soundPlay) {
            soundIcon.setImage(new Image(EntryPoint.class.
                    getResource("../img/sound/sound_off.png").toExternalForm()));
            EntryPoint.soundPlay = false;
            EntryPoint.clip.stop();
            System.out.println("sound stop");
        } else {
            soundIcon.setImage(new Image(EntryPoint.class
                    .getResource("../img/sound/sound_icon.png").toExternalForm()));
            EntryPoint.soundPlay = true;
            EntryPoint.clip.start();
            System.out.println("sound play");
        }
    }

    static void changeSoundImage(ImageView soundIcon) {
        if (EntryPoint.soundPlay) {
            soundIcon.setImage(new Image(EntryPoint.class
                    .getResource("../img/sound/sound_icon.png").toExternalForm()));
        } else {
            soundIcon.setImage(new Image(EntryPoint.class
                    .getResource("../img/sound/sound_off.png").toExternalForm()));
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setMinHeight(560);
        stage.setMinWidth(600);
        Parent root = signIn;
        myStage = stage;
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    class MediaPlaying implements Runnable {

        @Override
        public void run() {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    // Music  a =new Music();
                    try {
                        URL inurl = this.getClass().getResource("/music/bgm.wav");
                        clip = AudioSystem.getClip();
                        clip.open(AudioSystem.getAudioInputStream(inurl));
                        clip.start();
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                    } catch (Exception e) {
                        Logger.getLogger(EntryPoint.class.getName()).log(Level.SEVERE, null, e);
                        System.out.println("error");
                    }
                }
            });

        }

    }

}
