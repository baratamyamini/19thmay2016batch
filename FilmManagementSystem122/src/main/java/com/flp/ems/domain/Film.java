package com.flp.ems.domain;

	import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.JoinTable;
	import javax.persistence.ManyToMany;
	import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

	@Entity
	public class Film {
		@Id @GeneratedValue(strategy = GenerationType.AUTO)
		private Short film_id;
		
		private String title;
		private String description;
		@Temporal(TemporalType.DATE)
		private Date release_year;
		private Short rental_duration;
		private Float rental_rate;
		private Short length;
		private Long replacement_cost;
		private Float rating;
		private String special_features;
		@Temporal(TemporalType.TIMESTAMP)
		private Date last_update;
		@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
		@JoinColumn(name="language_id")
		private Language language;
		@ManyToOne(cascade = {CascadeType.ALL})
		@JoinTable(name = "film_category", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id") , inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
		private Category category;
		public Film()
		{
			
		}
		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}
		@ManyToMany(cascade = {CascadeType.ALL})
		@JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id") , inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
		private Set<Actor> actors = new HashSet<Actor>();
		 
	
		
		public int getFilm_id() {
			return film_id;
		}
		
		
		public Language getLanguage() {
			return language;
		}
		public void setLanguage(Language language) {
			this.language = language;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		public Date getRelease_year() {
			return release_year;
		}

		public void setRelease_year(Date release_year) {
			this.release_year = release_year;
		}

		public void setFilm_id(Short film_id) {
			this.film_id = film_id;
		}

		
		public Short getRental_duration() {
			return rental_duration;
		}
		public void setRental_duration(Short rental_duration) {
			this.rental_duration = rental_duration;
		}
		public Float getRental_rate() {
			return rental_rate;
		}
		public void setRental_rate(Float rental_rate) {
			this.rental_rate = rental_rate;
		}
		public Short getLength() {
			return length;
		}
		public void setLength(Short length) {
			this.length = length;
		}
		
		public Long getReplacement_cost() {
			return replacement_cost;
		}

		public void setReplacement_cost(Long replacement_cost) {
			this.replacement_cost = replacement_cost;
		}

		public Date getLast_update() {
			return last_update;
		}

		public void setLast_update(Date last_update) {
			this.last_update = last_update;
		}

		
		public Float getRating() {
			return rating;
		}

		public void setRating(Float rating) {
			this.rating = rating;
		}

		public Set<Actor> getActors() {
			return actors;
		}

		public void setActors(Set<Actor> actors) {
			this.actors = actors;
		}

		public String getSpecial_features() {
			return special_features;
		}
		public void setSpecial_features(String special_features) {
			this.special_features = special_features;
		}

		@Override
		public String toString() {
			return "Film [film_id=" + film_id + ", title=" + title + ", description=" + description + ", release_year="
					+ release_year + ", rental_duration=" + rental_duration + ", rental_rate=" + rental_rate
					+ ", length=" + length + ", replacement_cost=" + replacement_cost + ", rating=" + rating
					+ ", special_features=" + special_features + ", language=" + language + ", category=" + category
					+ ", actors=" + actors + "]";
		}

		

		

		
	}



