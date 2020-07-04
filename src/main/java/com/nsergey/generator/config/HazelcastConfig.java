package com.nsergey.generator.config;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.cp.IAtomicLong;
import com.hazelcast.flakeidgen.FlakeIdGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {

    @Bean
    @Qualifier("idGenerator")
    public FlakeIdGenerator idGenerator(@Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance) {
        return hazelcastInstance.getFlakeIdGenerator("idGenerator");
    }

    @Bean
    public IAtomicLong atomicLong(@Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance,
                                  @Value("${atomic.long.init.value}") long initValue) {
        IAtomicLong atomicLong = hazelcastInstance.getCPSubsystem().getAtomicLong("atomicLong");
        // if you need you can read this value from some data source
        atomicLong.compareAndSet(0, initValue);
        return atomicLong;
    }

}
