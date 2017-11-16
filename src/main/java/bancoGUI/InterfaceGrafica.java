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
    private JFrame cadastraUsuarioPainel, consultaUsuarioPainel;
    private JFrame cadastraEnderecoPainel, consultaEnderecoPainel;
    private JFrame cadastraPerfilPainel, consultaPerfilPainel;

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

        cadastraUsuarioPainel = new JFrame("Cadastro de Usuário");
        consultaUsuarioPainel = new JFrame("Consultar Usuário");
        cadastraEnderecoPainel = new JFrame("Cadastro de Endereco");
        consultaEnderecoPainel = new JFrame("Consultar Endereço");
        cadastraPerfilPainel = new JFrame("Cadastro de Perfil");
        consultaPerfilPainel = new JFrame("Consultar Perfil");



        //Coloque o caminho da imagem aqui:
        ImageIcon imagem = new ImageIcon("C:\\Users\\Josmar\\IdeaProjects\\PROGII_JOSMAR_SAIEFERT\\img\\logo.png");
        JLabel imageLabel = new JLabel(imagem);
        this.add(imageLabel);

        //listeners
        //Listerners
        sobre.addActionListener(this);
        cadastrarUsuario.addActionListener(this);
        consultarUsuario.addActionListener(this);
        cadastrarEndereco.addActionListener(this);
        consultarEndereco.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == sobre) {
            UIManager.put("OptionPane.okButtonText", "Certo");
            JOptionPane.showMessageDialog(this, "        " +
                    "Trabalho 2 de Programação II 2017.2" +
                    "\n  Professor Me. Marcelo Figueiredo Terenciani" +
                    "\n                           TADS 4º Semestre" +
                    "\n\n                            Josmar Saiefert" +
                    "\n                          RA: 201602375968" +
                    "","Sobre", JOptionPane.PLAIN_MESSAGE);
            //visor.setText(visor.getText().concat("1"));
        }
        else if (evento.getSource() == cadastrarUsuario){
            cadastraUsuarioPainel.setVisible(true);
            cadastraUsuarioPainel.setSize(720,480);
            cadastraUsuarioPainel.setLocationRelativeTo(null);
            cadastraUsuarioPainel.setResizable(false);
            cadastraUsuarioPainel.setVisible(true);
        }
        else if (evento.getSource() == consultarUsuario){
            consultaUsuarioPainel.setVisible(true);
            consultaUsuarioPainel.setSize(720,480);
            consultaUsuarioPainel.setLocationRelativeTo(null);
            consultaUsuarioPainel.setResizable(false);
            consultaUsuarioPainel.setVisible(true);
        }
    }
}

