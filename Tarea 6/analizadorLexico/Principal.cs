using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace analizadorLexico
{
    public partial class Principal : Form
    {
        public Principal()
        {
            InitializeComponent();
        }

        private void btnLimpiar_Click(object sender, EventArgs e)
        {
            txtResLexico.Text = "";
            txtErroresLexico.Text = "";
            txtExpresion.Text = "";
            txtErroresSemantico.Text = "";
            txtArbol.Text = "";
            dgvSintactico.Rows.Clear();
        }

        private void btnAnalizar_Click(object sender, EventArgs e)
        {
            if (txtExpresion.Text != "")
            {
                Compilador analizador = new Compilador();

                analizador.Analizador(txtExpresion.Text.ToString());

                txtResLexico.Text = analizador.dameListaToken();
                txtErroresLexico.Text = analizador.dameListaErrores();
                txtErroresSemantico.Text = analizador.dameListaErroresSemanticos();
                txtArbol.Text = analizador.muestraArbol();
                mostrarSintactico(analizador.dameListaSintactico(), analizador.dameSalida(), analizador.dameEntrada());
            } else {
                MessageBox.Show("El cuadro de texto está vacío");
            }
        }

        private void mostrarSintactico(List<String> lista, List<String> salida, List<String> entrada)
        {
            for (int i = 0; i < lista.Count; i++)
            {
                dgvSintactico.Rows.Add(lista[i], salida[i], entrada[i]);
            }
        }

        private void txtExpresion_KeyPress(object sender, KeyPressEventArgs e)
        {

        }
    }
}
