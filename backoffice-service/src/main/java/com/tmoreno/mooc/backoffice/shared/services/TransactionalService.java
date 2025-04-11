package com.tmoreno.mooc.backoffice.shared.services;

import java.util.function.Supplier;

public interface TransactionalService {

    void execute(Runnable runnable);
    <T> T execute(Supplier<T> supplier);

}
