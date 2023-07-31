package com.TudipRecruitment.CandidateDetails.repository;

import com.TudipRecruitment.CandidateDetails.entity.CandidateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CandidateDetailsRepository extends JpaRepository<CandidateDetails, UUID> {

    @Query("SELECT c from CandidateDetails c WHERE "+
            " c.name LIKE CONCAT( '%', :query , '%' ) " +
             "OR c.phoneNumber LIKE CONCAT( '%' , :query , '%' )"+
             "OR c.Address LIKE CONCAT( '%' , :query , '%' )" +
             "OR c.Email LIKE CONCAT( '%' , :query , '%' )")
    List<CandidateDetails> searchCandidateJPA(String query);

    @Query(value = "SELECT * from candidate_details c WHERE "+
            "OR c.name LIKE CONCAT( '%', :query , '%' )" +
            "OR c.phoneNumber LIKE CONCAT( '%' , :query , '%' )  OR "+
            "OR c.Address LIKE CONCAT( '%' , :query , '%' ) OR " +
            "OR c.Email LIKE CONCAT( '%' , :query , '%' )",nativeQuery = true)
    List<CandidateDetails> searchCandidateSQL(String query);
}
