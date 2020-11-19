# karaf-4.3.0-scr-issue-reproducer
Simple test to reproduce an issue I'm experiencing with SCR in Karaf 4.3.0

Install the repository as follows:

```feature:repo-add -i  mvn:org.example/my-features/1.0-SNAPSHOT/xml/features```

this will raise an exception showing that the @Reference annotation cannot be resolved:

```
Error executing command: Unable to resolve root: missing requirement [root] osgi.identity; osgi.identity=my-service; 
type=karaf.feature; version="[1.0.0.SNAPSHOT,1.0.0.SNAPSHOT]"; filter:="(&(osgi.identity=my-service)(type=karaf.feature)
(version>=1.0.0.SNAPSHOT)(version<=1.0.0.SNAPSHOT))" [caused by: Unable to resolve my-service/1.0.0.SNAPSHOT: missing 
requirement [my-service/1.0.0.SNAPSHOT] osgi.identity; osgi.identity=org.example.my-service; type=osgi.bundle; 
version="[1.0.0.SNAPSHOT,1.0.0.SNAPSHOT]"; resolution:=mandatory [caused by: Unable to resolve org.example.my-service/1.0.0.SNAPSHOT: 
missing requirement [org.example.my-service/1.0.0.SNAPSHOT] osgi.service; effective:=active; 
filter:="(objectClass=org.example.business_delegate.MyBusinessDelegateImpl)"]]
```
This happens in the org.example.my_service.MyRestService class which expose a REST service and tries to inject a reference.


