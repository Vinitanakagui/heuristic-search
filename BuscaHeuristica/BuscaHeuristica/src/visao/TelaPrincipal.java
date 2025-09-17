package visao;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cidade;
import modelo.CidadeProxima;


public class TelaPrincipal extends javax.swing.JFrame {

    private Map<String, Cidade> mapCidade = new HashMap<>();
    private Double distanciaFinal = 0.0;
    private Cidade cidadeAnterior;
    
    public TelaPrincipal() {
        initComponents();
        
        textDistancia.setText("0.0");
        preencherListaCidade();
        preencherTabela();
                
        tabelaOrigem.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                if (e.getClickCount() == 2) 
                { 
                    int linhaSelecionada = tabelaOrigem.getSelectedRow(); 
                    if (linhaSelecionada != -1) 
                    { 
                        preencherTextOrigem(linhaSelecionada);
                    }
                }
            }
        });
        
    }
 
    private void preencherTextOrigem(int linha)
    {
        textOrigem.setText((String) tabelaOrigem.getValueAt(linha, 0));
        textDistancia.setText("0.0");
    }
     
    private void preencherListaCidade()
    {
         String[] cidades = 
         {"Arad", "Bucharest", "Craiova", "Dobreta", "Eforie", "Fagaras", 
          "Giurgiu", "Hirsova", "Iasi", "Lugoj", "Mehadia", "Neamt", "Oradea", "Pitesti", 
          "Rimnicu Vilcea", "Sibiu", "Timisoara", "Urziceni", "Vaslui", "Zerind"
         };
         
         Double[] distanciaBucharest = {366.0, 0.0, 160.0, 242.0, 161.0, 176.0, 77.0, 151.0, 226.0, 
             244.0, 241.0, 234.0,380.0, 10.0, 193.0, 253.0, 329.0, 80.0, 199.0, 374.0};
         
         for(String nome : cidades)
         {
             this.mapCidade.put(nome, new Cidade());
             this.mapCidade.get(nome).setNome(nome);
             this.mapCidade.get(nome).setListaCidadeProxima(new ArrayList<>());
         }
         
         for (int i = 0; i < cidades.length; i++) 
         {
             this.mapCidade.get(cidades[i]).setDistanciaBucharest(distanciaBucharest[i]);
        
         }
            
        adicionarCidadeProxima("Arad", "Zerind", 75.0);
        adicionarCidadeProxima("Arad", "Sibiu", 140.0);
        adicionarCidadeProxima("Arad", "Timisoara", 118.0);
        adicionarCidadeProxima("Zerind", "Oradea", 71.0);
        adicionarCidadeProxima("Zerind", "Arad", 75.0);
        adicionarCidadeProxima("Oradea", "Sibiu", 151.0);
        adicionarCidadeProxima("Oradea", "Zerind", 75.0);
        adicionarCidadeProxima("Timisoara", "Lugoj", 111.0);
        adicionarCidadeProxima("Timisoara", "Arad", 118.0);
        adicionarCidadeProxima("Lugoj", "Mehadia", 70.0);
        adicionarCidadeProxima("Lugoj", "Timisoara", 111.0);
        adicionarCidadeProxima("Mehadia", "Dobreta", 75.0);
        adicionarCidadeProxima("Mehadia", "Lugoj", 70.0);
        adicionarCidadeProxima("Dobreta", "Mehadia", 75.0);
        adicionarCidadeProxima("Dobreta", "Craiova", 120.0);
        adicionarCidadeProxima("Craiova", "Rimnicu Vilcea", 146.0);
        adicionarCidadeProxima("Craiova", "Pitesti", 138.0);
        adicionarCidadeProxima("Craiova", "Dobreta", 120.0);
        adicionarCidadeProxima("Rimnicu Vilcea", "Sibiu", 80.0);
        adicionarCidadeProxima("Rimnicu Vilcea", "Pitesti", 97.0);
        adicionarCidadeProxima("Rimnicu Vilcea", "Craiova", 146.0);
        adicionarCidadeProxima("Sibiu", "Fagaras", 99.0);
        adicionarCidadeProxima("Sibiu", "Arad", 140.0);
        adicionarCidadeProxima("Sibiu", "Rimnicu Vilcea", 80.0);
        adicionarCidadeProxima("Sibiu", "Oradea", 151.0);
        adicionarCidadeProxima("Fagaras", "Bucharest", 211.0);
        adicionarCidadeProxima("Fagaras", "Sibiu", 99.0);
        adicionarCidadeProxima("Pitesti", "Bucharest", 101.0);
        adicionarCidadeProxima("Pitesti", "Craiova", 128.0);
        adicionarCidadeProxima("Pitesti", "Rimnicu Vilcea", 97.0);
        adicionarCidadeProxima("Bucharest", "Giurgiu", 90.0);
        adicionarCidadeProxima("Bucharest", "Urziceni", 85.0);
        adicionarCidadeProxima("Bucharest", "Fagaras", 211.0);
        adicionarCidadeProxima("Bucharest", "Pitesti", 10.0);
        adicionarCidadeProxima("Urziceni", "Vaslui", 142.0);
        adicionarCidadeProxima("Urziceni", "Hirsova", 98.0);
        adicionarCidadeProxima("Urziceni", "Bucharest", 85.0);
        adicionarCidadeProxima("Hirsova", "Eforie", 86.0);
        adicionarCidadeProxima("Hirsova", "Urziceni", 98.0);
        adicionarCidadeProxima("Vaslui", "Iasi", 92.0);
        adicionarCidadeProxima("Vaslui", "Urziceni", 142.0);
        adicionarCidadeProxima("Iasi", "Neamt", 87.0);
        adicionarCidadeProxima("Iasi", "Vaslui", 92.0);
        adicionarCidadeProxima("Giurgiu", "Bucharest", 90.0);
        adicionarCidadeProxima("Neamt", "Iasi", 87.0);
        adicionarCidadeProxima("Eforie", "Hirsova", 86.0);

        
        
    }
    
    private void adicionarCidadeProxima(String cidade1, String cidade2, Double distancia)
    {
        Cidade cidadeAux = this.mapCidade.get(cidade2);
        CidadeProxima cidadeProximaAux = new CidadeProxima();
        cidadeProximaAux.setCidade(cidadeAux);
        cidadeProximaAux.setDistancia(distancia);
        
        this.mapCidade.get(cidade1).getListaCidadeProxima().add(cidadeProximaAux);
    }
    private void preencherTabela()
    {
        DefaultTableModel modeloOrigem = (DefaultTableModel) tabelaOrigem.getModel();
        
        String[] cidades = 
         {"Arad", "Bucharest", "Craiova", "Dobreta", "Eforie", "Fagaras", 
          "Giurgiu", "Hirsova", "Iasi", "Lugoj", "Mehadia", "Neamt", "Oradea", "Pitesti", 
          "Rimnicu Vilcea", "Sibiu", "Timisoara", "Urziceni", "Vaslui", "Zerind"
         };
        
        for (String cidade : cidades) 
        {
            modeloOrigem.addRow( new String[]{cidade});
 
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaOrigem = new javax.swing.JTable();
        botaoCalcular = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textOrigem = new javax.swing.JTextField();
        textDestino = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textDistancia = new javax.swing.JTextField();
        checkBuscaGulosa = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Origem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tabelaOrigem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaOrigem);
        if (tabelaOrigem.getColumnModel().getColumnCount() > 0) {
            tabelaOrigem.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        botaoCalcular.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botaoCalcular.setText("Calcular");
        botaoCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCalcularActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Busca A* e Busca Gulosa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(337, 337, 337))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Destino:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Origem:");

        textOrigem.setEditable(false);
        textOrigem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        textDestino.setEditable(false);
        textDestino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDestino.setText("Bucharest");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Distância:");

        textDistancia.setEditable(false);
        textDistancia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        checkBuscaGulosa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        checkBuscaGulosa.setText("Busca Gulosa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkBuscaGulosa))
                            .addComponent(textDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botaoCalcular))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBuscaGulosa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(botaoCalcular)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
   private List<Cidade> buscarCidadesNaoPassadas(Cidade cidade, List<Cidade> cidadesPassadas)
   {
       List<Cidade> listaAux = new ArrayList<>();
       
       for (CidadeProxima c : cidade.getListaCidadeProxima()) 
       {
           if(!cidadesPassadas.contains(c.getCidade()))
           {   
               listaAux.add(c.getCidade());
           }
       }
       
       if(listaAux.isEmpty())
       {
           return null;
       }
       else
       {
           return listaAux;
       }
   }
   
    private Double retornarMenorDistanciaEntreCidadeBuscaGulosa(Cidade origem, Cidade destino)
    {
        for (CidadeProxima cidade : origem.getListaCidadeProxima())
        {
            if(cidade.getCidade().equals(destino))
            {
                return cidade.getDistancia();
            }
        }
        
        return 0.0;
    }
    private Cidade menorRotaBuscaGulosa(Cidade cidade, List<Cidade> cidadesPassadas)
    {
        List<Cidade> listaCidadesNaoPassadas = buscarCidadesNaoPassadas(cidade, cidadesPassadas);
       
        if(listaCidadesNaoPassadas.isEmpty())
        {
          JOptionPane.showMessageDialog(this, "Todas cidades foram Passadas","Atenção", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            Double menorDistanciaBucharest = listaCidadesNaoPassadas.get(0).getDistanciaBucharest();
            Double menorDistancia = 0.0;
            int indice = 0;
           
            for (int i = 0; i < listaCidadesNaoPassadas.size(); i++)
            {
                if(menorDistanciaBucharest > listaCidadesNaoPassadas.get(i).getDistanciaBucharest())
                {
                    menorDistanciaBucharest = listaCidadesNaoPassadas.get(i).getDistanciaBucharest();
                    menorDistancia = retornarMenorDistanciaEntreCidadeBuscaGulosa(cidade, listaCidadesNaoPassadas.get(i));
                    indice = i;
                }
            }
            
       
            if(indice == 0)
            {    
              menorDistancia = retornarMenorDistanciaEntreCidadeBuscaGulosa(cidade, listaCidadesNaoPassadas.get(0));
              distanciaFinal += menorDistancia;
              return listaCidadesNaoPassadas.get(0);
            }
            else
            {
                distanciaFinal += menorDistancia;
                return listaCidadesNaoPassadas.get(indice);
            }
            
        }
        
        return null;
    }
  
    private void buscaGulosa(Cidade origem, Cidade destino)
    {

        Cidade aux = origem;
        List<Cidade> cidadesPassadas = new ArrayList<>();
        cidadesPassadas.add(origem);
        
        do
        {
            aux = menorRotaBuscaGulosa(aux, cidadesPassadas);
            cidadesPassadas.add(aux);
             
        }while(!aux.equals(destino));
    }
    
    private Map<String, Double> retornarCidadesBuscaEstrela(Cidade origem)
    {
        Map<String, Double> mapCidadeAux = new HashMap<>();
        
        for (CidadeProxima c : origem.getListaCidadeProxima())
        {
            mapCidadeAux.put(c.getCidade().getNome(), c.getDistancia());
        }
        
        if(mapCidadeAux.isEmpty())
        {
            return null;
        }
        else
        {
            return mapCidadeAux;
        }
    }
    
    private Cidade retornarCidadePorNome(String nome)
    {
        return mapCidade.get(nome);
    }
    private Cidade menorRotaBuscaEstrela(Cidade cidade, List<Cidade> cidadesPassadas)
    {
        List<Cidade> listaCidadesNaoPassadas = buscarCidadesNaoPassadas(cidade, cidadesPassadas);
       
        Map<String, Double> mapCidadeAux = retornarCidadesBuscaEstrela(cidade);
        Double menorDistancia = Double.MAX_VALUE;
        Double distanciaAux = 0.0;
        String chave = "";

         for (Map.Entry<String, Double> entry : mapCidadeAux.entrySet())
         {
            Cidade aux = retornarCidadePorNome(entry.getKey());
            
            if(listaCidadesNaoPassadas.contains(aux))
            {
                if (entry.getValue() + aux.getDistanciaBucharest() < menorDistancia) 
                {
                    menorDistancia = entry.getValue() + aux.getDistanciaBucharest();
                    distanciaAux = entry.getValue();
                    chave = entry.getKey();
                }
            }
            
        }

        distanciaFinal += distanciaAux;

        return retornarCidadePorNome(chave);

   }
    private void buscaEstrela(Cidade origem, Cidade destino)
    {
        Cidade aux = origem;
        List<Cidade> cidadesPassadas = new ArrayList<>();
        cidadesPassadas.add(origem);
        
        do
        {
            aux = menorRotaBuscaEstrela(aux, cidadesPassadas);
            cidadesPassadas.add(aux);
            System.out.println("Cidade: " + aux.getNome());
//            System.out.println("Tamanho: " + cidadesPassadas.size());
             
        }while(!aux.equals(destino));
    }
    private void botaoCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCalcularActionPerformed
       
        Cidade origem = mapCidade.get(textOrigem.getText());
        Cidade destino = mapCidade.get(textDestino.getText());
        distanciaFinal = 0.0;
        
        textDistancia.setText("0.0");
        
        if(origem.equals(destino))
        {
            textDistancia.setText("0");
        }
        else
        {
            if(checkBuscaGulosa.isSelected())
            {
                buscaGulosa(origem, destino);
                
            }
            else
            {
                buscaEstrela(origem, destino);
            }
            
            textDistancia.setText(String.valueOf(distanciaFinal));
        }
       
        
    }//GEN-LAST:event_botaoCalcularActionPerformed
   
  
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCalcular;
    private javax.swing.JCheckBox checkBuscaGulosa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaOrigem;
    private javax.swing.JTextField textDestino;
    private javax.swing.JTextField textDistancia;
    private javax.swing.JTextField textOrigem;
    // End of variables declaration//GEN-END:variables
}
