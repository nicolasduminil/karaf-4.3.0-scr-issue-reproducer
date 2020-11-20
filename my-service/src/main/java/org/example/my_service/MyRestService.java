package org.example.my_service;

import lombok.extern.slf4j.*;
import org.example.business_delegate.*;
import org.osgi.service.component.annotations.*;

import javax.ws.rs.*;

@Path("/")
@Produces("application/json")
@Consumes("application/json")
@Slf4j
@Component
public class MyRestService implements MyService
{
  @Reference
  private MyBusinessDelegate myBusinessDelegate;

  @Override
  @GET
  public void testMyService()
  {
    log.info("### MyRestService.testMyService(): {}", myBusinessDelegate.sayHello());
  }
}
