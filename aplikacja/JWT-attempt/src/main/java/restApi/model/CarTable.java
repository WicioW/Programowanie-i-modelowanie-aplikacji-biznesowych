package restApi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class CarTable implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id")
	private int id;

	@Column(name = "marka")
	private String marka;

	@Column(name = "model")
	private String model;

	@Column(name = "rokProdukcji")
	private String rokProdukcji;

	@Column(name = "paliwo")
	private String paliwo;

	@Column(name = "przebieg")
	private Integer przebieg;

	@Column(name = "moc")
	private double moc;

	@Column(name = "cena")
	private double cena;

	CarTable(){};
	
	
	public CarTable(int id, String marka, String model, String rokProdukcji, String paliwo, Integer przebieg, double moc,
			double cena) {
this.id=id;
this.marka=marka;
this.model=model;
this.moc=moc;
this.paliwo=paliwo;
this.przebieg=przebieg;
this.cena=cena;
this.rokProdukcji=rokProdukcji;
	}

	public Integer getPrzebieg() {
		return przebieg;
	}

	public void setPrzebieg(Integer przebieg) {
		this.przebieg = przebieg;
	}

	public double getMoc() {
		return moc;
	}

	public void setMoc(double moc) {
		this.moc = moc;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRokProdukcji() {
		return rokProdukcji;
	}

	public void setRokProdukcji(String rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}

	public String getPaliwo() {
		return paliwo;
	}

	public void setPaliwo(String paliwo) {
		this.paliwo = paliwo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: " + getId() + "\n");
		sb.append("marka: " + getMarka() + "\n");
		sb.append("model: " + getModel() + "\n");
		sb.append("rokProdukcji: " + getRokProdukcji() + "\n");
		sb.append("paliwo: " + getPaliwo() + "\n");
		sb.append("przebieg: " + getPrzebieg());
		sb.append("moc: " + getMoc());
		sb.append("cena: " + getCena());

		return sb.toString();
	}

}
