package com.resource_server.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "resources")
public class Game {

	    @Id
	    @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name ="uuid", strategy ="uuid2")
	    @Column(name = "game_id")
	    private String id;
	    private String name;
	    private String genre;
	    private String releaseDate;
	    private String developer;
	    private String publisher;
	    private String platform;
	    private String features;
	    private BigDecimal price;
	    private BigDecimal discount;
	    private String description;
	    private String base64Image;
	    
		public Game(String name, String genre, String releaseDate, String developer, String publisher,
				String platform, String features, BigDecimal price, BigDecimal discount, String description,
				String base64Image) {
			this.name = name;
			this.genre = genre;
			this.releaseDate = releaseDate;
			this.developer = developer;
			this.publisher = publisher;
			this.platform = platform;
			this.features = features;
			this.price = price;
			this.discount = discount;
			this.description = description;
			this.base64Image = base64Image;
		}

		public Game() {
		
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getReleaseDate() {
			return releaseDate;
		}

		public void setReleaseDate(String releaseDate) {
			this.releaseDate = releaseDate;
		}

		public String getDeveloper() {
			return developer;
		}

		public void setDeveloper(String developer) {
			this.developer = developer;
		}

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		public String getPlatform() {
			return platform;
		}

		public void setPlatform(String platform) {
			this.platform = platform;
		}

		public String getFeatures() {
			return features;
		}

		public void setFeatures(String features) {
			this.features = features;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public BigDecimal getDiscount() {
			return discount;
		}

		public void setDiscount(BigDecimal discount) {
			this.discount = discount;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getBase64Image() {
			return base64Image;
		}

		public void setBase64Image(String base64Image) {
			this.base64Image = base64Image;
		}
	
		
			
	
	
}
