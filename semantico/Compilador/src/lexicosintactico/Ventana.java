package lexicosintactico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Ventana extends javax.swing.JFrame {
 FileNameExtensionFilter filtro= new FileNameExtensionFilter("Archivos Word y txt","docx","txt");
    File f;
    JFileChooser j= new JFileChooser();
    String data1 [][]={};
   String cabecera1[]={"No."," Token "," Tipo"};
    String path;
    int cont=0;
    int errores;
    String mensajini="";
    String tipo="";
    public Ventana() {
        initComponents();
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        Error = new javax.swing.JEditorPane();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        txtATexto1 = new javax.swing.JEditorPane();
        Lineas = new javax.swing.JEditorPane();
        LineaError = new javax.swing.JEditorPane();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(255, 102, 51));

        tabla.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabla);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Texto del Archivo");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Table.png"))); // NOI18N
        jButton1.setText("Generar Tabla Análisis Léxico");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tabla de Simbolos");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Brush.png"))); // NOI18N
        jButton3.setText("Limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Error.setEditable(false);
        Error.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Error.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Error.setForeground(java.awt.Color.blue);
        jScrollPane5.setViewportView(Error);

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Component.png"))); // NOI18N
        jButton2.setText("Análisis Sintáctico - Semántico");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtATexto1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtATexto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtATexto1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtATexto1KeyReleased(evt);
            }
        });

        Lineas.setEditable(false);
        Lineas.setText("1");
        Lineas.setOpaque(false);

        LineaError.setEditable(false);
        LineaError.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LineaError.setForeground(java.awt.Color.red);
        LineaError.setToolTipText("");
        LineaError.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(LineaError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Lineas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtATexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lineas, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
            .addComponent(LineaError)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtATexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Lista de Errores Sintácticos y Semánticos");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
                    .addComponent(jLabel5))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(429, 429, 429))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jButton2))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(273, Short.MAX_VALUE))))
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jLabel2)
                    .addGap(597, 1216, Short.MAX_VALUE)))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addContainerGap(613, Short.MAX_VALUE)))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/About.png"))); // NOI18N
        jMenu1.setText("Opciones");
        jMenu1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Save.png"))); // NOI18N
        jMenu2.setText("Abrir");
        jMenu2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/New document.png"))); // NOI18N
        jMenuItem1.setText("Abrir Archivo.txt");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenu1.add(jMenu2);

        jMenuItem2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Apply.png"))); // NOI18N
        jMenuItem2.setText("Guardar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HashMap <String,Integer> r = new HashMap<>();
        HashMap <String,Integer> op = new HashMap<>();
        HashMap <String,Integer> id = new HashMap<>();
        HashMap <String,Integer> deli = new HashMap<>();
        HashMap <String,Integer> num = new HashMap<>();
        LinkedList <String> texto = new LinkedList<>();
    
        r.put("BEGIN", 0);
        r.put("END", 0);
        r.put("WORD", 0);
        r.put("ALFA", 0);
        r.put("NUM", 0);
        r.put("DNUM", 0);
        r.put("BOOL", 0);
        r.put("LNUM", 0);
        r.put("TAKE", 0);
        r.put("SEND", 0);
        r.put("WHEN", 0);
        r.put("IT", 0);
        r.put("IS", 0);
        r.put("START", 0);
        r.put("STEP", 0);
        r.put("TO", 0);
        r.put("STOP", 0);
        r.put("SWHEN", 0);
        r.put("COMPLETE", 0);
        
        op.put("/", 0);
        op.put("*", 0);
        op.put("+", 0);
        op.put("-", 0);
        op.put("=", 0);
        op.put("^", 0);
        op.put("<", 0);
        op.put(">", 0);
        op.put("||", 0);
        op.put("&&", 0);
        
        deli.put("#", 0);
        deli.put(";", 0);
        deli.put("{", 0);
        deli.put("}", 0);
        deli.put(")", 0);
        deli.put(",", 0);
        deli.put("(",0);
        
        
         
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Token","Cantidad","Tipo"});
        
        StringTokenizer st = new StringTokenizer(txtATexto1.getText(),"{}();,\"=+-*/><||&&# \n\t",true);
        String token, text = "";
        while (st.hasMoreTokens()){
            token = st.nextToken();
            if(!" ".equals(token) && !"\n".equals(token) && !"\t".equals(token)){
                if (r.containsKey(token)) {
                    r.put(token, r.get(token)+1);            
                }else {
                    if (op.containsKey(token)) {
                        op.put(token, op.get(token)+1);            
                    }else {
                        if (deli.containsKey(token)){
                            deli.put(token, deli.get(token)+1);
                            if("#".equals(token)){
                                token = st.nextToken();
                                while (st.hasMoreTokens() && !"#".equals(token)){
                                    text += token;
                                    token = st.nextToken();
                                }
                                texto.add(text);
                                deli.put(token, deli.get(token)+1);
                                text = "";
                            }
                        }else {
                            if (id.containsKey(token)) {
                                id.put(token, id.get(token)+1); 
                            }else {
                                if(token.matches("([0-9]*)|([0-9]*.[0-9]+)")) {
                                    if (num.containsKey(token)) {
                                        num.put(token, num.get(token)+1);
                                    }else num.put(token, 1); 
                                }
                                else id.put(token, 1); 
                            }
                        }
                    }
                }
            }
        }
        
        Iterator<String> itr = r.keySet().iterator();
        while(itr.hasNext()){
            token = itr.next();
            if(r.get(token) > 0)model.addRow(new Object[]{token, r.get(token),"Palabra Reservada"});
        } 
        itr = op.keySet().iterator();
        while(itr.hasNext()){
            token = itr.next();
            if(op.get(token) > 0) model.addRow(new Object[]{token, op.get(token),"Operador"});
        } 
        itr = deli.keySet().iterator();
        while(itr.hasNext()){
            token = itr.next();
            if(deli.get(token) > 0) model.addRow(new Object[]{token, deli.get(token),"Delimitador"});
        } 
        itr = id.keySet().iterator();
        while(itr.hasNext()){
            token = itr.next();
            if(id.get(token) > 0) model.addRow(new Object[]{token, id.get(token),"Identificador"});
        } 
        itr = num.keySet().iterator();
        while(itr.hasNext()){
            token = itr.next();
            if(num.get(token) > 0) {
                if(token.matches("[0-9]+"))model.addRow(new Object[]{token, num.get(token),"Número"});
                if(token.matches("[0-9]+.[0-9]+"))model.addRow(new Object[]{token, num.get(token),"Número Decimal"});
            }
        }
        itr = texto.iterator();
        while(itr.hasNext()){
            model.addRow(new Object[]{itr.next(), "1","Texto"});
            
        }
        tabla.setModel(model);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        errores=0;
        LinkedList <String> ENT = new LinkedList<>();
        LinkedList <String> DEC = new LinkedList<>();
        LinkedList <String> TEXT = new LinkedList<>();
        LinkedList <String> TAKE = new LinkedList<>();
        
        String
                simbolo = "([=<>])",
                id = "([(a-z)(A-Z)](\\w)*)",
                num = "((\\d)+)",
                dec = "((\\d)+(\\.)(\\d)+)",
                text = "((((#)[.\\W\\w\\s]*(#))|("+id+"))((\\s)*(\\+)((\\s)*((#)[.\\W\\w\\s]*(#))|("+id+")))*)",
                send = "((\\s)*SEND(\\s)*(\\()(\\s)*((((#)[.\\W\\w\\s]*(#))|("+id+"))((\\s)*(\\+)((\\s)*((#)[.\\W\\w\\s]*(#))|("+id+")))*)(\\s)*(\\))(\\s)*(;))",
                //take = "((\\s)*TAKE(\\b)(\\s)*"+id+"((\\s)*(,(\\s)*"+id+"))*(\\s)*(;))",
                take = "((\\s)*TAKE(\\s)*(\\()(\\s)*((((#)[.\\W\\w\\s]*(#))|("+id+"))((\\s)*(\\+)((\\s)*((#)[.\\W\\w\\s]*(#))|("+id+")))*)(\\s)*(\\))(\\s)*(;))",
                operaciones = "(("+id+"|"+num+"|"+dec+")(\\s)*([+-/*](\\s)*("+id+"|"+num+"|"+dec+"))+)",
                defVal = "((\\s)*"+id+"(\\s)*=(\\s)*("+id+"|"+text+"|"+operaciones+"|"+num+"|"+dec+")(\\s)*(;))",
                defValVar = "((\\s)*"+id+"(\\s)*=(\\s)*("+id+"|"+text+"|"+operaciones+"|"+num+"|"+dec+")(\\s)*)",
                condicion = id+"(\\s)*"+simbolo+"(\\s)*("+id+"|"+num+"|"+dec+")((\\s)*([(&&)(||)](\\s)*"+id+"(\\s)*"+simbolo+"(\\s)*("+id+"|"+num+"|"+dec+")))*",
                var = "((\\s)*((NUM)|(DNUM)|(WORD))(\\b)(\\s)*("+id+"|"+defValVar+")((\\s)*(,(\\s)*("+id+"|"+defValVar+")))*(\\s)*(;))",
                main = "((\\s)*"+id+"(\\b)(\\s)*BEGIN(\\s)*(\\{)[.\\W\\w\\s]*(END(\\s)*(\\})(\\s)*)$)",
                main2 = "((\\s)*"+id+"(\\b)(\\s)*BEGIN(\\s)*(\\{))",
                main3 = "((\\s)*END(\\s)*(\\})(\\s)*)",
                
               start2 = "((\\s)*START(\\b)(\\s)*("+id+"|"+num+")(\\b)(\\s)*(=)*("+id+"|"+num+")(\\b)(\\s)*(STEP)(\\b)(\\s)*"+num+"(\\s)*[+-]?(\\s)*(\\b)(TO)(\\b)(\\s)*("+id+"|"+num+")(\\s)*(\\{))",
                start3 = "((\\s)*STOP(\\s)*(\\}))",
                when2 = "((\\s)*WHEN(\\s)*(\\()(\\s)*"+condicion+"(\\s)*(\\))(\\s)*(\\{))",
               when3 = "((\\s)*SWHEN(\\s)*(\\}))",
                it2 = "((\\s)*IT(\\s)*(\\()(\\s)*"+condicion+"(\\s)*(\\))(\\s)*(\\{))",
                it3 = "((\\s)*COMPLETE(\\s)*(\\}))",
                 entero = "[0-9]*",
                decimal = "[0-9]*.[0-9]+";
        
                
                LinkedList <Integer> error = new LinkedList<>();
                StringTokenizer st = new StringTokenizer(txtATexto1.getText(),";{}",true);
                String token = "", txt = "", e;
                int i = 1, mainE = 0, start = 0, when = 0, it = 0, eB = 0;
                Error.setText("");
                
                if(txtATexto1.getText().matches(main)) {
                    
                    while (st.hasMoreTokens()){
                        token = st.nextToken();
                        if(st.hasMoreTokens())token = token+st.nextToken();
                        if(token.matches("[.\\W\\w\\s]*(\\})") && st.countTokens() == 1){
                            String auxTok = st.nextToken();
                            token = token+(auxTok.substring(0,auxTok.indexOf("\n")));
                        }
                            StringTokenizer lin = new StringTokenizer(token,"\n",true);
                            while (lin.hasMoreTokens()){
                                e = lin.nextToken();
                                if("\n".equals(e)) i++;
                            }
                            
                            if(token.matches(start2)) start++;
                            if(token.matches(start3)) start--;
                            if(token.matches(when2)) when++;
                            if(token.matches(when3)) when--;
                            if(token.matches(it2)) it++;
                            if(token.matches(it3)) it--;
                            if((st.hasMoreTokens() == false && (start > 0 || when > 0 || it > 0)) || (start < 0 || when < 0 || it < 0)) eB = 1;
                            
                            if((token.matches(send) || token.matches(take) || token.matches(var) || token.matches(defVal) || token.matches(main2) || token.matches(main3) || token.matches("(\\s)*(\\$)") || token.matches(start2) || token.matches(start3) || token.matches(when2) || token.matches(when3) || token.matches(it2) || token.matches(it3)) && eB == 0){
                               if(token.matches(take)){
                                   
                               }
                                if(token.matches(var)){
                                    StringTokenizer stTipo = new StringTokenizer(token," ,;");
                                    String tipo = stTipo.nextToken();
                                    
                                    if(tipo.contains("NUM")){
                                        
                                        while(stTipo.hasMoreTokens()){
                                            tipo = stTipo.nextToken();
                                            
                                            if(ENT.contains(tipo) || DEC.contains(tipo) || TEXT.contains(tipo)|| TAKE.contains(tipo)){
                                                Error.setText("La Variable esta repetida ("+tipo+") "+i+": \n"
                                                               + "________________________________________________________________________\n"+token);
                                                for(int j = 1; j <i; j++){
                                                    txt += "\n";
                                                }
                                                LineaError.setText(txt+" ¡!");
                                                errores=1;
                                                break;
                                            }
                                            
                                            ENT.add(tipo);
                                        }
                                    }
                                    if(tipo.contains("DNUM")){
                                        
                                        while(stTipo.hasMoreTokens()){
                                            tipo = stTipo.nextToken();
                                            
                                            if(ENT.contains(tipo) || DEC.contains(tipo) || TEXT.contains(tipo)|| TAKE.contains(tipo)){
                                                Error.setText("La Variable esta repetida ("+tipo+") "+i+": \n"
                                                               + "________________________________________________________________________\n"+token);
                                                for(int j = 1; j <i; j++){
                                                    txt += "\n";
                                                }
                                                LineaError.setText(txt+" ¡!");
                                                 errores=1;
                                                break;
                                            }
                                            
                                            DEC.add(tipo);
                                        }
                                    }
                                    if(tipo.contains("TAKE")){
                                       
                                        
                                        while(stTipo.hasMoreTokens()){
                                            tipo = stTipo.nextToken();
                                            
                                            if(ENT.contains(tipo) || DEC.contains(tipo) || TEXT.contains(tipo)|| TAKE.contains(tipo)){
                                                Error.setText("La Variable esta repetida ("+tipo+") "+i+": \n"
                                                               + "________________________________________________________________________\n"+token);
                                                for(int j = 1; j <i; j++){
                                                    txt += "\n";
                                                }
                                                LineaError.setText(txt+" ¡!");
                                                 errores=1;
                                                break;
                                            }
                                            
                                            TAKE.add(tipo);
                                        }
                                    }
                                    if(tipo.contains("WORD")){
                                       
                                        while(stTipo.hasMoreTokens()){
                                            tipo = stTipo.nextToken();
                                            
                                            if(ENT.contains(tipo) || DEC.contains(tipo) || TEXT.contains(tipo)|| TAKE.contains(tipo)){
                                                Error.setText("La variable esta repetida ("+tipo+") "+i+": \n"
                                                               + "________________________________________________________________________\n"+token);
                                                for(int j = 1; j <i; j++){
                                                    txt += "\n";
                                                }
                                                LineaError.setText(txt+" ¡!");
                                                 errores=1;
                                                break;
                                            }
                                            
                                            TEXT.add(tipo);
                                        }
                                    }
                                }
                                if(token.matches(defVal)){
                                    StringTokenizer stComprobar = new StringTokenizer(token," \n\t=;");
                                    String ID = stComprobar.nextToken(), comprobar = "", tok = "";
                                    //System.out.print(ID);
                                    while(stComprobar.hasMoreTokens()){
                                            comprobar += stComprobar.nextToken();
                                        }
                                    
                                    if(ENT.contains(ID)){
                                        StringTokenizer stComprobarE = new StringTokenizer(comprobar,"+*/-");
                                        while(stComprobarE.hasMoreTokens()){
                                            tok = stComprobarE.nextToken();
                                            
                                            if(tok.matches(id)){
                                                if(ENT.contains(tok));
                                                else{
                                                    Error.setText("ERROR SEMÁNTICO ("+tok+") "+i+": \n"
                                                                    + "________________________________________________________________________\n"+token);
                                                    for(int j = 1; j <i; j++){
                                                        txt += "\n";
                                                    }
                                                    LineaError.setText(txt+" ¡!");
                                                     errores=1;
                                                    break;
                                                }
                                            }
                                            else{
                                                if(tok.matches(entero));
                                                else{
                                                    Error.setText("ERROR SEMÁNTICO ("+tok+") "+i+": \n"
                                                                    + "________________________________________________________________________\n"+token);
                                                    for(int j = 1; j <i; j++){
                                                        txt += "\n";
                                                    }
                                                    LineaError.setText(txt+" ¡!");
                                                     errores=1;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        if(DEC.contains(ID)){
                                            StringTokenizer stComprobarD = new StringTokenizer(comprobar,"+*/-");
                                            while(stComprobarD.hasMoreTokens()){
                                                tok = stComprobarD.nextToken();

                                                if(tok.matches(id)){
                                                    if(DEC.contains(tok));
                                                    else{
                                                        Error.setText("ERROR SEMÁNTICO ("+tok+") "+i+": \n"
                                                                        + "________________________________________________________________________\n"+token);
                                                        for(int j = 1; j <i; j++){
                                                            txt += "\n";
                                                        }
                                                        LineaError.setText(txt+" ¡!");
                                                         errores=1;
                                                        break;
                                                    }
                                                }
                                                else{
                                                    if(tok.matches(decimal));
                                                    else{
                                                        Error.setText("ERROR SEMÁNTICO ("+tok+") "+i+": \n"
                                                                        + "________________________________________________________________________\n"+token);
                                                        for(int j = 1; j <i; j++){
                                                            txt += "\n";
                                                        }
                                                        LineaError.setText(txt+" ¡!");
                                                         errores=1;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        else {
                                            if(TEXT.contains(ID)){
                                                   if(comprobar.matches("((((\")[.\\W\\w\\s]*(\"))|("+id+"))((\\s)*(\\+)((\\s)*((\")[.\\W\\w\\s]*(\"))|("+id+")))*)"));
                                                   else {
                                                       Error.setText("ERROR SEMÁNTICO "+i+": \n"
                                                                        + "________________________________________________________________________\n"+token);
                                                        for(int j = 1; j <i; j++){
                                                            txt += "\n";
                                                        }
                                                        LineaError.setText(txt+" ¡!");
                                                         errores=1;
                                                        break;
                                                   }
                                            }
                                            else{
                                                Error.setText("Variable no declarada "+i+": \n"
                                                                + "________________________________________________________________________\n"+token);
                                                for(int j = 1; j <i; j++){
                                                   txt += "\n";
                                                }
                                                LineaError.setText(txt+" ¡!");
                                                 errores=1;
                                                break;
                                            } 
                                        }
                                    }     
                                }
                            }
                            
                            
                            else {
                                if(token.contains("SEND")){
                                    txtATraducido.setText("PRINT");
                                    Error.setText("Error al declarar sentencia SEND; en la linea "+i+": \n"
                                                   + "\n"+token);
                                     errores=1;
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                if(token.contains("NUM") || token.contains("DNUM") || token.contains("WORD")){
                                    Error.setText("Error en declaracion de variables; en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                if(token.contains("TAKE")){
                                    Error.setText("Error en lectura de valor TAKE  en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                if(token.contains("STOP}")){
                                    
                                    Error.setText("Cierre de Ciclo START incorrecto  en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                if(token.contains("START")){
                                    
                                    Error.setText("Inicio de Ciclo START incorrecto  en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                if(token.contains("SWHEN")){
                                    Error.setText("Cierre de ciclo WHEN incorrecto en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                    break;
                                }
                                if(token.contains("WHEN")){
                                    Error.setText("Inicio de ciclo WHEN incorrecto en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                if(token.contains("COMPLETE")){
                                    
                                    Error.setText("Cierre de condicion IT incorrecto en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                if(token.contains("IT")){
                                   
                                    Error.setText("Inicio de IT incorrecto; en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                else {
                                    Error.setText("Sintaxis Erronea en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                            }
                            
                            
                    }
                    
                }
                   
                else {
                    st = new StringTokenizer(txtATexto1.getText(),";{}",true);
                    while (st.hasMoreTokens()){
                        token = st.nextToken();
                        if(st.hasMoreTokens())token = token+st.nextToken();
                        if(token.matches("[.\\W\\w\\s]*(\\})") && st.countTokens() == 1){
                            String auxTok = st.nextToken();
                            token = token+(auxTok.substring(0,auxTok.indexOf("\n")));
                        }
                            StringTokenizer lin = new StringTokenizer(token,"\n",true);
                            while (lin.hasMoreTokens()){
                                e = lin.nextToken();
                                if("\n".equals(e)) i++;
                            }
                            if(eB == 1) break;
                            if(token.matches(start2)) start++;
                            if(token.matches(start3)) start--;
                            if(token.matches(when2)) when++;
                            if(token.matches(when3)) when--;
                            if(token.matches(it2)) it++;
                            if(token.matches(it3)) it--;
                            if((st.hasMoreTokens() == false && (start > 0 || when > 0 || it > 0)) || (start < 0 || when < 0 || it < 0)) eB = 1;
                            
                            if((token.matches(send) || token.matches(take) || token.matches(var) || token.matches(defVal) || token.matches(main2) || token.matches(main3) || token.matches("(\\s)*(\\$)") || token.matches(start2) || token.matches(start3) || token.matches(when2) || token.matches(when3) || token.matches(it2) || token.matches(it3)) && eB == 0){
                                Error.setText("Compilado Exitosamente xD lml");
                                if(token.matches(main3)) eB = 1;
                            }
                             
                            else {
                                if(token.contains("SEND")){
                                    Error.setText("Error al declarar sentencia SEND  en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                if(token.contains("NUM") || token.contains("DNUM") || token.contains("WORD")){
                                    Error.setText("Error en declaracion de variables  en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                if(token.contains("TAKE")){
                                    Error.setText("Error en lectura de valor TAKE en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                if(token.contains("STOP}")){
                                    Error.setText("Cierre de Ciclo START incorrecto en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                if(token.contains("START")){
                                    Error.setText("Inicio de Ciclo START incorrecto  en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                if(token.contains("SWHEN")){
                                    Error.setText("Cierre de ciclo WHEN incorrecto  en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                if(token.contains("WHEN")){
                                    Error.setText("Inicio de ciclo WHEN incorrecto  en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                if(token.contains("COMPLETE")){
                                    Error.setText("Cierre de condicion IT incorrecto; en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                if(token.contains("IT")){
                                    Error.setText("Inicio de IT incorrecto en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                                else {
                                    Error.setText("Sintaxis Erronea en la linea "+i+": \n"
                                                   + "\n"+token);
                                    for(int j = 1; j <i; j++){
                                        txt += "\n";
                                    }
                                    LineaError.setText(txt+" ¡!");
                                     errores=1;
                                    break;
                                }
                            }
                    }
                    if(mainE == 0) {
                        Error.setText("Cierre de Clase incorrecto en la Linea "+i+": \n"
                                       + "\n"+token);
                        for(int j = 1; j <1; j++){
                            txt += "\n";
                        }
                        LineaError.setText(txt+" ¡!");
                         errores=1;
                    }
                }
            if(errores==1){
            btnTraducir.setEnabled(false);
        }else{
             btnTraducir.setEnabled(true);
        }
               
             
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtATexto1.setText("");
        LineaError.setText("");
        Error.setText("");
        txtATraducido.setText("");
        btnTraducir.setEnabled(false);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtATexto1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtATexto1KeyPressed
        StringTokenizer st = new StringTokenizer(txtATexto1.getText(),"\n",true);
        String txt = "",token;
        LineaError.setText("");
        Error.setText("");
        cont = 1;

        while (st.hasMoreTokens()){
            token= st.nextToken();
            if("\n".equals(token)) cont++;
        }

        for(int i = 1; i <= cont; i++){
            txt += i+"\n";
        }
        Lineas.setText(txt);
    }//GEN-LAST:event_txtATexto1KeyPressed

    private void txtATexto1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtATexto1KeyReleased
        StringTokenizer st = new StringTokenizer(txtATexto1.getText(),"\n",true);
        String txt = "",token;
        cont = 1;

        while (st.hasMoreTokens()){
            token= st.nextToken();
            if("\n".equals(token)) cont++;
        }

        for(int i = 1; i <= cont; i++){
            txt += i+"\n";
        }
        Lineas.setText(txt);
    }//GEN-LAST:event_txtATexto1KeyReleased

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Guardar();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //Se crea un jfilechooser
        j.setCurrentDirectory(new File("src\\lexicosintactico"));
        j.getSelectedFile();
        j.setFileFilter(filtro);//Añado el filtro
        j.showOpenDialog(j);

        int contPalabra=0;//Creo un contador para las palabras
        try{
            //Aqui se manda la ruta del archivo
            path= j.getSelectedFile().getAbsolutePath();//Obtiene la Ruta
            String name=j.getSelectedFile().getName();//Obtiene el nombre
            String lectura="";
            f = new File(path);

            try{

                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String aux;
                //Aqui cuento cuantas palabras hay
                StreamTokenizer st=new StreamTokenizer(new FileReader(f));
                while(st.nextToken()!=StreamTokenizer.TT_EOF){
                    if(st.ttype==StreamTokenizer.TT_WORD){
                        contPalabra++;

                    }
            
                }

                //Aqui empieza a leer el archivo linea por linea hasta que en el texto ya no haya nada

                while((aux = br.readLine())!=null)

                lectura = lectura+aux+"\n";//Voy acumulando todo en un string

            }catch(IOException e){}

            txtATexto1.setText(lectura);//Mando lo que resulto de la lectura
            int contador=0;
            StringTokenizer st = new StringTokenizer(txtATexto1.getText(),"\n",true);
            String Text = "",token;
            contador = 1;

            while (st.hasMoreTokens()){
                token= st.nextToken();
                if("\n".equals(token)) contador++;
            }

            for(int i = 1; i <= contador; i++){
                Text += i+"\n";
            }
            Lineas.setText(Text);

          
        }catch(NullPointerException e){

            javax.swing.JOptionPane.showMessageDialog(j, "Has seleccionado cerrar programa, saliendo...");

            System.exit(0);

        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
   
        public void Guardar()
    {
        try
        {
            j = new JFileChooser();
           
            
            j.setFileSelectionMode( JFileChooser.FILES_ONLY );
            FileNameExtensionFilter filtroTxt=new FileNameExtensionFilter("Documento de Texto","txt");
            j.setFileFilter(filtroTxt);
            j.setFileHidingEnabled(false);
            int fin = this.getTitle().lastIndexOf('.');
            if(fin == -1)fin = this.getTitle().length();
            j.setSelectedFile(new File(this.getTitle().substring(0,fin)));
          
            int select = j.showSaveDialog(this);
            File guarda = j.getSelectedFile();
            
            if(select == JFileChooser.APPROVE_OPTION)
            {
                if(guarda !=null)
                {
                    FileWriter  save=new FileWriter(guarda+".txt");
                    save.write(txtATexto1.getText());
                    save.close();
                    JOptionPane.showMessageDialog(null,"Se ha guardado el archivo","Información",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,"Su archivo no se ha guardado","Advertencia",JOptionPane.WARNING_MESSAGE);
        } 
    }         
        public void Guardarbas()
    {
        try
        {
            j = new JFileChooser();
           
            
            j.setFileSelectionMode( JFileChooser.FILES_ONLY );
            FileNameExtensionFilter filtroTxt=new FileNameExtensionFilter("Archivos BAS","bas");
            j.setFileFilter(filtroTxt);
            j.setFileHidingEnabled(false);
            int fin = this.getTitle().lastIndexOf('.');
            if(fin == -1)fin = this.getTitle().length();
            j.setSelectedFile(new File(this.getTitle().substring(0,fin)));
          
            int select = j.showSaveDialog(this);
            File guarda = j.getSelectedFile();
            
            if(select == JFileChooser.APPROVE_OPTION)
            {
                if(guarda !=null)
                {
                    FileWriter  save=new FileWriter(guarda+".bas");
                    save.write(txtATraducido.getText());
                    save.close();
                    JOptionPane.showMessageDialog(null,"Se ha guardado el archivo","Información",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,"Su archivo no se ha guardado","Advertencia",JOptionPane.WARNING_MESSAGE);
        } 
    }         
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane Error;
    private javax.swing.JEditorPane LineaError;
    private javax.swing.JEditorPane Lineas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel panel1;
    private javax.swing.JTable tabla;
    private javax.swing.JEditorPane txtATexto1;
    // End of variables declaration//GEN-END:variables
}
