/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Compilador;

import Propiedades.Propiedades;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import Compilador.Tokens;
import java_cup.runtime.Symbol;
import java.awt.Color;
import static java.awt.PageAttributes.MediaType.C;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;

/**
 *
 * @author Geovah
 */
public class Compiler extends javax.swing.JFrame {
    String NameArchivo = "";
    String PathArchivo = "";
    String PathA = "";
    NumeroLinea numerolinea;
    int rowCount = 0;
    
    private File openFile;
    List<String> separarContenido = null;
    DefaultMutableTreeNode nodoRaiz = null;
    DefaultTreeModel modeloArbol = null;
    
    public static String etiquetas;
    private ArrayList<String> etiquetasHtml;
    private String etiqueta;
    
    
    
    /**
     * Creates new form Editor
     */
    public Compiler() {
        initComponents();
        this.setLocationRelativeTo(null);
        jFrame3.setLocationRelativeTo(null);
        jFrame4.setLocationRelativeTo(null);
        jFrame5.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        cargaPropiedades();
        
        /*DefaultTreeModel modeloArbol = (DefaultTreeModel) jTree1.getModel();
        modeloArbol.setRoot(null);*/
        
        numerolinea = new NumeroLinea(txtEditor);
        jScrollPane3.setRowHeaderView(numerolinea);
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
            e.printStackTrace();
        }
      //  jMenuItem3.setEnabled(false);
    }
    
    private void analizarLexico() throws IOException{
        int cont = 1;
        
        String expr = (String) txtEditor.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                txtLexico.setText(resultado);
                return;
            }
            switch (token) {
                case Linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                case T_datos:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    break;
                case Estructuras_control:
                    resultado += "  <Estructura de control>\t" + lexer.lexeme + "\n";
                    break;
                case Estructuras_iteracion:
                    resultado += "  <Estructura de iteracion>\t" + lexer.lexeme + "\n";
                    break;
                case Mod:
                    resultado += "  <Mod>\t" + lexer.lexeme + "\n";
                    break;
                case Corchete_a:
                    resultado += "  <Corchete abierto>\t" + lexer.lexeme + "\n";
                    break;
                case Corchete_c:
                    resultado += "  <Corchete cerrado>\t" + lexer.lexeme + "\n";
                    break;
                case Escribir:
                    resultado += "  <Funcion de salida de texto>\t" + lexer.lexeme + "\n";
                    break;
                case Comillas:
                    resultado += "  <Comillas>\t\t" + lexer.lexeme + "\n";
                    break;
                case D_puntos:
                    resultado += "  <Dos puntos>\t\t" + lexer.lexeme + "\n";
                    break;
                case Diferente:
                    resultado += "  <Diferente>\t\t" + lexer.lexeme + "\n";
                    break;
                case Leer:
                    resultado += "  <Funcion de entrada de texto>\t" + lexer.lexeme + "\n";
                    break;
                case Coma:
                    resultado += "  <Coma>\t" + lexer.lexeme + "\n";
                    break;
                case Punto:
                    resultado += "  <Punto>\t" + lexer.lexeme + "\n";
                    break;
                case Entrada:
                    resultado += "  <Entrada de texto>\t" + lexer.lexeme + "\n";
                    break;
                case Salida:
                    resultado += "  <Salida de texto>\t" + lexer.lexeme + "\n";
                    break;
                case Librerias:
                    resultado += "  <Libreria>\t\t" + lexer.lexeme + "\n";
                    break;
                case Reservadas:
                    resultado += "  <Reservada>\t\t" + lexer.lexeme + "\n";
                    break;
                case Main:
                    resultado += "  <Funcion principal>\t" + lexer.lexeme + "\n";
                    break;
                case End:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t" + lexer.lexeme + "\n";
                    break;
                case Suma:
                    resultado += "  <Operador suma>\t" + lexer.lexeme + "\n";
                    break;
                case Resta:
                    resultado += "  <Operador resta>\t" + lexer.lexeme + "\n";
                    break;
                case Multiplicacion:
                    resultado += "  <Operador multiplicacion>\t" + lexer.lexeme + "\n";
                    break;
                case Division:
                    resultado += "  <Operador division>\t" + lexer.lexeme + "\n";
                    break;
                case Parentesis_a:
                    resultado += "  <Parentesis de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Parentesis_c:
                    resultado += "  <Parentesis de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_a:
                    resultado += "  <Llave de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_c:
                    resultado += "  <Llave de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case P_coma:
                    resultado += "  <Punto y coma>\t" + lexer.lexeme + "\n";
                    break;
            
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    break;
                case Asm:
                    resultado += "  <Ensamblador>\t\t" + lexer.lexeme + "\n";
                    break;
                case AX:
                    resultado += "  <Ensamblador registro AX>\t\t" + lexer.lexeme + "\n";
                    break;
                case CX:
                    resultado += "  <Ensamblador registro CX>\t\t" + lexer.lexeme + "\n";
                    break;
                case BX:
                    resultado += "  <Ensamblador registro CX>\t\t" + lexer.lexeme + "\n";
                    break;
               case DX:
                    resultado += "  <Ensamblador registro DX>\t\t" + lexer.lexeme + "\n";
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
        }
    }
    
    class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter {
        public MyHighlightPainter(Color color){
            super(color);
            
        }
    }
    
    Highlighter.HighlightPainter myHighlightPainter = new MyHighlightPainter(Color.LIGHT_GRAY);
    
    public void removeHighlights(JTextComponent TextPanel){
        Highlighter hilite = TextPanel.getHighlighter();
        Highlighter.Highlight[] hilites = hilite.getHighlights();
        
        for (int i = 0; i<hilites.length; i++){
            if(hilites[i].getPainter() instanceof MyHighlightPainter){
                hilite.removeHighlight(hilites[i]);
            }
        }
    }
    
    public void highlight(JTextComponent TextPanel, String Pattern){
        
        removeHighlights(TextPanel);
        try{
            Highlighter hilite = TextPanel.getHighlighter();
            Document doc = TextPanel.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;
            
            while((pos=text.toUpperCase().indexOf(Pattern.toUpperCase(),pos))>=0){
                hilite.addHighlight(pos, pos+Pattern.length(), myHighlightPainter);
                pos += Pattern.length();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
 regenerated by the Form Compiler.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        txtFind = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        txtClose = new javax.swing.JButton();
        jFrame2 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        t1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnFind1 = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnReplace = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        jFrame3 = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLexico = new javax.swing.JTextArea();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jFrame4 = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jFrame5 = new javax.swing.JFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtC = new javax.swing.JTextArea();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtEditor = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();

        jFrame1.setTitle("Find");
        jFrame1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jFrame1.setLocation(new java.awt.Point(425, 150));
        jFrame1.setMaximizedBounds(new java.awt.Rectangle(425, 150, 440, 150));
        jFrame1.setMinimumSize(new java.awt.Dimension(440, 150));

        jLabel1.setText("Find:");

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        txtClose.setText("Close");
        txtClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtClose)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFind)
                            .addComponent(txtClose))))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 85, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jFrame2.setLocation(new java.awt.Point(425, 150));
        jFrame2.setMaximizedBounds(new java.awt.Rectangle(425, 150, 400, 200));
        jFrame2.setMinimumSize(new java.awt.Dimension(400, 200));

        jLabel2.setText("Find:");

        btnFind1.setText("Find");
        btnFind1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFind1ActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnReplace.setText("Replace");
        btnReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplaceActionPerformed(evt);
            }
        });

        jLabel3.setText("Replace:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReplace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFind1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReplace))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClose)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jFrame3.setMinimumSize(new java.awt.Dimension(375, 500));

        txtLexico.setColumns(20);
        txtLexico.setRows(5);
        jScrollPane1.setViewportView(txtLexico);

        jMenu5.setText("Back");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar3.add(jMenu5);

        jFrame3.setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        jFrame4.setMinimumSize(new java.awt.Dimension(375, 200));

        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarSin);

        jMenu4.setText("Back");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenuBar2.add(jMenu4);

        jFrame4.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout jFrame4Layout = new javax.swing.GroupLayout(jFrame4.getContentPane());
        jFrame4.getContentPane().setLayout(jFrame4Layout);
        jFrame4Layout.setHorizontalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );
        jFrame4Layout.setVerticalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        );

        jFrame5.setMinimumSize(new java.awt.Dimension(730, 435));

        txtC.setColumns(20);
        txtC.setRows(5);
        jScrollPane4.setViewportView(txtC);

        jMenu7.setText("BACK");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar4.add(jMenu7);

        jMenu9.setText("SAVE");
        jMenu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu9ActionPerformed(evt);
            }
        });

        jMenuItem17.setText("Save as CPP");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem17);

        jMenuBar4.add(jMenu9);

        jMenu8.setText("COMPILE");

        jMenuItem18.setText("Compile");
        jMenuItem18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem18MouseClicked(evt);
            }
        });
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem18);

        jMenuBar4.add(jMenu8);

        jMenu10.setText("RUN");

        jMenuItem19.setText("Run");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem19);

        jMenuBar4.add(jMenu10);

        jFrame5.setJMenuBar(jMenuBar4);

        javax.swing.GroupLayout jFrame5Layout = new javax.swing.GroupLayout(jFrame5.getContentPane());
        jFrame5.getContentPane().setLayout(jFrame5Layout);
        jFrame5Layout.setHorizontalGroup(
            jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jFrame5Layout.setVerticalGroup(
            jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(103, 103, 103));

        txtEditor.setBackground(new java.awt.Color(55, 71, 79));
        txtEditor.setFont(txtEditor.getFont());
        txtEditor.setForeground(new java.awt.Color(254, 254, 254));
        txtEditor.setAlignmentX(0.1F);
        txtEditor.setCaretColor(new java.awt.Color(254, 254, 254));
        txtEditor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtEditor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEditorKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(txtEditor);

        jMenu3.setText("Compilar");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem6.setText("Analizador Lexico");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenuItem6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuItem6KeyPressed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem13.setText("Analizador Sintactico y Semantico");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuBar1.add(jMenu3);

        jMenu6.setText("Convertir");

        jMenuItem14.setText("C++");
        jMenuItem14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem14MouseClicked(evt);
            }
        });
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem14);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEditorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditorKeyReleased
        try {
            poneColores();
            
            if (txtEditor.getText().equals(" ")) {
                nodoRaiz.removeAllChildren();
            }
            
            if (evt.getKeyCode() == 10 || evt.getKeyCode() == 9 || evt.getKeyCode() == 46) {
                if (nodoRaiz != null) {
                    nodoRaiz.removeAllChildren();
                }
                obtenerContenido();
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtEditorKeyReleased
    
    private void obtenerContenido() {
        try {
            /*nodoRaiz = (DefaultMutableTreeNode) jTree1.getModel().getRoot();
            modeloArbol = (DefaultTreeModel) jTree1.getModel();*/
            
            separarContenido = null;
            separarContenido = Arrays.asList(txtEditor.getText().split("\\r?\\n"));
            
            if (separarContenido.size() > 0) {
                if (nodoRaiz != null) {
                    
                    for (int i = 1; i < separarContenido.size(); i++) {
                        nodoRaiz.add(new DefaultMutableTreeNode(i + separarContenido.get(i)));
                    }
                }
                if (nodoRaiz == null) {
                    nodoRaiz = new DefaultMutableTreeNode(separarContenido.get(0));
                }
                
                modeloArbol.setRoot(nodoRaiz);
                modeloArbol.reload(nodoRaiz);
                /*jTree1.expandPath(new TreePath(nodoRaiz.getPath()));*/
            }
            
        } catch (Exception e) {
        }
    }
    
    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        
        highlight(txtEditor, txtFind.getText());
    }//GEN-LAST:event_btnFindActionPerformed

    private void txtCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCloseActionPerformed
        // TODO add your handling code here:
        jFrame1.hide();
    }//GEN-LAST:event_txtCloseActionPerformed

    private void btnFind1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFind1ActionPerformed
        // TODO add your handling code here:
        highlight(txtEditor, t1.getText());
    }//GEN-LAST:event_btnFind1ActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        jFrame2.hide();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplaceActionPerformed
        // TODO add your handling code here:
        String a = t1.getText();
        String b = t2.getText();
        String c = txtEditor.getText();
        
        String d = c.replace(a, b);
        txtEditor.setText(d);

    }//GEN-LAST:event_btnReplaceActionPerformed
    
    private void jMenuItem6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuItem6KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem6KeyPressed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        jFrame3.show();
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        jFrame4.show();
        String ST = txtEditor.getText();
        Sintax s = new Sintax(new Compilador.LexerCup(new StringReader(ST)));
        
        try {
            s.parse();
            txtAnalizarSin.setText("Analisis realizado correctamente: No hay errores");
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalizarSin.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtAnalizarSin.setForeground(Color.red);
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        jFrame4.hide();
        this.show();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        jFrame3.hide();
        this.show();
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenuItem14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14MouseClicked

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        jFrame5.show();
        String info = txtEditor.getText();
        txtC.setText(info);
        
        String s=txtC.getText();
        String replaceString=s.replaceAll("inicio", "inicio");
        txtC.setText(replaceString);
        
        String s2=txtC.getText();
        String replaceString2=s2.replaceAll("entero", "int");
        txtC.setText(replaceString2);
        
        String s3=txtC.getText();
        String replaceString3=s3.replaceAll("hacer", "do");
        txtC.setText(replaceString3);
        
        String s4=txtC.getText();
        String replaceString4=s4.replaceAll("escribir", "cout");
        txtC.setText(replaceString4);
        
        String s5=txtC.getText();
        String replaceString5=s5.replaceAll("leer", "cin");
        txtC.setText(replaceString5);
        
        String s6=txtC.getText();
        String replaceString6=s6.replaceAll("mientras", "while");
        txtC.setText(replaceString6);

    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        // TODO add your handling code here:
        jFrame5.hide();
        this.show();
        
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu9ActionPerformed

    public void guardar(){
        try{
            JFileChooser file=new JFileChooser();
            file.showSaveDialog(this);
            File guarda=file.getSelectedFile();
        if(guarda != null)
        {
        try(FileWriter save = new FileWriter (guarda + ".asm")){
            save.write(txtC.getText());
            PathArchivo = guarda.getAbsolutePath();
            NameArchivo = guarda.getName();
            PathA = guarda.getPath();
        }
        JOptionPane.showMessageDialog(null, "Archivo guardado satisfactoriamente");
        }
        }catch(IOException ex) {ex.printStackTrace();}{ 
        }
    }
    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        guardar();
        
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        System.out.println(PathArchivo);
        System.out.println(NameArchivo);
        System.out.println(PathA);
        PrintWriter ost=null;
        try{
            ost = new PrintWriter(NameArchivo+".bat");
        }catch(IOException ex){
            Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ost.println("@echo off");
        ost.println("title Compiler");
        ost.println("CD " + PathArchivo);
        ost.println("g++" + " " + "-c" + " " + NameArchivo + ".asm");
        ost.println("g++" + " " + "-o" + " " + NameArchivo + ".exe" + " " + NameArchivo + ".asm");
        ost.println("CLS");
        ost.println("@exit");
        ost.println("pause");
        ost.close(); 
        Runtime rt = Runtime.getRuntime();
        
        try{
            rt.exec("cmd /c start " + NameArchivo + ".bat");

        }catch(IOException ex){
            Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem18MouseClicked

    public void ejecutar(){
           PrintWriter ost=null;
        try{
            ost = new PrintWriter(NameArchivo+".bat");
        }catch(IOException ex){
            Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ost.println("@echo off");
        //ost.println("title Compiler");
        ost.println("CD " + PathArchivo);
        ost.println(NameArchivo+".exe");
        //ost.println("g++" + " " + "-c" + " " + NameArchivo + ".cpp");
        //ost.println("g++" + " " + "-o" + " " + NameArchivo + ".exe" + " " + NameArchivo + ".cpp");
        //ost.println("CLS");
        ost.println("pause");
        ost.println("@exit");
        ost.close(); 
        Runtime rt = Runtime.getRuntime();
        
        try{
            rt.exec("cmd /c start " + NameArchivo + ".bat");
        }catch(IOException ex){
            Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        ejecutar();
        
    }//GEN-LAST:event_jMenuItem19ActionPerformed
    
    public void poneColores() throws BadLocationException {
        actualizaColorTexto(txtEditor,0, txtEditor.getText().length(), new Color(255, 255 ,255));

        llenaString(etiquetasHtml);
        compilaPalabras(txtEditor, new Color(144, 202, 249), etiquetas, true);//Compilar las palabras primarias
        compilaPalabras(txtEditor,Color.yellow, "\".*\"", false);
    }
    
    
    private void compilaPalabras(JTextPane text,Color color, String exp, boolean bold) {
        Pattern patron = Pattern.compile(exp);
        
        DefaultStyledDocument d= (DefaultStyledDocument) text.getDocument();
        CharSequence texto = null;
        try {
            texto = d.getText(0, d.getLength());
        } catch (BadLocationException ex) { }
        Matcher matcher = patron.matcher(texto);
        
        while (matcher.find()) {
            actualizaColorTexto(txtEditor,matcher.start(), matcher.end() - matcher.start(), color);
        }
    }
    
    private void actualizaColorTexto(JTextPane text,int i, int length, Color c) {
        StyledDocument doc = text.getStyledDocument();
        SimpleAttributeSet aset = new SimpleAttributeSet();
        StyleConstants.setForeground(aset, c);
        doc.setCharacterAttributes(i, length, aset, true);
    }
    public void llenaString(ArrayList<String> keys) {
        StringBuilder buff = new StringBuilder("");
        buff.append("(");
        for (String keyword : keys) {
            buff.append("\\b").append(keyword).append("\\b").append("|");
        }
        buff.deleteCharAt(buff.length() - 1);
        buff.append(")");
        etiquetas = buff.toString();
    }
    public void principales() {
        etiquetasHtml = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(getPalabraPrincipal(), " ");
        while (st.hasMoreTokens()) {
            etiquetasHtml.add(st.nextToken());
        }
    }
    
    private void cargaPropiedades() {
        Propiedades prop = new Propiedades();
        Properties p = prop.getProperties("Propiedades/tipoArchivo.properties");
        etiqueta = p.getProperty("principales");
        principales();
    }
    
    public String getPalabraPrincipal() {
        return etiqueta;
    }
    
    
    private void open(){
        try{
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Abrir archivo");
            chooser.showOpenDialog(null);
            openFile = chooser.getSelectedFile();
            if(openFile != null && !openFile.exists()){
                JOptionPane.showMessageDialog(null, "El archivo no existe", "Error", JOptionPane.ERROR_MESSAGE);
                openFile = null;
                return;
            }
            Scanner reader = new Scanner(openFile);
            String contents = "";
            while(reader.hasNextLine()){
                contents += reader.nextLine()+"\n";
            }
            reader.close();
            txtEditor.setText(contents);
            
            this.setTitle(openFile.getName());
            //jMenuItem3.setEnabled(true);
            poneColores();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void create(){
        try{
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Guardar archivo");
            chooser.showSaveDialog(null);
            
            openFile = chooser.getSelectedFile();
            save();
            //jMenuItem3.setEnabled(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void save(){
        try{
            if(openFile == null){
                JOptionPane.showMessageDialog(null, "Error guardando, no hay archivo seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
                
                return;
            }
            String contents = txtEditor.getText();
            
            Formatter form = new Formatter(openFile);
            form.format("%s", contents);
            form.close();
            this.setTitle(openFile.getName());
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void close(){
        try{
            int input = JOptionPane.showConfirmDialog(null, "Quiere guardar los cambios?", "Un momento", JOptionPane.YES_NO_CANCEL_OPTION);
            if(input == JOptionPane.YES_OPTION){
                create();
                System.exit(input);
            }else if(input == JOptionPane.CANCEL_OPTION){
                this.show();
            }else if(input == JOptionPane.NO_OPTION){
                System.exit(input);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void New(){
        try{
            int input = JOptionPane.showConfirmDialog(null, "Quiere guardar los cambios?", "Un momento", JOptionPane.YES_NO_CANCEL_OPTION);
            if(input == JOptionPane.YES_OPTION){
                create();
                txtEditor.setText(null);
                this.setTitle("Html Editor");
                //jMenuItem3.setEnabled(false);
                this.show();
            }else if(input == JOptionPane.CANCEL_OPTION){
                this.show();
            }else if(input == JOptionPane.NO_OPTION){
                txtEditor.setText(null);
                this.setTitle("Html Editor");
                //jMenuItem3.setEnabled(false);
                this.show();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
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
            java.util.logging.Logger.getLogger(Compiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Compiler().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnFind1;
    private javax.swing.JButton btnReplace;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JFrame jFrame4;
    private javax.swing.JFrame jFrame5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextArea txtAnalizarSin;
    private javax.swing.JTextArea txtC;
    private javax.swing.JButton txtClose;
    private javax.swing.JTextPane txtEditor;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextArea txtLexico;
    // End of variables declaration//GEN-END:variables
    
}
