# asyncapi-demo

## Generate model
```shell
asyncapi generate models java api.yaml --packageName=com.github.kirillsulim.demo
```

Will generate following class:

```java
package com.github.kirillsulim.demo;

import java.util.Objects;
import java.util.Map;
public class AnonymousSchema_1 {
  private String greeting;
  private Map<String, Object> additionalProperties;

  public String getGreeting() { return this.greeting; }
  public void setGreeting(String greeting) { this.greeting = greeting; }

  public Map<String, Object> getAdditionalProperties() { return this.additionalProperties; }
  public void setAdditionalProperties(Map<String, Object> additionalProperties) { this.additionalProperties = additionalProperties; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnonymousSchema_1 self = (AnonymousSchema_1) o;
      return 
        Objects.equals(this.greeting, self.greeting) &&
        Objects.equals(this.additionalProperties, self.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)greeting, (Object)additionalProperties);
  }

  @Override
  public String toString() {
    return "class AnonymousSchema_1 {\n" +   
      "    greeting: " + toIndentedString(greeting) + "\n" +
      "    additionalProperties: " + toIndentedString(additionalProperties) + "\n" +
    "}";
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
```

## Generate spring service

```shell
asyncapi generate fromTemplate api.yaml @asyncapi/java-spring-template -o generated
```