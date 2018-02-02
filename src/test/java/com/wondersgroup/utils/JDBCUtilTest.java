package com.wondersgroup.utils;

import com.wondersgroup.utill.JDBCUtil;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class JDBCUtilTest {
    @Test
    public void jdbc() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }
}
