package com.tmoreno.mooc.backoffice.course.infrastructure.commons;

import com.tmoreno.mooc.backoffice.shared.TransactionalService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class SpringTransactionalService implements TransactionalService {

    @Override
    @Transactional
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override
    @Transactional
    public <T> T execute(Supplier<T> supplier) {
        return supplier.get();
    }
}
