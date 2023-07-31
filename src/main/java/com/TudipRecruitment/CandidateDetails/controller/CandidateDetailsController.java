package com.TudipRecruitment.CandidateDetails.controller;


import com.TudipRecruitment.CandidateDetails.entity.CandidateDetails;
import com.TudipRecruitment.CandidateDetails.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/version/CandidateList")
public class CandidateDetailsController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void populateCandidateDetails(@RequestBody CandidateDetails candidateDetailsRequest){

        candidateService.saveCandidate(candidateDetailsRequest);
    }


    @GetMapping(value = "/")
    @ResponseStatus(code = HttpStatus.OK)
    public List<CandidateDetails> retrieveAllCandidates(){

        return  candidateService.getAllCandidates();
    }

    /*@GetMapping(value = "/sort/{parameter}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<CandidateDetails> sortedCandidates(@PathVariable String parameter){

        return candidateService.getCandidatesInSortedOrder(parameter);
    }*/

    @GetMapping(value = "/sort")
    @ResponseStatus(code = HttpStatus.OK)
    public List<CandidateDetails> sortedCandidates(@RequestParam("by") String parameter){

        return candidateService.getCandidatesInSortedOrder(parameter);
    }

   /* @GetMapping(value = "/pagination/{offset}/{sizeofPage}" )
    @ResponseStatus(code = HttpStatus.OK)
    public Page<CandidateDetails> implementPagination(@PathVariable int offset,@PathVariable int sizeofPage){

        return candidateService.findCandidateWithPagination(offset,sizeofPage);
    }*/

    @GetMapping(value = "/paging" )
    @ResponseStatus(code = HttpStatus.OK)
    public Page<CandidateDetails> implementPagination(@RequestParam("offSet") int offset,@RequestParam("pageSize") int sizeofPage){

        return candidateService.findCandidateWithPagination(offset,sizeofPage);
    }

    /*@GetMapping(value = "/pagination/{offset}/{sizeofPage}/{parameter}" )
    @ResponseStatus(code = HttpStatus.OK)
    public Page<CandidateDetails> findCandidateWithPaginationWithSorting(@PathVariable int offset,@PathVariable int sizeofPage,@PathVariable String parameter){

        return candidateService.findCandidateWithPaginationWithSorting(offset,sizeofPage,parameter);
    }*/

    @GetMapping(value = "/paging/sort" )
    @ResponseStatus(code = HttpStatus.OK)
    public Page<CandidateDetails> findCandidateWithPaginationWithSorting(@RequestParam("offSet") int offset,
                                                                                                        @RequestParam("pageSize") int sizeofPage,
                                                                                                        @RequestParam("by") String sortBy){

        return candidateService.findCandidateWithPaginationWithSorting(offset,sizeofPage,sortBy);
    }


    @GetMapping(value = "/paging/search" )
    @ResponseStatus(code = HttpStatus.OK)
    public Page<CandidateDetails> searchCandidateWithPagination(@RequestParam("offSet") int offset,
                                                                         @RequestParam("pageSize") int sizeofPage,
                                                                         @RequestParam("by") String sortBy,
                                                                         @RequestParam("query") String query){

        return candidateService.SearchCandidateWithPaginationAndSorting(offset,sizeofPage,sortBy,query);
    }

    @GetMapping(value = "/search" )
    @ResponseStatus(code = HttpStatus.OK)
    public List<CandidateDetails> searchForCandidates(@RequestParam("query") String query){

        return candidateService.searchCandidate(query);

    }

    @PutMapping("/updateCandidate")
    public CandidateDetails updateCandidate(@RequestBody CandidateDetails candidateUpdateRequest){

        return candidateService.updateCandidateDetails(candidateUpdateRequest);
    }


}
