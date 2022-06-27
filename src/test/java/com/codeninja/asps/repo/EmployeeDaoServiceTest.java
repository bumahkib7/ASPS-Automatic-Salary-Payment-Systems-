package com.codeninja.asps.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

class EmployeeDaoServiceTest {
    /**
     * Method under test: {@link EmployeeDaoService#getEmployeebyId(long)}
     */
    @Test
    void testGetEmployeebyId() throws DataAccessException {
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
        when(jdbcTemplate.update((String) any(), (Object[]) any())).thenReturn(1);
        assertEquals(1L, (new EmployeeDaoService(jdbcTemplate)).getEmployeebyId(1L));
        verify(jdbcTemplate).update((String) any(), (Object[]) any());
    }
}

