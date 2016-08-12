package com.flp.ems.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
@Entity
public class Actor {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Short actor_id;
	private String first_name;
	private String last_name;
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_update;
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	
	public Actor(String first_name, String last_name) {
		this.first_name=first_name;
		this.last_name=last_name;
	}
	public Actor() {
		super();
	}
	
	@ManyToMany(mappedBy="actors")
	private Set<Film> films=new HashSet<Film>();
	public Set<Film> getFilm() {
		return films;
	}
	public void setFilm(Set<Film> film) {
		this.films = film;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		return true;
	}
		public int getActor_id() {
		return actor_id;
	}
	
	public void setActor_id(Short actor_id) {
		this.actor_id = actor_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	@Override
	public String toString() {
		return "Actor [actor_id=" + actor_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", last_update=" + last_update + "]";
	}

}
