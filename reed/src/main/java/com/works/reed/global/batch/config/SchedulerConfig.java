package com.works.reed.global.batch.config;

import com.works.reed.domain.attendance.application.querydsl.AttendanceQueryService;
import com.works.reed.domain.attendance.dto.NonAttendance;
import com.works.reed.domain.notification.application.NotificationService;
import com.works.reed.domain.notification.dto.Notification;
import com.works.reed.domain.parent.application.querydsl.ParentQueryService;
import com.works.reed.global.batch.processor.AttendanceItemProcessor;
import com.works.reed.global.batch.reader.AttendaceItemReader;
import com.works.reed.global.batch.writer.AttendanceItemWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class SchedulerConfig {
    private static final int CHUNK_SIZE = 1;

    private final AttendanceQueryService attendanceQueryService;

    private final ParentQueryService parentQueryService;

    private final NotificationService notificationService;

    @Bean
    public Job checkAttendanceJob(final Step checkAttendanceStep, final JobRepository jobRepository) {
        return new JobBuilder("checkAttendanceJob", jobRepository)
                .preventRestart()
                .flow(checkAttendanceStep)
                .end()
                .build();
    }

    @Bean
    public Step checkAttendanceStep(final JobRepository jobRepository, final PlatformTransactionManager transactionManager) {
        return new StepBuilder("checkAttendanceStep", jobRepository)
                .<List<NonAttendance>, List<Notification>>chunk(CHUNK_SIZE, transactionManager)
                .startLimit(1)
                .reader(attendanceReader())
                .processor(attendanceProcessor())
                .writer(attendanceWriter())
                .build();
    }

    @Bean
    public ItemReader<List<NonAttendance>> attendanceReader() {
        return new AttendaceItemReader(attendanceQueryService);
    }

    @Bean
    public ItemProcessor<List<NonAttendance>, List<Notification>> attendanceProcessor() {
        return new AttendanceItemProcessor(parentQueryService);
    }

    @Bean
    public ItemWriter<List<Notification>> attendanceWriter() {
        return new AttendanceItemWriter(notificationService);
    }
}
