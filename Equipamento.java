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

    public void setmarca (String marca){
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
