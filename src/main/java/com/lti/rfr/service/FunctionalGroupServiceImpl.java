package com.lti.rfr.service;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.rfr.domain.FunctionalGroup;
import com.lti.rfr.repository.FunctionalGroupRepository;
import com.lti.rfr.service.dto.FunctionalGroupDTO;
import com.lti.rfr.service.dto.RfrRaw;
import com.lti.rfr.service.mapper.FunctionalGroupMapper;

/**
 * Service Implementation for managing FunctionalGroup.
 */
@Service
@Transactional
public class FunctionalGroupServiceImpl implements FunctionalGroupService {

    private final Logger log = LoggerFactory.getLogger(FunctionalGroupServiceImpl.class);

    private final FunctionalGroupRepository functionalGroupRepository;

    private final FunctionalGroupMapper functionalGroupMapper;

    public FunctionalGroupServiceImpl(FunctionalGroupRepository functionalGroupRepository,
            FunctionalGroupMapper functionalGroupMapper) {
        this.functionalGroupRepository = functionalGroupRepository;
        this.functionalGroupMapper = functionalGroupMapper;
    }

    /**
     * Save a functionalGroup.
     *
     * @param functionalGroupDTO
     *            the entity to save
     * @return the persisted entity
     */
    @Override
    public FunctionalGroupDTO save(FunctionalGroupDTO functionalGroupDTO) {
        log.debug("Request to save FunctionalGroup : {}", functionalGroupDTO);
        FunctionalGroup functionalGroup = functionalGroupMapper.toEntity(functionalGroupDTO);
        functionalGroup = functionalGroupRepository.save(functionalGroup);
        return functionalGroupMapper.toDto(functionalGroup);
    }

    /**
     * Get all the functionalGroups.
     *
     * @param pageable
     *            the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<FunctionalGroupDTO> findAll(Pageable pageable) {
        log.debug("Request to get all FunctionalGroups");
        return functionalGroupRepository.findAll(pageable)
                .map(functionalGroupMapper::toDto);
    }

    /**
     * Get one functionalGroup by id.
     *
     * @param id
     *            the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public FunctionalGroupDTO findOne(Long id) {
        log.debug("Request to get FunctionalGroup : {}", id);
        FunctionalGroup functionalGroup = functionalGroupRepository.findOne(id);
        return functionalGroupMapper.toDto(functionalGroup);
    }

    /**
     * Delete the functionalGroup by id.
     *
     * @param id
     *            the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete FunctionalGroup : {}", id);
        functionalGroupRepository.delete(id);
    }

    @Override
    public void importGroup(List<Map<String, String>> rows) {

        Set<FunctionalGroupDTO> list = functionalGroupRepository
                .findAll()
                .stream()
                .map(functionalGroupMapper::toDto)
                .collect(Collectors.toSet());

        Predicate<FunctionalGroupDTO> exists = list::contains;

        Set<FunctionalGroup> groups = rows.stream()
                .skip(1) // header
                .map(RfrRaw::new)
                .map(FunctionalGroupDTO::new)
                .distinct()
                .filter(exists.negate())
                .map(FunctionalGroup::new)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        if (isNotEmpty(groups)) {
            functionalGroupRepository.save(groups);
        }
    }
}
