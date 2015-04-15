package model;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

import model.Tower;


/**
 * Entity implementation class for Entity: Equipment
 *
 */
@Entity
public class Equipment implements Serializable { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int equipmentId;
	private String name;
	private String brand;
	private String description;
	private double price;
	@ManyToOne
	@JoinColumn(name="towerId")
	private Tower tower;

	public int getId() {
		return this.equipmentId;
	}
	
	public void setId(int id) {
		this.equipmentId = id;
	}   
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}   
	public String getBrand() {
		return this.brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}   
	public Tower getTower() {
		return this.tower;
	}

    public void setTower(Tower tower) {
		this.tower = tower;
	}
    
    public Equipment() {
		super();
	}   
   
}
