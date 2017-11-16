package bancoGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGrafica extends JFrame implements ActionListener {

    private JMenuBar barraDeMenu;
    private JMenu usuario, endereco, perfil;
    private JMenuItem cadastrarUsuario, consultarUsuario;
    private JMenuItem cadastrarEndereco, consultarEndereco;
    private JMenuItem cadastrarPerfil, consultarPerfil;
    private JButton sobre;

    InterfaceGrafica() {

        super("Programação II");
        barraDeMenu = new JMenuBar();
        this.setJMenuBar(barraDeMenu);

        usuario = new JMenu("Usuario");
        cadastrarUsuario = new JMenuItem("Cadastrar");
        consultarUsuario = new JMenuItem("Consultar");
        barraDeMenu.add(usuario);
        usuario.add(cadastrarUsuario);
        usuario.add(consultarUsuario);

        endereco = new JMenu("Endereço");
        cadastrarEndereco = new JMenuItem("Cadastrar");
        consultarEndereco = new JMenuItem("Consultar");
        barraDeMenu.add(endereco);
        endereco.add(cadastrarEndereco);
        endereco.add(consultarEndereco);

        perfil = new JMenu("Perfil");
        cadastrarPerfil = new JMenuItem("Cadastrar");
        consultarPerfil = new JMenuItem("Consultar");
        barraDeMenu.add(perfil);
        perfil.add(cadastrarPerfil);
        perfil.add(consultarPerfil);

        sobre = new JButton("Sobre");
        barraDeMenu.add(sobre);
        sobre.setOpaque(false);
        sobre.setContentAreaFilled(false);
        sobre.setBorderPainted(false);

        //Coloque o caminho da imagem aqui:
        ImageIcon imagem = new ImageIcon("C:\\Users\\Josmar\\IdeaProjects\\PROGII_JOSMAR_SAIEFERT\\img\\logo.png");
        JLabel imageLabel = new JLabel(imagem);
        this.add(imageLabel);

        //listeners
        //Listerners
        sobre.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == sobre) {
            UIManager.put("OptionPane.okButtonText", "Beleza!");
            JOptionPane.showMessageDialog(this, "        " +
                    "Trabalho 2 de Programação II 2017.2" +
                    "\n  Professor Me. Marcelo Figueiredo Terenciani" +
                    "\n                           TADS 4º Semestre" +
                    "\n\n                            Josmar Saiefert" +
                    "\n                          RA: 201602375968" +
                    "","Sobre", JOptionPane.PLAIN_MESSAGE);
            //visor.setText(visor.getText().concat("1"));

        }
    }
}

