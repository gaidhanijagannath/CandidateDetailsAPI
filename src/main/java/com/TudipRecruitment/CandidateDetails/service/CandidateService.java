package com.TudipRecruitment.CandidateDetails.service;


import com.TudipRecruitment.CandidateDetails.entity.CandidateDetails;
import com.TudipRecruitment.CandidateDetails.repository.CandidateDetailsRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class CandidateService {

    @Autowired
    private final CandidateDetailsRepository candidateDetailsRepository;

   /* @PostConstruct
    public void initDB(){

        List<CandidateDetails> candidateRecords = IntStream.rangeClosed(1, 200)
                .mapToObj(i -> new CandidateDetails("name " + i,
                        "869880666"+i,
                        i+"'th street avenue","email"+i+"@gmail.com"))
                .toList();

        candidateDetailsRepository.saveAll(candidateRecords);
    }*/

    public void saveCandidate(CandidateDetails candidateRequest) {
        candidateDetailsRepository.save(candidateRequest);
    }


    public List<CandidateDetails> getAllCandidates() {
        return candidateDetailsRepository.findAll();
    }


    //sorting
    public List<CandidateDetails> getCandidatesInSortedOrder(String parameterName){

        return candidateDetailsRepository.findAll(Sort.by(Sort.Direction.ASC,parameterName));
    }


    //pagination
    public Page<CandidateDetails> findCandidateWithPagination(int offset,int pageSize){

        return candidateDetailsRepository.findAll(PageRequest.of(offset,pageSize));

    }

    //pagination with sorting
    public Page<CandidateDetails> findCandidateWithPaginationWithSorting(int offset,int pageSize, String parameter){

        return candidateDetailsRepository
                        .findAll(PageRequest.of(offset,pageSize)
                        .withSort(Sort.by(Sort.Direction.ASC,parameter)));

    }

    public Page<CandidateDetails> SearchCandidateWithPaginationAndSorting(int offset,int pageSize, String parameter,String by){

        return candidateDetailsRepository
                .findAll(PageRequest.of(offset,pageSize)
                        .withSort(Sort.by(Sort.Direction.ASC,parameter)));

    }

    //searching
    public List<CandidateDetails> searchCandidate(String query){

        return  candidateDetailsRepository.searchCandidateJPA(query);
    }

}
