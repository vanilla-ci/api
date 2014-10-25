package com.vanillaci.api.model;

import javax.persistence.*;
import java.util.*;

/**
 * @author Joel Johnson
 */
@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CREATED", updatable = false)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_MODIFIED")
	private Date dateModified;

	public BaseEntity() {}

	@PrePersist
	protected final void prePersist() {
		dateCreated = new Date();
		dateModified = new Date();
	}

	@PreUpdate
	protected final void preUpdate() {
		dateModified = new Date();
	}

	public Long getId() {
		return id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if(o == null) return false;
		if(o.getClass() != this.getClass()) return false;

		BaseEntity other = (BaseEntity) o;
		return id != null && !id.equals(other.getId());
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}
}
