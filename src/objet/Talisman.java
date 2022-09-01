package objet;

public abstract class Talisman {

    private String name;
    private int giveenergie;
    private int givePv;
    private String avatar;
    private int [] position;
    private char id;

    public Talisman(String name, int giveenergie, int givePv, String avatar, int [] position, char id) {
        this.name = name;
        this.giveenergie = giveenergie;
        this.givePv = givePv;
        this.avatar = avatar;
        this.position = position;
        this.id = id;


    }

    public int getGivePv() {
        return givePv;
    }

    public void setGivePv(int givePv) {
        this.givePv = givePv;
    }

    public String getName() {
        return name;
    }

    public int getGiveenergie() {
        return giveenergie;

    }

    public String getAvatar() {
        return avatar;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }
}
