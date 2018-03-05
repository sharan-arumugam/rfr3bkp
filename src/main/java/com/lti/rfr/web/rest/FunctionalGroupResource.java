package com.lti.rfr.web.rest;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.lti.rfr.repository.FunctionalGroupRepository;
import com.lti.rfr.service.FunctionalGroupService;
import com.lti.rfr.service.dto.FunctionalGroupDTO;
import com.lti.rfr.web.rest.errors.BadRequestAlertException;
import com.lti.rfr.web.rest.util.HeaderUtil;
import com.lti.rfr.web.rest.util.PaginationUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing FunctionalGroup.
 */
@RestController
@RequestMapping("/api")
public class FunctionalGroupResource {

    private final Logger log = LoggerFactory.getLogger(FunctionalGroupResource.class);

    private static final String ENTITY_NAME = "functionalGroup";

    private final FunctionalGroupService functionalGroupService;
    private final FunctionalGroupRepository functionalGroupRepository;

    public FunctionalGroupResource(FunctionalGroupService functionalGroupService,
            FunctionalGroupRepository functionalGroupRepository) {

        this.functionalGroupRepository = functionalGroupRepository;
        this.functionalGroupService = functionalGroupService;
    }

    /**
     * POST /functional-groups : Create a new functionalGroup.
     *
     * @param functionalGroupDTO
     *            the functionalGroupDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new
     *         functionalGroupDTO, or with status 400 (Bad Request) if the
     *         functionalGroup has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/functional-groups")
    @Timed
    public ResponseEntity<FunctionalGroupDTO> createFunctionalGroup(@RequestBody FunctionalGroupDTO functionalGroupDTO)
            throws URISyntaxException {
        log.debug("REST request to save FunctionalGroup : {}", functionalGroupDTO);
        if (functionalGroupDTO.getId() != null) {
            throw new BadRequestAlertException("A new functionalGroup cannot already have an ID", ENTITY_NAME,
                    "idexists");
        }
        FunctionalGroupDTO result = functionalGroupService.save(functionalGroupDTO);
        return ResponseEntity.created(new URI("/api/functional-groups/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    /**
     * PUT /functional-groups : Updates an existing functionalGroup.
     *
     * @param functionalGroupDTO
     *            the functionalGroupDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated
     *         functionalGroupDTO, or with status 400 (Bad Request) if the
     *         functionalGroupDTO is not valid, or with status 500 (Internal Server
     *         Error) if the functionalGroupDTO couldn't be updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/functional-groups")
    @Timed
    public ResponseEntity<FunctionalGroupDTO> updateFunctionalGroup(@RequestBody FunctionalGroupDTO functionalGroupDTO)
            throws URISyntaxException {
        log.debug("REST request to update FunctionalGroup : {}", functionalGroupDTO);
        if (functionalGroupDTO.getId() == null) {
            return createFunctionalGroup(functionalGroupDTO);
        }
        FunctionalGroupDTO result = functionalGroupService.save(functionalGroupDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, functionalGroupDTO.getId().toString()))
                .body(result);
    }

    /**
     * GET /functional-groups : get all the functionalGroups.
     *
     * @param pageable
     *            the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of
     *         functionalGroups in body
     */
    @GetMapping("/functional-groups")
    @Timed
    public ResponseEntity<List<FunctionalGroupDTO>> getAllFunctionalGroups(Pageable pageable) {

        log.debug("REST request to get a page of FunctionalGroups");
        Page<FunctionalGroupDTO> page = functionalGroupService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/functional-groups");

        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @GetMapping("/functional-group-master")
    public Map<String, Map<String, String>> getAllFunctionalGroupMaster() {

        log.debug("REST request to get a page of FunctionalGroups");
        List<FunctionalGroupDTO> list = functionalGroupRepository
                .findAll()
                .stream()
                .map(FunctionalGroupDTO::new)
                .collect(toList());
        
        

        Map<String, List<FunctionalGroupDTO>> imtMap = list.stream()
                .filter(dto -> null != dto.getImt())
                .collect(groupingBy(FunctionalGroupDTO::getImt));

        Map<String, Map<String, List<FunctionalGroupDTO>>> imt1Map = new HashMap<>();

        imtMap.forEach((imt, dtoList) -> {
            imt1Map.put(imt, dtoList
                    .stream()
                    .filter(dto -> null != dto.getImt1())
                    .collect(groupingBy(FunctionalGroupDTO::getImt1)));
        });

        Map<String, Map<String, String>> finalMap = new HashMap<>();

        imt1Map.forEach((imt, dtoMap) -> {
            Map<String, String> xMap1 = new HashMap<>();
            dtoMap.forEach((imt1, dtoList) -> {
                xMap1.put(imt1, dtoList.stream()
                        .map(FunctionalGroupDTO::getImt2)
                        .collect(joining(", ")));
            });
            finalMap.put(imt, xMap1);
        });

        log.info("=====================##  IMT  ##========================");

        finalMap.forEach((imt, map1) -> {
            log.info("==IMT :: " + imt);
            map1.forEach((imt1, imt2CS) -> {
                log.info("====IMT-1 :: " + imt1);
                log.info("=======IMT-2 :: " + imt2CS);
            });
        });

        return finalMap;
    }

    /**
     * GET /functional-groups/:id : get the "id" functionalGroup.
     *
     * @param id
     *            the id of the functionalGroupDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the
     *         functionalGroupDTO, or with status 404 (Not Found)
     */
    @GetMapping("/functional-groups/{id}")
    @Timed
    public ResponseEntity<FunctionalGroupDTO> getFunctionalGroup(@PathVariable Long id) {
        log.debug("REST request to get FunctionalGroup : {}", id);
        FunctionalGroupDTO functionalGroupDTO = functionalGroupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(functionalGroupDTO));
    }

    /**
     * DELETE /functional-groups/:id : delete the "id" functionalGroup.
     *
     * @param id
     *            the id of the functionalGroupDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/functional-groups/{id}")
    @Timed
    public ResponseEntity<Void> deleteFunctionalGroup(@PathVariable Long id) {
        log.debug("REST request to delete FunctionalGroup : {}", id);
        functionalGroupService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
