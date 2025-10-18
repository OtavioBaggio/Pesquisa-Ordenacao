/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrame;

//Importações:
import Entities.Ordenacao;
import jPanel.Fundo_dados;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Interface gráfica para execução de métodos de ordenação em uma lista de números.
 * Esta classe fornece uma interface baseada em JFrame, permitindo que o usuário
 * carregue números de um arquivo, escolha métodos de ordenação (Bolha, Seleção, 
 * Inserção, Shake, Pente, Shell, QuickSort), execute os métodos selecionados e 
 * visualize os resultados, incluindo comparações, trocas e tempo de execução.
 * A interface também utiliza um painel de fundo com imagem para melhor estética.
 * 
 * @author Otávio Baggio
 */
public class Interface_ordenacao extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Interface_ordenacao.class.getName());

    /**
     * Creates new form Interface_ordenacao
     */
    
    /***
     * Lista de números carregados pelo usuário a partir de um arquivo.
     */
    private List<Integer> numerosCarregados;
    
    /***
     * Construtor da interface
     * Inicializa os componentes gráficos, configura o fundo com imagem e define propriedades do JFrame.
     */
    public Interface_ordenacao() {
        initComponents();
        
        // Salva o painel original criado pelo NetBeans
        JPanel painelOriginal = (JPanel) this.getContentPane();
        painelOriginal.setOpaque(false); // deixa transparente para mostrar o fundo

        // Cria o painel de fundo com a imagem
        Fundo_dados fundo = new Fundo_dados("src/imagens/Numeros-desordenados.png");
        fundo.setLayout(new BorderLayout());

        // Adiciona o painel original sobre o fundo
        fundo.add(painelOriginal, BorderLayout.CENTER);

        // Define o fundo como o content pane do JFrame
        setContentPane(fundo);

        setTitle("Ordenação com Interface");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    /***
     * Atualiza o campo de texto que exibe os métodos de ordenação selecionados.
     * Esse método verifica quais checkboxes estão marcados e exibe os nomes correspondentes
     * no JTextArea {@code txtA_metodoSelecionado}.
     */
    private void atualizarMetodosSelecionados(){
        StringBuilder sb = new StringBuilder();
        if (cb_bolha.isSelected())
            sb.append("Bolha\n");
        if (cb_selecao.isSelected())
            sb.append("Seleção\n");
        if (cb_insercao.isSelected())
            sb.append("Inserção\n");
        if (cb_shake.isSelected())
            sb.append("Shake\n");
        if (cb_pente.isSelected())
            sb.append("Pente\n");
        if (cb_shell.isSelected())
            sb.append("Shell\n");
        if (cb_quick.isSelected())
            sb.append("QuickSort\n");
        if (cb_heap.isSelected())
            sb.append("HeapSort\n");
        if(cb_merge.isSelected())
            sb.append("MergeSort\n");
        txtA_metodoSelecionado.setText(sb.toString());
    }
    
    /**
     * Executa o método de ordenação especificado sobre uma lista de números.
     * 
     * @param nome Nome do método de ordenação (ex.: "Bolha", "QuickSort").
     * @param lista Lista de inteiros a ser ordenada.
     * @return Uma string formatada contendo o método utilizado, número de 
     *         comparações, número de trocas, tempo de execução em nanossegundos
     *         e a lista ordenada.
     * @throws IllegalArgumentException Se o nome do método não for reconhecido.
     */
    private String executarMetodo(String nome, List<Integer> lista) {
        long inicio = System.nanoTime();    // vai apresentar o tempo nanosegundos, bom para dados imensos
        int[] dados;    //vetor para armazenar as trocas e comparações
        // Estava estudando no youtube, e achei a versão nova desse switch,
        // mais curta e limpa:
        switch (nome) {     
            case "Bolha" -> dados = Ordenacao.bolha(lista);
            case "Seleção" -> dados = Ordenacao.selecao(lista);
            case "Inserção" -> dados = Ordenacao.insercao(lista);
            case "Shake" -> dados = Ordenacao.agitacao(lista);
            case "Pente" -> dados = Ordenacao.pente(lista);
            case "Shell" -> dados = Ordenacao.shell(lista);
            case "QuickSort" -> dados = Ordenacao.quickSort(lista);
            case "HeapSort" -> dados = Ordenacao.heapSort(lista);
            case "MergeSort" -> dados = Ordenacao.mergeSort(lista);
            default -> throw new IllegalArgumentException("Método inválido");
        }
        long fim = System.nanoTime();
        long tempo = fim - inicio;

        return String.format(
            "Método: %s\n" +
            "Comparações: %d\n" +
            "Trocas: %d\n" +
            "Tempo: %d ns\n" +
            "Lista ordenada: %s\n\n",
            nome, dados[0], dados[1], tempo, lista
        );
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_carregarArquivo = new javax.swing.JButton();
        btn_executar = new javax.swing.JButton();
        txt_numeros = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA_metodoSelecionado = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        cb_bolha = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        cb_selecao = new javax.swing.JCheckBox();
        cb_insercao = new javax.swing.JCheckBox();
        cb_shake = new javax.swing.JCheckBox();
        cb_pente = new javax.swing.JCheckBox();
        cb_shell = new javax.swing.JCheckBox();
        cb_quick = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtA_ordenados = new javax.swing.JTextArea();
        cb_heap = new javax.swing.JCheckBox();
        cb_merge = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ordenador de valores");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel2.setText("utilizando métodos de Ordenação");
        jLabel2.setOpaque(true);

        btn_carregarArquivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_carregarArquivo.setText("Carregar Arquivo");
        btn_carregarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_carregarArquivoActionPerformed(evt);
            }
        });

        btn_executar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_executar.setText("Executar");
        btn_executar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_executarActionPerformed(evt);
            }
        });

        txt_numeros.setEditable(false);
        txt_numeros.setBackground(new java.awt.Color(204, 204, 204));
        txt_numeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numerosActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Números Carregados:");
        jLabel3.setOpaque(true);

        txtA_metodoSelecionado.setEditable(false);
        txtA_metodoSelecionado.setBackground(new java.awt.Color(204, 204, 204));
        txtA_metodoSelecionado.setColumns(20);
        txtA_metodoSelecionado.setRows(5);
        jScrollPane1.setViewportView(txtA_metodoSelecionado);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Métodos Selecionados:");
        jLabel4.setOpaque(true);

        cb_bolha.setBackground(new java.awt.Color(204, 204, 204));
        cb_bolha.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        cb_bolha.setText("Bolha");
        cb_bolha.setOpaque(true);
        cb_bolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_bolhaActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Escolha o método(s):");
        jLabel5.setOpaque(true);

        cb_selecao.setBackground(new java.awt.Color(204, 204, 204));
        cb_selecao.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        cb_selecao.setText("Seleção");
        cb_selecao.setOpaque(true);
        cb_selecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_selecaoActionPerformed(evt);
            }
        });

        cb_insercao.setBackground(new java.awt.Color(204, 204, 204));
        cb_insercao.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        cb_insercao.setText("Inserção");
        cb_insercao.setOpaque(true);
        cb_insercao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_insercaoActionPerformed(evt);
            }
        });

        cb_shake.setBackground(new java.awt.Color(204, 204, 204));
        cb_shake.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        cb_shake.setText("Shake");
        cb_shake.setOpaque(true);
        cb_shake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_shakeActionPerformed(evt);
            }
        });

        cb_pente.setBackground(new java.awt.Color(204, 204, 204));
        cb_pente.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        cb_pente.setText("Pente");
        cb_pente.setOpaque(true);
        cb_pente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_penteActionPerformed(evt);
            }
        });

        cb_shell.setBackground(new java.awt.Color(204, 204, 204));
        cb_shell.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        cb_shell.setText("Shell");
        cb_shell.setOpaque(true);
        cb_shell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_shellActionPerformed(evt);
            }
        });

        cb_quick.setBackground(new java.awt.Color(204, 204, 204));
        cb_quick.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        cb_quick.setText("Quick");
        cb_quick.setOpaque(true);
        cb_quick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_quickActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Números Ordenados:");
        jLabel6.setOpaque(true);

        txtA_ordenados.setEditable(false);
        txtA_ordenados.setBackground(new java.awt.Color(204, 204, 204));
        txtA_ordenados.setColumns(20);
        txtA_ordenados.setRows(5);
        jScrollPane2.setViewportView(txtA_ordenados);

        cb_heap.setBackground(new java.awt.Color(204, 204, 204));
        cb_heap.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        cb_heap.setText("Heap");
        cb_heap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_heapActionPerformed(evt);
            }
        });

        cb_merge.setBackground(new java.awt.Color(204, 204, 204));
        cb_merge.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        cb_merge.setText("Merge");
        cb_merge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_mergeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_carregarArquivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(136, 136, 136))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_numeros, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cb_bolha)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_selecao)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_insercao)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_shake)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_pente)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_shell)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_quick)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_heap)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_merge))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))
                                .addGap(18, 18, 18)
                                .addComponent(btn_executar)))
                        .addContainerGap(19, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btn_carregarArquivo)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_numeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cb_bolha)
                            .addComponent(cb_selecao)
                            .addComponent(cb_insercao)
                            .addComponent(cb_shake)
                            .addComponent(cb_pente)
                            .addComponent(cb_shell)
                            .addComponent(cb_quick)
                            .addComponent(cb_heap)
                            .addComponent(cb_merge)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addComponent(btn_executar))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_bolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_bolhaActionPerformed
        atualizarMetodosSelecionados();
    }//GEN-LAST:event_cb_bolhaActionPerformed

    /**
    * Ação executada quando o botão "Carregar Arquivo" é pressionado.
    * Abre um diálogo de seleção de arquivo para que o usuário escolha um 
    * arquivo de texto contendo números inteiros (um por linha). Os números 
    * são lidos, parseados e armazenados na lista numerosCarregados. Em caso 
    * de sucesso, exibe os números carregados no campo txt_numeros e mostra 
    * uma mensagem de confirmação com a quantidade de números. Se ocorrer erro 
    * de leitura ou se o arquivo contiver valores não numéricos, exibe uma 
    * mensagem de erro ao usuário.
    *
    * @param evt O evento de clique no botão "Carregar Arquivo"
    */
    private void btn_carregarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_carregarArquivoActionPerformed
        JFileChooser ch = new JFileChooser();
        int retorno = ch.showOpenDialog(this);
        if(retorno == JFileChooser.APPROVE_OPTION){
            File arquivo = ch.getSelectedFile();
            try{
                numerosCarregados = Files.lines(arquivo.toPath()).map(Integer::parseInt).toList();
                
                txt_numeros.setText(numerosCarregados.toString());   
                
                JOptionPane.showMessageDialog(this, 
                    "Arquivo carregado com sucesso!\n" +
                    "Quantidade de números: " + numerosCarregados.size(),
                    "Carregamento OK", 
        JOptionPane.INFORMATION_MESSAGE);
            }catch(IOException | NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Erro ao carregar arquivo: " + ex.getMessage());
            }
        }
        
    }//GEN-LAST:event_btn_carregarArquivoActionPerformed
    
    /**
     * Ação executada quando o botão "Executar" é pressionado.
     * Este método verifica se há números carregados e se pelo menos um algoritmo 
     * de ordenação foi selecionado. Caso contrário, exibe mensagens de aviso.
     * Para cada algoritmo de ordenação selecionado (Bolha, Seleção, Inserção, 
     * Shake, Pente, Shell ou QuickSort), uma nova Thread é criada e iniciada. 
     * Cada thread executa o método executarMetodo, passando uma cópia da lista 
     * original de números. O resultado de cada execução é adicionado ao componente 
     * txtA_ordenados de forma assíncrona, utilizando SwingUtilities.invokeLater 
     * para garantir a atualização segura da interface gráfica.
     *
     * @param evt O evento de clique no botão "Executar"
     */
    private void btn_executarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_executarActionPerformed
        if (numerosCarregados == null || numerosCarregados.isEmpty()) {  // se estiver vazia fará:
        JOptionPane.showMessageDialog(this, "Carregue um arquivo primeiro!", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
        }

        if (!cb_bolha.isSelected() && !cb_selecao.isSelected() && !cb_insercao.isSelected() &&
            !cb_shake.isSelected() && !cb_pente.isSelected() && !cb_shell.isSelected() && !cb_quick.isSelected() &&
            !cb_heap.isSelected() && !cb_merge.isSelected()) {

            JOptionPane.showMessageDialog(this, "Selecione ao menos um método de ordenação!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Iniciando execução dos métodos selecionados...", "Executando", JOptionPane.INFORMATION_MESSAGE);

        txtA_ordenados.setText("Executando métodos selecionados...\n");

        //Função para rodar cada método em uma thread separada
        Runnable executarMetodoThread = (Runnable & java.io.Serializable) () -> {}; // só para declarar
        
        // Sem lambda, fica muito GRANDE:
        /*
        if (cb_bolha.isSelected()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String resultado = executarMetodo("Bolha", new ArrayList<>(numerosCarregados));
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            txtA_ordenados.append(resultado);
                        }
                    });
                }
            }).start();
        }*/
        if (cb_bolha.isSelected()) {
            new Thread(() -> {
                String resultado = executarMetodo("Bolha", new ArrayList<>(numerosCarregados));
                SwingUtilities.invokeLater(() -> txtA_ordenados.append(resultado));
            }).start();
        }

        if (cb_selecao.isSelected()) {
            new Thread(() -> {
                String resultado = executarMetodo("Seleção", new ArrayList<>(numerosCarregados));
                SwingUtilities.invokeLater(() -> txtA_ordenados.append(resultado));
            }).start();
        }

        if (cb_insercao.isSelected()) {
            new Thread(() -> {
                String resultado = executarMetodo("Inserção", new ArrayList<>(numerosCarregados));
                SwingUtilities.invokeLater(() -> txtA_ordenados.append(resultado));
            }).start();
        }

        if (cb_shake.isSelected()) {
            new Thread(() -> {
                String resultado = executarMetodo("Shake", new ArrayList<>(numerosCarregados));
                SwingUtilities.invokeLater(() -> txtA_ordenados.append(resultado));
            }).start();
        }

        if (cb_pente.isSelected()) {
            new Thread(() -> {
                String resultado = executarMetodo("Pente", new ArrayList<>(numerosCarregados));
                SwingUtilities.invokeLater(() -> txtA_ordenados.append(resultado));
            }).start();
        }

        if (cb_shell.isSelected()) {
            new Thread(() -> {
                String resultado = executarMetodo("Shell", new ArrayList<>(numerosCarregados));
                SwingUtilities.invokeLater(() -> txtA_ordenados.append(resultado));
            }).start();
        }

        if (cb_quick.isSelected()) {
            new Thread(() -> {
                String resultado = executarMetodo("QuickSort", new ArrayList<>(numerosCarregados));
                SwingUtilities.invokeLater(() -> txtA_ordenados.append(resultado));
            }).start();
        }
        
        if (cb_heap.isSelected()) {
            new Thread(() -> {
                String resultado = executarMetodo("HeapSort", new ArrayList<>(numerosCarregados));
                SwingUtilities.invokeLater(() -> txtA_ordenados.append(resultado));
            }).start();
        }
    
        if (cb_merge.isSelected()) {
            new Thread(() -> {
                String resultado = executarMetodo("MergeSort", new ArrayList<>(numerosCarregados));
                SwingUtilities.invokeLater(() -> txtA_ordenados.append(resultado));
            }).start();
        }
        
        
        
        JOptionPane.showMessageDialog(this, "Execução concluída!\nVerifique os resultados na área de saída.",
            "Finalizado", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btn_executarActionPerformed

    private void txt_numerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numerosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numerosActionPerformed

    private void cb_selecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_selecaoActionPerformed
        atualizarMetodosSelecionados();
    }//GEN-LAST:event_cb_selecaoActionPerformed

    private void cb_insercaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_insercaoActionPerformed
        atualizarMetodosSelecionados();
    }//GEN-LAST:event_cb_insercaoActionPerformed

    private void cb_shakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_shakeActionPerformed
        atualizarMetodosSelecionados();
    }//GEN-LAST:event_cb_shakeActionPerformed

    private void cb_penteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_penteActionPerformed
        atualizarMetodosSelecionados();
    }//GEN-LAST:event_cb_penteActionPerformed

    private void cb_shellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_shellActionPerformed
        atualizarMetodosSelecionados();
    }//GEN-LAST:event_cb_shellActionPerformed

    private void cb_quickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_quickActionPerformed
        atualizarMetodosSelecionados();
    }//GEN-LAST:event_cb_quickActionPerformed

    private void cb_heapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_heapActionPerformed
        atualizarMetodosSelecionados();
    }//GEN-LAST:event_cb_heapActionPerformed

    private void cb_mergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_mergeActionPerformed
        atualizarMetodosSelecionados();
    }//GEN-LAST:event_cb_mergeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Interface_ordenacao().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_carregarArquivo;
    private javax.swing.JButton btn_executar;
    private javax.swing.JCheckBox cb_bolha;
    private javax.swing.JCheckBox cb_heap;
    private javax.swing.JCheckBox cb_insercao;
    private javax.swing.JCheckBox cb_merge;
    private javax.swing.JCheckBox cb_pente;
    private javax.swing.JCheckBox cb_quick;
    private javax.swing.JCheckBox cb_selecao;
    private javax.swing.JCheckBox cb_shake;
    private javax.swing.JCheckBox cb_shell;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtA_metodoSelecionado;
    private javax.swing.JTextArea txtA_ordenados;
    private javax.swing.JTextField txt_numeros;
    // End of variables declaration//GEN-END:variables
}
