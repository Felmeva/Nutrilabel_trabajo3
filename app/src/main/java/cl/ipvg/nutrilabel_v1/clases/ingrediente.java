package cl.ipvg.nutrilabel_v1.clases;


public class ingrediente {
    private String idIng, nombreI;
    private float energiaI, proteinasI, grasasI, hdcI, sodioI;

    public ingrediente() {
    }

    public ingrediente(String idIng, String nombreI, float energiaI, float proteinasI, float grasasI, float hdcI, float sodioI) {
        this.idIng = idIng;
        this.nombreI = nombreI;
        this.energiaI = energiaI;
        this.proteinasI = proteinasI;
        this.grasasI = grasasI;
        this.hdcI = hdcI;
        this.sodioI = sodioI;
    }


    public String getIdIng() {
        return idIng;
    }

    public void setIdIng(String idIng) {
        this.idIng = idIng;
    }

    public String getNombreI() {
        return nombreI;
    }

    public void setNombreI(String nombreI) {
        this.nombreI = nombreI;
    }

    public float getEnergiaI() {
        return energiaI;
    }

    public void setEnergiaI(float energiaI) {
        this.energiaI = energiaI;
    }

    public float getProteinasI() {
        return proteinasI;
    }

    public void setProteinasI(float proteinasI) {
        this.proteinasI = proteinasI;
    }

    public float getGrasasI() {
        return grasasI;
    }

    public void setGrasasI(float grasasI) {
        this.grasasI = grasasI;
    }

    public float getHdcI() {
        return hdcI;
    }

    public void setHdcI(float hdcI) {
        this.hdcI = hdcI;
    }

    public float getSodioI() {
        return sodioI;
    }

    public void setSodioI(float sodioI) {
        this.sodioI = sodioI;
    }

    @Override
    public String toString() {
        return "ingrediente{" +
                "idIng='" + idIng + '\'' +
                ", nombreI='" + nombreI + '\'' +
                ", energiaI=" + energiaI +
                ", proteinasI=" + proteinasI +
                ", grasasI=" + grasasI +
                ", hdcI=" + hdcI +
                ", sodioI=" + sodioI +
                '}';
    }


}
