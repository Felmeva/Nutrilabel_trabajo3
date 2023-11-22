package cl.ipvg.nutrilabel_v1.clases;

public class receta {
    private String idReceta ,nombreR;
    private float eneR, proR, graR, hdcR, sodR, grR;

    public receta() {
    }

    public receta(String idReceta, String nombreR, float eneR, float proR, float graR, float hdcR, float sodR, float grR) {
        this.idReceta = idReceta;
        this.nombreR = nombreR;
        this.eneR = eneR;
        this.proR = proR;
        this.graR = graR;
        this.hdcR = hdcR;
        this.sodR = sodR;
        this.grR = grR;
    }

    public String getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(String idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombreR() {
        return nombreR;
    }

    public void setNombreR(String nombreR) {
        this.nombreR = nombreR;
    }

    public float getEneR() {
        return eneR;
    }

    public void setEneR(float eneR) {
        this.eneR = eneR;
    }

    public float getProR() {
        return proR;
    }

    public void setProR(float proR) {
        this.proR = proR;
    }

    public float getGraR() {
        return graR;
    }

    public void setGraR(float graR) {
        this.graR = graR;
    }

    public float getHdcR() {
        return hdcR;
    }

    public void setHdcR(float hdcR) {
        this.hdcR = hdcR;
    }

    public float getSodR() {
        return sodR;
    }

    public void setSodR(float sodR) {
        this.sodR = sodR;
    }

    public float getGrR() {
        return grR;
    }

    public void setGrR(float grR) {
        this.grR = grR;
    }

    @Override
    public String toString() {
        return "receta{" +
                "idReceta='" + idReceta + '\'' +
                ", nombreR='" + nombreR + '\'' +
                ", eneR=" + eneR +
                ", proR=" + proR +
                ", graR=" + graR +
                ", hdcR=" + hdcR +
                ", sodR=" + sodR +
                ", grR=" + grR +
                '}';
    }


}
