package com.flp.ems.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Language {
			@Id @GeneratedValue(strategy = GenerationType.AUTO)
			private int language_id;
		private String name;
		@Temporal(TemporalType.TIMESTAMP)
		private Date last_update;

		
		public Set<Film> getFilm() {
			return film;
		}
		public void setFilm(Set<Film> film) {
			this.film = film;
		}
		public Date getLast_update() {
			return last_update;
		}
		public void setLast_update(Date last_update) {
			this.last_update = last_update;
		}
		@OneToMany(mappedBy="language")
		private Set<Film> film;
		@Override
		public String toString() {
			return "Language [language_id=" + language_id + ", name=" + name + ", last_update=" + last_update + "]";
		}
		public int getLanguage_id() {
			return language_id;
		}
		public void setLanguage_id(int language_id) {
			this.language_id = language_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
}
