package com.works.reed.domain.course.application;

import com.works.reed.domain.course.dao.*;
import com.works.reed.domain.course.domain.CourseAttendanceEntity;
import com.works.reed.domain.course.domain.CourseEntity;
import com.works.reed.domain.course.domain.CourseScheduleEntity;
import com.works.reed.domain.course.dto.Course;
import com.works.reed.domain.course.dto.CourseSchedule;
import com.works.reed.domain.course.dto.CourseStudent;
import com.works.reed.domain.course.dto.request.CourseStudRegisterRequest;
import com.works.reed.domain.course.dto.response.CourseAttendanceInfo;
import com.works.reed.domain.course.exception.NotFoundCourseException;
import com.works.reed.domain.course.mapper.CourseMapper;
import com.works.reed.domain.member.dao.MemberRepository;
import com.works.reed.domain.member.domain.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Transactional(rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseScheduleRepository courseScheduleRepository;
    private final CourseStudentRepository courseStudentRepository;
    private final CourseAttendanceRepository courseAttendanceRepository;
    private final CourseStudRegisterRepository courseStudRegisterRepository;
    private final MemberRepository memberRepository;
    private final CourseMapper courseMapper;

    @Override
    public void register(Course course, List<CourseSchedule> courseSchedules) {
        CourseEntity courseEntity = courseRepository.save(courseMapper.createCourse(course));
        courseScheduleRepository.saveAll(courseMapper.createCourseSchedulesWithCsno(courseEntity.getId(), courseSchedules));
    }

    @Override
    public void remove(Long courseId) {
        List<CourseScheduleEntity> classSchedules = courseScheduleRepository.findByCourseId(courseId).orElseThrow(() -> NotFoundCourseException.EXCEPTION);
        courseScheduleRepository.deleteAll(classSchedules);
        courseRepository.deleteById(courseId);
    }

    @Override
    public void registerCourses(CourseStudent courseStudent) {
        courseStudentRepository.save(courseMapper.createCourseStudent(courseStudent));
    }

    @Override
    public List<CourseAttendanceInfo> findCourseAttendanceInfo(Long courseId) {
        List<CourseStudRegisterRequest> request = courseStudRegisterRepository.findAllByCourseId(courseId);
        List<CourseAttendanceInfo> list = null;

        IntStream.rangeClosed(0, request.size()).forEach(i -> {
            list.add(CourseAttendanceInfo.builder()
                    .studentName(memberRepository.findById(request.get(i).getMemberId()).get().getName())
                    .isAttendance(false)
                    .build());

            courseAttendanceRepository.save(CourseAttendanceEntity.builder()
                    .studentName(memberRepository.findById(request.get(i).getMemberId()).get().getName())
                    .isAttendance(false)
                    .build());
        });

        return list;
    }

    @Override
    public void attendance(Long memberId) {
        Optional<MemberEntity> entity = memberRepository.findById(memberId);
        if(entity.isPresent()) {
            Optional<CourseAttendanceEntity> attendanceEntity = courseAttendanceRepository.findById(entity.get().getName());
            if(attendanceEntity.isPresent()) {
                courseAttendanceRepository.save(
                        CourseAttendanceEntity.builder()
                                .studentName(attendanceEntity.get().getStudentName())
                                .isAttendance(true)
                                .build());
            }
        }
    }
}
