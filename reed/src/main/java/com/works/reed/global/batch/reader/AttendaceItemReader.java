package com.works.reed.global.batch.reader;

import com.works.reed.domain.attendance.application.querydsl.AttendanceQueryService;
import com.works.reed.domain.attendance.dto.NonAttendance;
import com.works.reed.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class AttendaceItemReader implements ItemReader<List<NonAttendance>> {
    private static final int SIZE = 50;

    private final AttendanceQueryService attendanceQueryService;
    private int page = 1;

    @Override
    public List<NonAttendance> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        log.info("....................... attendaceItemReader start");

        final List<NonAttendance> nonAttendanceList = attendanceQueryService.findNonAttendance(pageRequest((page)));
        log.info("....................... nonAttendanceList : {} ", nonAttendanceList.size());

        if (nonAttendanceList.isEmpty()) {
            page = 1;
            return null;
        }

        page++;

        log.info("....................... attendaceItemReader end");

        return nonAttendanceList;
    }

    private PageRequest pageRequest(int page) {
        return PageRequest.builder().page(page).size(SIZE).build();
    }
}
