package com.paultamayo.commons.helpers;

import lombok.Builder;
import lombok.Generated;

@Builder
@Generated
public record ApiModel<T>(StatusRequestEnum status, String message, T data) {

}
