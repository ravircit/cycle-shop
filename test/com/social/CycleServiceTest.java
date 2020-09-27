package com.social;

import com.social.data.CycleStore;
import com.social.model.Command;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CycleServiceTest {
    CycleService cycleService=null;
    @Before
    public void setUp() {
        cycleService=new CycleService("data.txt");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetComponents()
    {
        assertEquals(cycleService.getAllComponents().size(),5);
    }

    @Test
    public void testPurchaseCycle()
    {
        Command command=new Command("purchase_cycle 1.1","09-2020");
        cycleService.purchaseCycle(command);
        assertEquals(cycleService.getPurchasedCycleForCustomer(1).getComponents().size(),1);
    }
}
