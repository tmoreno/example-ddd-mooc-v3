package com.tmoreno.mooc.backoffice.course.domain;

import com.tmoreno.mooc.backoffice.course.domain.exceptions.InvalidModuleTitleException;
import org.apache.commons.lang3.StringUtils;

public record ModuleTitle(
    String value
) {

    private static final int MAX_LENGTH = 100;
    private static final int MIN_LENGTH = 10;

    public ModuleTitle {
        ensureValidTitle(value);
    }

    private void ensureValidTitle(String value) {
        if (StringUtils.isBlank(value)) {
            throw new InvalidModuleTitleException("Module title can't be blank");
        } else if (value.length() > MAX_LENGTH) {
            throw new InvalidModuleTitleException("Module title length is more than " + MAX_LENGTH);
        } else if (value.length() < MIN_LENGTH) {
            throw new InvalidModuleTitleException("Module title length is less than " + MIN_LENGTH);
        }
    }
}
