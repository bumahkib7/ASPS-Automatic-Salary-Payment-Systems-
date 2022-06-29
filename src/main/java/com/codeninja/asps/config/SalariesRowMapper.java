package com.codeninja.asps.config;

import com.codeninja.asps.models.Salary;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class SalariesRowMapper implements RowMapper<Salary> {

    @Override

    public Salary mapRow(ResultSet rs, int rowNum) throws SQLException, SQLException {
        return new Salary(
                (int) rs.getLong("id"),
                rs.getInt("salary")
        );
    }


}
