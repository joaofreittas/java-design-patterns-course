package templatemethod.example1;

public class Main {

    public static void main(String[] args) {

    }

}

abstract class ProcessadoraPagamento {

    public void processarPagamento() {
        validarDados();
        validarSaldo();
        efetuarPagamento();
        notificarUsuario();
    }
    private void validarDados() {
        System.out.println("Validando dados");
    }

    private void validarSaldo() {
        System.out.println("Validando saldo");
    }

    protected abstract void efetuarPagamento();

    private void notificarUsuario() {
        System.out.println("Notificando usuário");
    }

}

class ProcessadoraPagamentoBoleto extends ProcessadoraPagamento {

    @Override
    protected void efetuarPagamento() {
        System.out.println("Efetuando pagamento via boleto");
    }

}

class ProcessadoraPagamentoCartao extends ProcessadoraPagamento {

    @Override
    protected void efetuarPagamento() {
        System.out.println("Efetuando pagamento via cartão");
    }

}
