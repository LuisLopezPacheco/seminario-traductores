namespace analizadorLexico
{
    partial class Principal
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.txtExpresion = new System.Windows.Forms.TextBox();
            this.lblIngresar = new System.Windows.Forms.Label();
            this.btnAnalizar = new System.Windows.Forms.Button();
            this.txtResLexico = new System.Windows.Forms.TextBox();
            this.btnLimpiar = new System.Windows.Forms.Button();
            this.txtErroresLexico = new System.Windows.Forms.TextBox();
            this.lblResultado = new System.Windows.Forms.Label();
            this.lblErrores = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.dgvSintactico = new System.Windows.Forms.DataGridView();
            this.txtArbol = new System.Windows.Forms.TextBox();
            this.lblArbol = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.txtErroresSemantico = new System.Windows.Forms.TextBox();
            this.Pila = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Salida = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Entrada = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.dgvSintactico)).BeginInit();
            this.SuspendLayout();
            // 
            // txtExpresion
            // 
            this.txtExpresion.AcceptsTab = true;
            this.txtExpresion.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtExpresion.Font = new System.Drawing.Font("Consolas", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtExpresion.Location = new System.Drawing.Point(12, 44);
            this.txtExpresion.Multiline = true;
            this.txtExpresion.Name = "txtExpresion";
            this.txtExpresion.ScrollBars = System.Windows.Forms.ScrollBars.Both;
            this.txtExpresion.Size = new System.Drawing.Size(886, 418);
            this.txtExpresion.TabIndex = 0;
            this.txtExpresion.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtExpresion_KeyPress);
            // 
            // lblIngresar
            // 
            this.lblIngresar.AutoSize = true;
            this.lblIngresar.Font = new System.Drawing.Font("Arial", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblIngresar.Location = new System.Drawing.Point(12, 17);
            this.lblIngresar.Name = "lblIngresar";
            this.lblIngresar.Size = new System.Drawing.Size(148, 24);
            this.lblIngresar.TabIndex = 1;
            this.lblIngresar.Text = "Ingrese código";
            // 
            // btnAnalizar
            // 
            this.btnAnalizar.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btnAnalizar.Font = new System.Drawing.Font("Arial", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnAnalizar.Location = new System.Drawing.Point(1216, 12);
            this.btnAnalizar.Name = "btnAnalizar";
            this.btnAnalizar.Size = new System.Drawing.Size(108, 50);
            this.btnAnalizar.TabIndex = 2;
            this.btnAnalizar.Text = "Analizar";
            this.btnAnalizar.UseVisualStyleBackColor = true;
            this.btnAnalizar.Click += new System.EventHandler(this.btnAnalizar_Click);
            // 
            // txtResLexico
            // 
            this.txtResLexico.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.txtResLexico.Font = new System.Drawing.Font("Arial Narrow", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtResLexico.Location = new System.Drawing.Point(908, 37);
            this.txtResLexico.Multiline = true;
            this.txtResLexico.Name = "txtResLexico";
            this.txtResLexico.ReadOnly = true;
            this.txtResLexico.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.txtResLexico.Size = new System.Drawing.Size(285, 234);
            this.txtResLexico.TabIndex = 3;
            // 
            // btnLimpiar
            // 
            this.btnLimpiar.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btnLimpiar.Font = new System.Drawing.Font("Arial", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnLimpiar.Location = new System.Drawing.Point(1358, 12);
            this.btnLimpiar.Name = "btnLimpiar";
            this.btnLimpiar.Size = new System.Drawing.Size(108, 53);
            this.btnLimpiar.TabIndex = 4;
            this.btnLimpiar.Text = "Limpiar";
            this.btnLimpiar.UseVisualStyleBackColor = true;
            this.btnLimpiar.Click += new System.EventHandler(this.btnLimpiar_Click);
            // 
            // txtErroresLexico
            // 
            this.txtErroresLexico.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtErroresLexico.Font = new System.Drawing.Font("Arial Narrow", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtErroresLexico.Location = new System.Drawing.Point(908, 299);
            this.txtErroresLexico.Multiline = true;
            this.txtErroresLexico.Name = "txtErroresLexico";
            this.txtErroresLexico.ReadOnly = true;
            this.txtErroresLexico.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.txtErroresLexico.Size = new System.Drawing.Size(285, 226);
            this.txtErroresLexico.TabIndex = 6;
            // 
            // lblResultado
            // 
            this.lblResultado.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.lblResultado.AutoSize = true;
            this.lblResultado.Font = new System.Drawing.Font("Arial", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblResultado.Location = new System.Drawing.Point(904, 12);
            this.lblResultado.Name = "lblResultado";
            this.lblResultado.Size = new System.Drawing.Size(159, 22);
            this.lblResultado.TabIndex = 7;
            this.lblResultado.Text = "Analizador Léxico";
            // 
            // lblErrores
            // 
            this.lblErrores.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.lblErrores.AutoSize = true;
            this.lblErrores.Font = new System.Drawing.Font("Arial", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblErrores.Location = new System.Drawing.Point(904, 274);
            this.lblErrores.Name = "lblErrores";
            this.lblErrores.Size = new System.Drawing.Size(161, 22);
            this.lblErrores.TabIndex = 8;
            this.lblErrores.Text = "Errores de Léxico";
            // 
            // label2
            // 
            this.label2.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Arial", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(11, 465);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(185, 22);
            this.label2.TabIndex = 11;
            this.label2.Text = "Analizador Sintáctico";
            // 
            // dgvSintactico
            // 
            this.dgvSintactico.AllowUserToAddRows = false;
            this.dgvSintactico.AllowUserToDeleteRows = false;
            this.dgvSintactico.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.dgvSintactico.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvSintactico.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Pila,
            this.Salida,
            this.Entrada});
            this.dgvSintactico.Location = new System.Drawing.Point(16, 490);
            this.dgvSintactico.Name = "dgvSintactico";
            this.dgvSintactico.RowHeadersWidth = 50;
            this.dgvSintactico.Size = new System.Drawing.Size(863, 265);
            this.dgvSintactico.TabIndex = 12;
            // 
            // txtArbol
            // 
            this.txtArbol.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtArbol.Font = new System.Drawing.Font("Arial Narrow", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtArbol.Location = new System.Drawing.Point(1203, 132);
            this.txtArbol.Multiline = true;
            this.txtArbol.Name = "txtArbol";
            this.txtArbol.ReadOnly = true;
            this.txtArbol.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.txtArbol.Size = new System.Drawing.Size(263, 623);
            this.txtArbol.TabIndex = 13;
            // 
            // lblArbol
            // 
            this.lblArbol.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.lblArbol.AutoSize = true;
            this.lblArbol.Font = new System.Drawing.Font("Arial", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblArbol.Location = new System.Drawing.Point(1199, 107);
            this.lblArbol.Name = "lblArbol";
            this.lblArbol.Size = new System.Drawing.Size(142, 22);
            this.lblArbol.TabIndex = 14;
            this.lblArbol.Text = "Árbol Sintáctico";
            // 
            // label1
            // 
            this.label1.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Arial", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(900, 528);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(178, 22);
            this.label1.TabIndex = 16;
            this.label1.Text = "Errores Semánticos";
            // 
            // txtErroresSemantico
            // 
            this.txtErroresSemantico.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.txtErroresSemantico.Font = new System.Drawing.Font("Arial Narrow", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtErroresSemantico.Location = new System.Drawing.Point(885, 553);
            this.txtErroresSemantico.Multiline = true;
            this.txtErroresSemantico.Name = "txtErroresSemantico";
            this.txtErroresSemantico.ReadOnly = true;
            this.txtErroresSemantico.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.txtErroresSemantico.Size = new System.Drawing.Size(308, 202);
            this.txtErroresSemantico.TabIndex = 15;
            // 
            // Pila
            // 
            this.Pila.HeaderText = "Pila";
            this.Pila.Name = "Pila";
            this.Pila.Width = 600;
            // 
            // Salida
            // 
            this.Salida.HeaderText = "Salida";
            this.Salida.Name = "Salida";
            // 
            // Entrada
            // 
            this.Entrada.HeaderText = "Entrada";
            this.Entrada.Name = "Entrada";
            // 
            // Principal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1493, 767);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtErroresSemantico);
            this.Controls.Add(this.lblArbol);
            this.Controls.Add(this.txtArbol);
            this.Controls.Add(this.dgvSintactico);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.lblErrores);
            this.Controls.Add(this.lblResultado);
            this.Controls.Add(this.txtErroresLexico);
            this.Controls.Add(this.btnLimpiar);
            this.Controls.Add(this.txtResLexico);
            this.Controls.Add(this.btnAnalizar);
            this.Controls.Add(this.lblIngresar);
            this.Controls.Add(this.txtExpresion);
            this.Name = "Principal";
            this.Text = "Compilador";
            ((System.ComponentModel.ISupportInitialize)(this.dgvSintactico)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtExpresion;
        private System.Windows.Forms.Label lblIngresar;
        private System.Windows.Forms.Button btnAnalizar;
        private System.Windows.Forms.TextBox txtResLexico;
        private System.Windows.Forms.Button btnLimpiar;
        private System.Windows.Forms.TextBox txtErroresLexico;
        private System.Windows.Forms.Label lblResultado;
        private System.Windows.Forms.Label lblErrores;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.DataGridView dgvSintactico;
        private System.Windows.Forms.TextBox txtArbol;
        private System.Windows.Forms.Label lblArbol;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtErroresSemantico;
        private System.Windows.Forms.DataGridViewTextBoxColumn Pila;
        private System.Windows.Forms.DataGridViewTextBoxColumn Salida;
        private System.Windows.Forms.DataGridViewTextBoxColumn Entrada;
    }
}

