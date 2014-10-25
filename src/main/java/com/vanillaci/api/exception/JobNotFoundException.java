package com.vanillaci.api.exception;

/**
 * @author Joel Johnson
 */
public class JobNotFoundException extends BaseException {
	public JobNotFoundException(Long id) {
		super(404, "Job with ID " + id + " does not exist");
	}

	public JobNotFoundException(Long id, Throwable original) {
		super(404, "Job with ID " + id + " does not exist", original);
	}
}
