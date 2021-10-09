package com.irreporter.models;

//import com.irreporter.models.Incident;
import com.irreporter.models.enums.Status;
import com.irreporter.models.enums.Type;

import javax.persistence.*;
import java.util.Date;
/**
 * The class {@code Incident} represents an occurrence, condition, 
 * or situation arising in the course of work that resulted in or could 
 * have resulted in injuries, illnesses, damage, or fatalities.
 * 
 * {@code Incident} should have an id, title, type[Redflag, Intervention], 
 * status[Draft, Under investigation, Resolved, Rejected], createdOn and comment
 *
 */
@Entity
@Table(name = "incidentstable")
public class Incident {
    private int id;
    private String title;
    private Type  type;
    private Status status;
    private Date  createdOn;
    private String comment;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "Type")
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "Status")
	public Status getStatus() {
		return status;}
	public void setStatus(Status status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CreatedOn")
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "Comment")
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Incident{" +
				"id=" + id +
				", title='" + title + '\'' +
				", type=" + type +
				", status=" + status +
				", createdOn=" + createdOn +
				", comment='" + comment + '\'' +
				'}';
	}
}

