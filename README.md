# karaf-4.3.0-scr-issue-reproducer
Simple test to reproduce an issue I'm experiencing with SCR in Karaf 4.3.0

Install the repository as follows:

```feature:repo-add -i  mvn:org.example/my-features/1.0-SNAPSHOT/xml/features```

and run the following command:

```test:sayHello```

this will raise an exception showing that the @Reference annotation is null:

```
4:11:49.424 ERROR [qtp1054448204-393] An unexpected error occurred during error handling. No further error processing will occur.
org.apache.cxf.interceptor.Fault: null
        at org.apache.cxf.service.invoker.AbstractInvoker.createFault(AbstractInvoker.java:162) ~[!/:3.4.0]
        at org.apache.cxf.service.invoker.AbstractInvoker.invoke(AbstractInvoker.java:128) ~[!/:3.4.0]
        at org.apache.cxf.jaxrs.JAXRSInvoker.invoke(JAXRSInvoker.java:201) ~[!/:3.4.0]
        at org.apache.cxf.jaxrs.JAXRSInvoker.invoke(JAXRSInvoker.java:104) ~[!/:3.4.0]
        at org.apache.cxf.interceptor.ServiceInvokerInterceptor$1.run(ServiceInvokerInterceptor.java:59) ~[!/:3.4.0]
        at org.apache.cxf.interceptor.ServiceInvokerInterceptor.handleMessage(ServiceInvokerInterceptor.java:96) ~[!/:3.4.0]
        at org.apache.cxf.phase.PhaseInterceptorChain.doIntercept(PhaseInterceptorChain.java:308) ~[!/:3.4.0]
        at org.apache.cxf.transport.ChainInitiationObserver.onMessage(ChainInitiationObserver.java:121) ~[!/:3.4.0]
        at org.apache.cxf.transport.http.AbstractHTTPDestination.invoke(AbstractHTTPDestination.java:267) ~[!/:3.4.0]
        at org.apache.cxf.transport.servlet.ServletController.invokeDestination(ServletController.java:234) ~[!/:3.4.0]
        at org.apache.cxf.transport.servlet.ServletController.invoke(ServletController.java:208) ~[!/:3.4.0]
        at org.apache.cxf.transport.servlet.ServletController.invoke(ServletController.java:160) ~[!/:3.4.0]
        at org.apache.cxf.transport.servlet.CXFNonSpringServlet.invoke(CXFNonSpringServlet.java:225) ~[!/:3.4.0]
        at org.apache.cxf.transport.servlet.AbstractHTTPServlet.handleRequest(AbstractHTTPServlet.java:296) ~[!/:3.4.0]
        at org.apache.cxf.transport.servlet.AbstractHTTPServlet.doGet(AbstractHTTPServlet.java:220) ~[!/:3.4.0]
        at javax.servlet.http.HttpServlet.service(HttpServlet.java:687) ~[!/:3.1.0]
        at org.apache.cxf.transport.servlet.AbstractHTTPServlet.service(AbstractHTTPServlet.java:271) ~[!/:3.4.0]
        at org.eclipse.jetty.servlet.ServletHolder.handle(ServletHolder.java:763) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.servlet.ServletHandler$CachedChain.doFilter(ServletHandler.java:1651) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.websocket.server.WebSocketUpgradeFilter.doFilter(WebSocketUpgradeFilter.java:226) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.servlet.ServletHandler$CachedChain.doFilter(ServletHandler.java:1638) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.servlet.ServletHandler.doHandle(ServletHandler.java:567) ~[!/:9.4.31.v20200723]
        at org.ops4j.pax.web.service.jetty.internal.HttpServiceServletHandler.doHandle(HttpServiceServletHandler.java:71) ~[!/:?]
        at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:143) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.security.SecurityHandler.handle(SecurityHandler.java:602) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:127) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.server.handler.ScopedHandler.nextHandle(ScopedHandler.java:235) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.server.session.SessionHandler.doHandle(SessionHandler.java:1610) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.server.handler.ScopedHandler.nextHandle(ScopedHandler.java:233) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.server.handler.ContextHandler.doHandle(ContextHandler.java:1377) ~[!/:9.4.31.v20200723]
        at org.ops4j.pax.web.service.jetty.internal.HttpServiceContext.doHandle(HttpServiceContext.java:294) ~[!/:?]
        at org.eclipse.jetty.server.handler.ScopedHandler.nextScope(ScopedHandler.java:188) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.servlet.ServletHandler.doScope(ServletHandler.java:507) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.server.session.SessionHandler.doScope(SessionHandler.java:1580) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.server.handler.ScopedHandler.nextScope(ScopedHandler.java:186) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.server.handler.ContextHandler.doScope(ContextHandler.java:1292) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:141) ~[!/:9.4.31.v20200723]
        at org.ops4j.pax.web.service.jetty.internal.JettyServerHandlerCollection.handle(JettyServerHandlerCollection.java:82) ~[!/:?]
        at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:127) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.server.Server.handle(Server.java:501) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.server.HttpChannel.lambda$handle$1(HttpChannel.java:383) ~[!/:9.4.31.v20200723]
        at org.eclipse.jetty.server.HttpChannel.dispatch(HttpChannel.java:556) [!/:9.4.31.v20200723]
        at org.eclipse.jetty.server.HttpChannel.handle(HttpChannel.java:375) [!/:9.4.31.v20200723]
        at org.eclipse.jetty.server.HttpConnection.onFillable(HttpConnection.java:273) [!/:9.4.31.v20200723]
        at org.eclipse.jetty.io.AbstractConnection$ReadCallback.succeeded(AbstractConnection.java:311) [!/:9.4.31.v20200723]
        at org.eclipse.jetty.io.FillInterest.fillable(FillInterest.java:105) [!/:9.4.31.v20200723]
        at org.eclipse.jetty.io.ChannelEndPoint$1.run(ChannelEndPoint.java:104) [!/:9.4.31.v20200723]
        at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:806) [!/:9.4.31.v20200723]
        at org.eclipse.jetty.util.thread.QueuedThreadPool$Runner.run(QueuedThreadPool.java:938) [!/:9.4.31.v20200723]
        at java.lang.Thread.run(Thread.java:834) [?:?]
Caused by: java.lang.NullPointerException
        at org.example.my_service.MyRestService.testMyService(MyRestService.java:23) ~[?:?]
        at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[?:?]
        at jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[?:?]
        at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[?:?]
        at java.lang.reflect.Method.invoke(Method.java:566) ~[?:?]
        at org.apache.cxf.service.invoker.AbstractInvoker.performInvocation(AbstractInvoker.java:179) ~[!/:3.4.0]
        at org.apache.cxf.service.invoker.AbstractInvoker.invoke(AbstractInvoker.java:96) ~[!/:3.4.0]

```
This happens in the org.example.my_service.MyRestService class, line #23. This class exposes a REST service which is called
by the command. It tries to inject a reference but unsuccessfuly because its content is null.

The issue seems to happen only when the @Reference annotation is used in a REST service because in the other tests I have
done, using it in different contexts like POJOs, it worked as expected.


