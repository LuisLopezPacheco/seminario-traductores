using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace analizadorLexico
{
    class Reglas
    {
        public int num;
        public int num_va;
        public String nombre;

        public Reglas()
        {

        }

        public Reglas(int num, int num_va, String nombre)
        {
            this.num = num;
            this.num_va = num_va;
            this.nombre = nombre;
        }
    }
}
