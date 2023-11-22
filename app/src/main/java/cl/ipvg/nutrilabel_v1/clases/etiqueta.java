package cl.ipvg.nutrilabel_v1.clases;

public class etiqueta {

    ingrediente ingre1 = new ingrediente();
    receta rece1 = new receta();
    private String idEtiqueta, nombreEt;
    private float eneEt, proEt, GrasEt, hdcEt, sodEt;

    public etiqueta() {
    }

    public etiqueta(String idEtiqueta, String nombreEt, float eneEt, float proEt, float grasEt, float hdcEt, float sodEt) {
        this.idEtiqueta = idEtiqueta;
        this.nombreEt = nombreEt;
        this.eneEt = eneEt;
        this.proEt = proEt;
        GrasEt = grasEt;
        this.hdcEt = hdcEt;
        this.sodEt = sodEt;
    }

    public String getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(String idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public String getNombreEt() {
        return nombreEt;
    }

    public void setNombreEt(String nombreEt) {
        this.nombreEt = nombreEt;
    }

    public float getEneEt() {
        return eneEt;
    }

    public void setEneEt(float eneEt) {
        this.eneEt = eneEt;
    }

    public float getProEt() {
        return proEt;
    }

    public void setProEt(float proEt) {
        this.proEt = proEt;
    }

    public float getGrasEt() {
        return GrasEt;
    }

    public void setGrasEt(float grasEt) {
        GrasEt = grasEt;
    }

    public float getHdcEt() {
        return hdcEt;
    }

    public void setHdcEt(float hdcEt) {
        this.hdcEt = hdcEt;
    }

    public float getSodEt() {
        return sodEt;
    }

    public void setSodEt(float sodEt) {
        this.sodEt = sodEt;
    }

    @Override
    public String toString() {
        return "etiqueta{" +
                "idEtiqueta='" + idEtiqueta + '\'' +
                ", nombreEt='" + nombreEt + '\'' +
                ", eneEt=" + eneEt +
                ", proEt=" + proEt +
                ", GrasEt=" + GrasEt +
                ", hdcEt=" + hdcEt +
                ", sodEt=" + sodEt +
                '}';
    }

    public float calcularEnergia(float enerIt, float gr){
        float energia;

        energia = (((enerIt * gr) / 100));

        return energia;


    }

    public float calcularProteinas(float proIt, float gr){
        float proteina;

        proteina = (((proIt * gr) / 100));

        return proteina;


    }

    public float calcularGrasas(float graIt, float gr){
        float grasas;

        grasas = (((graIt * gr) / 100));

        return grasas;


    }

    public float calcularHdc(float hdcIt, float gr){
        float hdc;

        hdc = (((hdcIt * gr) / 100));

        return hdc;


    }

    public float calcularSodio(float soIt, float gr){
        float sodio;

        sodio = (((soIt * gr) / 100));

        return sodio;


    }
}
