package example.producer;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum EventType {

    CREATE,

    DELETE,

    UPDATE,

    @JsonEnumDefaultValue
    UNKNOWN

}
