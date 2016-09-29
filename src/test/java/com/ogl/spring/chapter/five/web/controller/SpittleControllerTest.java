package com.ogl.spring.chapter.five.web.controller;

import com.ogl.spring.chapter.five.dao.SpittleRepository;
import com.ogl.spring.chapter.five.entity.Spittle;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpittleControllerTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);

        // para que el marco de trabajo mock no intente resolver el nombre de la vista
        // que proviene del controlador invocamos setSingleView
        // en muchos casos no es necesario pero para este método del controlador el nombre
        // de la vista es similar al de la ruta de la solicitud y MockMvc falla xq la ruta
        // se confunde
//        MockMvc mockMvc = standaloneSetup(controller).build();
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(
                new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();

        mockMvc.perform(get("/spittles")) // ruta en el controlador RequestMapping
                .andExpect(view().name("spittles")) // nombre del method se puede cambiar con value
                // .andExpect(view().name("LOL"))
                .andExpect(model().attributeExists("spittleList")) // Confirma expectativas
                .andExpect(model().attribute("spittleList", expectedSpittles));
    }

    @Test
    public void shouldShowRecentSpittlesModel() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);

        // para que el marco de trabajo mock no intente resolver el nombre de la vista
        // que proviene del controlador invocamos setSingleView
        // en muchos casos no es necesario pero para este método del controlador el nombre
        // de la vista es similar al de la ruta de la solicitud y MockMvc falla xq la ruta
        // se confunde
//        MockMvc mockMvc = standaloneSetup(controller).build();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spittles/map")) // ruta en el controlador RequestMapping
                .andExpect(view().name("mapvista")) // nombre de la vista se puede cambiar con value
                .andExpect(model().attributeExists("spittleList")) // Confirma expectativas
                .andExpect(model().attribute("spittleList", expectedSpittles));
    }

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedspittles = createSpittleList(50);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(238900, 50)).thenReturn(expectedspittles);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();

        mockMvc.perform(get("/spittles?max=238900&count=50"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedspittles.toArray())));
    }

    @Test
    public void testSpittle() throws Exception {
        final Long id = 12345L;
        Spittle expectedSpittle = createSpittleList(1).get(0);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findById(id)).thenReturn(expectedSpittle);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spittles/".concat(String.valueOf(id))))
                .andExpect(view().name("param/spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }


}
