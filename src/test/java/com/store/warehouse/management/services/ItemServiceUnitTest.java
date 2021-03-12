package com.store.warehouse.management.services;

import com.store.warehouse.management.model.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceUnitTest {

    @Autowired
    private ItemService itemService;

        @Test
        public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
            List<Item> items = itemService.list();
            Assert.assertEquals(items.size(), 0);
        }
    }
