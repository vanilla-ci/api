package com.vanillaci.api.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;

/**
 * @author Joel Johnson
 */
@MappedSuperclass
public abstract class AbstractBuildStep extends BaseEntity {
	@Column
	private String name;

	@ElementCollection
	@MapKeyColumn(name = "name")
	@Column(name = "value")
	@CollectionTable(name = "buildStepProperties", joinColumns = @JoinColumn(name = "buildStepId"))
	private Map<String, String> parameters = new HashMap<>();

	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "jobId", nullable = false)
	private Job job;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
}
