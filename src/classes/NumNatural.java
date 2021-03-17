package classes;

public class NumNatural {

    private long numero = 0;

    
    public NumNatural() throws Exception {
        if (this.numero < 0) {
            throw new Exception("O número não pode ser <0");
        }
        numero = 0;
    }

    public NumNatural(long numero) throws Exception {
        if (this.numero < 0) {
            throw new Exception("Número não pode ser <0");
        }
        this.numero = numero;
    }

    public NumNatural(NumNatural valor) {
        valor = valor;
    }

    public long getNumero() {
        return numero;
    }

    public void setValor(NumNatural valor) {
        valor = valor;
    }

    public void setNumero(long numero) throws Exception {
        if (this.numero < 0) {
            throw new Exception("Número inválido");
        }
        this.numero = numero;
    }

    public NumNatural calcularFatorial() throws Exception {

        long aux = this.numero;

        long fatorial = 1;
        for (int i = 1; aux > 1; i--) {
            fatorial = fatorial * aux;
            aux = aux - 1;
        }
        return new NumNatural(fatorial);

    }

    public boolean eNumeroPerfeito() {
        int soma = 0;

        for (int i = 1; i < this.numero; i++) {

            if (this.numero % i == 0) {
                soma += i;
            }
        }

        return soma == this.numero;
    }

    public boolean eCapicua() {

        long n_invertido = 0, resultado = 0;
        long aux = this.numero;

        for (int i = 0; aux != 0; i++) {

            resultado = aux % 10;
            aux = aux / 10;
            n_invertido = n_invertido * 10 + resultado;
        }
        return (n_invertido == this.numero);

    }

    public boolean eQuadradoPerfeito() {

        long result = (long) Math.sqrt(this.numero);
        if (result * result == this.numero) {
            return true;
        } else {
            return false;
        }
    }

    public boolean eNumeroPrimo() {

        int soma = 0;

        for (int i = 1; i <= this.numero; i++) {

            if (this.numero % i == 0) {
                soma++;
            }
        }
        System.out.println(soma);
        if (soma == 2) {
            return true;
        } else {
            return false;
        }
    }

    public String mudarBase(int base) {        
        int num = (int)numero;
        switch (base) {

            case 2:
                return Integer.toBinaryString(num);
            case 8:
                return Integer.toOctalString(num);
            case 16:
                return Integer.toHexString(num);
        }

        return null;
    }

    public NumNatural calcularMDC(NumNatural objeto) throws Exception {

        long aux1 = this.numero;
        long aux2 = objeto.numero;
        long resto;
        long mdc = 0;

        while (aux2 != 0) {
            resto = aux1 % aux2;
            aux1 = aux2;
            aux2 = resto;
            mdc = aux1;
        }
        NumNatural objtMDC = new NumNatural(mdc);
        return objtMDC;
    }

    public NumNatural calcularMMC(NumNatural objeto) throws Exception {

        long aux1 = this.numero;
        long aux2 = objeto.numero;

        return new NumNatural((aux1 * aux2) / calcularMDC(objeto).getNumero());
    }

    public boolean PrimoEntreSi(NumNatural objeto) throws Exception {          

         return (((this.calcularMDC(objeto).getNumero()) == 1));    
        
    }

}
