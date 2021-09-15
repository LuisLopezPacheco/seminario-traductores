
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using System.IO;

namespace Analizador_lexico
{
	/// <summary>
	/// Description of MainForm.
	/// </summary>
	public partial class MainForm : Form
	{
		public MainForm() {
			
			//
			// The InitializeComponent() call is required for Windows Forms designer support.
			//
			InitializeComponent();
			
			dataTable.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
			dataTableError.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
			resize();
			textBox.Multiline = true;
			textBox.AcceptsTab = true;
			//textBox.SelectionTabs  = new int[] {20};
			//
			// TODO: Add constructor code after the InitializeComponent() call.
			//
		}
		
		
		void EjecutarToolStripMenuItemClick(object sender, EventArgs e) {
			//codigo a ejecutar
			String entrada = textBox.Text;
			AnalizadorLexico lex = new AnalizadorLexico(entrada);
			LinkedList<Token> lTokens = lex.escanear();
			//MessageBox.Show();
			LinkedList<Token> lTokensError = lex.listError();
			
			limpiar();
			rellenar(lTokens, lTokensError);
		/*
			//analizador sintactico
			analizadorSintactico sin = new analizadorSintactico(lTokens);
			if(lTokensError.Count == 0) {
				if(sin.analizar()) {
					MessageBox.Show("valido");
				} else {
					MessageBox.Show("Sintaxis invalido");
				}
			} else {
				MessageBox.Show("Lexico invaldio");
				
			}*/
			
		}
		
		void rellenar(LinkedList<Token> lista, LinkedList<Token> listaError) {
			//int count = 0;
			foreach(Token item in lista) {
				dataTable.Rows.Add(item.getStado(), item.getToken(), item.getFila(), item.gefColumna(), item.getId());
				
				
			}
			foreach(Token item in listaError) {
				dataTableError.Rows.Add(item.getToken(), item.getFila(), item.gefColumna());
			}
		}
		
		void limpiar() {
			dataTable.Rows.Clear();
			dataTable.Refresh();
			dataTableError.Rows.Clear();
			dataTableError.Refresh();
		}
		
		
		
		
		 
		void resize() {
			int border = 18, margen = 60;
			int size = this.Width - dataTable.Width- margen;
			textBox.Width = size;
			textBox.Height = this.Height - 210;
			tabControl.Width = size + border;
			tabControl.Height= this.Height - 177;
			dataTableError.Width = size + border-7;
			dataTable.Height = this.Height - 91;
			dataTableError.Location = new Point(dataTableError.Location.X, textBox.Height + 64);
			dataTable.Location = new Point(textBox.Width + margen/2, dataTable.Location.Y);
		}
		
		
		
		void TextBoxKeyDown(object sender, KeyEventArgs e) {
			
			if(e.KeyCode == Keys.F5) {
				MessageBox.Show("EJECUTAR.");
			}
		}
	
		
		
		void MainFormResize(object sender, EventArgs e) {
			resize();
		}
		
		void ToolStripMenuItem3Click(object sender, EventArgs e) {
			if(openFile.ShowDialog() == DialogResult.OK) {
				textBox.Text = File.ReadAllText(openFile.FileName);
			}
		}
		
		void ToolStripMenuItem4Click(object sender, EventArgs e) {
			if(textBox.Text != "") {
				//no esta vacio
				MessageBox.Show("se borro");
				textBox.Text = "";
			}
		}
	}
}
