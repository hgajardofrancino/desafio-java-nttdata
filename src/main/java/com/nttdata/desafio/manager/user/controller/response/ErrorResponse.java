package com.nttdata.desafio.manager.user.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    String message;
}
