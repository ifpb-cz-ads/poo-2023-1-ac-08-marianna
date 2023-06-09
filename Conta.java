import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Conta {

    private int numero;
    private String nome_titular;
    protected double saldo;

    public Conta(int numero, String nome_titular){
        this.numero = numero;
        this.nome_titular = nome_titular;
        this.saldo = 0;
    }

    public void depositar(double valor){
        this.saldo = this.getSaldo() + valor;
    }

    public boolean sacar(double valor) {
        if (this.getSaldo() >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }
    public double getSaldo() {
        return saldo;
    }
    public int getNumero() {
        return numero;
    }
    public String getNome_titular() {
        return nome_titular;
    }
        
    public void setNome_titular (String nome_titular){
        this.nome_titular = nome_titular;
    }
}

class ContaEspecial extends Conta {
    private double limite;

    public ContaEspecial(int numero, String nome_titular, double limite){
        super(numero, nome_titular);
        this.limite = limite;

    }

    @Override
    public boolean sacar(double valor){
        if(valor <= this.limite + this.saldo){
            this.saldo -= valor;
            return true;
        }
        else return false;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite){
        this.limite = limite;
    }
}

class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, String nome_titular){
        super(numero, nome_titular);
    }

    public void reajustar(double percentual){
        saldo = saldo + saldo*percentual;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Conta> contas = new ArrayList<>();
        int numeroDaConta = 0;
        
        while (true) {
            System.out.println("Digite 1 para criar uma conta, 2 para ver o saldo de uma conta, 3 para sacar, 4 para depositar ou qualquer outra tecla para sair:");
            String opcao = scanner.nextLine();
            
            if (opcao.equals("1")) {
                System.out.println("Digite o nome do titular da conta:");
                String nomeTitular = scanner.nextLine();
                
                numeroDaConta++;
                System.out.println("Digite o tipo de conta a ser criada: 1 para normal, 2 para especial, 3 para poupança. outro numero: inválido.");
                String tipoConta = scanner.nextLine();
                
                switch(tipoConta){
                    case "1":
                        Conta conta = new Conta(numeroDaConta, nomeTitular);
                        contas.add(conta);
        
                        System.out.println("Conta criada com sucesso! O número da conta é " + conta.getNumero());
                        break;
                    case "2":
                        System.out.println("Insira o limite da conta especial:");
                        double limite = scanner.nextDouble();
                        scanner.nextLine();

                        ContaEspecial contaE = new ContaEspecial(numeroDaConta, nomeTitular, limite);
                        contas.add(contaE);

                        System.out.println("Conta criada com sucesso! O número da conta é " + contaE.getNumero());
                        break;
                    case "3":
                        ContaPoupanca contaP = new ContaPoupanca(numeroDaConta, nomeTitular);
                        contas.add(contaP);

                        System.out.println("Conta criada com sucesso! O número da conta é " + contaP.getNumero());
                        break;
                    default: break;
                }
            
            } else if (opcao.equals("2")) {
                System.out.println("Digite o número da conta:");
                int numeroConta = scanner.nextInt();
                scanner.nextLine();

                Conta conta = null;
                for (Conta c : contas) {
                    if (c.getNumero() == numeroConta) {
                        conta = c;
                        break;
                    }
                }

                if (conta == null) {
                    System.out.println("Conta não encontrada.");
                } else {
                    System.out.println("Saldo da conta de " + conta.getNome_titular() + ": R$" + conta.getSaldo());
                }
            } else if (opcao.equals("3")) {
                System.out.println("Digite o número da conta:");
                int numeroConta = scanner.nextInt();
                scanner.nextLine();

                Conta conta = null;
                for (Conta c : contas) {
                    if (c.getNumero() == numeroConta) {
                        conta = c;
                        break;
                    }
                }

                if (conta == null) {
                    System.out.println("Conta não encontrada.");
                } else {
                    System.out.println("Digite o valor a ser sacado:");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    if (conta.sacar(valor)) {
                        System.out.println("Saque efetuado com sucesso! Novo saldo: R$" + conta.getSaldo());
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                }
            } else if (opcao.equals("4")) {
                System.out.println("Digite o número da conta:");
                int numeroConta = scanner.nextInt();

                Conta conta = null;
                for (Conta c : contas) {
                    if (c.getNumero() == numeroConta) {
                        conta = c;
                        break;
                    }
                }
                if (conta == null) {
                    System.out.println("Conta não encontrada.");
                } else {
                    System.out.println("Digite o valor a ser depositado:");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    conta.depositar(valor);
                    System.out.println("Novo saldo: R$" + conta.getSaldo());
                }
            } else break;
        }
        scanner.close();
    }
}
