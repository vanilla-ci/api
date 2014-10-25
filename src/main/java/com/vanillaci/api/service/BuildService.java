package com.vanillaci.api.service;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.vanillaci.api.*;
import com.vanillaci.api.model.*;
import com.vanillaci.api.repository.*;
import org.springframework.amqp.rabbit.core.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * @author Joel Johnson
 */
@Service
public class BuildService {
	@Qualifier("buildRepository")
	@Autowired
	private BuildRepository buildRepository;

	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private AppConfiguration appConfiguration;

	@Autowired
	private ObjectMapper objectMapper;

	public Build createBuild(Job job, Map<String, String> parameters) {
		Build build = new Build();
		build.setJob(job);
		build.setParameters(parameters);

		return buildRepository.save(build);
	}

	public void startBuild(Build build) {
		Job job = build.getJob();
		List<Map<String, Object>> steps = convertSteps(job.getSteps());
		List<Map<String, Object>> postSteps = convertSteps(job.getPostSteps());

		Map<String, Object> message = new HashMap<>();
		message.put("id", build.getId());
		message.put("parameters", build.getParameters());
		message.put("steps", steps);
		message.put("postSteps", postSteps);

		try {
			String json = objectMapper.writeValueAsString(message);
			rabbitTemplate.convertAndSend(appConfiguration.getQueueName(), json);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	private List<Map<String, Object>> convertSteps(List<AbstractBuildStep> steps) {
		List<Map<String, Object>> result = new ArrayList<>();
		for (AbstractBuildStep step : steps) {
			Map<String, Object> stepMap = convertStep(step);
			result.add(stepMap);
		}
		return result;
	}

	private Map<String, Object> convertStep(AbstractBuildStep step) {
		Map<String, Object> result = new HashMap<>();

		result.put("name", step.getName());
		result.put("parameters", step.getParameters());

		return result;
	}
}
