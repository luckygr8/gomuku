/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maingui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import player.Player;
import player.Side_fields;
import player.button;

/**
 *
 * @author lakshay
 */
public class Playpanel extends javax.swing.JPanel implements ActionListener {

    /**
     * Creates new form
     *
     */
   
    private maingui.Mainframe ref;
    
    private Side_fields temp;
    private int leftDiagnolx, rightDiagnolx, horizontalx, verticalx, leftDiagnolo, rightDiagnolo, horizontalo, verticalo;
    private Side_fields[] SF;
    private Music m;

    void increment(char pawn, String name) {
        if (pawn == 'x') {
            switch (name) {
                case "ULC":
                case "LRC":
                    leftDiagnolx++;
                    return;
                case "URC":
                case "LLC":
                    rightDiagnolx++;
                    return;
                case "UV":
                case "LV":
                    verticalx++;
                    return;
                case "LH":
                case "RH":
                    horizontalx++;
                    return;
            }
        } else {
            switch (name) {
                case "ULC":
                case "LRC":
                    leftDiagnolo++;
                    return;
                case "URC":
                case "LLC":
                    rightDiagnolo++;
                    return;
                case "UV":
                case "LV":
                    verticalo++;
                    return;
                case "LH":
                case "RH":
                    horizontalo++;
                    return;
            }
        }
    }

    Playpanel(maingui.Mainframe aThis) {
        this();
        ref = aThis;

        p1 = new Player();
        p2 = new Player();
        p1.setName(ref.getN1());
        p2.setName(ref.getN2());

        p1.setPawn('x');
        p2.setPawn('o');
        p1.setTurn(true);
        p2.setTurn(false);
        CURRENT = p1;
    }

    public void reinitializex_fields() {
        leftDiagnolx = rightDiagnolx = horizontalx = verticalx = 1;
    }

    public void reinitializeo_fields() {
        leftDiagnolo = rightDiagnolo = horizontalo = verticalo = 1;
    }

    public void reinitialize_side_fields() {

        for (int i = 0; i < 8; i++) {
            SF[i].setX(0);
            SF[i].setY(0);

        }
    }
    private player.Player p1, p2, CURRENT;
    private static button[][] arr;

    public Player update_turn() {
        if (p1.isTurn()) {
            p1.setTurn(false);
            p2.setTurn(true);
            return p2;
        } else {
            p1.setTurn(true);
            p2.setTurn(false);
            return p1;
        }
    }
    private int UPPER_BOUND = 20, LOWER_BOUND = 1;

    boolean check_if_sidefield_exists(Side_fields s, String field_name) {

        button b = arr[s.getX() - 1][s.getY() - 1];
        switch (field_name) {

            case "ULC":
                if (s.getX() == LOWER_BOUND || s.getY() == LOWER_BOUND || b.isEnabled()) {
                    return false;
                }
                return true;
            case "LRC":
                if (s.getX() == UPPER_BOUND || s.getY() == UPPER_BOUND || b.isEnabled()) {
                    return false;
                }
                return true;
            case "URC":
                if (s.getX() == LOWER_BOUND || s.getY() == UPPER_BOUND || b.isEnabled()) {
                    return false;
                }
                return true;
            case "LLC":
                if (s.getX() == UPPER_BOUND || s.getY() == LOWER_BOUND || b.isEnabled()) {
                    return false;
                }
                return true;
            case "UV":
                if (s.getX() == LOWER_BOUND || b.isEnabled()) {
                    return false;
                }
                return true;
            case "LV":
                if (s.getX() == UPPER_BOUND || b.isEnabled()) {
                    return false;
                }
                return true;
            case "LH":
                if (s.getY() == LOWER_BOUND || b.isEnabled()) {
                    return false;
                }
                return true;
            case "RH":
                if (s.getY() == UPPER_BOUND || b.isEnabled()) {
                    return false;
                }
                return true;
        }
        return false;
    }

    public Playpanel() {
       /* try {

            ImageIcon icons = new ImageIcon(getClass().getResource("/Extragui/wood.jpg"));

            backimage = icons.getImage();

        } catch (Exception ex) {
        }*/
        initComponents();
        setSize(1000, 805);

        setLayout(new GridLayout(20, 20, 1, 1));
        arr = new button[20][20];
        SF = new Side_fields[8];

        setVisible(true);

        for (int i = 0; i < 8; i++) {
            SF[i] = new Side_fields();
        }
        temp = new Side_fields();
        SF[0].setName("ULC");
        SF[1].setName("UV");
        SF[2].setName("URC");
        SF[3].setName("LH");
        SF[4].setName("LV");
        SF[5].setName("LLC");
        SF[6].setName("RH");
        SF[7].setName("LRC");

        for (int i = 0; i < 20; i++)// x cords
        {
            for (int j = 0; j < 20; j++)// y cords
            {
                arr[i][j] = new button();

                arr[i][j].setXcord(i + 1);
                arr[i][j].setYcord(j + 1);
                arr[i][j].setActionCommand(Integer.toString(i + 1) + "-" + Integer.toString(j + 1));
                arr[i][j].setFont(new Font("Arial", Font.BOLD, 35));
                arr[i][j].addActionListener(this);
                add(arr[i][j]);
            }
        }

    }

