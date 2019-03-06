package com.example.booksystem.dao;

import com.example.booksystem.entity.Appointment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AppointmentDao {

    /**
     * 插入预约记录
     * @param bookId
     * @param studentId
     * @return
     */
    @Insert("insert into appointment (book_id, student_id) values (#{bookId}, #{studentId})")
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    /**
     * 通过主键查询预约记录
     * @param bookId
     * @param studentId
     * @return
     */
    @Select("select * from appointment where book_id = #{bookId} and student_id = #{studentId}")
    Appointment queryByPrimaryKey(@Param("bookId") long bookId, @Param("studentId") long studentId);

}
