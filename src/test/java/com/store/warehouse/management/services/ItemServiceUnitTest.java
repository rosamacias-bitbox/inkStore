package com.store.warehouse.management.services;

import com.store.warehouse.management.dto.ItemDTO;
import com.store.warehouse.management.model.entity.Item;
import com.store.warehouse.management.services.impl.ItemServiceImpl;
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
    private ItemServiceImpl itemService;

        @Test
        public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
            List<ItemDTO> items = itemService.getItems();
            Assert.assertEquals(items.size(), 1);
        }
    }
