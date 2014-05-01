/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.services;

import com.hendricks.musicstoreweb2.app.conf.ConnectionConfig;
import com.hendricks.musicstoreweb2.repository.ProductBuyerRepository;
import com.hendricks.musicstoreweb2.services.AddProductBuyerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author kurvin
 */
public class AddProductBuyerServiceTest {
    
    private static ApplicationContext ctx;
    private ProductBuyerRepository repo;
    private AddProductBuyerService service;
    
    public AddProductBuyerServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void productBuyer() {
         service = ctx.getBean(AddProductBuyerService.class);
         repo = ctx.getBean(ProductBuyerRepository.class);
         boolean check = service.addManager("Matthew Grayson");
         repo.deleteAll();
         Assert.assertEquals(check, true);
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}