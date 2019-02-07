package com.example.ssm.mybatis.main;

import com.example.ssm.mybatis.mapper.RoleMapper;
import com.example.ssm.mybatis.pojo.Role;
import com.example.ssm.mybatis.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class MybatisMain {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(MybatisMain.class);
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            log.info(role.getNote());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
