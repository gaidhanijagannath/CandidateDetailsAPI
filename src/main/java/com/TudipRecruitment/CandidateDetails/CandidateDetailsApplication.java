package com.TudipRecruitment.CandidateDetails;

import com.TudipRecruitment.CandidateDetails.service.CandidateService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class CandidateDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateDetailsApplication.class, args);


	}

}
