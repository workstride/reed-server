package com.works.reed.domain.parent.application;

import com.works.reed.domain.parent.dao.ParentRepository;
import com.works.reed.domain.parent.dto.Parent;
import com.works.reed.domain.parent.exception.ExistParentException;
import com.works.reed.domain.parent.exception.NotFoundParentException;
import com.works.reed.domain.parent.mapper.ParentMapper;
import com.works.reed.global.common.dao.MemberSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {
    private final MemberSecurity memberSecurity;
    private final ParentRepository parentRepository;
    private final ParentMapper parentMapper;

    public void register(Parent parent) {
        if (parentRepository.findById(parentMapper.createParentId(parent)).isPresent()) {
            throw ExistParentException.EXCEPTION;
        }
        parentRepository.save(parentMapper.createParent(parent));
    }

}
