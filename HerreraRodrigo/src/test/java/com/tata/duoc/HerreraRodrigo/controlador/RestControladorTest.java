package com.tata.duoc.HerreraRodrigo.controlador;

import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest
public class RestControladorTest extends TestCase {

    @Autowired
    private MockMvc mockMvc;

    public void testGetAllClients() throws Exception {
        this.mockMvc.perform(get("/clientes")).andExpect(status().isOk());
    }
}