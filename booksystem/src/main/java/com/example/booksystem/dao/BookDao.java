package com.example.booksystem.dao;

import com.example.booksystem.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookDao {

    /**
     * 通过ID查询图书
     * @param id
     * @return
     */
    @Select("select book_id, name, number from book where book_id=#{id}")
    Book queryById(long id);

    /**
     * 查询所有图书
     * @param offset
     * @param limit
     * @return
     */
    @Select("select book_id, name, number from book limit #{limit} offset #{offset}")
    List<Book> queryAll(@Param("offset") int offset,
                        @Param("limit") int limit);

}
