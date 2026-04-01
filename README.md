# gplatform.gwt
GWT implementation of gplatform

## Build
To use this you can simply add the sources to your classpath.

### maven
`de.exware.gplatform.gwt` is now on Maven Central.
To use with maven simply add the following dependency:

```
    <dependency>
        <groupId>de.exware</groupId>
        <artifactId>gplatform.gwt</artifactId>
        <version>VERSION</version>
    </dependency>
```

where VERSION should be replaced by the version number in version.txt.

You can build your own local maven version by calling

```
sh nobuto.sh -t installToMaven -vvv
```
