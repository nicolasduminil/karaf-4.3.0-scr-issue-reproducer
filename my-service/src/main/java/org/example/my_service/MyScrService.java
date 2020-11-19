package org.example.my_service;

import com.fasterxml.jackson.jaxrs.json.*;
import org.apache.cxf.*;
import org.apache.cxf.endpoint.*;
import org.apache.cxf.jaxrs.*;
import org.osgi.service.component.annotations.*;

@Component
public class MyScrService
{
  private Server server;

  @Activate
  public void activate() throws Exception
  {
    JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();
    bean.setAddress("/");
    bean.setBus(BusFactory.getDefaultBus());
    bean.setProvider(new JacksonJsonProvider());
    bean.setServiceBean(new MyRestService());
    server = bean.create();
  }

  @Deactivate
  public void deactivate() throws Exception
  {
    if (server != null)
      server.destroy();
  }
}
