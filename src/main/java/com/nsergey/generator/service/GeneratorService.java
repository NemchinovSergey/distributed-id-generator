package com.nsergey.generator.service;

import com.hazelcast.cp.IAtomicLong;
import com.hazelcast.flakeidgen.FlakeIdGenerator;
import com.nsergey.generator.error.IdGenerationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GeneratorService {

    private final FlakeIdGenerator idGenerator;
    private final IAtomicLong atomicLong;

    public GeneratorService(FlakeIdGenerator idGenerator, IAtomicLong atomicLong) {
        this.idGenerator = idGenerator;
        this.atomicLong = atomicLong;
    }

    public long getTimeBasedUniqueId() {
        log.debug("Get next id");
        try {
            long id = idGenerator.newId();
            log.debug("Id value: {}", id);
            return id;
        } catch (Exception e) {
            throw new IdGenerationException(e.getMessage(), e);
        }
    }

    public long getGloballySequentialId() {
        log.debug("Get next global value");
        try {
            long id = atomicLong.incrementAndGet();
            log.debug("Global value: {}", id);
            return id;
        } catch (Exception e) {
            throw new IdGenerationException(e.getMessage(), e);
        }
    }

}
