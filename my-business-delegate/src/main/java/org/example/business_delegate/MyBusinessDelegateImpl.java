package org.example.business_delegate;

import org.osgi.service.component.annotations.*;

@Component
public class MyBusinessDelegateImpl implements MyBusinessDelegate
{
  @Override
  public String sayHello()
  {
    return "Hello SCR Karaf 4.3.0";
  }
}
