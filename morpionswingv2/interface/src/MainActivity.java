public class MainActivity {

    // méthode principale
    public static void main(String[] args) {
        TicTacToe dialog = new TicTacToe();
        dialog.setTitle("Tic-Tac-Toe");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }


}
