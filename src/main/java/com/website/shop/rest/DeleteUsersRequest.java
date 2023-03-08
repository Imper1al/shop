package com.website.shop.rest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteUsersRequest {

    @Schema(description = "Unique ids of users")
    @NotEmpty(message = "Fields is mandatory")
    private List<Integer> userIds;
}
