package mobi.unam.smarty.utilities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by UNAM Mobile on 01/09/2014.
 */
public class Ruta {

    @SerializedName("col")
    private List<Integer> colores;
    @SerializedName("surOeste")
    private List<Double> surOeste;
    @SerializedName("nornotEste")
    private List<Double> notEste;
    @SerializedName("polos")
    private List<Double> polilinea;

    private int id;

    public Ruta(List<Integer> colores, List<Double> surOeste, List<Double> notEste, List<Double> polilinea) {
        this.colores = colores;
        this.surOeste = surOeste;
        this.notEste = notEste;
        this.polilinea = polilinea;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getColores() {
        return colores;
    }

    public List<Double> getSurOeste() {
        return surOeste;
    }

    public List<Double> getNotEste() {
        return notEste;
    }

    public List<Double> getPolilinea() {
        return polilinea;
    }

    public int getId() {
        return id;
    }
}
