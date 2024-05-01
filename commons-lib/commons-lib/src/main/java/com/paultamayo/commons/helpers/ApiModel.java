package com.paultamayo.commons.helpers;

import lombok.Builder;

@Builder
public record ApiModel<T>(StatusRequestEnum status, String message, T data) {

}
