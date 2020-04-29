/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardlevel;

import javafx.scene.control.Button;

/**
 *
 * @author Eman
 */
public class Evaluation {

   public static int evaluate(Button b[][]) {
       
        for (int row = 0; row < 3; row++) {
            if (b[row][0].getText().equals(b[row][1].getText()) && b[row][1].getText().equals(b[row][2].getText())) {
                switch (b[row][0].getText()) {
                    case "X":
                        return 10;
                    case "O":
                        return -10;
                }
            }
        }

        for (int col = 0; col < 3; col++) {
            if (b[0][col].getText().equals(b[1][col].getText()) && b[1][col].getText().equals(b[2][col].getText())) {
                switch (b[0][col].getText()) {
                    case "X":
                        return 10;
                    case "O":
                        return -10;
                }
            }
        }

        if (b[0][0].getText().equals(b[1][1].getText()) && b[1][1].getText().equals(b[2][2].getText())) {
            switch (b[0][0].getText()) {
                case "X":
                    return 10;
                case "O":
                    return -10;
            }
        }

        if (b[0][2].getText().equals(b[1][1].getText()) && b[1][1].getText().equals(b[2][0].getText())) {
            switch (b[0][2].getText()) {
                case "X":
                    return 10;
                case "O":
                    return -10;
            }
        }
        return 0;
    }


    
}


