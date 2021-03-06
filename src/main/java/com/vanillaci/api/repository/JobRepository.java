package com.vanillaci.api.repository;

import com.vanillaci.api.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

/**
 * @author Joel Johnson
 */
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
