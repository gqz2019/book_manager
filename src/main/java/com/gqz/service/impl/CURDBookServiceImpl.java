package com.gqz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gqz.mapper.BookMapper;
import com.gqz.pojo.Book;
import com.gqz.service.CURDBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>实现类</p>
 *
 * @author gqz20
 * @create 2021-06-03 19:10
 **/
@Service
public class CURDBookServiceImpl implements CURDBookService {
    @Autowired
    private BookMapper bookMapper;

    /**
     * 添加book
     *
     * @param book
     * @return
     */
    @Override
    public int addBook(Book book) {
        int i = bookMapper.update(book,null);
        return i;
    }

    /**
     * 删除图书
     *
     * @param name
     */
    @Override
    public void deleteBook(String name) {
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("book_name",name);
        bookMapper.deleteByMap(map);
    }

    /**
     * 重载方法
     *
     * @param id
     */
    @Override
    public void deleteBook(Integer id) {
        bookMapper.deleteById(id);
    }

    /**
     * 更新图书
     *
     * @param book
     */
    @Override
    public void updateBook(Book book) {
        bookMapper.updateById(book);
    }

    /**
     * 查找图书
     *
     * @param book
     * @return
     */
    @Override
    public Book findBook(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public Integer getBookCount(Integer id) {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        Integer count = bookMapper.selectCount(wrapper);
        return count;
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> books = bookMapper.selectList(null);
        return books;
    }
}
