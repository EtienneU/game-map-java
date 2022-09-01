package personnage.ennemi;

public class Boss extends Monstre {
    private boolean resurrection = false;
    private int pvInit = this.getPv();
    private String msg;

    public Boss() {
        super("Patron", 20, 2, 10, 5, new int[]{0, 0}, 'B', " ");
        this.msg = "  ********   JE SUIS LE BIG BOSS !! MWAHAHAHAAHAAAA !!  ********   ";
    }

    public Boss(String var1, int var2, int var3, int var4, int var5, int[] var6, char var7, String var8) {
        super(var1, var2, var3, var4, var5, var6, var7, var8);
        this.setAvatar(var8);
        this.msg = "  ********   JE SUIS LE BIG BOSS !! MWAHAHAHAAHAAAA !!  ********   ";
    }

    public boolean getResurrection() {
        return this.resurrection;
    }

    public int getPvInit() {
        return this.pvInit;
    }

    public String getMsg() {
        return "\n" + this.msg + "\n";
    }

    public void setResurrection(boolean var1) {
        this.resurrection = var1;
    }

    public void setPvInit(int var1) {
        this.pvInit = var1;
    }

    public void setMsg(String var1) {
        this.msg = var1;
    }
}
