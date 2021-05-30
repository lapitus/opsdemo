package com.lapitus.opsdemoapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DualController {


    private final JdbcTemplate jdbcTemplate;
    private static final String SQL = "SELECT sysdate FROM DUAL";

    @Autowired
    public DualController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/sysdate")
    String getSysDate() {
        return jdbcTemplate.queryForObject(SQL,String.class);
    }

}
