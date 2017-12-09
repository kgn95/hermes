package domain;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;

import domain.Session;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
public class SessionTest {
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	private static Session Sessiontest;
	private static String id = "dwqdasdasd";
	private static String channelId = "channelid879461";
	private static String message1 = "hi";
	private static String message2 = "salut";
	private static String message3 = "aloha";
	private static List<String> messages = new ArrayList<String>();
	
	@BeforeClass
    public static void setUpBeforeClass() throws ParseException {
        Sessiontest = new Session();
        Sessiontest.setId(id);
        Sessiontest.setChannelId(channelId);
        Sessiontest.setActive();
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);
        Sessiontest.addMessage(message1);
        Sessiontest.addMessage(message2);
        Sessiontest.addMessage(message3);
        
        
    }
	
	
	@Test
	public void testgetId() {
		Assert.assertEquals(id,Sessiontest.getId());
	}
	@Test
	public void testgetChannelId() throws ParseException {
		Assert.assertEquals(channelId,Sessiontest.getChannelId());
	}
	@Test
	public void testisActive() throws ParseException {
		Assert.assertEquals(false,Sessiontest.isActive());
	}
	@Test
	public void testgetActive() throws ParseException {
		Assert.assertEquals(true,Sessiontest.getActive());
	}
	@Test
	public void testgetMessages() throws ParseException {
		Assert.assertEquals(messages,Sessiontest.getMessages());
	}
	@Test
	public void testdisable() throws ParseException {
		Sessiontest.disable();
		Assert.assertEquals(false,Sessiontest.isActive());
	}
	@Test
	public void testgetEndDate_Date() throws ParseException {
		Date a = new Date();
		a.setDate(12);
		a.setMonth(12);
		a.setYear(2017);
		a.setHours(21);
		a.setMinutes(39);
		Sessiontest.setEndDate(a);
		Assert.assertEquals(a,Sessiontest.getEndDate_Date());
	}
	@Test
	public void testgetStartDate_Date() throws ParseException {
		Date s = new Date();
		s.setDate(12);
		s.setMonth(12);
		s.setYear(2017);
		s.setHours(21);
		s.setMinutes(39);
		Sessiontest.setStartDate(s);
		Assert.assertEquals(s,Sessiontest.getStartDate_Date());
	}
	@Test
	public void testgetStartDateD() throws ParseException {
		Date s = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		s.setDate(12);
		s.setMonth(12);
		s.setYear(2017);
		s.setHours(21);
		s.setMinutes(39);
		Sessiontest.setStartDate(s);
		Assert.assertEquals(format1.format(s),Sessiontest.getStartDateD());
	}
	@Test
	public void testgetEndDateD() throws ParseException {
		Date s = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		s.setDate(12);
		s.setMonth(12);
		s.setYear(2017);
		s.setHours(21);
		s.setMinutes(39);
		Sessiontest.setEndDate(s);
		Assert.assertEquals(format1.format(s),Sessiontest.getEndDateD());
	}
	/*@Test
	public void testSession() throws ParseException {
		String date = (Sessiontest.getStartDateD() + " - " + Sessiontest.getEndDateD());
		Session test2 = new Session("id2",date);
		Assert.assertEquals("id2",test2.getId());
	}*/
}