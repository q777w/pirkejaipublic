package miestai_pirkejai;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pirkejai {

		public Pirkejai() {
			
			super();
			
		}

		 @Id
		 @GeneratedValue(strategy=GenerationType.IDENTITY)
		 
		 private Integer id;
		 private String vardas;
		 private String pavarde;
		
		 @ManyToOne(cascade=CascadeType.ALL)
		 @JoinColumn(name="miestas_id",referencedColumnName="id",insertable=false, updatable=false)
		 private Miestai miestai;
		 private String miestas;
		 
		public Miestai getMiestai() {
			 
			 return miestai;
			 
		}
		public void setMiestai(Miestai miestai) {
			 
			 this.miestai = miestai;
		}
		  
		public Integer getId() {
			
			return id;
			
		}
		public void setId(Integer id) {
			
			this.id = id;
			
		}
		public String getVardas() {
			
			return vardas;
			
		}
		public void setVardas(String vardas) {

			this.vardas = vardas;
			
		}
		public String getPavarde() {
			
			return pavarde;
			
		}
		public void setPavarde(String pavarde) {
			
			this.pavarde = pavarde;
			
		}
		public String getMiestas() {
			
			return miestas;
			
		}
		public void setMiestas(String miestas) {
			
			this.miestas = miestas;		
			
		}
				
}