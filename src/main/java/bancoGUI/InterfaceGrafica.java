package bancoGUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InterfaceGrafica extends JFrame implements ActionListener {


    private JMenuBar barraDeMenu;
    private JMenu barraMenu, gerenciar;
    private JMenuItem cadastroUsuarioEndereco, cadastrarPerfil;
    private JMenuItem listarUsuarios, buscarEnderecos;
    private JButton sobre, salvarBanco, salvarBancoPerfil ,editarUsuario, excluirUsuario;
    private JTextField nomeUsuario, sobrenomeUsuario, logradouro, complemento, bairro, numero, cep, nomePerfil, descricaoPerfil;
    private JLabel sucesso, nomeUsuarioLabel, sobrenomeUsuarioLabel, logradouroLabel, complementoLabel, bairroLabel, numeroLabel, cepLabel;
    private JLabel nomePerfilLabel, descricaoPerfilLabel, alertaSalvarUsuario;
    private JFrame cadastroUsuarioEnderecoJframe, cadastroPerfilJframe, buscaUsuarioPainel;
    private JFrame editaExcluiPainel;
    private JTable tabela;
    private JPanel painelEditarExcluir;
    private JScrollPane perfilOpcoes;
    DefaultTableModel tabelaUsuario = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return column == 1 || column == 2 ? true : false;
        }
    };

    InterfaceGrafica() {
        super("Programação II");
        barraDeMenu = new JMenuBar();
        this.setJMenuBar(barraDeMenu);

        //Novo > Cadastro
        barraMenu = new JMenu("Novo");
        cadastroUsuarioEndereco = new JMenuItem("Usuário");
        cadastrarPerfil = new JMenuItem("Perfil");
        barraDeMenu.add(barraMenu);
        barraMenu.add(cadastroUsuarioEndereco);
        barraMenu.add(cadastrarPerfil);
        cadastroUsuarioEnderecoJframe = new JFrame("Cadastror Usuário e endereço");
        cadastroPerfilJframe = new JFrame("Cadastrar perfil");

        //Usuárioc e Endereço
        //Usuário
        TitledBorder tituloUsuario = new TitledBorder("Usuário");
        salvarBanco = new JButton("Cadastrar");
        JPanel usuarioJpane = new JPanel();
        usuarioJpane.setBorder(tituloUsuario);
        cadastroUsuarioEnderecoJframe.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        cadastroUsuarioEnderecoJframe.add(usuarioJpane);
        nomeUsuario = new JTextField(15);
        nomeUsuarioLabel = new JLabel("Nome:");
        sobrenomeUsuario = new JTextField(25);
        sobrenomeUsuarioLabel = new JLabel("Sobrenome:");
        usuarioJpane.add(nomeUsuarioLabel);
        usuarioJpane.add(nomeUsuario);
        usuarioJpane.add(sobrenomeUsuarioLabel);
        usuarioJpane.add(sobrenomeUsuario);
        //Endereço:
        TitledBorder tituloEndereco = new TitledBorder("Endereço");
        JPanel enderecoJpane = new JPanel(new GridLayout(3, 1));
        enderecoJpane.setBorder(tituloEndereco);
        cadastroUsuarioEnderecoJframe.add(enderecoJpane);
        logradouroLabel = new JLabel("Logradouro");
        complementoLabel = new JLabel("Complemento");
        bairroLabel = new JLabel("Bairro: ");
        numeroLabel = new JLabel("Numero: ");
        cepLabel = new JLabel("Cep:");
        logradouro = new JTextField(31);
        complemento = new JTextField(46);
        bairro = new JTextField(36);
        numero = new JTextField(10);
        cep = new JTextField(10);
        JPanel logradouroNumero = new JPanel();
        JPanel bairroCep = new JPanel();
        JPanel comple = new JPanel();
        enderecoJpane.add(logradouroNumero);
        enderecoJpane.add(bairroCep);
        enderecoJpane.add(comple);
        logradouroNumero.add(logradouroLabel, BorderLayout.NORTH);
        logradouroNumero.add(logradouro, BorderLayout.NORTH);
        logradouroNumero.add(numeroLabel, BorderLayout.NORTH);
        logradouroNumero.add(numero, BorderLayout.NORTH);
        bairroCep.add(bairroLabel, BorderLayout.CENTER);
        bairroCep.add(bairro, BorderLayout.CENTER);
        bairroCep.add(cepLabel, BorderLayout.CENTER);
        bairroCep.add(cep, BorderLayout.CENTER);
        comple.add(complementoLabel, BorderLayout.SOUTH);
        comple.add(complemento, BorderLayout.SOUTH);
        cadastroPerfilJframe.add(perfilOpcoes);
        cadastroUsuarioEnderecoJframe.add(salvarBanco);



        //Perfil
        TitledBorder tituloPerfil = new TitledBorder("Perfil");
        JPanel perfilJpane = new JPanel();
        perfilJpane.setBorder(tituloPerfil);
        cadastroPerfilJframe.add(perfilJpane);
        nomePerfil = new JTextField(15);
        nomePerfilLabel = new JLabel("Nome:");
        descricaoPerfil = new JTextField(30);
        descricaoPerfilLabel = new JLabel("Descrição:");
        perfilJpane.add(nomePerfilLabel);
        perfilJpane.add(nomePerfil);
        perfilJpane.add(descricaoPerfilLabel);
        perfilJpane.add(descricaoPerfil);
        salvarBancoPerfil = new JButton("Cadastrar");
        perfilJpane.add(salvarBancoPerfil);


        //Menu Gerenciar
        gerenciar = new JMenu("Gerenciar");
        listarUsuarios = new JMenuItem("Listar usuários");
        buscarEnderecos = new JMenuItem("Listar endereços");
        barraDeMenu.add(gerenciar);
        gerenciar.add(listarUsuarios);
        gerenciar.add(buscarEnderecos);

        //Tabela/Listar
        buscaUsuarioPainel = new JFrame("Consultar cadastroUsuarioEndereco de usuário");

        tabela = new JTable(tabelaUsuario);
        tabela.setGridColor(Color.LIGHT_GRAY);
        tabela.setShowVerticalLines(false);
        tabelaUsuario.addColumn("ID");
        tabelaUsuario.addColumn("Nome");
        tabelaUsuario.addColumn("Sobrenome");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(5);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(250);
        excluirUsuario = new JButton("Excluir");
        editarUsuario = new JButton("Editar");
        painelEditarExcluir = new JPanel();
        alertaSalvarUsuario = new JLabel("Dê duplo clique na célula que deseja alterar. Para salvar, selecione a linha que foi alterada e clique no botão 'Editar'.");
        alertaSalvarUsuario.setForeground(Color.RED);
        painelEditarExcluir.add(editarUsuario);
        painelEditarExcluir.add(excluirUsuario);
        buscaUsuarioPainel.setLayout(new BorderLayout());
        buscaUsuarioPainel.add(BorderLayout.SOUTH, painelEditarExcluir);
        JScrollPane barraRolagem = new JScrollPane(tabela);
        buscaUsuarioPainel.add(BorderLayout.CENTER, barraRolagem);
        buscaUsuarioPainel.add(alertaSalvarUsuario, BorderLayout.NORTH);

        //Botão Sobre
        sobre = new JButton("Sobre");
        barraDeMenu.add(sobre);
        sobre.setOpaque(false);
        sobre.setContentAreaFilled(false);
        sobre.setBorderPainted(false);

        editaExcluiPainel = new JFrame("Editar/Excluir cadastroUsuarioEndereco");

        //Coloque o caminho da imagem aqui:
        ImageIcon imagem = new ImageIcon("C:\\Users\\SAIEFERT.FINANCIAL\\IdeaProjects\\PROGII_JOSMAR_SAIEFERT\\img\\logo.png");
        JLabel imageLabel = new JLabel(imagem);
        this.add(imageLabel);

        //Listerners
        cadastroUsuarioEndereco.addActionListener(this);
        cadastrarPerfil.addActionListener(this);
        listarUsuarios.addActionListener(this);
        salvarBanco.addActionListener(this);
        salvarBancoPerfil.addActionListener(this);
        buscarEnderecos.addActionListener(this);
        sobre.addActionListener(this);
        editarUsuario.addActionListener(this);
        excluirUsuario.addActionListener(this);
    }

    public static void pesquisar(DefaultTableModel tabelaModelo) {
        tabelaModelo.setNumRows(0);
        DAOUsuario dao = new DAOUsuario();
        for (Usuario usuario : dao.listarUsuarios()) {
            tabelaModelo.addRow(new Object[]{usuario.getidUsuario(), usuario.getNome(), usuario.getSobrenome()});
        }
    }

    //Ações dos botões
    public void actionPerformed(ActionEvent evento) {
        //Botão Cadastrar
        if (evento.getSource() == salvarBanco) {
            Usuario usuario = new Usuario();
            Endereco endereco = new Endereco();
            DAOUsuario usuarioDao = new DAOUsuario();
            DAOEndereco enderecoDao = new DAOEndereco();

            String nome, usuarioSobrenome;
            String enderecoLogradouro, enderecoComplemento, enderecoBairro, enderecoNumero, enderecoCep;
            nome = nomeUsuario.getText();
            enderecoLogradouro = logradouro.getText();
            enderecoComplemento = complemento.getText();
            enderecoBairro = bairro.getText();
            enderecoNumero = numero.getText();
            enderecoCep = cep.getText();
            usuarioSobrenome = sobrenomeUsuario.getText();

            if (usuarioSobrenome.isEmpty() || nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos de usuário!", "" +
                        "Não foi possível salvar", JOptionPane.PLAIN_MESSAGE);
            } else {
                usuario.setNome(nome);
                usuario.setSobrenome(usuarioSobrenome);
                usuarioDao.salvarUsuario(usuario);
                endereco.setLogradouro(enderecoLogradouro);
                endereco.setBairro(enderecoBairro);
                endereco.setNumero(enderecoNumero);
                endereco.setComplemento(enderecoComplemento);
                endereco.setCep(enderecoCep);
                enderecoDao.salvarEndereco(endereco);
                JOptionPane.showMessageDialog(this, "Usuário\n" + nome + " " +
                        usuarioSobrenome + " incluído com sucesso!", "Cadastrado!", JOptionPane.PLAIN_MESSAGE);
            }
        }else if (evento.getSource() == salvarBancoPerfil) {
            Perfil perfil = new Perfil();
            DAOPerfil perfilDao = new DAOPerfil();

            String perfilNome, perfilDescricao;
            perfilNome = nomePerfil.getText();
            perfilDescricao = descricaoPerfil.getText();

            if (perfilDescricao.isEmpty() || perfilNome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos de perfil!", "" +
                        "Não foi possível salvar", JOptionPane.PLAIN_MESSAGE);
            } else {
                perfil.setNome(perfilNome);
                perfil.setDescricao(perfilDescricao);
                perfilDao.salvarPerfil(perfil);
                JOptionPane.showMessageDialog(this, "Usuário\n" + perfilNome +
                        " incluído com sucesso!", "Cadastrado!", JOptionPane.PLAIN_MESSAGE);
            }
        }
        //Botão Sobre
        else if (evento.getSource() == sobre) {
            JOptionPane.showMessageDialog(this, "        " +
                    "Trabalho 2 de Programação II 2017.2" +
                    "\n  Professor Me. Marcelo Figueiredo Terenciani" +
                    "\n                           TADS 4º Semestre" +
                    "\n\n                            Josmar Saiefert" +
                    "\n                          RA: 201602375968" +
                    "", "Sobre", JOptionPane.PLAIN_MESSAGE);

            //Submenu cadastrar
        } else if (evento.getSource() == cadastroUsuarioEndereco) {
            cadastroUsuarioEnderecoJframe.setVisible(true);
            cadastroUsuarioEnderecoJframe.setSize(680, 480);
            cadastroUsuarioEnderecoJframe.setLocationRelativeTo(null);
            cadastroUsuarioEnderecoJframe.setResizable(false);
            cadastroUsuarioEnderecoJframe.setVisible(true);

            //Submenu Consultar
        } else if (evento.getSource() == cadastrarPerfil) {
            cadastroPerfilJframe.setVisible(true);
            cadastroPerfilJframe.setSize(680, 480);
            cadastroPerfilJframe.setLocationRelativeTo(null);
            cadastroPerfilJframe.setResizable(false);
            cadastroPerfilJframe.setVisible(true);
            //submenu cadastrar perfil
        } else if (evento.getSource() == listarUsuarios) {
            pesquisar(tabelaUsuario);
            buscaUsuarioPainel.setVisible(true);
            buscaUsuarioPainel.setSize(700, 480);
            buscaUsuarioPainel.setLocationRelativeTo(null);
            buscaUsuarioPainel.setResizable(true);
            buscaUsuarioPainel.setVisible(true);

            //Submenu Editar/Excluir
        } else if (evento.getSource() == buscarEnderecos) {
            editaExcluiPainel.setVisible(true);
            editaExcluiPainel.setSize(720, 480);
            editaExcluiPainel.setLocationRelativeTo(null);
            editaExcluiPainel.setResizable(false);
            editaExcluiPainel.setVisible(true);

        } else if (evento.getSource() == editarUsuario) {
            Usuario usuario = new Usuario();
            DAOUsuario daoUsuario = new DAOUsuario();
            Object linha;
            Object nomeModificado;
            Object sobrenomeModificado;
            int linhaSelecionada;
            linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada >= 0) {
                linha = tabela.getValueAt(linhaSelecionada, 0);
                nomeModificado = tabela.getValueAt(linhaSelecionada, 1);
                sobrenomeModificado = tabela.getValueAt(linhaSelecionada, 2);
                usuario.setIdUsuario((Integer) linha);
                usuario.setNome((String) nomeModificado);
                usuario.setSobrenome((String) sobrenomeModificado);
                daoUsuario.editarUsuario(usuario);
                JOptionPane.showMessageDialog(null, nomeModificado);

            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }
        } else if (evento.getSource() == excluirUsuario) {
            int reply = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir usuário?" +
                    "", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                Usuario usuario = new Usuario();
                DAOUsuario daoUsuario = new DAOUsuario();
                Object linha;
                int linhaSelecionada;
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    linha = tabela.getValueAt(linhaSelecionada, 0);
                    usuario.setIdUsuario((Integer) linha);
                    daoUsuario.excluirUsuario(usuario);
                } else {
                    JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
                }

            }

        }
    }
}



