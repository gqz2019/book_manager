package com.gqz.service;

import com.gqz.pojo.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>图书的增删改查</p>
 *
 * @author gqz20
 * @create 2021-06-03 19:08
 **/
public interface CURDBookService {
    /**
     * 添加book
     * @param book
     * @return
     */
    int addBook(Book book);

    /**
     * 删除图书
     * @param name
     */
    void deleteBook(String name);

    /**
     * 重载方法
     * @param id
     */
    void deleteBook(Integer id);

    /**
     * 更新图书
     * @param book
     */
    void updateBook(Book book);

    /**
     * 查找图书
     * @param book
     * @return
     */
    Book findBook(Integer id);

    Integer getBookCount(Integer id);

    List<Book> getAllBook();
}
