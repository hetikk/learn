package com.github.hetikk.learn.controller;

import com.github.hetikk.learn.model.InputData;
import com.github.hetikk.learn.model.OutputData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = SimpleController.TAG, description = "Shows the data info")
public class SimpleController {

    public static final String TAG = "Data";

    private final OutputData RESULT = new OutputData();

    @Operation(summary = "Test endpoint summary", description = "Test endpoint", tags = "Test")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
    })
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("Test");
    }

    @Operation(summary = "Get data by UUID", tags = "Test")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully"),
    })
    @GetMapping("/{uuid}")
    public OutputData getOne(@PathVariable String uuid) {
        return RESULT;
    }

    @Operation(summary = "View a list of available data", description = "View a list of available data", tags = SimpleController.TAG)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the users", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OutputData.class)))})
    })
    @GetMapping
    public List<OutputData> getAll() {
        return List.of(RESULT);
    }

    @Operation(summary = "Create new data", description = "Create new data", tags = SimpleController.TAG)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = OutputData.class))})
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OutputData create(@RequestBody InputData input) {
        return RESULT;
    }

    @Operation(summary = "Update data by UUID", description = "Update data by UUID", tags = SimpleController.TAG)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = OutputData.class))})
    })
    @PutMapping("/{uuid}")
    public OutputData update(@PathVariable String uuid, @RequestBody InputData input) {
        return RESULT;
    }

    @Operation(summary = "Delete data by UUID", description = "Delete data by UUID", tags = SimpleController.TAG)
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "No Content")})
    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String uuid) {}

}
