package com.works.reed.domain.announcement.application;

import com.works.reed.domain.announcement.dao.AnnounceRepository;
import com.works.reed.domain.announcement.domain.AnnounceEntity;
import com.works.reed.domain.announcement.dto.Announce;
import com.works.reed.domain.announcement.dto.AnnounceInfo;
import com.works.reed.domain.announcement.dto.request.AnnounceRequest;
import com.works.reed.domain.announcement.mapper.AnnounceMapper;
import com.works.reed.global.common.dao.MemberSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnnounceServiceImpl implements AnnounceService {

    private final AnnounceRepository announceRepository;
    private final MemberSecurity memberSecurity;
    private final AnnounceMapper mapper;

    @Override
    public void upload(AnnounceRequest announce) {
        Announce ann = Announce.builder()
                .academyId(announce.getAcademyId())
                .memberId(memberSecurity.getMember().getId())
                .annTitle(announce.getAnnTitle())
                .annContent(announce.getAnnContent())
                .build();

        announceRepository.save(mapper.createEntity(ann));
    }

    @Override
    public AnnounceInfo read(Long id) {
        Optional<AnnounceEntity> result = announceRepository.findById(id);
        if(result.isPresent()) {
            AnnounceEntity entity = result.get();
            AnnounceInfo build = AnnounceInfo.builder()
                    .id(entity.getId())
                    .annTitle(entity.getAnnTitle())
                    .annContent(entity.getAnnContent())
                    .build();
            return build;
        }
        return null;
    }

    @Override
    public void edit(AnnounceRequest request, Long id) {
        Announce ann = Announce.builder()
                .id(id)
                .academyId(request.getAcademyId())
                .annTitle(request.getAnnTitle())
                .annContent(request.getAnnContent())
                .build();
        announceRepository.save(mapper.createEntity(ann));
    }

    @Override
    public void delete(Long id) {
        announceRepository.deleteById(id);
    }

}
