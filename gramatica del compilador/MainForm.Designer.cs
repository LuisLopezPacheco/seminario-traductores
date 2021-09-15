
namespace Analizador_lexico
{
	partial class MainForm
	{
		/// <summary>
		/// Designer variable used to keep track of non-visual components.
		/// </summary>
		private System.ComponentModel.IContainer components = null;
		
		/// <summary>
		/// Disposes resources used by the form.
		/// </summary>
		/// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
		protected override void Dispose(bool disposing)
		{
			if (disposing) {
				if (components != null) {
					components.Dispose();
				}
			}
			base.Dispose(disposing);
		}
		
		/// <summary>
		/// This method is required for Windows Forms designer support.
		/// Do not change the method contents inside the source code editor. The Forms designer might
		/// not be able to load this method if it was changed manually.
		/// </summary>
		private void InitializeComponent() {
			System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
			this.toolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
			this.toolStripMenuItem4 = new System.Windows.Forms.ToolStripMenuItem();
			this.toolStripMenuItem3 = new System.Windows.Forms.ToolStripMenuItem();
			this.ejecutarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.menuStrip1 = new System.Windows.Forms.MenuStrip();
			this.tabControl = new System.Windows.Forms.TabControl();
			this.tabPage1 = new System.Windows.Forms.TabPage();
			this.textBox = new System.Windows.Forms.RichTextBox();
			this.columnaError = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.filaError = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.lexemaError = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.dataTableError = new System.Windows.Forms.DataGridView();
			this.dataTable = new System.Windows.Forms.DataGridView();
			this.token_ = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.lexeman = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.fila_ = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.columna_ = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.id = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.openFile = new System.Windows.Forms.OpenFileDialog();
			this.menuStrip1.SuspendLayout();
			this.tabControl.SuspendLayout();
			this.tabPage1.SuspendLayout();
			((System.ComponentModel.ISupportInitialize)(this.dataTableError)).BeginInit();
			((System.ComponentModel.ISupportInitialize)(this.dataTable)).BeginInit();
			this.SuspendLayout();
			// 
			// toolStripMenuItem1
			// 
			this.toolStripMenuItem1.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
									this.toolStripMenuItem4,
									this.toolStripMenuItem3});
			this.toolStripMenuItem1.Name = "toolStripMenuItem1";
			this.toolStripMenuItem1.Size = new System.Drawing.Size(90, 30);
			this.toolStripMenuItem1.Text = "";
			// 
			// toolStripMenuItem4
			// 
			this.toolStripMenuItem4.Name = "toolStripMenuItem4";
			this.toolStripMenuItem4.Size = new System.Drawing.Size(165, 30);
			this.toolStripMenuItem4.Text = "Nuevo";
			this.toolStripMenuItem4.Click += new System.EventHandler(this.ToolStripMenuItem4Click);
			// 
			// ejecutarToolStripMenuItem
			// 
			this.ejecutarToolStripMenuItem.Name = "ejecutarToolStripMenuItem";
			this.ejecutarToolStripMenuItem.Size = new System.Drawing.Size(74, 24);
			this.ejecutarToolStripMenuItem.Text = "Ejecutar";
			this.ejecutarToolStripMenuItem.Click += new System.EventHandler(this.EjecutarToolStripMenuItemClick);
			// 
			// menuStrip1
			// 
			this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
									this.toolStripMenuItem1,
									this.ejecutarToolStripMenuItem});
			this.menuStrip1.Location = new System.Drawing.Point(0, 0);
			this.menuStrip1.Name = "menuStrip1";
			this.menuStrip1.Size = new System.Drawing.Size(1144, 28);
			this.menuStrip1.TabIndex = 5;
			this.menuStrip1.Text = "menuStrip1";
			// 
			// tabControl
			// 
			this.tabControl.Controls.Add(this.tabPage1);
			this.tabControl.Location = new System.Drawing.Point(0, 28);
			this.tabControl.Name = "tabControl";
			this.tabControl.SelectedIndex = 0;
			this.tabControl.Size = new System.Drawing.Size(616, 578);
			this.tabControl.TabIndex = 6;
			// 
			// tabPage1
			// 
			this.tabPage1.Controls.Add(this.textBox);
			this.tabPage1.Location = new System.Drawing.Point(4, 25);
			this.tabPage1.Name = "tabPage1";
			this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
			this.tabPage1.Size = new System.Drawing.Size(608, 549);
			this.tabPage1.TabIndex = 0;
			this.tabPage1.Text = "Codigo";
			this.tabPage1.UseVisualStyleBackColor = true;
			// 
			// textBox
			// 
			this.textBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.textBox.Location = new System.Drawing.Point(6, 6);
			this.textBox.Name = "textBox";
			this.textBox.Size = new System.Drawing.Size(596, 537);
			this.textBox.TabIndex = 7;
			this.textBox.Text = "";
			this.textBox.TextChanged += new System.EventHandler(this.TextBoxTextChanged);
			this.textBox.KeyDown += new System.Windows.Forms.KeyEventHandler(this.TextBoxKeyDown);
			// 
			// dataTable
			// 
			this.dataTable.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
			this.dataTable.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
									this.token_,
									this.lexeman,
									this.fila_,
									this.columna_,
									this.id});
			dataGridViewCellStyle1.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
			dataGridViewCellStyle1.BackColor = System.Drawing.SystemColors.Window;
			dataGridViewCellStyle1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			dataGridViewCellStyle1.ForeColor = System.Drawing.SystemColors.ControlText;
			dataGridViewCellStyle1.SelectionBackColor = System.Drawing.SystemColors.Highlight;
			dataGridViewCellStyle1.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
			dataGridViewCellStyle1.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
			this.dataTable.DefaultCellStyle = dataGridViewCellStyle1;
			this.dataTable.Location = new System.Drawing.Point(634, 53);
			this.dataTable.Name = "dataTable";
			this.dataTable.RowTemplate.Height = 24;
			this.dataTable.Size = new System.Drawing.Size(491, 679);
			this.dataTable.TabIndex = 0;
			// 
			// token_
			// 
			this.token_.HeaderText = "Token";
			this.token_.Name = "token_";
			// 
			// lexeman
			// 
			this.lexeman.HeaderText = "lexema";
			this.lexeman.Name = "lexeman";
			// 
			// fila_
			// 
			this.fila_.HeaderText = "Fila";
			this.fila_.Name = "fila_";
			// 
			// columna_
			// 
			this.columna_.HeaderText = "Columna";
			this.columna_.Name = "columna_";
			// 
			// id
			// 
			this.id.HeaderText = "Id";
			this.id.Name = "id";
			// 
			// openFile
			// 
			this.openFile.FileName = "openFile";
			// 
			// MainForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(1144, 744);
			this.Controls.Add(this.tabControl);
			this.Controls.Add(this.dataTableError);
			this.Controls.Add(this.dataTable);
			this.Controls.Add(this.menuStrip1);
			this.MainMenuStrip = this.menuStrip1;
			this.Name = "MainForm";
			this.Text = "Analizador Sintactico LR";
			this.Resize += new System.EventHandler(this.MainFormResize);
			this.menuStrip1.ResumeLayout(false);
			this.menuStrip1.PerformLayout();
			this.tabControl.ResumeLayout(false);
			this.tabPage1.ResumeLayout(false);
			((System.ComponentModel.ISupportInitialize)(this.dataTableError)).EndInit();
			((System.ComponentModel.ISupportInitialize)(this.dataTable)).EndInit();
			this.ResumeLayout(false);
			this.PerformLayout();
		}
		private System.Windows.Forms.OpenFileDialog openFile;
		private System.Windows.Forms.DataGridViewTextBoxColumn id;
		private System.Windows.Forms.DataGridViewTextBoxColumn columna_;
		private System.Windows.Forms.DataGridViewTextBoxColumn fila_;
		private System.Windows.Forms.DataGridViewTextBoxColumn lexeman;
		private System.Windows.Forms.DataGridViewTextBoxColumn token_;
		private System.Windows.Forms.RichTextBox textBox;
		private System.Windows.Forms.TabPage tabPage1;
		private System.Windows.Forms.TabControl tabControl;
		private System.Windows.Forms.ToolStripMenuItem ejecutarToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem4;
		private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem3;
		private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem1;
		private System.Windows.Forms.MenuStrip menuStrip1;
		private System.Windows.Forms.DataGridViewTextBoxColumn columnaError;
		private System.Windows.Forms.DataGridViewTextBoxColumn filaError;
		private System.Windows.Forms.DataGridViewTextBoxColumn lexemaError;
		private System.Windows.Forms.DataGridView dataTableError;
		private System.Windows.Forms.DataGridView dataTable;
		
		

	}
}
