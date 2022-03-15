package com.example.redis.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import static javax.management.timer.Timer.ONE_DAY;

@Component
@Slf4j
class CacheService {

  @Scheduled(fixedRate = ONE_DAY)
  @CacheEvict(value = { "managerService", "clientService" }, allEntries = true)
  public void clearCache() {
    log.info("Caches have been cleared.");
  }
}