import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TicTacToe extends JDialog {
    //Attribut
    private JPanel contentPane;
    private JButton buttonRestart;
    private JButton buttonQuit;
    private JButton button01;
    private JButton button11;
    private JButton button21;
    private JButton button00;
    private JButton button02;
    private JButton button12;
    private JButton button22;
    private JButton button10;
    private JButton button20;
    private JButton buttontxt;
    private ArrayList<JButton> listeBtn;
    public Morpion Lejeu;
    private int t=1;

    //Constructeur
    public TicTacToe() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonRestart);
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onQuit();
            }
        });
        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onQuit();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        //Mon dev

        init();
    }

    // Fonction d'initialisation (appelé dans le contructeur)
    private void init(){
        initListeBtn();
        initEcouteurBtn();
        Lejeu =new Morpion();
    }

    // Fonction qui initialise la collection de Jbutton
    private void initListeBtn(){
        listeBtn = new ArrayList<>();
        listeBtn.add(button00);
        listeBtn.add(button01);
        listeBtn.add(button02);

        listeBtn.add(button10);
        listeBtn.add(button11);
        listeBtn.add(button12);

        listeBtn.add(button20);
        listeBtn.add(button21);
        listeBtn.add(button22);
    }

    // Fonction qui initialise les écouteurs ("click") des boutons
    private void initEcouteurBtn(){
        for (JButton unBouton: listeBtn  ) {
            unBouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String s=unBouton.getName();
                    JButton lebtn =unBouton;
                    onClick(s,lebtn);
                }
            });
        }

        buttonRestart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRestart();
            }
        });

        buttonQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onQuit();
            }
        });
    }

    // Fonction qui définie la méthode de clic pour les 9 boutons centraux
    private void onClick(String s, JButton lebtn) {
        if (Lejeu.win() == 1 ||Lejeu.win() == 2) {
        } else {
            buttontxt.setText("joueur suivant");

        if (Lejeu.cochercase(s)) {
            if (t % 2 == 1) {
                lebtn.setText("X");
            } else {
                lebtn.setText("O");
            }
            t = t + 1;
        } else {
                buttontxt.setText("case prise");
        }
    }
        if (Lejeu.win() == 2) {
            buttontxt.setText("égalité");
        }else{
            if (Lejeu.win() == 1) {
                buttontxt.setText("victoire");
            }
        }
    }
    // Fonction qui définie la méthode de clic pour le bouton restart
    private void onRestart() {
        initinter();
        buttontxt.setText("nouvelle partie");
    }
    private void initinter(){
        Lejeu.restart();
        for (JButton lebtn : listeBtn){
            lebtn.setText(" ");
        }
    }
    // Fonction qui définie la méthode de clic pour le bouton quitter
    private void onQuit() {
        dispose();
    }

}
