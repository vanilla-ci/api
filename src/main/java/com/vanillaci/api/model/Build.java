package com.vanillaci.api.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;

/**
 * @author Joel Johnson
 */
@Entity
public class Build extends BaseEntity {
	@ManyToOne(optional = false)
	@JoinColumn(name = "jobId", nullable = false)
	private Job job;

	@ElementCollection
	@MapKeyColumn(name = "name")
	@Column(name = "value")
	@CollectionTable(name = "buildProperties", joinColumns = @JoinColumn(name = "buildId"))
	private Map<String, String> parameters = new HashMap<>();

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
}
