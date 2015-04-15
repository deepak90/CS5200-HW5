package model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import javax.persistence.*;
import model.Site;

@Entity
public class Tower implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int towerId;
	private String name;
	private int height;
	private int slides;
	@ManyToOne
	@JoinColumn(name="siteId")
	private Site site;
	
	public int getId() {
		return this.towerId;
	}
	
	public void setId(int id) {
		this.towerId = id;
	}   
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}   
	public int getHeight() {
		return this.height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}   
	public int getSlides() {
		return this.slides;
	}
	
	public void setSlides(int slides) {
		this.slides = slides;
	}   
	public Site getSite() {
		return this.site;
	}
	
	public void setSite(Site site) {
		this.site = site;
	}
	public Tower() {
		super();
	} 
	@OneToMany(mappedBy="tower",cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Equipment> equipments;
	
	public List<Equipment> getEquipments() {
		return equipments;
	}
	
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}  
   
}
