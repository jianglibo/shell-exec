package com.jianglibo.shellexec.vo;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.jianglibo.shellexec.factory.AppModule;


public class TestXmlAlter {
	
	@Inject @Named("xml")
	private ObjectMapper xmlOm;
	
	@Inject @Named("yml")
	private ObjectMapper ymlOm;

	@Before
	public void setUp() {
		Guice.createInjector(new AppModule()).injectMembers(this);
	}

	@Test
	public void t() throws JsonProcessingException {
		assertNotNull(xmlOm);
		AnXmlObj axo = new AnXmlObj(1, "hello", (float) 1.2, new Date());
		String s = ymlOm.writeValueAsString(axo);
		System.out.println(s);
		s = xmlOm.writeValueAsString(axo);
		System.out.println(s);
	}

	@JacksonXmlRootElement(localName="abc")
	public static class AnXmlObj {
		private int myint;
		private String mystr;
		private float myfloat;
		
		@JacksonXmlText
		private String value = "<!-- hello ttt -->";
		
		@JacksonXmlElementWrapper(localName="strlist")
		private List<String> list;
		
		@JacksonXmlProperty(isAttribute=true)
		private Date mydate;

		public AnXmlObj(int myint, String mystr, float myfloat, Date mydate) {
			super();
			this.myint = myint;
			this.mystr = mystr;
			this.myfloat = myfloat;
			this.mydate = mydate;
			this.list = new ArrayList<>();
			this.list.add("an str item");
		}

		public int getMyint() {
			return myint;
		}

		public void setMyint(int myint) {
			this.myint = myint;
		}

		public String getMystr() {
			return mystr;
		}

		public void setMystr(String mystr) {
			this.mystr = mystr;
		}

		public float getMyfloat() {
			return myfloat;
		}

		public void setMyfloat(float myfloat) {
			this.myfloat = myfloat;
		}

		public Date getMydate() {
			return mydate;
		}

		public void setMydate(Date mydate) {
			this.mydate = mydate;
		}

		public List<String> getList() {
			return list;
		}

		public void setList(List<String> list) {
			this.list = list;
		}
		
		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
