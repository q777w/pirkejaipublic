package miestai_pirkejai;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Miestai {

	public Miestai() {
		
		super();

	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	private String miestas;
	
	  @JsonIgnore
	  @OneToMany(cascade = CascadeType.ALL)
	  @JoinColumn(name="miestas_id", referencedColumnName="id", insertable=false, updatable=false)    
	  private List <Pirkejai> Pirkejai;
	  
	public Integer getId() {
		
		return id;
		
	}
	public void setId(Integer id) {
		
		this.id = id;
		
	}
	public String getMiestas() {
		
		return miestas;
		
	}
	public void setMiestas(String miestas) {
		
		this.miestas = miestas;
		
	}
	public List<Pirkejai> getPirkejai() {
		
		return pirkejai;
		
	}
	public void setPirkejai(List<Pirkejai> pirkejai) {
		
	}
	
}