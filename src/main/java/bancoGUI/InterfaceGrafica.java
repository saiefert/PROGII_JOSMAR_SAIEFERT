package bancoGUI;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InterfaceGrafica extends JFrame implements ActionListener {


    private JMenuBar barraDeMenu;
    private JMenu barraMenu, gerenciar;
    private JMenuItem cadastroUsuarioMaisEnderecoJmenu, cadastrarPerfilJmenu;
    private JMenuItem listarUsuariosJmenu, listarEnderecosJmenu, listarPerfilJmenu;
    private JButton salvarBancoPerfil, editarUsuario, excluirUsuario, excluirEndereco, editarEndereco, editarPerfil, excluirPerfil;
    private JButton sobre, salvarBanco;
    private JTextField nomeUsuario, sobrenomeUsuario, logradouro, complemento, bairro, numero, cep, nomePerfil, descricaoPerfil;
    private JLabel sucesso, nomeUsuarioLabel, sobrenomeUsuarioLabel, logradouroLabel, complementoLabel, bairroLabel, numeroLabel, cepLabel;
    private JLabel nomePerfilLabel, descricaoPerfilLabel, alertaSalvarLabel, perfilAlertaLabel, selecionarPerfilLabel;
    private JFrame cadastroUsuarioEnderecoJframe, cadastroPerfilJframe;
    private JFrame listarEnderecosJframe, listaUsuarioJframe, listarPerfilJframe;
    private JTable tabelaUser, tabelaEnd, tabelaPerf;
    private JPanel painelEditarExcluirUsuario, painelEditarExcluirEndereco, painelEditarExcluirPerfil;
    private static JComboBox perfilOpcoes;

    DefaultTableModel tabelaUsuario = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return column == 1 || column == 2 ? true : false;
        }
    };

    DefaultTableModel tabelaEndereco = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return column == 1 || column == 2 || column == 3 || column == 4 || column == 5 ? true : false;
        }
    };

    DefaultTableModel tabelaPerfil = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return column == 1 || column == 2 ? true : false;
        }
    };

    InterfaceGrafica() {
        super("Programação II");
        barraDeMenu = new JMenuBar();
        this.setJMenuBar(barraDeMenu);

        //Menu Novo
        barraMenu = new JMenu("Novo");
        cadastroUsuarioMaisEnderecoJmenu = new JMenuItem("Usuário");
        cadastrarPerfilJmenu = new JMenuItem("Perfil");
        barraDeMenu.add(barraMenu);
        barraMenu.add(cadastrarPerfilJmenu);
        barraMenu.add(cadastroUsuarioMaisEnderecoJmenu);
        cadastroUsuarioEnderecoJframe = new JFrame("Cadastror Usuário e endereço");
        cadastroPerfilJframe = new JFrame("Cadastrar perfil");

        //Menu Gerenciar
        gerenciar = new JMenu("Gerenciar");
        listarUsuariosJmenu = new JMenuItem("Listar usuários");
        listarEnderecosJmenu = new JMenuItem("Listar endereços");
        listarPerfilJmenu = new JMenuItem("Listar Perfil");
        barraDeMenu.add(gerenciar);
        gerenciar.add(listarUsuariosJmenu);
        gerenciar.add(listarEnderecosJmenu);
        gerenciar.add(listarPerfilJmenu);

       //Usuário Jframe (Cadastro)
        TitledBorder tituloUsuario = new TitledBorder("Usuário");
        salvarBanco = new JButton("Cadastrar");
        JPanel usuarioJpane = new JPanel();
        usuarioJpane.setBorder(tituloUsuario);
        cadastroUsuarioEnderecoJframe.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        cadastroUsuarioEnderecoJframe.add(usuarioJpane);
        nomeUsuario = new JTextField(5);
        nomeUsuarioLabel = new JLabel("Nome:");
        sobrenomeUsuario = new JTextField(20);
        sobrenomeUsuarioLabel = new JLabel("Sobrenome:");
        usuarioJpane.add(nomeUsuarioLabel);
        usuarioJpane.add(nomeUsuario);
        usuarioJpane.add(sobrenomeUsuarioLabel);
        usuarioJpane.add(sobrenomeUsuario);
        perfilOpcoes = new JComboBox();
        selecionarPerfilLabel = new JLabel("Selecione o perfil");
        usuarioJpane.add(selecionarPerfilLabel);
        usuarioJpane.add(perfilOpcoes);

        //Endereço Jframe (Cadastro)
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
        cadastroUsuarioEnderecoJframe.add(salvarBanco);

        //Perfil Jframe(Cadastro)
        TitledBorder tituloPerfil = new TitledBorder("Perfil");
        JPanel perfilJpane = new JPanel();
        perfilJpane.setBorder(tituloPerfil);
        cadastroPerfilJframe.add(perfilJpane);
        nomePerfil = new JTextField(15);
        nomePerfilLabel = new JLabel("Nome:");
        descricaoPerfil = new JTextField(25);
        descricaoPerfilLabel = new JLabel("Descrição:");
        perfilJpane.add(nomePerfilLabel);
        perfilJpane.add(nomePerfil);
        perfilJpane.add(descricaoPerfilLabel);
        perfilJpane.add(descricaoPerfil);
        salvarBancoPerfil = new JButton("Cadastrar");
        perfilJpane.add(salvarBancoPerfil);
        perfilAlertaLabel = new JLabel("Exemplo: Nome [Gerente] Descrição [Administrativo]");
        perfilAlertaLabel.setForeground(Color.lightGray);
        perfilJpane.add(perfilAlertaLabel);



        //Tabela Usuário
        listaUsuarioJframe = new JFrame("Consultar usuários");
        tabelaUser = new JTable(tabelaUsuario);
        tabelaUser.setGridColor(Color.LIGHT_GRAY);
        tabelaUser.setShowVerticalLines(false);
        tabelaUsuario.addColumn("ID");
        tabelaUsuario.addColumn("Nome");
        tabelaUsuario.addColumn("Sobrenome");
        tabelaUser.getColumnModel().getColumn(0).setPreferredWidth(5);
        tabelaUser.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabelaUser.getColumnModel().getColumn(2).setPreferredWidth(250);
        excluirUsuario = new JButton("Excluir");
        editarUsuario = new JButton("Editar");
        painelEditarExcluirUsuario = new JPanel();
        alertaSalvarLabel = new JLabel("Dê duplo clique na célula que deseja alterar. Para salvar, selecione a linha que foi alterada e clique no botão 'Editar'.");
        alertaSalvarLabel.setForeground(Color.RED);
        painelEditarExcluirUsuario.add(editarUsuario);
        painelEditarExcluirUsuario.add(excluirUsuario);
        listaUsuarioJframe.setLayout(new BorderLayout());
        listaUsuarioJframe.add(BorderLayout.SOUTH, painelEditarExcluirUsuario);
        JScrollPane barraRolagem = new JScrollPane(tabelaUser);
        listaUsuarioJframe.add(BorderLayout.CENTER, barraRolagem);
        listaUsuarioJframe.add(alertaSalvarLabel, BorderLayout.NORTH);

        //Tabela Endereço
        listarEnderecosJframe = new JFrame("Consultar Endereços");
        tabelaEnd = new JTable(tabelaEndereco);
        tabelaEnd.setGridColor(Color.LIGHT_GRAY);
        tabelaEnd.setShowVerticalLines(false);
        tabelaEndereco.addColumn("ID");
        tabelaEndereco.addColumn("Logradouro");
        tabelaEndereco.addColumn("Complemento");
        tabelaEndereco.addColumn("Bairro");
        tabelaEndereco.addColumn("Numero");
        tabelaEndereco.addColumn("Cep");
        tabelaEnd.getColumnModel().getColumn(0).setPreferredWidth(5);
        tabelaEnd.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabelaEnd.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabelaEnd.getColumnModel().getColumn(3).setPreferredWidth(50);
        tabelaEnd.getColumnModel().getColumn(4).setPreferredWidth(10);
        excluirEndereco = new JButton("Excluir");
        editarEndereco = new JButton("Editar");
        painelEditarExcluirEndereco = new JPanel();
        alertaSalvarLabel = new JLabel("Dê duplo clique na célula que deseja alterar. Para salvar, selecione a linha que foi alterada e clique no botão 'Editar'.");
        alertaSalvarLabel.setForeground(Color.RED);
        painelEditarExcluirEndereco.add(editarEndereco);
        painelEditarExcluirEndereco.add(excluirEndereco);
        listarEnderecosJframe.setLayout(new BorderLayout());
        listarEnderecosJframe.add(BorderLayout.SOUTH, painelEditarExcluirEndereco);
        JScrollPane barraRolagemEndereco = new JScrollPane(tabelaEnd);
        listarEnderecosJframe.add(BorderLayout.CENTER, barraRolagemEndereco);
        listarEnderecosJframe.add(alertaSalvarLabel, BorderLayout.NORTH);

        //Tabela Perfil
        listarPerfilJframe = new JFrame("Consultar Endereços");
        tabelaPerf = new JTable(tabelaPerfil);
        tabelaPerf.setGridColor(Color.LIGHT_GRAY);
        tabelaPerf.setShowVerticalLines(false);
        tabelaPerfil.addColumn("ID");
        tabelaPerfil.addColumn("Nome");
        tabelaPerfil.addColumn("Descrição");
        tabelaPerf.getColumnModel().getColumn(0).setPreferredWidth(5);
        tabelaPerf.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabelaPerf.getColumnModel().getColumn(2).setPreferredWidth(100);
        excluirPerfil = new JButton("Excluir");
        editarPerfil = new JButton("Editar");
        painelEditarExcluirPerfil = new JPanel();
        alertaSalvarLabel = new JLabel("Dê duplo clique na célula que deseja alterar. Para salvar, selecione a linha que foi alterada e clique no botão 'Editar'.");
        alertaSalvarLabel.setForeground(Color.RED);
        painelEditarExcluirPerfil.add(editarPerfil);
        painelEditarExcluirPerfil.add(excluirPerfil);
        listarPerfilJframe.setLayout(new BorderLayout());
        listarPerfilJframe.add(BorderLayout.SOUTH, painelEditarExcluirPerfil);
        JScrollPane barraRolagemPerfil = new JScrollPane(tabelaPerf);
        listarPerfilJframe.add(BorderLayout.CENTER, barraRolagemPerfil);
        listarPerfilJframe.add(alertaSalvarLabel, BorderLayout.NORTH);

        //Botão Sobre
        sobre = new JButton("Sobre");
        barraDeMenu.add(sobre);
        sobre.setOpaque(false);
        sobre.setContentAreaFilled(false);
        sobre.setBorderPainted(false);

        //Coloque o caminho da imagem aqui:
        ImageIcon imagem = new ImageIcon("C:\\Users\\SAIEFERT.FINANCIAL\\IdeaProjects\\PROGII_JOSMAR_SAIEFERT\\img\\logo.png");
        JLabel imageLabel = new JLabel(imagem);
        this.add(imageLabel);

        //Listerners
        cadastroUsuarioMaisEnderecoJmenu.addActionListener(this);
        cadastrarPerfilJmenu.addActionListener(this);
        listarPerfilJmenu.addActionListener(this);
        listarUsuariosJmenu.addActionListener(this);
        salvarBanco.addActionListener(this);
        salvarBancoPerfil.addActionListener(this);
        listarEnderecosJmenu.addActionListener(this);
        sobre.addActionListener(this);
        editarUsuario.addActionListener(this);
        excluirUsuario.addActionListener(this);
        editarEndereco.addActionListener(this);
        excluirEndereco.addActionListener(this);
        editarPerfil.addActionListener(this);
        excluirPerfil.addActionListener(this);
    }

    //Adiciona um perfil do banco de dados no JCombo
    public static void adicionaPerfilJcombo() {
        DAOPerfil dao = new DAOPerfil();
        for (Perfil perfil : dao.listarPerfil()) {
            perfilOpcoes.removeItem(perfil.getNome());
            perfilOpcoes.addItem(perfil.getNome());
        }
    }

    //Pega a opção no JCombobox e relaciona com o id_perfil e o retorna.
    public static int perfilJcomboListar() {
        String nome;
        int idPerfil = 0;
        DAOPerfil dao = new DAOPerfil();
        nome = (String) perfilOpcoes.getSelectedItem();

        for (Perfil perfil : dao.listarPerfil()) {
            if (nome.equals(perfil.getNome())) {
                return perfil.getIdPerfil();
            }
        }

        return idPerfil;
    }

    //Lista todos os usuários do banco de dados e adiciona linhas a cada usuário
    public static void pesquisarUsuario(DefaultTableModel tabelaModelo) {
        tabelaModelo.setNumRows(0);
        DAOUsuario dao = new DAOUsuario();
        for (Usuario usuario : dao.listarUsuarios()) {
            tabelaModelo.addRow(new Object[]{usuario.getidUsuario(), usuario.getNome(), usuario.getSobrenome()});
        }
    }

    //Lista todos os enderecos e adiciona linhas a cada endereco
    public static void pesquisarEndereco(DefaultTableModel tabelaModeloEndereco) {
        tabelaModeloEndereco.setNumRows(0);
        DAOEndereco daoEndereco = new DAOEndereco();
        for (Endereco endereco : daoEndereco.listarEnderecos()) {
            tabelaModeloEndereco.addRow(new Object[]{endereco.getIdEndereco(), endereco.getLogradouro(), endereco.getComplemento()
                    , endereco.getBairro(), endereco.getNumero(), endereco.getCep()});
        }
    }

    //Lista todos os perfils e adiciona linhas a cada perfil
    public static void pesquisarPerfil(DefaultTableModel tabelaModeloPerfil) {
        tabelaModeloPerfil.setNumRows(0);
        DAOPerfil daoPerfil = new DAOPerfil();
        for (Perfil perfil : daoPerfil.listarPerfil()) {
            tabelaModeloPerfil.addRow(new Object[]{perfil.getIdPerfil(), perfil.getNome(), perfil.getDescricao()});
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

            if (usuarioSobrenome.isEmpty() || nome.isEmpty() || enderecoLogradouro.isEmpty() || enderecoBairro.isEmpty() ||
                    enderecoNumero.isEmpty() || enderecoCep.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Favor, preencha todos os campos!!", "" +
                        "Não foi possível salvar", JOptionPane.PLAIN_MESSAGE);
            } else {
                usuario.setIdUsu(perfilJcomboListar());
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
        } else if (evento.getSource() == salvarBancoPerfil) {
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
                JOptionPane.showMessageDialog(this, "Perfil\n" + perfilNome +
                        " inserido com sucesso!", "Cadastrado!", JOptionPane.PLAIN_MESSAGE);
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
        } else if (evento.getSource() == cadastroUsuarioMaisEnderecoJmenu) {
            cadastroUsuarioEnderecoJframe.setVisible(true);
            cadastroUsuarioEnderecoJframe.setSize(680, 480);
            cadastroUsuarioEnderecoJframe.setLocationRelativeTo(null);
            cadastroUsuarioEnderecoJframe.setResizable(false);
            cadastroUsuarioEnderecoJframe.setVisible(true);
            adicionaPerfilJcombo();
            int contador = 0;
            DAOPerfil dao = new DAOPerfil();
            for (Perfil perfil : dao.listarPerfil()) {
                contador = perfilOpcoes.getItemCount();
            }
            if (contador == 0) {
                nomeUsuario.setEditable(false);
                sobrenomeUsuario.setEditable(false);
                logradouro.setEditable(false);
                cep.setEditable(false);
                numero.setEditable(false);
                complemento.setEditable(false);
                bairro.setEditable(false);
                salvarBanco.setEnabled(false);
                perfilOpcoes.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Ops, detectei que não há nenhum perfil cadastrado." +
                        " \nCada usuário precisa estar em pelo menos um perfil. Para cadastrar um perfil, vá no menu Novo > Perfil");
            } else {
                nomeUsuario.setEditable(true);
                sobrenomeUsuario.setEditable(true);
                logradouro.setEditable(true);
                cep.setEditable(true);
                numero.setEditable(true);
                complemento.setEditable(true);
                bairro.setEditable(true);
                salvarBanco.setEnabled(true);
                perfilOpcoes.setEnabled(true);
            }

            //Submenu Consultar
        } else if (evento.getSource() == cadastrarPerfilJmenu) {
            cadastroPerfilJframe.setVisible(true);
            cadastroPerfilJframe.setSize(680, 480);
            cadastroPerfilJframe.setLocationRelativeTo(null);
            cadastroPerfilJframe.setResizable(false);
            cadastroPerfilJframe.setVisible(true);

            //submenu Listar usuários
        } else if (evento.getSource() == listarUsuariosJmenu) {
            pesquisarUsuario(tabelaUsuario);
            listaUsuarioJframe.setVisible(true);
            listaUsuarioJframe.setSize(700, 480);
            listaUsuarioJframe.setLocationRelativeTo(null);
            listaUsuarioJframe.setResizable(true);
            listaUsuarioJframe.setVisible(true);


            //Submenu Listar Enderecos
        } else if (evento.getSource() == listarEnderecosJmenu) {
            pesquisarEndereco(tabelaEndereco);
            listarEnderecosJframe.setVisible(true);
            listarEnderecosJframe.setSize(720, 480);
            listarEnderecosJframe.setLocationRelativeTo(null);
            listarEnderecosJframe.setResizable(false);
            listarEnderecosJframe.setVisible(true);

        } else if (evento.getSource() == listarPerfilJmenu) {
            pesquisarPerfil(tabelaPerfil);
            listarPerfilJframe.setVisible(true);
            listarPerfilJframe.setSize(720, 480);
            listarPerfilJframe.setLocationRelativeTo(null);
            listarPerfilJframe.setResizable(false);
            listarPerfilJframe.setVisible(true);

        } else if (evento.getSource() == editarUsuario) {
            Usuario usuario = new Usuario();
            DAOUsuario daoUsuario = new DAOUsuario();
            Object linha;
            Object nomeModificado;
            Object sobrenomeModificado;
            int linhaSelecionada;
            linhaSelecionada = tabelaUser.getSelectedRow();
            if (linhaSelecionada >= 0) {
                linha = tabelaUser.getValueAt(linhaSelecionada, 0);
                nomeModificado = tabelaUser.getValueAt(linhaSelecionada, 1);
                sobrenomeModificado = tabelaUser.getValueAt(linhaSelecionada, 2);
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
                linhaSelecionada = tabelaUser.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    linha = tabelaUser.getValueAt(linhaSelecionada, 0);
                    usuario.setIdUsuario((Integer) linha);
                    daoUsuario.excluirUsuario(usuario);
                    pesquisarUsuario(tabelaUsuario);
                } else {
                    JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
                }
            }

        } else if (evento.getSource() == editarEndereco) {
            Endereco endereco = new Endereco();
            DAOEndereco daoEndereco = new DAOEndereco();
            Object linha;
            Object logradouro, complemento, bairro, numero, cep;
            int linhaSelecionada;
            linhaSelecionada = tabelaEnd.getSelectedRow();
            if (linhaSelecionada >= 0) {
                linha = tabelaEnd.getValueAt(linhaSelecionada, 0);
                logradouro = tabelaEnd.getValueAt(linhaSelecionada, 1);
                complemento = tabelaEnd.getValueAt(linhaSelecionada, 2);
                bairro = tabelaEnd.getValueAt(linhaSelecionada, 3);
                numero = tabelaEnd.getValueAt(linhaSelecionada, 4);
                cep = tabelaEnd.getValueAt(linhaSelecionada, 5);
                endereco.setIdEndereco((Integer) linha);
                endereco.setLogradouro((String) logradouro);
                endereco.setComplemento((String) complemento);
                endereco.setBairro((String) bairro);
                endereco.setNumero((String) numero);
                endereco.setCep((String) cep);
                daoEndereco.editarEndereco(endereco);
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }
        } else if (evento.getSource() == excluirEndereco) {
            int reply = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir endereço?" +
                    "", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                Endereco endereco = new Endereco();
                DAOEndereco daoEndereco = new DAOEndereco();
                Object linha;
                int linhaSelecionada;
                linhaSelecionada = tabelaEnd.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    linha = tabelaEnd.getValueAt(linhaSelecionada, 0);
                    endereco.setIdEndereco((Integer) linha);
                    daoEndereco.excluirEndereco(endereco);
                    pesquisarEndereco(tabelaEndereco);
                } else {
                    JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
                }
            }
        } else if (evento.getSource() == editarPerfil) {
            Perfil perfil = new Perfil();
            DAOPerfil daoPerfil = new DAOPerfil();
            Object linha;
            Object nome, descricao;
            int linhaSelecionada;
            linhaSelecionada = tabelaPerf.getSelectedRow();
            if (linhaSelecionada >= 0) {
                linha = tabelaPerf.getValueAt(linhaSelecionada, 0);
                nome = tabelaPerf.getValueAt(linhaSelecionada, 1);
                descricao = tabelaPerf.getValueAt(linhaSelecionada, 2);
                perfil.setIdPerfil((Integer) linha);
                perfil.setNome((String) nome);
                perfil.setDescricao((String) descricao);
                daoPerfil.editarPerfil(perfil);
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }
        } else if (evento.getSource() == excluirPerfil) {
            int reply = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o Perfil?" +
                    "", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                Perfil perfil = new Perfil();
                DAOPerfil daoPerfil = new DAOPerfil();
                Object linha;
                int linhaSelecionada;
                linhaSelecionada = tabelaPerf.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    linha = tabelaPerf.getValueAt(linhaSelecionada, 0);
                    perfil.setIdPerfil((Integer) linha);
                    daoPerfil.excluirPerfil(perfil);
                    pesquisarPerfil(tabelaPerfil);
                } else {
                    JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
                }
            }
        }
    }
}


