public class Film {
    private int ar;
    private String cim;
    private boolean feliratos;

    public Film(int ar, String cim, boolean feliratos) {
        this.ar = ar;
        this.cim = cim;
        this.feliratos = feliratos;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public boolean isFeliratos() {
        return feliratos;
    }

    public void setFeliratos(boolean feliratos) {
        this.feliratos = feliratos;
    }
    public static void fn(){}
}
