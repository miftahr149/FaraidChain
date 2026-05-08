package com.ems.estatemanagementsystem.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table
public class Land extends Property {
  private String titleId;

  private double tax;

  private String state;

  private String district;

  private String address;

  private String lotNumber;

  private double area;

  private String type;
  // pertanian, bangunan, industri

  private Date regDate;

}
