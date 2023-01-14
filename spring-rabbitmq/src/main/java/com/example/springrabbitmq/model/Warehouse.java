package com.example.springrabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Warehouse implements Serializable {
    private String id;
    private String name;
}
