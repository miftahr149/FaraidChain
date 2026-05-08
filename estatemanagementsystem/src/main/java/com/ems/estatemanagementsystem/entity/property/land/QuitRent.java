package com.ems.estatemanagementsystem.entity.property.land;

import java.sql.Date;

import com.ems.estatemanagementsystem.entity.Land;

import jakarta.persistence.Entity;
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
@Table(name = "quitrent")
public class QuitRent extends Land {

  private String accNumber;

  private String year;

  private double amount;

  private Date paymentDate;

  private String lotNumber;

}
