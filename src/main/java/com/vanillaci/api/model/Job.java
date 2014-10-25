package com.vanillaci.api.model;

import javax.persistence.*;
import java.util.*;

/**
 * @author Joel Johnson
 */
@Entity
public class Job extends BaseEntity {
	@Column
	private String name;

	@OneToMany(mappedBy = "job", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<BuildStep> steps = new ArrayList<>();

	@OneToMany(mappedBy = "job", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<PostBuildStep> postSteps = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BuildStep> getSteps() {
		return steps;
	}

	public void setBuildSteps(List<BuildStep> buildSteps) {
		this.steps = buildSteps;
	}

	public List<PostBuildStep> getPostSteps() {
		return postSteps;
	}

	public void setPostSteps(List<PostBuildStep> postBuildSteps) {
		this.postSteps = postBuildSteps;
	}
}
