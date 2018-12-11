/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compa.mvdb_desktop;

import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ElKebabHenry
 */
public class ListOfMoviesTest {
    
    public ListOfMoviesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of fetchMoviesFromDB method, of class ListOfMovies.
     */
    @Test
    public void testFetchMoviesFromDB() throws Exception {
        System.out.println("fetchMoviesFromDB");
        ListOfMovies instance = new ListOfMovies();
        JSONObject expResult = null;
        JSONObject result = instance.fetchMoviesFromDB();
        assertNotEquals(expResult, result);
        assertTrue("is array?", !result.isEmpty());
    }
    
}
