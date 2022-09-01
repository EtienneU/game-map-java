package action;

public class Attaque {
    private String name;
    private int degat;
    private int uenergie;

    public Attaque(String var1, int var2, int var3) {
        this.name = var1;
        this.degat = var2;
        this.uenergie = var3;
    }

    public String getName() {
        return this.name;
    }

    public int getDegat() {
        return this.degat;
    }

    public int getUenergie() {
        return this.uenergie;
    }
}
