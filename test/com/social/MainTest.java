package com.social;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MainTest {
  private InputStream sysInBackup;
  private PrintStream sysOutBackup;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUp() throws Exception {
    sysInBackup = System.in;
    sysOutBackup = System.out;
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void tearDown() throws Exception {
    System.setIn(sysInBackup);
    System.setOut(sysOutBackup);
  }

  @Test
  public void testShowMenu() throws IOException {
    final String commands = "show_cycle_parts\nexit";

    final String expectedOutput ="Welcome to Cycle shop.\r\n" +
            "1.Wheel\r\n" +
            "    1.1 Tube 100.0\r\n" +
            "    1.2 Tyre 105.0\r\n" +
            "    1.3 Tubeless Tyre 300.0\r\n" +
            "2.Frame\r\n" +
            "    2.1 Triangle 200.0\r\n" +
            "    2.2 Steel 500.0\r\n" +
            "3.Handle\r\n" +
            "    3.1 Breaks 50.0\r\n" +
            "    3.2 Ring 40.0\r\n" +
            "    3.3 Light 100.0\r\n" +
            "4.Seat\r\n" +
            "    4.1 For Man 50.0\r\n" +
            "    4.2 For Woman 40.0\r\n" +
            "    4.3 For Child 100.0\r\n" +
            "5.Chain Assembly\r\n" +
            "    5.1 Chain 50.0\r\n" +
            "    5.2 Gear 40.0\r\n" +
            "    5.3 Pedal 100.0\r\n";

    final ByteArrayInputStream in = new ByteArrayInputStream(commands.getBytes());
    System.setIn(in);

    Main.main(new String[] {"data.txt"});
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testPurchaseCycle() throws IOException {
    final String commands = "purchase_cycle 1.1 1.2\nexit";

    final String expectedOutput ="Welcome to Cycle shop.\r\n" +
            "Purchased list of customer number 1\r\n" +
            "Price of Wheel is - 205.0\r\n" +
            "Total price is - 205.0\r\n";

    final ByteArrayInputStream in = new ByteArrayInputStream(commands.getBytes());
    System.setIn(in);

    Main.main(new String[] {"data.txt"});
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testPurchaseAllParts() throws IOException {
    final String commands = "purchase_cycle 1.2 2.1\nexit";

    final String expectedOutput ="Welcome to Cycle shop.\r\n" +
            "Purchased list of customer number 1\r\n" +
            "Price of Wheel is - 105.0\r\n" +
            "Price of Frame is - 200.0\r\n"+
            "Total price is - 305.0\r\n";

    final ByteArrayInputStream in = new ByteArrayInputStream(commands.getBytes());
    System.setIn(in);

    Main.main(new String[] {"data.txt"});
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testModifyPrice() throws IOException {
    final String commands = "modify_price 5.1 09-2020 09-2022 500\n" +
            "show_cycle_parts\nexit";

    final String expectedOutput = "Welcome to Cycle shop.\r\n" +
            "1.Wheel\r\n" +
            "    1.1 Tube 100.0\r\n" +
            "    1.2 Tyre 105.0\r\n" +
            "    1.3 Tubeless Tyre 300.0\r\n" +
            "2.Frame\r\n" +
            "    2.1 Triangle 200.0\r\n" +
            "    2.2 Steel 500.0\r\n" +
            "3.Handle\r\n" +
            "    3.1 Breaks 50.0\r\n" +
            "    3.2 Ring 40.0\r\n" +
            "    3.3 Light 100.0\r\n" +
            "4.Seat\r\n" +
            "    4.1 For Man 50.0\r\n" +
            "    4.2 For Woman 40.0\r\n" +
            "    4.3 For Child 100.0\r\n" +
            "5.Chain Assembly\r\n" +
            "    5.1 Chain 500.0\r\n" +
            "    5.2 Gear 40.0\r\n" +
            "    5.3 Pedal 100.0\r\n";

    final ByteArrayInputStream in = new ByteArrayInputStream(commands.getBytes());
    System.setIn(in);

    Main.main(new String[] {"data.txt"});
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testPurchaseForCustomer() throws IOException {
    final String commands = "purchase_cycle 1.1 1.2\ncheck_cycle_price 1\nexit";

    final String expectedOutput = "Welcome to Cycle shop.\r\n" +
            "Purchased list of customer number 1\r\n" +
            "Price of Wheel is - 205.0\r\n" +
            "Total price is - 205.0\r\n" +
            "Purchased list of customer number 1\r\n" +
            "Price of Wheel is - 205.0\r\n" +
            "Total price is - 205.0\r\n";

    final ByteArrayInputStream in = new ByteArrayInputStream(commands.getBytes());
    System.setIn(in);

    Main.main(new String[] {"data.txt"});
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testInputNotValid() throws IOException {
    final String commands = "purchase_cycle 8.1 1.2\nexit";
    final String expectedOutput = "Input not valid.\r\n" ;
    final ByteArrayInputStream in = new ByteArrayInputStream(commands.getBytes());
    System.setIn(in);
    Main.main(new String[] {"data.txt"});
  }
}
