package dao.common;

import io.cucumber.core.exception.CucumberException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class AutotestCache {
    private static final Logger logger = LoggerFactory.getLogger(AutotestCache.class);
    private Map<String, Object> CACHE;

    public AutotestCache() {
        this.CACHE = new ConcurrentHashMap<>();
        logger.trace("The cache was successfully initialized!");
    }

    public void addToCache(String key, Object object) {
        CACHE.put(key, object);
        logger.trace(String.format("An object named \"%s\" has been added to the cache", key));
    }

    public Object getObjectFromCacheByKey(String key) {
        if (CACHE.size() > 0) {
            if (CACHE.containsKey(key)) {
                return CACHE.get(key);
            }
            throw new CucumberException(String.format("In cache for feature not found object on key \"%s\"", key));
        }
        throw new CucumberException("Cache is empty");
    }

    public Object getObjectFromCacheByKeyContains(String key) {
        if (CACHE.size() > 0) {

            for (Map.Entry<String, Object> entry : CACHE.entrySet()) {
                String localKey = entry.getKey();

                if (localKey.contains(key)) {
                    return entry.getValue();
                }
            }
            throw new CucumberException(String.format("Object containing in key was not found in cache for feature %s", key));
        } else {
            throw new CucumberException("Cache is empty");
        }
    }


    public void clearCache() {
        this.CACHE = new ConcurrentHashMap<>();
        logger.trace("The cache was successfully cleared!");
    }

    public boolean isKeyContains(String key) {
        if (CACHE.size() > 0) {
            if (CACHE.containsKey(key)) {
                return true;
            }
        }
        return false;
    }
}
