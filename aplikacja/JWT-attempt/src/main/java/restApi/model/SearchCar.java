package restApi.model;



public class SearchCar {

   private String model;
   private String marka;
   private Integer rokProdukcji_od;
   private Integer rokProdukcji_do;
   private String paliwo;
   private Integer przebieg_od;
   private Integer przebieg_do;
   private double moc_od;
   private double moc_do;
   private double cena_od;
   private double cena_do;
   
   
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getMarka() {
	return marka;
}
public void setMarka(String marka) {
	this.marka = marka;
}

public String getPaliwo() {
	return paliwo;
}
public void setPaliwo(String paliwo) {
	this.paliwo = paliwo;
}
public Integer getPrzebieg_od() {
	return przebieg_od;
}
public void setPrzebieg_od(Integer przebieg_od) {
	this.przebieg_od = przebieg_od;
}
public Integer getPrzebieg_do() {
	return przebieg_do;
}
public void setPrzebieg_do(Integer przebieg_do) {
	this.przebieg_do = przebieg_do;
}
public double getMoc_od() {
	return moc_od;
}
public void setMoc_od(double moc_od) {
	this.moc_od = moc_od;
}
public double getMoc_do() {
	return moc_do;
}
public void setMoc_do(double moc_do) {
	this.moc_do = moc_do;
}
public double getCena_od() {
	return cena_od;
}
public void setCena_od(double cena_od) {
	this.cena_od = cena_od;
}
public double getCena_do() {
	return cena_do;
}
public void setCena_do(double cena_do) {
	this.cena_do = cena_do;
}
public Integer getRokProdukcji_od() {
	return rokProdukcji_od;
}
public void setRokProdukcji_od(Integer rokProdukcji_od) {
	this.rokProdukcji_od = rokProdukcji_od;
}
public Integer getRokProdukcji_do() {
	return rokProdukcji_do;
}
public void setRokProdukcji_do(Integer rokProdukcji_do) {
	this.rokProdukcji_do = rokProdukcji_do;
}

   
	
}
