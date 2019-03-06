package com.example.booksystem.dao;

import com.example.booksystem.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;

public class AppointmentDaoTest extends BaseTest {

    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void testInsertAppointment() {
        appointmentDao.insertAppointment(1000, 1000001);
        assertNotNull(appointmentDao.queryByPrimaryKey(1000, 1000001));
        assertNull(appointmentDao.queryByPrimaryKey(1001, 1000001));
        assertNull(appointmentDao.queryByPrimaryKey(1000, 1000000));
    }
}
