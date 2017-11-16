package bancoGUI;

public class Main {
    public static void main(String[] args) {
        InterfaceGrafica painel = new InterfaceGrafica();
        painel.pack();
        painel.setSize(720,480);
        painel.setLocationRelativeTo(null);
        painel.setResizable(false);
        painel.setVisible(true);
        painel.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
}


