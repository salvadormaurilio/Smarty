package mobi.unam.smarty.utilities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by UNAM Mobile on 01/09/2014.
 */
public class Ruta {

    @SerializedName("col")
    List<Integer> colores;
    @SerializedName("surOeste")
    List<Double> surOeste;
    @SerializedName("nornotEste")
    List<Double> notEste;
    @SerializedName("polos")
    List<Double> polilinea;

    public Ruta(List<Integer> colores, List<Double> surOeste, List<Double> notEste, List<Double> polilinea) {
        this.colores = colores;
        this.surOeste = surOeste;
        this.notEste = notEste;
        this.polilinea = polilinea;
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
}
