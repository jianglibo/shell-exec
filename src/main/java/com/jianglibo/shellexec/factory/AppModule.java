package com.jianglibo.shellexec.factory;

import java.io.IOException;

import org.apache.http.client.fluent.Executor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.jianglibo.shellexec.hc.MyHttpClient;


public class AppModule extends AbstractModule {

	@Override
	protected void configure() {
	}


	@Provides
	@Singleton
	Executor providerExecutor() {
		return Executor.newInstance(new MyHttpClient().getHttpClient());
	}


	@Provides
	@Singleton
	@Named("yml")
	ObjectMapper providerYmlObjectMapper() {
		return new ObjectMapper(new YAMLFactory());
	}

	@Provides
	@Singleton
	@Named("xml")
	ObjectMapper providerXmlMapper() {
		XmlMapper mapper = new XmlMapper();
		mapper.configure(Feature.WRITE_XML_DECLARATION, true);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		return mapper;
	}

}
