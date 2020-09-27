package com.social;

import com.social.exceptions.DataLoadFailedException;
import com.social.exceptions.InputNotValidException;
import com.social.exceptions.InvalidCommandException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class ExceptionTest {
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

    @Test(expected = DataLoadFailedException.class)
    public void testInputFileNotFoundException() throws IOException {
        Main.main(new String[]{"data1.txt"});
    }

    @Test(expected = InvalidCommandException.class)
    public void testInvalidCommandParams() throws IOException {
        final String commands = "not_valid_command\r\n";
        final ByteArrayInputStream in = new ByteArrayInputStream(commands.getBytes());
        System.setIn(in);

        Main.main(new String[] {"data.txt"});
    }
}
