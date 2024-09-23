package com.works.reed.domain.parent.application.querydsl;

import com.works.reed.domain.parent.dao.querydsl.ParentQueryRepository;
import com.works.reed.domain.parent.dto.ParentInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class ParentQueryServiceImpl implements ParentQueryService {

    private final ParentQueryRepository parentQueryRepository;

    public List<ParentInfo> findParentsByChildId(Long memberId) {
        return parentQueryRepository.findParentsByChildId(memberId);
    }

}
