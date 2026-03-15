package com.paultamayo.commons.helpers;

import lombok.Builder;
import lombok.Generated;

@Builder
@Generated
public record ApiModel<T extends Object>(StatusRequestEnum status, String message, Object data) {

}