    boolean if_following_side_field_has_same_pawn(Side_fields s, char pawn) {
        button b = arr[s.getX() - 1][s.getY() - 1];
        if (!b.isEnabled()) {
            if (b.getText().charAt(0) == (pawn)) {

                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void actionPerformed(ActionEvent e) {

        play_button_sound(CURRENT.getPawn());
        button t = (button) e.getSource();
        t.setEnabled(false);
        t.setText(Character.toString(CURRENT.getPawn()));
        reinitialize_side_fields();
        temp.setX(t.getXcord());
        temp.setY(t.getYcord());
        temp.setName(CURRENT.getName());
        reinitializeo_fields();
        reinitializex_fields();
        check_for_wins(temp, CURRENT.getPawn());
        CURRENT = update_turn();
        ref.getCurrent_turn().setText("CURRENT TURN : " + CURRENT.getName() + " (" + CURRENT.getPawn() + " )");

    }

    void play_button_sound(char pawn) {
        if (pawn == 'o') {
            m.playSong(m.O_SOUND);
        } else {
            m.playSong(m.x_SOUND);
        }
    }

    boolean variable_check(char pawn, String name) {
        if (pawn == 'x') {
            if (name == "ULC" || name == "LRC") {
                if (leftDiagnolx >= 5) {
                    return true;
                }
            }
            if (name == "URC" || name == "LLC") {
                if (rightDiagnolx >= 5) {
                    return true;
                }
            }
            if (name == "LV" || name == "UV") {
                if (verticalx >= 5) {
                    return true;
                }
            }
            if (name == "RH" || name == "LH") {
                if (horizontalx >= 5) {
                    return true;
                }
            }
        } else {
            if (name == "ULC" || name == "LRC") {
                if (leftDiagnolo >= 5) {
                    return true;
                }
            }
            if (name == "URC" || name == "LLC") {
                if (rightDiagnolo >= 5) {
                    return true;
                }
            }
            if (name == "LV" || name == "UV") {
                if (verticalo >= 5) {
                    return true;
                }
            }
            if (name == "RH" || name == "LH") {
                if (horizontalo >= 5) {
                    return true;
                }
            }
        }
        return false;
    }

    void check_sidefields(Side_fields pos, char pawn, String name) {
        Side_fields temp = pos;
        if (check_if_sidefield_exists(temp, name)) {
            temp = get_side_fields(name, temp);
            if (if_following_side_field_has_same_pawn(temp, pawn)) {
                increment(pawn, name);

            }
            if (check_if_sidefield_exists(temp, name)) {
                temp = get_side_fields(name, temp);
                if (if_following_side_field_has_same_pawn(temp, pawn)) {
                    increment(pawn, name);

                }
                if (check_if_sidefield_exists(temp, name)) {
                    temp = get_side_fields(name, temp);
                    if (if_following_side_field_has_same_pawn(temp, pawn)) {
                        increment(pawn, name);

                    }
                    if (check_if_sidefield_exists(temp, name)) {
                        temp = get_side_fields(name, temp);
                        if (if_following_side_field_has_same_pawn(temp, pawn)) {
                            increment(pawn, name);

                        }
                    }

                }

            }

        }

        if (variable_check(pawn, name)) {
            m.playSong(m.WIN);
            JOptionPane.showMessageDialog(ref, temp.getName() + " with pawn " + pawn + " wins the game");
            System.exit(1);
        }
    }

    void check_for_wins(Side_fields pos, char pawn) {
        check_sidefields(pos, pawn, "ULC");
        check_sidefields(pos, pawn, "LRC");
        check_sidefields(pos, pawn, "URC");
        check_sidefields(pos, pawn, "LLC");
        check_sidefields(pos, pawn, "UV");
        check_sidefields(pos, pawn, "LV");
        check_sidefields(pos, pawn, "RH");
        check_sidefields(pos, pawn, "LH");
    }

    /**
     * @deprecated @param temp
     * @deprecated
     *
     * the below given method was once used for in game testing and now is not
     * functional now
     */
    /*void check_for_win(Side_fields pos, char pawn) {
     Side_fields temp = pos;
     //testing(temp);
     //  System.out.println(pos.getX()+"-"+pos.getY());
     if (check_if_sidefield_exists(temp, "ULC")) {
     temp = get_side_fields("ULC", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "ULC");
     // System.out.println("yes"+" "+pawn);
     }
     if (check_if_sidefield_exists(temp, "ULC")) {
     temp = get_side_fields("ULC", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "ULC");
     //  System.out.println("yes"+" "+pawn);
     }
     if (check_if_sidefield_exists(temp, "ULC")) {
     temp = get_side_fields("ULC", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "ULC");
     //   System.out.println("yes"+" "+pawn);
     }
     if (check_if_sidefield_exists(temp, "ULC")) {
     temp = get_side_fields("ULC", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "ULC");
     //    System.out.println("yes"+" "+pawn);
     }
     }
     //else return;
     }
     // else return;
     }
     //else return;
     }
     // else return;
     if (variable_check(pawn, "ULC")) {
     m.playSong(m.WIN);
     JOptionPane.showMessageDialog(ref, pos.getName() + " with pawn " + pawn + " wins the game");
     System.exit(1);
     }
     temp=pos;
     if (check_if_sidefield_exists(temp, "LRC")) {
     temp = get_side_fields("LRC", temp);
           
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LRC");
     // System.out.println("yesa"+" "+pawn);
     }
     if (check_if_sidefield_exists(temp, "LRC")) {
     temp = get_side_fields("LRC", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LRC");
     //    System.out.println("yesa"+" "+pawn);
     }
     if (check_if_sidefield_exists(temp, "LRC")) {
     temp = get_side_fields("LRC", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LRC");
     //    System.out.println("yesa"+" "+pawn);
     }
     if (check_if_sidefield_exists(temp, "LRC")) {
     temp = get_side_fields("LRC", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LRC");
     // System.out.println("yesa"+" "+pawn);
     }
     }
     // else return;
     }
     // else return;
     }
     // else return;
     }
     // else return;
     if (variable_check(pawn, "LRC")) {
     m.playSong(m.WIN);
     JOptionPane.showMessageDialog(ref, pos.getName() + " with pawn " + pawn + " wins the game");
     System.exit(1);
     }
     // System.out.println(pawn+" o  "+leftDiagnolo+" x  "+leftDiagnolx);

     temp = pos;
     if (check_if_sidefield_exists(temp, "URC")) {
     temp = get_side_fields("URC", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "URC");
     //System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "URC")) {
     temp = get_side_fields("URC", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "URC");
     // System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "URC")) {
     temp = get_side_fields("URC", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "URC");
     // System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "URC")) {
     temp = get_side_fields("URC", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "URC");
     //  System.out.println("yes");
     }
     }
     ///  else return;
     }
     //   else return;
     }
     //   else return;
     }
     if (variable_check(pawn, "URC")) {
     m.playSong(m.WIN);
     JOptionPane.showMessageDialog(ref, pos.getName() + " with pawn " + pawn + " wins the game");
     System.exit(1);
     }

     temp = pos;
     if (check_if_sidefield_exists(temp, "LLC")) {
     temp = get_side_fields("LLC", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LLC");
     //System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "LLC")) {
     temp = get_side_fields("LLC", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LLC");
     // System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "LLC")) {
     temp = get_side_fields("LLC", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LLC");
     // System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "LLC")) {
     temp = get_side_fields("LLC", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LLC");
     //  System.out.println("yes");
     }
     }
     //  else return;
     }
     //  else return;
     }
     //   else return;
     }
     if (variable_check(pawn, "LLC")) {
     m.playSong(m.WIN);
     JOptionPane.showMessageDialog(ref, pos.getName() + " with pawn " + pawn + " wins the game");
     System.exit(1);
     }

     temp = pos;
     if (check_if_sidefield_exists(temp, "UV")) {
     temp = get_side_fields("UV", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "UV");
     //System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "UV")) {
     temp = get_side_fields("UV", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "UV");
     // System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "UV")) {
     temp = get_side_fields("UV", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "UV");
     // System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "UV")) {
     temp = get_side_fields("UV", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "UV");
     //  System.out.println("yes");
     }
     }
     //    else return;
     }
     //    else return;
     }
     //   else return;
     }
     if (variable_check(pawn, "UV")) {
     m.playSong(m.WIN);
     JOptionPane.showMessageDialog(ref, pos.getName() + " with pawn " + pawn + " wins the game");
     System.exit(1);
     }

     temp = pos;
     if (check_if_sidefield_exists(temp, "LV")) {
     temp = get_side_fields("LV", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LV");
     //System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "LV")) {
     temp = get_side_fields("LV", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LV");
     // System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "LV")) {
     temp = get_side_fields("LV", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LV");
     // System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "LV")) {
     temp = get_side_fields("LV", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LV");
     //  System.out.println("yes");
     }
     }
     //      else return;
     }
     //    else return;
     }
     //  else return;
     }
     if (variable_check(pawn, "LV")) {
     m.playSong(m.WIN);
     JOptionPane.showMessageDialog(ref, pos.getName() + " with pawn " + pawn + " wins the game");
     System.exit(1);
     }

     temp = pos;
     if (check_if_sidefield_exists(temp, "RH")) {
     temp = get_side_fields("RH", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "RH");
     //System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "RH")) {
     temp = get_side_fields("RH", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "RH");
     // System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "RH")) {
     temp = get_side_fields("RH", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "RH");
     // System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "RH")) {
     temp = get_side_fields("RH", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "RH");
     //  System.out.println("yes");
     }
     }
     //    else return;
     }
     // else return;
     }
     //  else return;
     }
     if (variable_check(pawn, "RH")) {
     m.playSong(m.WIN);
     JOptionPane.showMessageDialog(ref, pos.getName() + " with pawn " + pawn + " wins the game");
     System.exit(1);
     }

     temp = pos;
     if (check_if_sidefield_exists(temp, "LH")) {
     temp = get_side_fields("LH", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LH");
     //System.out.println("yes");
     }
     if (check_if_sidefield_exists(temp, "LH")) {
     temp = get_side_fields("LH", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LH");
     // System.out.println("yes"); 
     }
     if (check_if_sidefield_exists(temp, "LH")) {
     temp = get_side_fields("LH", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LH");

     }
     if (check_if_sidefield_exists(temp, "LH")) {
     temp = get_side_fields("LH", temp);
     if (if_following_side_field_has_same_pawn(temp, pawn)) {
     increment(pawn, "LH");

     }
     }
     }
     }
     }
     if (variable_check(pawn, "LH")) {
     m.playSong(m.WIN);
     JOptionPane.showMessageDialog(ref, pos.getName() + " with pawn " + pawn + " wins the game");
     System.exit(1);
     }
     }*/
    @Deprecated// this method was used for in-game testing purposes only//
    void testing(Side_fields temp) {
        System.out.println(temp.getX() + "--" + temp.getY());
        System.out.println("ulc :" + check_if_sidefield_exists(temp, "ULC") + get_side_fields("ULC", temp).getX() + "--" + get_side_fields("ULC", temp).getY());
        System.out.println("uv :" + check_if_sidefield_exists(temp, "UV") + get_side_fields("UV", temp).getX() + "--" + get_side_fields("UV", temp).getY());
        System.out.println("URC :" + check_if_sidefield_exists(temp, "URC") + get_side_fields("URC", temp).getX() + "--" + get_side_fields("URC", temp).getY());
        System.out.println("LH :" + check_if_sidefield_exists(temp, "LH") + get_side_fields("LH", temp).getX() + "--" + get_side_fields("LH", temp).getY());
        System.out.println("RH :" + check_if_sidefield_exists(temp, "RH") + get_side_fields("RH", temp).getX() + "--" + get_side_fields("RH", temp).getY());
        System.out.println("LLC :" + check_if_sidefield_exists(temp, "LLC") + get_side_fields("LLC", temp).getX() + "--" + get_side_fields("LLC", temp).getY());
        System.out.println("LV :" + check_if_sidefield_exists(temp, "LV") + get_side_fields("LV", temp).getX() + "--" + get_side_fields("LV", temp).getY());
        System.out.println("LRC :" + check_if_sidefield_exists(temp, "LRC") + get_side_fields("LRC", temp).getX() + "--" + get_side_fields("LRC", temp).getY());
    }

    Side_fields get_side_fields(String name, Side_fields s) {
        Side_fields temp;
        temp = new Side_fields();
        switch (name) {
            case "ULC":
                temp.setX(s.getX() - 1);
                temp.setY(s.getY() - 1);
                break;
            case "LRC":
                temp.setX(s.getX() + 1);
                temp.setY(s.getY() + 1);
                break;
            case "URC":
                temp.setX(s.getX() - 1);
                temp.setY(s.getY() + 1);
                break;
            case "LLC":
                temp.setX(s.getX() + 1);
                temp.setY(s.getY() - 1);
                break;
            case "UV":
                temp.setX(s.getX() - 1);
                temp.setY(s.getY());
                break;
            case "LV":
                temp.setX(s.getX() + 1);
                temp.setY(s.getY());
                break;
            case "LH":
                temp.setX(s.getX());
                temp.setY(s.getY() - 1);
                break;
            case "RH":
                temp.setX(s.getX());
                temp.setY(s.getY() + 1);
        }
        return temp;
    }

    private Image backimage;

    @Override
    protected void paintComponent(Graphics g) {
        if (backimage == null) {
            super.paintComponent(g);
        } else {
            g.drawImage(backimage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
