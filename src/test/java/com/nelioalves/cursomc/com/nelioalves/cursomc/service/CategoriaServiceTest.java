package com.nelioalves.cursomc.com.nelioalves.cursomc.service;

import com.nelioalves.cursomc.CursomcApplication;
import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.service.CategoriaService;
import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CategoriaService.class)
public class CategoriaServiceTest {

    @Autowired
    private CategoriaService categoriaService;

    @Test
    public void buscarCategoria(){
        Categoria categoria = categoriaService.find(1);
        assertThat(categoria, CoreMatchers.notNullValue());
    }
}
