package com.vanillaci.api.controller;

import com.fasterxml.jackson.databind.*;
import com.vanillaci.api.*;
import com.vanillaci.api.exception.*;
import com.vanillaci.api.model.*;
import com.vanillaci.api.service.*;
import org.apache.log4j.*;
import org.springframework.amqp.rabbit.core.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.*;

/**
 * @author Joel Johnson
 */
@Controller
@RequestMapping(value = "/job", method = RequestMethod.GET, produces = "application/json")
public class JobController {
	private Logger log = Logger.getLogger(JobController.class);

	@Autowired
	private JobService jobService;

	@Autowired
	private BuildService buildService;

	@RequestMapping(value = "/{id}/start", method = RequestMethod.POST)
	@ResponseBody
	public Build startJob(@PathVariable("id") Long id, @RequestBody Map<String, String> parameters) {
		log.info("Starting job");

		Job job = jobService.getJob(id);
		Build build = buildService.createBuild(job, parameters);

		buildService.startBuild(build);

		return build;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Job createJob(@RequestBody Job job) {
		job = jobService.createJob(job);
		return job;
	}
}
