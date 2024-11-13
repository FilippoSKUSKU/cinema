package org.elis.cinema;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import static org.assertj.core.api.Assertions.*;

import org.elis.cinema.dto.attore.InsertAttoreDTO;
import org.elis.cinema.dto.utente.InsertUtenteDTO;
import org.elis.cinema.dto.utente.LoginDTO;
import org.elis.cinema.model.Quiz;
import org.elis.cinema.repository.jpa.AttoreRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ContextConfiguration(classes = CinemaApplication.class)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CinemaApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private AttoreRepository attoreRepository;

    @Test
    @Order(1)
    void inserisciUtente() throws Exception{
        InsertUtenteDTO utenteDTO = new InsertUtenteDTO();
        utenteDTO.setUsername("filo99");
        utenteDTO.setPassword("P4ssw0rd!1");
        utenteDTO.setEmail("f.pignalberi@elis.org");
        String body = mapper.writeValueAsString(utenteDTO);

        mockMvc.perform(
                post("/all/utente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
        ).andExpect(
                status().isOk()
        );
    }
    @Test
    @Order(2)
    void login() throws Exception{
        LoginDTO loginDto = new LoginDTO();
        loginDto.setUsername("filo99");
        loginDto.setPassword("P4ssw0rd!1");
        String body = mapper.writeValueAsString(loginDto);
        mockMvc.perform(
                post("/all/utente/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
        ).andExpect(
                status().isOk()
        );
    }

    @Test
    @Order(3)
    @WithMockUser(username = "Username qualunque",authorities = "ROLE_STAFF")
    void insertAttoreConUserDetails() throws Exception{
        InsertAttoreDTO dto = new InsertAttoreDTO();
        dto.setNome("paola");
        dto.setCognome("cortellesi");
        String body = mapper.writeValueAsString(dto);
        mockMvc.perform(post("/staff/attore").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isOk());
    }

    @Test
    @Order(4)
    void testAttoreRepository(){
        assertThat(attoreRepository.findById(1L).get().getDataCreazione()).isBefore(LocalDateTime.now());
        Assertions.assertNotNull(attoreRepository.findById(2L));

    }

    @Test
    void restTemplateTest(){
        RestTemplate restTemplate = new RestTemplate();
        Quiz quiz = restTemplate.getForObject("https://opentdb.com/api.php?amount=10", Quiz.class);
        System.out.println(quiz);
        assertThat(quiz).isNotNull();
    }

}
