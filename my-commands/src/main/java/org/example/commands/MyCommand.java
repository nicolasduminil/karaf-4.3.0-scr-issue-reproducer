package org.example.commands;

import com.fasterxml.jackson.jaxrs.json.*;
import org.apache.cxf.jaxrs.client.*;
import org.apache.karaf.shell.api.action.*;
import org.apache.karaf.shell.api.action.lifecycle.*;

import javax.ws.rs.core.*;
import java.util.*;

@Service
@Command(scope = "test", name = "sayHello", description = "Say Hello")
public class MyCommand implements Action
{
  @Override
  public Object execute() throws Exception
  {
    WebClient webClient = WebClient.create("http://localhost:8181/cxf", List.of(new JacksonJsonProvider()));
    webClient.header("Content-Type", MediaType.APPLICATION_JSON).get();
    return null;
  }
}
