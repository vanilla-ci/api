package com.vanillaci.api.service;

import com.vanillaci.api.exception.*;
import com.vanillaci.api.model.*;
import com.vanillaci.api.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import javax.persistence.*;

/**
 * @author Joel Johnson
 */
@Service
public class JobService {
	@Qualifier("jobRepository")
	@Autowired
	private JobRepository jobRepository;

	@Transactional
	public Job createJob(Job job) {
		// TODO: validate all plugins exist
		for (AbstractBuildStep buildStep : job.getSteps()) {
			buildStep.setJob(job);
		}

		for (AbstractBuildStep buildStep : job.getPostSteps()) {
			buildStep.setJob(job);
		}

		job = jobRepository.save(job);
		return job;
	}

	public Job getJob(Long id) {
		Job one = jobRepository.getOne(id);

		try {
			if(!one.getId().equals(id)) { // this forces the exception to be thrown immediately.
				throw new JobNotFoundException(id);
			}
		} catch (EntityNotFoundException e) {
			throw new JobNotFoundException(id, e);
		}

		return one;
	}
}
