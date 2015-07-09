package demo.docker;

/**
 * @author Ganga Aloori
 */
public class RedisEntity {

    private final String key;
    private final String value;

    private RedisEntity() {
        this.key = null;
        this.value = null;
    }

    public RedisEntity(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "RedisEntity{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
