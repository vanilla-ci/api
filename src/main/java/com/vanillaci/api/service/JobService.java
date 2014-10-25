package com.vanillaci.api.service;

import com.vanillaci.api.model.*;
import com.vanillaci.api.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

/**
 * @author Joel Johnson
 */
@Service
public class JobService {
	@Qualifier("jobRepository")
	@Autowired
	private JobRepository jobRepository;

	public Job createJob(Job job) {
		// TODO: validate all plugins exist
		return jobRepository.save(job);
	}
}
