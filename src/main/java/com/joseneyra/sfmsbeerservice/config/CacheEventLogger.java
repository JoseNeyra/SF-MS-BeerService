package com.joseneyra.sfmsbeerservice.config;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

@Slf4j
public class CacheEventLogger implements CacheEventListener<Object, Object> {

    @Override
    public void onEvent(CacheEvent<?, ?> cacheEvent) {
         log.info("CACHE UPDATED => Key: {} | EventType: {} | OldValue: {} | NewValue: {}",
                 cacheEvent.getKey(), cacheEvent.getType(), cacheEvent.getOldValue(),
                 cacheEvent.getNewValue());
    }
}
