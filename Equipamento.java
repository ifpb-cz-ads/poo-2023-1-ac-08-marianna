public class Equipamento {
    private String marca;
    private int vidaUtil;

    public Equipamento (String marca, int vidaUtil){
        this.marca = marca;
        this.vidaUtil = vidaUtil;
    }

    public String getMarca (){
        return marca;
    }

    public void setMarca (String marca){
        this.marca = marca;
    }

    public int getVidaUtil (){
        return vidaUtil;
    }

    public void setVidaUtil (int vidaUtil){
        this.vidaUtil = vidaUtil;
    }
}


class Computador extends Equipamento {
    private String modelo;
    private int ram;

    public Computador (String marca, int vidaUtil, String modelo, int ram){
        super(marca, vidaUtil);
        this.modelo = modelo;
        this.ram = ram;
    }

    public String getModelo (){
        return modelo;
    }

    public void setModelo (String modelo){
        this.modelo = modelo;
    }

    public int getRam (){
        return ram;
    }

    public void setRam (int ram){
        this.ram = ram;;
    }
}

class testaEquipamento {
        public static void main (String[] args){

        // Criando um objeto da classe Equipamento
        Equipamento equipamento = new Equipamento("Acer", 6);
        equipamento.setMarca("Asus");
        equipamento.setVidaUtil(5);
        
        // Imprimindo os atributos do objeto Equipamento
        System.out.println("Equipamento:");
        System.out.println("Marca: " + equipamento.getMarca());
        System.out.println("A vida útil do equipamento é de: " + equipamento.getVidaUtil() + " anos.");
        
        // Criando um objeto da classe Computador
        Computador computador = new Computador("Samsung", 5, "i5", 8);
        computador.setMarca("Lenovo");
        computador.setVidaUtil(7);
        computador.setModelo("i7");
        computador.setRam(16);
        
        // Imprimindo os atributos do objeto Computador
        System.out.println("\nComputador:");
        System.out.println("Marca: " + computador.getMarca());
        System.out.println("A vida útil do equipamento é de: " + computador.getVidaUtil() + " anos.");
        System.out.println("Modelo: " + computador.getModelo());
        System.out.println("Memória: " + computador.getRam() + " GB de ram");
    }
}