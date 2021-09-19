package com.gqz;

import com.gqz.mapper.BookMapper;
import com.gqz.pojo.Book;
import com.gqz.service.CURDBookService;
import com.gqz.start.CURDUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

/**
 * <p></p>
 *
 * @author gqz20
 * @create 2021-06-03 21:38
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
@Slf4j
public class test {
    @Autowired
    private CURDBookService curd;

    @Autowired
    private CURDUtils curdUtils;

    @Test
    public void aVoid() {
        Book book1 = curd.findBook(1);
        System.out.println(book1);
    }
    @Test
    public void b(){
        curdUtils.d();
    }
    @Test
    public void c(){
        /*Date date = new Date();
        Instant instant = date.toInstant();
        log.info(instant.toString());
        System.out.println(LocalDate.now());
        log.info(LocalDate.now().toString());*/

        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter inFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter outFormat = DateTimeFormatter.ofPattern("MM月 dd日 yyyy年, KK:mm:ss a");
        String outDateStr = localDateTime.format(outFormat);


        String time = localDateTime.format(outFormat);

        log.info(time);


    }
}
