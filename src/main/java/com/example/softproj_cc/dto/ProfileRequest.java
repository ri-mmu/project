package com.example.softproj_cc.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProfileRequest { private String bio; private String photoUrl; private List<Long> interestIds; }
