package demo.docker;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * @author Ganga Aloori
 */
@Component
public class RedisDAO {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public RedisEntity get(String key) {
        System.out.println("Fetching the value for key: "+key);
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        return new RedisEntity(key, ops.get(key));
    }

    public void set(RedisEntity entity) {
        System.out.println("Saving "+entity);
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(entity.getKey(), entity.getValue());
    }

    public List<RedisEntity> list() {

        List<RedisEntity> entityList = new ArrayList<>();
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        Set<String> keySet = redisTemplate.keys("*");
        List<String> values = ops.multiGet(keySet);
        String[] keys = keySet.toArray(new String[0]);
        for (int i=0; i<keys.length; i++)
            entityList.add(new RedisEntity(keys[i], values.get(i)));

        return entityList;
    }
}
